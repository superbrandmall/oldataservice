package com.sbm.module.onlineleasing.api.sysmessage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.sysmessage.biz.ISysMessageService;
import com.sbm.module.onlineleasing.api.sysmessage.domain.SysMessage;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency(timeout = 60L, limit = 30)
@Authorization
@Controller
@RequestMapping("/ol/api/sysmessage")
public class SysMessageController extends BaseController {

	@Autowired
	private ISysMessageService service;

	/**
	 * 
	 * details:查询系统消息明细
	 * 
	 * @author junkai.zhang
	 * @param sysMessage
	 * @return
	 */
	@RequestMapping(value = "/details")
	@ResponseBody
	public JsonContainer details(@RequestBody SysMessage sysMessage) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getDetails(sysMessage);
		setSuccessMessage(jsonContainer, sysMessage);
		return jsonContainer;
	}

	/**
	 * 
	 * readed:未读变已读
	 * 
	 * @author junkai.zhang
	 * @param sysMessage
	 * @return
	 */
	@RequestMapping(value = "/read")
	@ResponseBody
	public JsonContainer read(@RequestBody SysMessage sysMessage) {
		JsonContainer jsonContainer = getJsonContainer();
		service.read(sysMessage);
		setSuccessMessage(jsonContainer, sysMessage);
		return jsonContainer;
	}

}