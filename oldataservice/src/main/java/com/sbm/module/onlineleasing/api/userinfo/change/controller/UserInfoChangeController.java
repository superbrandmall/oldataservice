package com.sbm.module.onlineleasing.api.userinfo.change.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.userinfo.change.biz.IUserInfoChangeService;
import com.sbm.module.onlineleasing.api.userinfo.change.domain.UserInfoChange;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency
@Controller
@RequestMapping("/ol/api/userinfo")
public class UserInfoChangeController extends BaseController {

	@Autowired
	private IUserInfoChangeService service;

	/**
	 * 
	 * forgetPassword:忘记密码
	 * 
	 * @author junkai.zhang
	 * @param login
	 * @return
	 */
	@RequestMapping(value = "/forget/password")
	@ResponseBody
	public JsonContainer forgetPassword(@RequestBody UserInfoChange userInfoChange) {
		JsonContainer jsonContainer = getJsonContainer();
		service.forgetPassword(userInfoChange);
		setSuccessMessage(jsonContainer, null);
		return jsonContainer;
	}

	/**
	 * 
	 * changePassword:修改密码
	 * 
	 * @author junkai.zhang
	 * @param login
	 * @return
	 */
	@Authorization
	@RequestMapping(value = "/change/password")
	@ResponseBody
	public JsonContainer changePassword(@RequestBody UserInfoChange userInfoChange) {
		JsonContainer jsonContainer = getJsonContainer();
		service.changePassword(userInfoChange);
		setSuccessMessage(jsonContainer, null);
		return jsonContainer;
	}

	/**
	 * 
	 * changeMobile:修改手机
	 * 
	 * @author junkai.zhang
	 * @param userInfoChange
	 * @return
	 */
	@Authorization
	@RequestMapping(value = "/change/mobile")
	@ResponseBody
	public JsonContainer changeMobile(@RequestBody UserInfoChange userInfoChange) {
		JsonContainer jsonContainer = getJsonContainer();
		service.changeMobile(userInfoChange);
		setSuccessMessage(jsonContainer, null);
		return jsonContainer;
	}

	/**
	 * 
	 * changeEmail:修改邮箱
	 * 
	 * @author junkai.zhang
	 * @param userInfoChange
	 * @return
	 */
	@Authorization
	@RequestMapping(value = "/change/email")
	@ResponseBody
	public JsonContainer changeEmail(@RequestBody UserInfoChange userInfoChange) {
		JsonContainer jsonContainer = getJsonContainer();
		service.changeEmail(userInfoChange);
		setSuccessMessage(jsonContainer, null);
		return jsonContainer;
	}

}