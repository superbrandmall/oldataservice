package com.sbm.module.common.api.verificationcode.domain;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.commonapi.mail.domain<br/>
 * File Name:MailData.java<br/>
 * 
 * 作成日 ：2017-8-3 下午2:11:23 <br/>
 * 
 * @author ：junkai.zhang
 */
public class VerificationCode {

	/**
	 * 关键字
	 */
	private String keyword;

	/**
	 * 生成的key
	 */
	private String key;

	/**
	 * 值
	 */
	private Object value;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
