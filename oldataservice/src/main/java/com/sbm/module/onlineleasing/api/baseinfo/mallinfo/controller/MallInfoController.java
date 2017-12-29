package com.sbm.module.onlineleasing.api.baseinfo.mallinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.baseinfo.mallinfo.biz.IMallInfoService;
import com.sbm.module.onlineleasing.api.baseinfo.mallinfo.domain.MallInfoVo;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency
// @Authorization(type = UserConstant.USER)
@Controller
@RequestMapping("/ol/api/baseinfo/mallinfo")
public class MallInfoController extends BaseController {

	@Autowired
	private IMallInfoService service;

	/**
	 * 
	 * getMallInfo:获取getMallInfo
	 * 
	 * @author junkai.zhang
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/getMallInfo")
	@ResponseBody
	public JsonContainer getMallInfo(@RequestBody MallInfoVo vo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getMallInfo(vo);
		setSuccessMessage(jsonContainer, vo);
		return jsonContainer;
	}

}