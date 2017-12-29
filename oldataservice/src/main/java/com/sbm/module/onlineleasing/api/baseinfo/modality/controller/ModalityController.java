package com.sbm.module.onlineleasing.api.baseinfo.modality.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.baseinfo.modality.biz.IModalityService;
import com.sbm.module.onlineleasing.api.baseinfo.modality.domain.ModalityVo;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency
// @Authorization
@Controller
@RequestMapping("/ol/api/baseinfo/modality")
public class ModalityController extends BaseController {

	@Autowired
	private IModalityService service;

	/**
	 * 
	 * getAll:业态
	 * 
	 * @author junkai.zhang
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/getModalityList")
	@ResponseBody
	public JsonContainer getModalityList(@RequestBody ModalityVo vo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getModalityList(vo);
		setSuccessMessage(jsonContainer, vo);
		return jsonContainer;
	}

}