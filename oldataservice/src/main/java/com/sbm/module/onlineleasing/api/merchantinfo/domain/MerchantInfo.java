/**
 * Project Name:posUploadData
 * File Name:JsonContainer.java
 * Package Name:com.sbm.module.postsales.domain
 * Date:2016-1-7下午2:23:21
 * Copyright (c) 2016, Super Brand Mail Inc All Rights Reserved.
 *
 */

package com.sbm.module.onlineleasing.api.merchantinfo.domain;

import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.onlineleasing.base.merchantaddress.domain.TOLMerchantAddress;
import com.sbm.module.onlineleasing.base.merchantbankaccount.domain.TOLMerchantBankAccount;
import com.sbm.module.onlineleasing.base.merchantbusinesslicense.domain.TOLMerchantBusinessLicense;

import java.util.List;

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
public class MerchantInfo {

	private String merchantCode;

	private TOLMerchant merchant;

	public List<TOLMerchantBankAccount> getMerchantBankAccounts() {
		return merchantBankAccounts;
	}

	public void setMerchantBankAccounts(List<TOLMerchantBankAccount> merchantBankAccounts) {
		this.merchantBankAccounts = merchantBankAccounts;
	}

	private TOLMerchantAddress merchantAddress;

	private List<TOLMerchantBankAccount> merchantBankAccounts;

	private TOLMerchantBusinessLicense merchantBusinessLicense;

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
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

}
