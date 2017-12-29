package com.sbm.module.onlineleasing.base.user.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
@Entity(name = "TOLUser")
@Table(name = "T_OL_USER")
public class TOLUser extends BaseEntity {

	private String code;

	private String merchantCode;

	private String email;

	private String mobile;

	private String password;

	private Integer lang;

	private Integer type;

	// private Integer regState;

	@Column(columnDefinition = "timestamp")
	private Date lastLogin;

	private Integer emailVerified;

	private Integer mobileVerified;

	private Integer international;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLang() {
		return lang;
	}

	public void setLang(Integer lang) {
		this.lang = lang;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	// public Integer getRegState() {
	// return regState;
	// }
	//
	// public void setRegState(Integer regState) {
	// this.regState = regState;
	// }

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Integer getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Integer emailVerified) {
		this.emailVerified = emailVerified;
	}

	public Integer getMobileVerified() {
		return mobileVerified;
	}

	public void setMobileVerified(Integer mobileVerified) {
		this.mobileVerified = mobileVerified;
	}

	public Integer getInternational() {
		return international;
	}

	public void setInternational(Integer international) {
		this.international = international;
	}

}
