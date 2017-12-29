package com.sbm.module.onlineleasing.api.baseinfo.bidparam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.baseinfo.bidparam.biz.IBidParamService;
import com.sbm.module.onlineleasing.api.baseinfo.bidparam.domain.BidParamVo;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency
// @Authorization(type = UserConstant.USER)
@Controller
@RequestMapping("/ol/api/baseinfo/bidparam")
public class BidParamController extends BaseController {

	@Autowired
	private IBidParamService service;

	/******************************************************************************************/
	// 条件查询分页

	/**
	 * 
	 * getBidParam:获取出价参数
	 * 
	 * @author junkai.zhang
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/getBidParam")
	@ResponseBody
	public JsonContainer getBidParam(@RequestBody BidParamVo vo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getBidParam(vo);
		setSuccessMessage(jsonContainer, vo);
		return jsonContainer;
	}

}