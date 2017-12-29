package com.sbm.module.common.api.verificationcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.api.verificationcode.biz.IVerificationCodeService;
import com.sbm.module.common.api.verificationcode.domain.VerificationCode;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency
@Controller
@RequestMapping("/ol/api/verificationcode")
public class VerificationCodeController extends BaseController {

	@Autowired
	private IVerificationCodeService service;

	@RequestMapping(value = "/email")
	@ResponseBody
	public JsonContainer email(@RequestBody VerificationCode verificationCode) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getEmailVerificationCode(verificationCode);
		setSuccessMessage(jsonContainer, verificationCode);
		return jsonContainer;
	}

	@RequestMapping(value = "/mobile")
	@ResponseBody
	public JsonContainer mobile(@RequestBody VerificationCode verificationCode) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getMobileVerificationCode(verificationCode);
		setSuccessMessage(jsonContainer, verificationCode);
		return jsonContainer;
	}

	@RequestMapping(value = "/check")
	@ResponseBody
	public JsonContainer check(@RequestBody VerificationCode verificationCode) {
		JsonContainer jsonContainer = getJsonContainer();
		service.checkVerificationCode(verificationCode);
		setSuccessMessage(jsonContainer, verificationCode);
		return jsonContainer;
	}

}