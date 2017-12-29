package com.sbm.module.onlineleasing.api.interactive.bidresult.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.interactive.bidresult.biz.IBidResultReceiveService;
import com.sbm.module.onlineleasing.api.interactive.bidresult.domain.BidResultReceiveVo;
import com.sbm.module.onlineleasing.base.user.constant.UserConstant;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Authorization(type = UserConstant.ADMIN)
@Controller
@RequestMapping("/ol/api/interactive/bidresult")
public class BidResultReceiveController extends BaseController {

	@Autowired
	private IBidResultReceiveService service;

//	@ApiOperation(nickname = "approve", value="审批通过", notes="审批通过")
//	@ApiImplicitParam(name = "vo", value = "出价结果列表", required = true, dataType = "BidResultReceiveVo")
	@RequestMapping(value = "/approve", method = RequestMethod.POST)
	@ResponseBody
	public JsonContainer approve(@RequestBody BidResultReceiveVo vo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.approve(vo);
		setSuccessMessage(jsonContainer, null);
		return jsonContainer;
	}

//	@ApiOperation(nickname = "effect", value="出价生效", notes="出价生效")
//	@ApiImplicitParam(name = "vo", value = "出价结果列表", required = true, dataType = "BidResultReceiveVo")
	@RequestMapping(value = "/effect", method = RequestMethod.POST)
	@ResponseBody
	public JsonContainer effect(@RequestBody BidResultReceiveVo vo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.effect(vo);
		setSuccessMessage(jsonContainer, null);
		return jsonContainer;
	}

}