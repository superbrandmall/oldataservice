package com.sbm.module.onlineleasing.api.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.register.biz.IRegisterMerchantCheckService;
import com.sbm.module.onlineleasing.api.register.domain.RegisterMerchantCheck;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency
@Authorization
@Controller
@RequestMapping("/ol/api/register/merchantcheck")
public class RegisterMerchantCheckController extends BaseController {

	@Autowired
	private IRegisterMerchantCheckService service;

	@RequestMapping(value = "/search")
	@ResponseBody
	public JsonContainer search(@RequestBody RegisterMerchantCheck registerMerchantCheck) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getSearch(registerMerchantCheck);
		setSuccessMessage(jsonContainer, registerMerchantCheck);
		return jsonContainer;
	}

	@RequestMapping(value = "/baseInfo")
	@ResponseBody
	public JsonContainer baseInfo(@RequestBody RegisterMerchantCheck registerMerchantCheck) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getBaseInfo(registerMerchantCheck);
		setSuccessMessage(jsonContainer, registerMerchantCheck);
		return jsonContainer;
	}

	@RequestMapping(value = "/baseInfo/V2")
	@ResponseBody
	public JsonContainer baseInfoV2(@RequestBody RegisterMerchantCheck registerMerchantCheck) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getBaseInfoV2(registerMerchantCheck);
		setSuccessMessage(jsonContainer, registerMerchantCheck);
		return jsonContainer;
	}
	
}