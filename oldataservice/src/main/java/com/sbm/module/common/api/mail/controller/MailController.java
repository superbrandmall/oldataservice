package com.sbm.module.common.api.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.api.mail.biz.IMailService;
import com.sbm.module.common.api.mail.domain.MailData;
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
@RequestMapping("/ol/api/mail")
public class MailController extends BaseController {

	@Autowired
	private IMailService service;

	@RequestMapping(value = "/send")
	@ResponseBody
	public JsonContainer send(@RequestBody MailData mailData) {
		JsonContainer jsonContainer = getJsonContainer();
		service.sendMail(mailData);
		setSuccessMessage(jsonContainer, null);
		return jsonContainer;
	}

}