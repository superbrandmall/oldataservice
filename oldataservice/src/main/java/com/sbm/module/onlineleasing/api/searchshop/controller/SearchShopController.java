package com.sbm.module.onlineleasing.api.searchshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.searchshop.biz.ISearchShopService;
import com.sbm.module.onlineleasing.api.searchshop.domain.SearchShop;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency
@Authorization
@Controller
@RequestMapping("/ol/api/searchshop")
public class SearchShopController extends BaseController {

	@Autowired
	private ISearchShopService service;

	@RequestMapping(value = "/details")
	@ResponseBody
	public JsonContainer details(@RequestBody SearchShop searchShop) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getDetails(searchShop);
		setSuccessMessage(jsonContainer, searchShop);
		return jsonContainer;
	}

	@RequestMapping(value = "/histories")
	@ResponseBody
	public JsonContainer histories(@RequestBody SearchShop searchShop) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getHistories(searchShop);
		setSuccessMessage(jsonContainer, searchShop);
		return jsonContainer;
	}

}