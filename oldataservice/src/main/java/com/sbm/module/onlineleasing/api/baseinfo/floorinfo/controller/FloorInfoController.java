package com.sbm.module.onlineleasing.api.baseinfo.floorinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.baseinfo.floorinfo.biz.IFloorInfoService;
import com.sbm.module.onlineleasing.api.baseinfo.floorinfo.domain.FloorInfoVo;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency(limit = 30)
// @Authorization(type = UserConstant.USER)
@Controller
@RequestMapping("/ol/api/baseinfo/floorinfo")
public class FloorInfoController extends BaseController {

	@Autowired
	private IFloorInfoService service;

	/**
	 * 
	 * getFloorInfo:获取getFloorInfo
	 * 
	 * @author junkai.zhang
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/getFloorInfo")
	@ResponseBody
	public JsonContainer getFloorInfo(@RequestBody FloorInfoVo vo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getFloorInfo(vo);
		setSuccessMessage(jsonContainer, vo);
		return jsonContainer;
	}

}