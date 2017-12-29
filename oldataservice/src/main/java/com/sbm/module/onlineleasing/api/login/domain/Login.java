package com.sbm.module.onlineleasing.api.login.domain;

import org.apache.commons.lang3.StringUtils;

import com.sbm.module.common.api.apiinteractive.constant.ApiInteractiveConstant;
import com.sbm.module.common.api.apiinteractive.handler.IApiInteractiveProcess;
import com.sbm.module.common.base.util.CloneUtil;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.onlineleasingapi.login.domain<br/>
 * File Name:Login.java<br/>
 * 
 * 作成日 ：2017-8-3 上午10:13:05 <br/>
 * 
 * @author ：junkai.zhang
 */
public class Login implements IApiInteractiveProcess {

	public Object clone(Object body) {
		Login obj = (Login) CloneUtil.jsonClone(body, Login.class);
		if (StringUtils.isNotBlank(obj.getPassword())) {
			obj.setPassword(ApiInteractiveConstant.STAR);
		}
		return obj;
	}

	private String username;

	private String password;

	private String code;

	private String email;

	private String mobile;

	private String merchantCode;

	private String merchantName;

	private Integer lang;

	private Integer regState;

	private Integer type;

	private Integer international;

	private Integer merchantBrandCount;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public Integer getLang() {
		return lang;
	}

	public void setLang(Integer lang) {
		this.lang = lang;
	}

	public Integer getRegState() {
		return regState;
	}

	public void setRegState(Integer regState) {
		this.regState = regState;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getInternational() {
		return international;
	}

	public void setInternational(Integer international) {
		this.international = international;
	}

	public Integer getMerchantBrandCount() {
		return merchantBrandCount;
	}

	public void setMerchantBrandCount(Integer merchantBrandCount) {
		this.merchantBrandCount = merchantBrandCount;
	}

}
