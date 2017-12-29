package com.sbm.module.partner.hd.rest.merchant.domain;

public class HdMerchantProperties {

	/**
	 * 注册地址
	 */
	private String registerAddress;

	/**
	 * 注册资金

	 */
	private String regCapital;

	/**
	 * 股东结构
	 */
	private String shareholder;

	/**
	 * 统一社会信用代码
	 */
	private String uscc;

	/**
	 * 经营范围
	 */
	private String business_scope;

	/**
	 * 天眼查ID
	 */
	private String tianyancha_id;

	/**
	 * 邮寄地址
	 */
	private String postAddress;

	/**
	 * 营业执照

	 */
	private String business_licence;

	/**
	 * OL商户访问URL
	 */
	private String ol_url;

	public String getShareholder() {
		return shareholder;
	}

	public void setShareholder(String shareholder) {
		this.shareholder = shareholder;
	}

	public String getUscc() {
		return uscc;
	}

	public void setUscc(String uscc) {
		this.uscc = uscc;
	}

	public String getBusiness_scope() {
		return business_scope;
	}

	public void setBusiness_scope(String business_scope) {
		this.business_scope = business_scope;
	}

	public String getTianyancha_id() {
		return tianyancha_id;
	}

	public void setTianyancha_id(String tianyancha_id) {
		this.tianyancha_id = tianyancha_id;
	}

	public String getPostAddress() {
		return postAddress;
	}

	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}

	public String getBusiness_licence() {
		return business_licence;
	}

	public void setBusiness_licence(String business_licence) {
		this.business_licence = business_licence;
	}

	public String getOl_url() {
		return ol_url;
	}

	public String getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(String regCapital) {
		this.regCapital = regCapital;
	}

	public void setOl_url(String ol_url) {
		this.ol_url = ol_url;
	}

	public String getRegisterAddress() {
		return registerAddress;
	}

	public void setRegisterAddress(String registerAddress) {
		this.registerAddress = registerAddress;
	}
}
