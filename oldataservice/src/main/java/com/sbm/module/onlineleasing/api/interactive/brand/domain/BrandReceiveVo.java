package com.sbm.module.onlineleasing.api.interactive.brand.domain;

import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;

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
public class BrandReceiveVo {

	private TOLBrand brand;

	private String method;

	private String code;

	private String message;

	public TOLBrand getBrand() {
		return brand;
	}

	public void setBrand(TOLBrand brand) {
		this.brand = brand;
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
