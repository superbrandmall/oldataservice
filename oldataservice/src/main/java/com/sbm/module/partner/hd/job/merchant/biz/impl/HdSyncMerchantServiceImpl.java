package com.sbm.module.partner.hd.job.merchant.biz.impl;

import com.sbm.module.onlineleasing.base.merchantaddress.biz.ITOLMerchantAddressService;
import com.sbm.module.onlineleasing.base.merchantaddress.domain.TOLMerchantAddress;
import com.sbm.module.onlineleasing.base.merchantbankaccount.biz.ITOLMerchantBankAccountService;
import com.sbm.module.onlineleasing.base.merchantbankaccount.domain.TOLMerchantBankAccount;
import com.sbm.module.onlineleasing.base.tempparam.biz.ITOLTempParamService;
import com.sbm.module.onlineleasing.base.tempparam.constant.TempParamConstant;
import com.sbm.module.partner.hd.rest.merchant.domain.HdBank;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.onlineleasing.base.merchant.biz.ISyncMerchantService;
import com.sbm.module.onlineleasing.base.merchant.biz.ITOLMerchantService;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.partner.hd.job.base.biz.impl.HdSyncServiceImpl;
import com.sbm.module.partner.hd.job.base.domain.HdSyncDetail;
import com.sbm.module.partner.hd.rest.base.domain.HdResult;
import com.sbm.module.partner.hd.rest.base.domain.HdResultBody;
import com.sbm.module.partner.hd.rest.base.domain.QueryFilter;
import com.sbm.module.partner.hd.rest.merchant.biz.IHdMerchantService;
import com.sbm.module.partner.hd.rest.merchant.domain.HdMerchant;

import java.util.List;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.job.sync.mall.biz.impl<br/>
 * File Name:HdSyncMallServiceImpl.java<br/>
 * 
 * 作成日 ：2017-10-11 下午1:29:23 <br/>
 * 
 * @author ：junkai.zhang
 */
@Component("hdSyncMerchantServiceImpl")
public class HdSyncMerchantServiceImpl extends HdSyncServiceImpl implements ISyncMerchantService {

	@Autowired
	private ITOLMerchantService service;
	@Autowired
	private ITOLMerchantAddressService addressService;
	@Autowired
	private ITOLMerchantBankAccountService bankAccountService;
	@Autowired
	private ITOLTempParamService tempParamService;

	@Autowired
	private IHdMerchantService hdMerchantService;

	public void sync() {
		// 查询条件
		QueryFilter queryFilter = new QueryFilter();
		queryFilter.getFilter().put("type", "merchant");
		// 第一次查询
		HdResult<HdResultBody<HdMerchant>> result = query(queryFilter);
		// 遍历查询
		for (int i = 1; i < result.getBody().getPageCount(); i++) {
//			// TODO
//			if (i >= 3) {
//				break;
//			}
			queryFilter.setPage(i);
			query(queryFilter);
		}
	}

	private HdResult<HdResultBody<HdMerchant>> query(QueryFilter queryFilter) {
		HdSyncDetail<TOLMerchant> detail = getSyncDetail();
		HdResult<HdResultBody<HdMerchant>> result = hdMerchantService.query(queryFilter);
		// 校对返回结果
		checkResult(result);
		// 遍历结果
		for (HdMerchant obj : result.getBody().getRecords()) {
			TOLMerchant po = service.findByHdUuid(obj.getUuid());
			TOLMerchantAddress address;
			TOLMerchantBankAccount bankAccount;
			// 不存在新增
			if (null == po) {
				// 主体
				po = new TOLMerchant();
				convert(po, obj);
				service.saveMerchant(po);

				// 地址
				address = new TOLMerchantAddress();
				address.setCode(po.getCode());
				convert(address, obj);
				addressService.save(address);

				// 银行账号
				for(HdBank bank : obj.getBanks()) {
					bankAccount = new TOLMerchantBankAccount();
					bankAccount.setCode(po.getCode());
					convert(bankAccount, bank);
					bankAccountService.save(bankAccount);
				}
				detail.getInsertList().add(po);
			}
			// 存在更新
			else {
				// 主体
				convert(po, obj);
				service.update(po);

				// 地址
				address = addressService.findByCode(po.getCode());
				if (null == address) {
					address = new TOLMerchantAddress();
					address.setCode(po.getCode());
					convert(address, obj);
					addressService.save(address);
				} else {
					convert(address, obj);
					addressService.update(address);
				}

				// 银行账号
				List<TOLMerchantBankAccount>  bankAccounts = bankAccountService.findAllByCode(po.getCode());
				if (bankAccounts.size() <= obj.getBanks().size()) {
					for (int i = 0; i < obj.getBanks().size(); i++) {
						if (i < bankAccounts.size()) {
							bankAccount = bankAccounts.get(i);
							convert(bankAccount, obj.getBanks().get(i));
							bankAccountService.update(bankAccount);
						} else {
							bankAccount = new TOLMerchantBankAccount();
							bankAccount.setCode(po.getCode());
							convert(bankAccount, obj.getBanks().get(i));
							bankAccountService.save(bankAccount);
						}
					}
				} else {
					for (int i = 0; i < bankAccounts.size(); i++) {
						if (i < obj.getBanks().size()) {
							bankAccount = bankAccounts.get(i);
							convert(bankAccount, obj.getBanks().get(i));
							bankAccountService.update(bankAccount);
						} else {
							bankAccount = bankAccounts.get(i);
							bankAccountService.delete(bankAccount);
						}
					}
				}

				detail.getUpdateList().add(po);
			}
		}
		log(detail, result, HdMerchant.class);
		return result;
	}

	/**
	 * 
	 * convert:转换
	 * 
	 * @author junkai.zhang
	 * @param po
	 * @param obj
	 */
	private void convert(TOLMerchant po, HdMerchant obj) {
		// 海鼎uuid
		po.setHdUuid(obj.getUuid());
		// 海鼎编码
		po.setHdCode(obj.getCode());
		// 海鼎状态
		po.setHdState(obj.getState());
		// 名称
		po.setName(obj.getName());
		// 类型
		po.setType(tempParamService.findByParamAndValue(TempParamConstant.brandDealerType, obj.getBrandDealerType()).getKey());

		// 注册资金
		po.setCapital(obj.getProperties().getRegCapital());
		// 股东结构
		po.setShareholder(obj.getProperties().getShareholder());
		// 统一社会信用代码
		po.setUscc(obj.getProperties().getUscc());
		// 经营范围
		po.setBusinessScope(obj.getProperties().getBusiness_scope());
		// 天眼查id 不需要

	}

	/**
	 * 转换地址
	 * @param address
	 * @param obj
	 */
	private void convert(TOLMerchantAddress address, HdMerchant obj){
		// 注册地址
		address.setStreetAddress(obj.getProperties().getRegisterAddress());
		// 邮寄地址
		address.setMailingAddress(obj.getProperties().getPostAddress());
	}

	/**
	 * 转换银行账号
	 * @param bankAccount
	 * @param obj
	 */
	private void convert(TOLMerchantBankAccount bankAccount, HdBank obj) {
		// 银行账号
		bankAccount.setBankAccount(obj.getAccount());
		// 银行名称
		bankAccount.setBankAccountDesc(obj.getName());
	}


}
