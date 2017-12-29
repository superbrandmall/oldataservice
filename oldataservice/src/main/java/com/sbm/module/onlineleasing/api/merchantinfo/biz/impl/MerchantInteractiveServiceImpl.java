package com.sbm.module.onlineleasing.api.merchantinfo.biz.impl;

import com.sbm.module.common.business.util.AppPropertyUtils;
import com.sbm.module.onlineleasing.api.merchantinfo.event.MerchantUpdateEvent;
import com.sbm.module.onlineleasing.base.merchantaddress.biz.ITOLMerchantAddressService;
import com.sbm.module.onlineleasing.base.merchantaddress.domain.TOLMerchantAddress;
import com.sbm.module.onlineleasing.base.merchantbankaccount.biz.ITOLMerchantBankAccountService;
import com.sbm.module.onlineleasing.base.merchantbankaccount.domain.TOLMerchantBankAccount;
import com.sbm.module.onlineleasing.base.merchantbusinesslicense.biz.ITOLMerchantBusinessLicenseService;
import com.sbm.module.onlineleasing.base.merchantbusinesslicense.domain.TOLMerchantBusinessLicense;
import com.sbm.module.onlineleasing.base.tempparam.biz.ITOLTempParamService;
import com.sbm.module.onlineleasing.base.tempparam.constant.TempParamConstant;
import com.sbm.module.partner.hd.rest.merchant.domain.HdBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.base.pulisher.constant.BusinessEventListenerConstant;
import com.sbm.module.common.base.pulisher.template.BusinessEventTemplate;
import com.sbm.module.common.business.biz.IThreadSleepExecuteCallBack;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.merchantinfo.biz.IMerchantInteractiveService;
import com.sbm.module.onlineleasing.api.merchantinfo.event.MerchantEvent;
import com.sbm.module.onlineleasing.base.merchant.biz.ITOLMerchantService;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.onlineleasing.base.sysmessage.domain.TOLSysMessage;
import com.sbm.module.partner.hd.rest.base.biz.impl.HdInteractiveServiceImpl;
import com.sbm.module.partner.hd.rest.base.constant.HdConstant;
import com.sbm.module.partner.hd.rest.base.domain.HdResult;
import com.sbm.module.partner.hd.rest.merchant.biz.IHdMerchantService;
import com.sbm.module.partner.hd.rest.merchant.domain.HdMerchant;

import java.util.List;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/
/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.biz.impl<br/>
 * File Name:EdiInteractiveDetailServiceImpl.java<br/>
 * 
 * 作成日 ：2016-1-4 下午5:05:55 <br/>
 * 
 * @author ：junkai.zhang 
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
/**
 * @preserve public
 */
@Component
@Transactional(value = TransactionConstant.OL, propagation = Propagation.REQUIRED)
public class MerchantInteractiveServiceImpl extends HdInteractiveServiceImpl implements IMerchantInteractiveService {

	@Autowired
	private ITOLMerchantService service;
	@Autowired
	private ITOLMerchantAddressService addressService;
	@Autowired
	private ITOLMerchantBusinessLicenseService businessLicenseService;
	@Autowired
	private ITOLMerchantBankAccountService bankAccountService;

	@Autowired
	private ITOLTempParamService tempParamService;

	@Autowired
	private IHdMerchantService hdMerchantService;

	/********************************************************************/
	// 商户准入

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public void merchantAccress(TOLMerchant obj) {
		// 发布事件
		BusinessEventTemplate template = getTemplate()
				.put(BusinessEventListenerConstant.SysMessage, new TOLSysMessage(getUserCode(), "商户准入流程已发起，商户编码：" + obj.getCode()))
				.put(BusinessEventListenerConstant.BaseEntity, obj)
				.put(BusinessEventListenerConstant.METHOD, BusinessEventListenerConstant.SAVE);
		publishEvent(new MerchantEvent(template));
	}

	/********************************************************************/
	// 执行商户准入

	public void doMerchantAccress(TOLMerchant obj) {
		// 多线程防止事务未提交
		TOLMerchant po = findByCode(obj.getCode());
		// 转换
		HdMerchant vo = new HdMerchant();
		convert2vo(vo, po);
		// 调用
		HdResult<HdMerchant> result = hdMerchantService.save(vo);
		// 校对返回结果
		checkResult(result);
		// 处理结果
		processResult(po, result);
		// 更新
		service.update(po);
	}

