package com.sbm.module.onlineleasing.api.admin.merchant.biz.impl;

import com.sbm.module.onlineleasing.api.admin.merchant.biz.IMerchantVoService;
import com.sbm.module.onlineleasing.api.admin.merchant.domain.MerchantVo;
import com.sbm.module.onlineleasing.base.merchantaddress.biz.ITOLMerchantAddressService;
import com.sbm.module.onlineleasing.base.merchantbankaccount.biz.ITOLMerchantBankAccountService;
import com.sbm.module.onlineleasing.base.merchantbrand.biz.ITOLMerchantBrandService;
import com.sbm.module.onlineleasing.base.merchantbusinesslicense.biz.ITOLMerchantBusinessLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.base.merchant.biz.ITOLMerchantService;

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
public class MerchantVoServiceImpl extends BusinessServiceImpl implements IMerchantVoService {

	@Autowired
	private ITOLMerchantService merchantService;
	@Autowired
	private ITOLMerchantAddressService merchantAddressService;
	@Autowired
	private ITOLMerchantBankAccountService merchantBankAccountService;
	@Autowired
	private ITOLMerchantBrandService merchantBrandService;
	@Autowired
	private ITOLMerchantBusinessLicenseService merchantBusinessLicenseService;

	@Override
	public void findAllByConditionPage(MerchantVo vo) {
		vo.setPagination(merchantService.findAllByConditionPage(vo.getMerchant()));
	}

	@Override
	public void findByCode(MerchantVo vo) {
		vo.setMerchant(merchantService.findByCode(vo.getMerchant().getCode()));
		if (null != vo.getMerchant()) {
			vo.setMerchantAddress(merchantAddressService.findByCode(vo.getMerchant().getCode()));
			vo.setMerchantBankAccounts(merchantBankAccountService.findAllByCode(vo.getMerchant().getCode()));
			vo.setMerchantBrands(merchantBrandService.findAllByMerchantCode(vo.getMerchant().getCode()));
			vo.setMerchantBusinessLicense(merchantBusinessLicenseService.findByCode(vo.getMerchant().getCode()));
		}
	}

}
