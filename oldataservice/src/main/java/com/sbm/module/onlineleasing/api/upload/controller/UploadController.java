package com.sbm.module.onlineleasing.api.upload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.upload.biz.IUploadService;
import com.sbm.module.onlineleasing.api.upload.domain.Upload;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency
@Authorization
@Controller
@RequestMapping("/ol/api/upload")
public class UploadController extends BaseController {

	@Autowired
	private IUploadService service;

	@RequestMapping(value = "/multi")
	@ResponseBody
	public JsonContainer multi(Upload upload) {
		JsonContainer jsonContainer = getJsonContainer();
		service.upload(upload);
		setSuccessMessage(jsonContainer, upload);
		return jsonContainer;
	}

}