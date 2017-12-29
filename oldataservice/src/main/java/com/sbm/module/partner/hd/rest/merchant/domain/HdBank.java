package com.sbm.module.partner.hd.rest.merchant.domain;

public class HdBank {

	/**
	 * 银行名称
	 */
	private String name;

	/**
	 * 银行账号
	 */
	private String account;

	public HdBank(String name, String account) {
		this.name = name;
		this.account = account;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public HdBank() {

	}
}
