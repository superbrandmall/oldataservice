package com.sbm.module.onlineleasing.api.merchantinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.merchantinfo.biz.IMerchantInfoService;
import com.sbm.module.onlineleasing.api.merchantinfo.domain.MerchantInfo;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency
@Authorization
@Controller
@RequestMapping("/ol/api/merchantinfo")
public class MerchantInfoController extends BaseController {

	@Autowired
	private IMerchantInfoService service;

	/**
	 * 
	 * getMerchantInfo:获取merchantInfo
	 * 
	 * @author junkai.zhang
	 * @param merchantInfo
	 * @return
	 */
	@RequestMapping(value = "/get")
	@ResponseBody
	public JsonContainer getMerchantInfo(@RequestBody MerchantInfo merchantInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getMerchantInfo(merchantInfo);
		setSuccessMessage(jsonContainer, merchantInfo);
		return jsonContainer;
	}

	/**
	 * 
	 * updateMerchantInfo:更新merchantInfo
	 * 
	 * @author junkai.zhang
	 * @param merchantInfo
	 * @return
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public JsonContainer updateMerchantInfo(@RequestBody MerchantInfo merchantInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.updateMerchantInfo(merchantInfo);
		setSuccessMessage(jsonContainer, null);
		return jsonContainer;
	}

}