	/**
	 * 
	 * processResult:处理结果
	 * 
	 * @author junkai.zhang
	 * @param po
	 * @param result
	 */
	private void processResult(TOLMerchant po, HdResult<HdMerchant> result) {
		// 海鼎uuid
		po.setHdUuid(result.getBody().getUuid());
		// 海鼎编码
		po.setHdCode(result.getBody().getCode());
		// 设置海鼎状态
		po.setHdState(result.getBody().getState());
	}

	/**
	 * 
	 * convert2HdMerchant:转换
	 * 
	 * @author junkai.zhang
	 * @param vo
	 * @param po
	 */
	private void convert2vo(HdMerchant vo, TOLMerchant po) {
		// 海鼎自动生成
		// 商户代码
//		vo.setCode(po.getCode());
		// 商户名称
		vo.setName(po.getName());
		// 状态
		vo.setState(HdConstant.HD_STATE_USING);

		// 商户类型
		vo.setBrandDealerType(tempParamService.findByParamAndKey(TempParamConstant.brandDealerType, po.getType()).getValue());

		// 注册资金
		vo.getProperties().setRegCapital(po.getCapital());
		// 股东结构
		vo.getProperties().setShareholder(po.getShareholder());
		// 统一社会信用代码
		vo.getProperties().setUscc(po.getUscc());
		// 经营范围
		vo.getProperties().setBusiness_scope(po.getBusinessScope());
		// 天眼查ID
		vo.getProperties().setTianyancha_id(String.valueOf(po.getTianyanchaId()));

		TOLMerchantBusinessLicense businessLicense = businessLicenseService.findByCode(po.getCode());
		if (null != businessLicense) {
			// 营业执照
			vo.getProperties().setBusiness_licence(businessLicense.getBusinessLicense());
		}

		// OL商户访问URL
		vo.getProperties().setOl_url(AppPropertyUtils.getProperty("tianYanChaUrl") + po.getCode());

		TOLMerchantAddress address = addressService.findByCode(po.getCode());
		if (null != address) {
			// 注册地址
			vo.getProperties().setRegisterAddress(address.getStreetAddress());
			// 邮寄地址
			vo.getProperties().setPostAddress(address.getMailingAddress());
		}

		// 银行账户
		List<TOLMerchantBankAccount> bankAccounts = bankAccountService.findAllByCode(po.getCode());
		for (TOLMerchantBankAccount bankAccount : bankAccounts) {
			vo.getBanks().add(new HdBank(bankAccount.getBankAccountDesc(), bankAccount.getBankAccount()));
		}

		// TODO 商户联系人 暂时不传
		// TODO 联系电话 暂时不传
		// TODO 传真 暂时不传

	}

	/********************************************************************/
	// 商户修改

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public void merchantUpdate(TOLMerchant obj) {
		// 发布事件
		BusinessEventTemplate template = getTemplate()
				.put(BusinessEventListenerConstant.SysMessage, new TOLSysMessage(getUserCode(), "商户修改流程已发起，商户编码：" + obj.getCode()))
				.put(BusinessEventListenerConstant.BaseEntity, obj)
				.put(BusinessEventListenerConstant.METHOD, BusinessEventListenerConstant.UPDATE);
		publishEvent(new MerchantUpdateEvent(template));
	}

	/********************************************************************/
	// 执行商户修改

	public void doMerchantUpdate(TOLMerchant obj) {
		// 多线程防止事务未提交
		TOLMerchant po = findByCode(obj.getCode());
		// 转换
		HdMerchant vo = new HdMerchant();
		convert2vo(vo, po);
		// 设置更新key
		setUpdateKey(vo, po);
		// 调用
		HdResult<HdMerchant> result = hdMerchantService.save(vo);
		// 校对返回结果
		checkResult(result);
		// 更新不需要
		// 处理结果
		// processResult(po, result);
		// 更新
		// service.update(po);
	}

	private void setUpdateKey(HdMerchant vo, TOLMerchant po) {
		// 海鼎uuid
		vo.setUuid(po.getHdUuid());
		// 海鼎编码
		vo.setCode(po.getHdCode());
	}

	/********************************************************************/

	/**
	 * 
	 * findByCode:多线程处理防止事务未提交
	 * 
	 * @author junkai.zhang
	 * @param code
	 * @return
	 */
	private TOLMerchant findByCode(final String code) {
		return threadSleepExecute(new BusinessException(BusinessCode.C5200, new Object[] { code }, null),
				new IThreadSleepExecuteCallBack<TOLMerchant>() {
					public TOLMerchant execute() {
						TOLMerchant po = service.findByCode(code);
						return po;
					}
				});
	}
}
