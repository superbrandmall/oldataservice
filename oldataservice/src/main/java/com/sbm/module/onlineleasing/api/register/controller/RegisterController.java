package com.sbm.module.onlineleasing.api.register.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.api.jsonwebtoken.biz.IJSONWebTokenService;
import com.sbm.module.common.api.jsonwebtoken.constant.JSONWebTokenConstant;
import com.sbm.module.common.api.jsonwebtoken.domain.JSONWebToken;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.register.biz.IRegisterService;
import com.sbm.module.onlineleasing.api.register.domain.Register;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency
@Controller
@RequestMapping("/ol/api/register")
public class RegisterController extends BaseController {

	@Autowired
	private IRegisterService service;
	@Autowired
	private IJSONWebTokenService tokenService;

	/**********************************************************************/

	/**
	 * 
	 * step1:阶段1
	 * 
	 * @author junkai.zhang
	 * @param register
	 * @return
	 */
	@RequestMapping(value = "/step1")
	@ResponseBody
	public JsonContainer step1(@RequestBody Register register, HttpServletResponse response) {
		JsonContainer jsonContainer = getJsonContainer();
		service.step1(register);
		setSuccessMessage(jsonContainer, register);

		// 设置token
		response.setHeader(JSONWebTokenConstant.AUTHORIZATION,
				tokenService.getJWTString(new JSONWebToken(register.getUser().getCode(), register.getUser().getType())));
		// 回传login
		response.setHeader(JSONWebTokenConstant.LOGIN, register.getUser().getCode());
		return jsonContainer;
	}

	/**********************************************************************/

	/**
	 * 
	 * step2:阶段2
	 * 
	 * @author junkai.zhang
	 * @param register
	 * @return
	 */
	@Authorization
	@RequestMapping(value = "/step2")
	@ResponseBody
	public JsonContainer step2(@RequestBody Register register) {
		JsonContainer jsonContainer = getJsonContainer();
		service.step2(register);
		setSuccessMessage(jsonContainer, register);
		return jsonContainer;
	}

	/**********************************************************************/

	/**
	 * 
	 * step3:step3，已有品牌，不修改
	 * 
	 * @author junkai.zhang
	 * @param register
	 * @return
	 */
	@Authorization
	@RequestMapping(value = "/step3AddExistingBrandWithoutUpdate")
	@ResponseBody
	public JsonContainer step3AddExistingBrandWithoutUpdate(@RequestBody Register register) {
		JsonContainer jsonContainer = getJsonContainer();
		service.step3AddExistingBrandWithoutUpdate(register);
		setSuccessMessage(jsonContainer, register);
		return jsonContainer;
	}

	/**
	 * 
	 * step3:step3，新增品牌
	 * 
	 * @author junkai.zhang
	 * @param register
	 * @return
	 */
	@Authorization
	@RequestMapping(value = "/step3AddNewBrand")
	@ResponseBody
	public JsonContainer step3AddNewBrand(@RequestBody Register register) {
		JsonContainer jsonContainer = getJsonContainer();
		service.step3AddNewBrand(register);
		setSuccessMessage(jsonContainer, register);
		return jsonContainer;
	}
}