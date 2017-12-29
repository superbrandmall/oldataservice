package com.sbm.module.onlineleasing.api.interactive.merchant.domain;

import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.onlineleasing.api.interactive.merchant.domain<br/>
 * File Name:Merchant.java<br/>
 * 
 * 作成日 ：2017-9-25 下午4:57:42 <br/>
 * 
 * @author ：junkai.zhang
 */
public class MerchantReceiveVo {

	private TOLMerchant merchant;

	private String method;

	private String code;

	private String message;

	public TOLMerchant getMerchant() {
		return merchant;
	}

	public void setMerchant(TOLMerchant merchant) {
		this.merchant = merchant;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
