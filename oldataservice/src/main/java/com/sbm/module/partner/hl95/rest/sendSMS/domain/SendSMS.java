package com.sbm.module.partner.hl95.rest.sendSMS.domain;

import org.apache.commons.lang3.StringUtils;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hl95.rest.sendSMS.domain<br/>
 * File Name:SendSMS.java<br/>
 * 
 * 作成日 ：2017-10-24 下午5:00:38 <br/>
 * 
 * @author ：junkai.zhang
 */
public class SendSMS {

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 短信
	 */
	private String message;

	/**
	 * 下发唯一标识
	 */
	private String linkid = StringUtils.EMPTY;

	/**
	 * 扩展小号
	 */
	private String subcode = StringUtils.EMPTY;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLinkid() {
		return linkid;
	}

	public void setLinkid(String linkid) {
		this.linkid = linkid;
	}

	public String getSubcode() {
		return subcode;
	}

	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}

}
