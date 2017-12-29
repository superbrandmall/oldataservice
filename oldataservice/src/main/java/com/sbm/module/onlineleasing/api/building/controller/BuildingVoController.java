package com.sbm.module.onlineleasing.api.building.controller;

import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.api.building.biz.IBuildingVoService;
import com.sbm.module.onlineleasing.api.building.domain.BuildingVo;
import com.sbm.module.onlineleasing.api.mall.biz.IMallVoService;
import com.sbm.module.onlineleasing.api.mall.domain.MallVo;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;
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
@RequestMapping("/ol/api/building")
public class BuildingVoController extends BaseController {

	@Autowired
	private IBuildingVoService service;

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
	public JsonContainer findAllByConditionPage(@RequestBody BuildingVo vo) {
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
	public JsonContainer detail(@RequestBody BuildingVo vo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.findByCode(vo);
		setSuccessMessage(jsonContainer, vo);
		return jsonContainer;
	}
}