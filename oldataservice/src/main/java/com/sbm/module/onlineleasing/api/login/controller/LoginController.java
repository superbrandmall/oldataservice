package com.sbm.module.onlineleasing.api.login.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.api.jsonwebtoken.biz.IJSONWebTokenService;
import com.sbm.module.common.api.jsonwebtoken.constant.JSONWebTokenConstant;
import com.sbm.module.common.api.jsonwebtoken.domain.JSONWebToken;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.login.biz.ILoginService;
import com.sbm.module.onlineleasing.api.login.domain.Login;
import com.sbm.module.onlineleasing.base.user.constant.UserConstant;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency(timeout = 60L, limit = 20)
@Controller
@RequestMapping("/ol/api/login")
public class LoginController extends BaseController {

	@Autowired
	private ILoginService service;
	@Autowired
	private IJSONWebTokenService tokenService;

	/**
	 * 
	 * login:登陆
	 * 
	 * @author junkai.zhang
	 * @param login
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public JsonContainer login(@RequestBody Login login, HttpServletResponse response) {
		JsonContainer jsonContainer = getJsonContainer();
		service.login(login, UserConstant.USER);
		setSuccessMessage(jsonContainer, login);

		// 设置token
		response.setHeader(JSONWebTokenConstant.AUTHORIZATION,
				tokenService.getJWTString(new JSONWebToken(login.getCode(), login.getType())));
		// 回传login
		response.setHeader(JSONWebTokenConstant.LOGIN, login.getCode());
		return jsonContainer;
	}

	/**
	 * 
	 * adminLogin:管理员登陆
	 * 
	 * @author junkai.zhang
	 * @param login
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/adminLogin")
	@ResponseBody
	public JsonContainer adminLogin(@RequestBody Login login, HttpServletResponse response) {
		JsonContainer jsonContainer = getJsonContainer();
		service.login(login, UserConstant.ADMIN);
		setSuccessMessage(jsonContainer, login);

		// 设置token
		response.setHeader(JSONWebTokenConstant.AUTHORIZATION,
				tokenService.getJWTString(new JSONWebToken(login.getCode(), login.getType())));
		// 回传login
		response.setHeader(JSONWebTokenConstant.LOGIN, login.getCode());
		return jsonContainer;
	}

	/**
	 * 
	 * lang:切换语言
	 * 
	 * @author junkai.zhang
	 * @param login
	 * @return
	 */
	@RequestMapping(value = "/lang")
	@ResponseBody
	public JsonContainer lang(@RequestBody Login login) {
		JsonContainer jsonContainer = getJsonContainer();
		service.updateLanguage(login);
		setSuccessMessage(jsonContainer, login);
		return jsonContainer;
	}

}