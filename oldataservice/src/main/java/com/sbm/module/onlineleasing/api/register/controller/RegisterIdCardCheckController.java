package com.sbm.module.onlineleasing.api.register.controller;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.register.biz.IRegisterIdCardCheckService;
import com.sbm.module.onlineleasing.api.register.biz.IRegisterMerchantCheckService;
import com.sbm.module.onlineleasing.api.register.domain.RegisterIdCardCheck;
import com.sbm.module.onlineleasing.api.register.domain.RegisterMerchantCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */

/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency
@Authorization
@Controller
@RequestMapping("/ol/api/register/idcardcheck")
public class RegisterIdCardCheckController extends BaseController {

	@Autowired
	private IRegisterIdCardCheckService service;

	@RequestMapping(value = "/idcard")
	@ResponseBody
	public JsonContainer baseInfoV2(@RequestBody RegisterIdCardCheck registerIdCardCheck) {
		JsonContainer jsonContainer = getJsonContainer();
		service.check(registerIdCardCheck);
		setSuccessMessage(jsonContainer, null);
		return jsonContainer;
	}
	
}