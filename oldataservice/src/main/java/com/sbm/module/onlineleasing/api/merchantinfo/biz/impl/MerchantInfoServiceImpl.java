package com.sbm.module.onlineleasing.api.merchantinfo.biz.impl;

import com.sbm.module.onlineleasing.base.merchantbankaccount.domain.TOLMerchantBankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.merchantinfo.biz.IMerchantInfoService;
import com.sbm.module.onlineleasing.api.merchantinfo.domain.MerchantInfo;
import com.sbm.module.onlineleasing.base.merchant.biz.ITOLMerchantService;
import com.sbm.module.onlineleasing.base.merchantaddress.biz.ITOLMerchantAddressService;
import com.sbm.module.onlineleasing.base.merchantbankaccount.biz.ITOLMerchantBankAccountService;
import com.sbm.module.onlineleasing.base.merchantbusinesslicense.biz.ITOLMerchantBusinessLicenseService;
import com.sbm.module.onlineleasing.base.merchantbusinesslicense.domain.TOLMerchantBusinessLicense;

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
public class MerchantInfoServiceImpl extends BusinessServiceImpl implements IMerchantInfoService {

	@Autowired
	private ITOLMerchantService merchantService;
	@Autowired
	private ITOLMerchantAddressService merchantAddressService;
	@Autowired
	private ITOLMerchantBankAccountService merchantBankAccountService;
	@Autowired
	private ITOLMerchantBusinessLicenseService merchantBusinessLicenseService;

	public void getMerchantInfo(MerchantInfo merchantInfo) {
		// 商户code
		String code = merchantInfo.getMerchantCode();
		// 商户信息
		merchantInfo.setMerchant(merchantService.findByCode(code));
		// 商户地址
		merchantInfo.setMerchantAddress(merchantAddressService.findByCode(code));
		// 商户银行信息
		merchantInfo.setMerchantBankAccounts(merchantBankAccountService.findAllByCode(code));
		// 商户license
		merchantInfo.setMerchantBusinessLicense(merchantBusinessLicenseService.findByCode(code));
	}

	public void updateMerchantInfo(MerchantInfo merchantInfo) {
		// 更新商户信息
		merchantService.update(merchantInfo.getMerchant());
		// 更新商户地址
		merchantAddressService.update(merchantInfo.getMerchantAddress());
		// 更新商户银行信息
		for (TOLMerchantBankAccount merchantBankAccount : merchantInfo.getMerchantBankAccounts()){
			merchantBankAccountService.update(merchantBankAccount);
		}
		// 更新商户license
		if (null != merchantInfo.getMerchantBusinessLicense()) {
			TOLMerchantBusinessLicense merchantBusinessLicense = merchantInfo.getMerchantBusinessLicense();
			// id不为空则更新
			if (null != merchantBusinessLicense.getId()) {
				merchantBusinessLicenseService.update(merchantBusinessLicense);
			}
			// id为空则插入
			else {
				merchantBusinessLicense.setCode(merchantInfo.getMerchantCode());
				merchantBusinessLicenseService.save(merchantBusinessLicense);
			}
		}
	}
}
