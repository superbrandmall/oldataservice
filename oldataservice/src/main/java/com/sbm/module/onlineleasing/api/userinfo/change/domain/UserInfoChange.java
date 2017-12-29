/**
 * Project Name:posUploadData
 * File Name:JsonContainer.java
 * Package Name:com.sbm.module.postsales.domain
 * Date:2016-1-7下午2:23:21
 * Copyright (c) 2016, Super Brand Mail Inc All Rights Reserved.
 *
 */

package com.sbm.module.onlineleasing.api.userinfo.change.domain;

import org.apache.commons.lang3.StringUtils;

import com.sbm.module.common.api.apiinteractive.constant.ApiInteractiveConstant;
import com.sbm.module.common.api.apiinteractive.handler.IApiInteractiveProcess;
import com.sbm.module.common.api.verificationcode.domain.VerificationCode;
import com.sbm.module.common.base.util.CloneUtil;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/
/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.domain<br/>
 * File Name:JsonContainer.java<br/>
 * 
 * 作成日 ：2016-1-7 下午2:23:21 <br/>
 * 
 * @author ：junkai.zhang
 * @preserve all
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
public class UserInfoChange implements IApiInteractiveProcess {

	public Object clone(Object body) {
		UserInfoChange obj = (UserInfoChange) CloneUtil.jsonClone(body, UserInfoChange.class);
		if (StringUtils.isNotBlank(obj.getPassword())) {
			obj.setPassword(ApiInteractiveConstant.STAR);
		}
		return obj;
	}

	private String userCode;

	private String username;

	private String password;

	private String oldPassword;

	private VerificationCode verificationCode;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

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

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public VerificationCode getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(VerificationCode verificationCode) {
		this.verificationCode = verificationCode;
	}

}
