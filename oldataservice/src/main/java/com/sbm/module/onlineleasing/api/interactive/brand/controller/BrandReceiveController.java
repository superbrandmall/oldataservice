package com.sbm.module.onlineleasing.api.interactive.brand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.interactive.brand.biz.IBrandReceiveService;
import com.sbm.module.onlineleasing.api.interactive.brand.domain.BrandReceiveVo;
import com.sbm.module.onlineleasing.base.user.constant.UserConstant;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Authorization(type = UserConstant.ADMIN)
@Controller
@RequestMapping("/ol/api/interactive/brand")
public class BrandReceiveController extends BaseController {

	@Autowired
	private IBrandReceiveService service;

	@RequestMapping(value = "/receive")
	@ResponseBody
	public JsonContainer receive(@RequestBody BrandReceiveVo vo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.receive(vo);
		setSuccessMessage(jsonContainer, null);
		return jsonContainer;
	}

}