/**
 * Project Name:posUploadData
 * File Name:JsonContainer.java
 * Package Name:com.sbm.module.postsales.domain
 * Date:2016-1-7下午2:23:21
 * Copyright (c) 2016, Super Brand Mail Inc All Rights Reserved.
 *
 */

package com.sbm.module.onlineleasing.api.register.domain;

import org.apache.commons.lang3.StringUtils;

import com.sbm.module.common.api.apiinteractive.constant.ApiInteractiveConstant;
import com.sbm.module.common.api.apiinteractive.handler.IApiInteractiveProcess;
import com.sbm.module.common.api.verificationcode.domain.VerificationCode;
import com.sbm.module.common.base.util.CloneUtil;
import com.sbm.module.onlineleasing.api.brandinfo.domain.BrandInfo;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.onlineleasing.base.merchantaddress.domain.TOLMerchantAddress;
import com.sbm.module.onlineleasing.base.merchantbusinesslicense.domain.TOLMerchantBusinessLicense;
import com.sbm.module.onlineleasing.base.user.domain.TOLUser;
import com.sbm.module.onlineleasing.base.usercontacts.domain.TOLUserContacts;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/
/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.domain<br/>
 * File Name:JsonContainer.java<br/>
 * 
 * 作成日 ：2016-1-7 下午2:23:21 <br/>
 * 
 * @author ：junkai.zhang
 * @preserve all
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
public class Register implements IApiInteractiveProcess {

	public Object clone(Object body) {
		Register obj = (Register) CloneUtil.jsonClone(body, Register.class);
		if (null != obj && null != obj.getUser()) {
			if (StringUtils.isNotBlank(obj.getUser().getPassword())) {
				obj.getUser().setPassword(ApiInteractiveConstant.STAR);
			}
		}
		return obj;
	}

	// 用户相关
	private TOLUser user;

	private VerificationCode verificationCode;

	private TOLUserContacts userContacts;

	// 租户相关
	private TOLMerchant merchant;

	private TOLMerchantAddress merchantAddress;

	// private TOLMerchantBankAccount merchantBankAccount;

	private TOLMerchantBusinessLicense merchantBusinessLicense;

	private Integer merchantBrandCount;

	// 品牌相关
	private BrandInfo brandInfo;

	public TOLUser getUser() {
		return user;
	}

	public void setUser(TOLUser user) {
		this.user = user;
	}

	public TOLUserContacts getUserContacts() {
		return userContacts;
	}

	public void setUserContacts(TOLUserContacts userContacts) {
		this.userContacts = userContacts;
	}

	public TOLMerchant getMerchant() {
		return merchant;
	}

	public void setMerchant(TOLMerchant merchant) {
		this.merchant = merchant;
	}

	public TOLMerchantAddress getMerchantAddress() {
		return merchantAddress;
	}

	public void setMerchantAddress(TOLMerchantAddress merchantAddress) {
		this.merchantAddress = merchantAddress;
	}

	public TOLMerchantBusinessLicense getMerchantBusinessLicense() {
		return merchantBusinessLicense;
	}

	public void setMerchantBusinessLicense(TOLMerchantBusinessLicense merchantBusinessLicense) {
		this.merchantBusinessLicense = merchantBusinessLicense;
	}

	public BrandInfo getBrandInfo() {
		return brandInfo;
	}

	public void setBrandInfo(BrandInfo brandInfo) {
		this.brandInfo = brandInfo;
	}

	public VerificationCode getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(VerificationCode verificationCode) {
		this.verificationCode = verificationCode;
	}

	public Integer getMerchantBrandCount() {
		return merchantBrandCount;
	}

	public void setMerchantBrandCount(Integer merchantBrandCount) {
		this.merchantBrandCount = merchantBrandCount;
	}

}
