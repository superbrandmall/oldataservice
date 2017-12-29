package com.sbm.module.onlineleasing.api.userinfo.check.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.userinfo.check.biz.IUserInfoCheckService;
import com.sbm.module.onlineleasing.api.userinfo.check.domain.UserInfoCheck;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency
@Controller
@RequestMapping("/ol/api/userinfo/check")
public class UserInfoCheckController extends BaseController {

	@Autowired
	private IUserInfoCheckService service;

	/**
	 * 
	 * isNotExistMobile:手机号不存在
	 * 
	 * @author junkai.zhang
	 * @param mobile
	 * @return
	 */
	@RequestMapping(value = "/isNotExist/mobile")
	@ResponseBody
	public JsonContainer isNotExistMobile(@RequestBody UserInfoCheck userInfoCheck) {
		JsonContainer jsonContainer = getJsonContainer();
		service.isNotExistMobile(userInfoCheck.getMobile());
		setSuccessMessage(jsonContainer, null);
		return jsonContainer;
	}

	/**
	 * 
	 * isNotExistEmail:邮箱不存在
	 * 
	 * @author junkai.zhang
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/isNotExist/email")
	@ResponseBody
	public JsonContainer isNotExistEmail(@RequestBody UserInfoCheck userInfoCheck) {
		JsonContainer jsonContainer = getJsonContainer();
		service.isNotExistEmail(userInfoCheck.getEmail());
		setSuccessMessage(jsonContainer, null);
		return jsonContainer;
	}

	/**
	 * 
	 * isNotExistIdCard:证件不存在
	 * 
	 * @author junkai.zhang
	 * @param userInfoCheck
	 * @return
	 */
	@RequestMapping(value = "/isNotExist/idCard")
	@ResponseBody
	public JsonContainer isNotExistIdCard(@RequestBody UserInfoCheck userInfoCheck) {
		JsonContainer jsonContainer = getJsonContainer();
		service.isNotExistIdCard(userInfoCheck.getIdCard());
		setSuccessMessage(jsonContainer, null);
		return jsonContainer;
	}

	/*****************************************************************/

	/**
	 * 
	 * existMobile:手机号存在
	 * 
	 * @author junkai.zhang
	 * @param mobile
	 * @return
	 */
	@RequestMapping(value = "/exist/mobile")
	@ResponseBody
	public JsonContainer existMobile(@RequestBody UserInfoCheck userInfoCheck) {
		JsonContainer jsonContainer = getJsonContainer();
		service.existMobile(userInfoCheck.getMobile());
		setSuccessMessage(jsonContainer, null);
		return jsonContainer;
	}

	/**
	 * 
	 * existEmail:邮箱存在
	 * 
	 * @author junkai.zhang
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/exist/email")
	@ResponseBody
	public JsonContainer existEmail(@RequestBody UserInfoCheck userInfoCheck) {
		JsonContainer jsonContainer = getJsonContainer();
		service.existEmail(userInfoCheck.getEmail());
		setSuccessMessage(jsonContainer, null);
		return jsonContainer;
	}

	/**
	 * 
	 * existIdCard:证件存在
	 * 
	 * @author junkai.zhang
	 * @param userInfoCheck
	 * @return
	 */
	@RequestMapping(value = "/exist/idCard")
	@ResponseBody
	public JsonContainer existIdCard(@RequestBody UserInfoCheck userInfoCheck) {
		JsonContainer jsonContainer = getJsonContainer();
		service.existIdCard(userInfoCheck.getIdCard());
		setSuccessMessage(jsonContainer, null);
		return jsonContainer;
	}

}