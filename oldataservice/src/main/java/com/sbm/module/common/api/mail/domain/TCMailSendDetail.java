package com.sbm.module.common.api.mail.domain;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sbm.module.common.business.domain.BaseEntity;

/*****************************************************************************/
/**
 * Project Name:CRMDataProcess<br/>
 * Package Name:com.sbm.module.gag.domain<br/>
 * File Name:GAGReceipt.java<br/>
 * 
 * 作成日 ：2017-4-13 下午5:58:11 <br/>
 * 
 * @author ：junkai.zhang
 */
@Entity(name = "TCMailSendDetail")
@Table(name = "T_C_MAIL_SEND_DETAIL")
public class TCMailSendDetail extends BaseEntity {

	private String code;

	private String mailTemplateCode;

	private String sentFrom;

	private String sentTo;

	private String sentCc;

	// 参数map
	@Transient
	private Map<String, Object> paramsMap;

	// 参数字符串
	@Column(columnDefinition = "text")
	private String params;

	@Column(columnDefinition = "timestamp")
	private Date sentDate;

	@Column(columnDefinition = "text")
	private String html;

	private Integer type;

	@Column(columnDefinition = "text")
	private String errorMessage;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMailTemplateCode() {
		return mailTemplateCode;
	}

	public void setMailTemplateCode(String mailTemplateCode) {
		this.mailTemplateCode = mailTemplateCode;
	}

	public String getSentFrom() {
		return sentFrom;
	}

	public void setSentFrom(String sentFrom) {
		this.sentFrom = sentFrom;
	}

	public String getSentTo() {
		return sentTo;
	}

	public void setSentTo(String sentTo) {
		this.sentTo = sentTo;
	}

	public String getSentCc() {
		return sentCc;
	}

	public void setSentCc(String sentCc) {
		this.sentCc = sentCc;
	}

	public Map<String, Object> getParamsMap() {
		return paramsMap;
	}

	public void setParamsMap(Map<String, Object> paramsMap) {
		this.paramsMap = paramsMap;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
