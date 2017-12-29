package com.sbm.module.onlineleasing.api.interactive.brand.biz.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.api.mail.domain.MailData;
import com.sbm.module.common.api.mail.domain.TCMailSendDetail;
import com.sbm.module.common.api.mail.domain.TCMailTemplate;
import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.base.pulisher.constant.BusinessEventListenerConstant;
import com.sbm.module.common.base.pulisher.template.BusinessEventTemplate;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.util.ParamsUtil;
import com.sbm.module.onlineleasing.api.interactive.brand.biz.IBrandReceiveService;
import com.sbm.module.onlineleasing.api.interactive.brand.constant.BrandReceiveConstant;
import com.sbm.module.onlineleasing.api.interactive.brand.domain.BrandReceiveVo;
import com.sbm.module.onlineleasing.api.interactive.brand.event.BrandReceiveEvent;
import com.sbm.module.onlineleasing.base.brand.biz.ITOLBrandService;
import com.sbm.module.onlineleasing.base.brand.constant.BrandConstant;
import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;
import com.sbm.module.onlineleasing.base.merchantbrand.biz.ITOLMerchantBrandService;
import com.sbm.module.onlineleasing.base.merchantbrand.domain.TOLMerchantBrand;
import com.sbm.module.onlineleasing.base.sysmessage.domain.TOLSysMessage;
import com.sbm.module.onlineleasing.base.user.biz.ITOLUserService;
import com.sbm.module.onlineleasing.base.user.domain.TOLUser;

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
public class BrandReceiveServiceImpl extends BusinessServiceImpl implements IBrandReceiveService {

	@Value("#{propertiesReader['application.BrandReceiveServiceImpl.mailTemplateCode']}")
	private String mailTemplateCode;

	@Autowired
	private ITOLBrandService brandService;
	@Autowired
	private ITOLMerchantBrandService merchantBrandService;
	@Autowired
	private ITOLUserService userService;

	public void receive(BrandReceiveVo vo) {
		// 准入
		if (BrandReceiveConstant.ACCRESS.equalsIgnoreCase(vo.getMethod())) {
			doAccress(vo);
		}
		// 修改
		else if (BrandReceiveConstant.UPDATE.equalsIgnoreCase(vo.getMethod())) {
			// TODO
			doUpdate(vo);
		}
		// 操作码不正确
		else {
			throw new BusinessException(BusinessCode.C11100, new Object[] { vo.getMethod() }, null);
		}
	}

	/****************************************************************************/

	/**
	 * 
	 * doAccress:品牌准入
	 * 
	 * @author junkai.zhang
	 * @param vo
	 */
	private void doAccress(BrandReceiveVo vo) {
		ParamsUtil.canNotBeEmpty(vo.getBrand().getCode());
		TOLBrand brand = brandService.findByCode(vo.getBrand().getCode());
		if (null == brand) {
			throw new BusinessException(BusinessCode.C5004, new Object[] { vo.getBrand().getCode() }, null);
		}
		// 目前全部成功
		// TODO
		if (true) {
			brand.setStatus(BrandConstant.ADMITTANCE);
		}
		brandService.update(brand);
		accressInfo(brand);
	}

	/**
	 * 
	 * accressInfo:准入通知
	 * 
	 * @author junkai.zhang
	 * @param brand
	 */
	private void accressInfo(TOLBrand brand) {
		// 查询出品牌相关的商户
		List<TOLMerchantBrand> merchantBrands = merchantBrandService.findAllByBrandCode(brand.getCode());
		// 如果没有关联商户，直接return TODO
		if (null == merchantBrands || merchantBrands.isEmpty()) {
			return;
		}
		List<String> merchantCodes = new ArrayList<String>();
		for (TOLMerchantBrand merchantBrand : merchantBrands) {
			merchantCodes.add(merchantBrand.getMerchantCode());
		}
		// 查询用户
		List<TOLUser> list = userService.findAllByMerchantCodes(merchantCodes);
		String message = MessageFormat.format("您的品牌（{0}）审核已通过", brand.getName());
		// 发送邮件
		MailData mailData = new MailData();
		// 设置邮件模板
		mailData.setMailTemplate(new TCMailTemplate(mailTemplateCode));
		// 创建发送列表
		List<TCMailSendDetail> details = new ArrayList<TCMailSendDetail>();
		// 创建系统消息列表
		List<TOLSysMessage> sysMessages = new ArrayList<TOLSysMessage>();

		TCMailSendDetail detail = null;
		TOLSysMessage sysMessage = null;
		for (TOLUser user : list) {
			// 创建发送明细
			detail = new TCMailSendDetail();
			// 设置发送明细发送人
			detail.setSentTo(user.getEmail());
			// 创建发送明细参数
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			// 设置发送明细参数
			paramsMap.put(BrandReceiveConstant.MESSAGE, message);
			// 设置参数到明细
			detail.setParamsMap(paramsMap);
			// 设置明细到列表
			details.add(detail);

			// 创建系统消息明细
			sysMessage = new TOLSysMessage(user.getCode(), message);
			// 设置明细到列表
			sysMessages.add(sysMessage);
		}
		// 设置列表
		mailData.setDetails(details);
		// 设置模板
		BusinessEventTemplate template = getTemplate().put(BusinessEventListenerConstant.MAIL, mailData).put(
				BusinessEventListenerConstant.SysMessage, sysMessages);
		publishEvent(new BrandReceiveEvent(template));

	}

	/****************************************************************************/

	/**
	 * 
	 * doUpdate:品牌更新
	 * 
	 * @author junkai.zhang
	 * @param vo
	 */
	private void doUpdate(BrandReceiveVo vo) {

	}

}
