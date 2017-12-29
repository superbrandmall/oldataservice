package com.sbm.module.onlineleasing.api.register.biz.impl;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.util.ParamsUtil;
import com.sbm.module.onlineleasing.api.register.biz.IRegisterIdCardCheckService;
import com.sbm.module.onlineleasing.api.register.biz.IRegisterMerchantCheckService;
import com.sbm.module.onlineleasing.api.register.domain.RegisterIdCardCheck;
import com.sbm.module.onlineleasing.api.register.domain.RegisterMerchantCheck;
import com.sbm.module.onlineleasing.api.userinfo.check.biz.IUserInfoCheckService;
import com.sbm.module.onlineleasing.base.merchant.biz.ITOLMerchantService;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.onlineleasing.base.merchantaddress.biz.ITOLMerchantAddressService;
import com.sbm.module.onlineleasing.base.merchantaddress.domain.TOLMerchantAddress;
import com.sbm.module.onlineleasing.base.merchantbankaccount.biz.ITOLMerchantBankAccountService;
import com.sbm.module.onlineleasing.base.merchantbusinesslicense.biz.ITOLMerchantBusinessLicenseService;
import com.sbm.module.onlineleasing.base.merchantbusinesslicense.domain.TOLMerchantBusinessLicense;
import com.sbm.module.partner.nuozhengtong.idcard.biz.INZTIdCardService;
import com.sbm.module.partner.nuozhengtong.idcard.domain.NZTIdCardResult;
import com.sbm.module.partner.tianyancha.rest.baseinfo.biz.IBaseInfoService;
import com.sbm.module.partner.tianyancha.rest.baseinfo.domain.BaseInfo;
import com.sbm.module.partner.tianyancha.rest.baseinfo.domain.BaseInfoResult;
import com.sbm.module.partner.tianyancha.rest.search.biz.ISearchService;
import com.sbm.module.partner.tianyancha.rest.search.domain.Search;
import com.sbm.module.partner.tianyancha.rest.search.domain.SearchData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
public class RegisterIdCardCheckServiceImpl extends BusinessServiceImpl implements IRegisterIdCardCheckService {

	@Autowired
	private IUserInfoCheckService userInfoCheckService;
	@Autowired
	private INZTIdCardService nztIdCardService;

	@Override
	public void check(RegisterIdCardCheck registerIdCardCheck) {
		userInfoCheckService.isNotExistIdCard(registerIdCardCheck.getIdCard());
		NZTIdCardResult result = nztIdCardService.idCardCheck(registerIdCardCheck.getName(), registerIdCardCheck.getIdCard());
		nztIdCardService.check(result);
	}
}
