package com.sbm.module.onlineleasing.api.admin.user.controller;

import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.admin.floor.biz.IFloorVoService;
import com.sbm.module.onlineleasing.api.admin.floor.domain.FloorVo;
import com.sbm.module.onlineleasing.api.admin.user.biz.IUserVoService;
import com.sbm.module.onlineleasing.api.admin.user.domain.UserVo;
import com.sbm.module.onlineleasing.base.user.constant.UserConstant;
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
@Authorization(type = UserConstant.ADMIN)
@Controller
@RequestMapping("/ol/api/user")
public class UserVoController extends BaseController {

	@Autowired
	private IUserVoService service;

	/******************************************************************************************/
	// 条件查询分页

	/**
	 *
	 * findAllByConditionPage:条件查询分页
	 *
	 * @author junkai.zhang
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/findAllByConditionPage")
	@ResponseBody
	public JsonContainer findAllByConditionPage(@RequestBody UserVo vo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.findAllByConditionPage(vo);
		setSuccessMessage(jsonContainer, vo);
		return jsonContainer;
	}

	/******************************************************************************************/
	// 明细

	/**
	 * 明细
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/findByCode")
	@ResponseBody
	public JsonContainer detail(@RequestBody UserVo vo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.findByCode(vo);
		setSuccessMessage(jsonContainer, vo);
		return jsonContainer;
	}
}