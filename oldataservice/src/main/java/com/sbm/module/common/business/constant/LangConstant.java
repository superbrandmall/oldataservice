package com.sbm.module.common.business.constant;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.common.constant<br/>
 * File Name:BusinessCode.java<br/>
 * 
 * 作成日 ：2017-7-28 下午3:31:01 <br/>
 * 
 * @author ：junkai.zhang
 */
public enum LangConstant {

	/*****************************************************************/
	// 语言

	/**
	 * 中文
	 */
	ZH_CN("1", "ZH_CN"),
	/**
	 * 英文
	 */
	EN_US("2", "EN_US");

	/*****************************************************************/

	private String lang;

	private String type;

	private LangConstant(String lang, String type) {
		this.lang = lang;
		this.type = type;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer intValue() {
		return Integer.valueOf(lang);
	}
}
