package com.sbm.module.onlineleasing.api.download.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.download.biz.IDownloadService;
import com.sbm.module.onlineleasing.api.download.domain.Download;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency
@Controller
@RequestMapping("/ol/api/download")
public class DownloadController extends BaseController {

	@Autowired
	private IDownloadService service;

	/**
	 * 
	 * pre:下载预处理
	 * 
	 * @author junkai.zhang
	 * @param download
	 * @return
	 */
	@Authorization
	@RequestMapping(value = "/pre")
	@ResponseBody
	public JsonContainer pre(@RequestBody Download download) {
		JsonContainer jsonContainer = getJsonContainer();
		service.preDownload(download);
		setSuccessMessage(jsonContainer, download);
		return jsonContainer;
	}

	/**
	 * 
	 * file:下载
	 * 
	 * @author junkai.zhang
	 * @param key
	 * @param type
	 * @param response
	 */
	@RequestMapping(value = "/file")
	public void file(String key, String type, HttpServletResponse response) {
		service.getFile(key, type, response);
	}

}