package com.sbm.module.common.api.serialcode.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.api.serialcode.biz.ITCSerialCodeService;
import com.sbm.module.common.api.serialcode.domain.TCSerialCode;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency
@Authorization
@Controller
@RequestMapping("/ol/api/serialcode")
public class SerialCodeController extends BaseController {

	@Autowired
	private ITCSerialCodeService service;

	@RequestMapping(value = "/next/{serialGroup}")
	@ResponseBody
	public JsonContainer next(@PathVariable("serialGroup") String serialGroup) {
		JsonContainer jsonContainer = getJsonContainer();
		TCSerialCode serialCode = service.nextBizId(serialGroup);
		setSuccessMessage(jsonContainer, serialCode);
		return jsonContainer;
	}

	@Authorization
	@RequestMapping(value = "/nextarr")
	@ResponseBody
	public JsonContainer nextarr(@RequestParam(value = "serialGroup[]") String[] serialGroup) {
		JsonContainer jsonContainer = getJsonContainer();
		Map<String, TCSerialCode> map = new HashMap<String, TCSerialCode>();
		for (String sg : serialGroup) {
			TCSerialCode serialCode = service.nextBizId(sg);
			map.put(sg, serialCode);
		}
		setSuccessMessage(jsonContainer, map);
		return jsonContainer;
	}

}