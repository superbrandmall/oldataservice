package com.sbm.module.onlineleasing.api.shopinfo.controller;

import com.sbm.module.onlineleasing.api.shopinfo.domain.ShopFloorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.shopinfo.biz.IShopInfoService;
import com.sbm.module.onlineleasing.api.shopinfo.domain.ShopInfo;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency
@Controller
@RequestMapping("/ol/api/shopinfo")
public class ShopInfoController extends BaseController {

	@Autowired
	private IShopInfoService service;

	/**
	 * 
	 * getShopInfo:getShopInfo
	 * 
	 * @author junkai.zhang
	 * @param shopInfo
	 * @return
	 */
	@Authorization
	@RequestMapping(value = "/get")
	@ResponseBody
	public JsonContainer getShopInfo(@RequestBody ShopInfo shopInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getShopInfo(shopInfo);
		setSuccessMessage(jsonContainer, shopInfo);
		return jsonContainer;
	}

	/**
	 * 
	 * getShopInfo:getShopInfo
	 * 
	 * @author junkai.zhang
	 * @param shopInfo
	 * @return
	 */
	@RequestMapping(value = "/getBeforeLogin")
	@ResponseBody
	public JsonContainer getShopInfoBeforeLogin(@RequestBody ShopInfo shopInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getShopInfoBeforeLogin(shopInfo);
		setSuccessMessage(jsonContainer, shopInfo);
		return jsonContainer;
	}

	/**
	 *
	 * getShopFloorInfo:getShopFloorInfo
	 *
	 * @author junkai.zhang
	 * @param shopFloorInfo
	 * @return
	 */
	@Authorization
	@RequestMapping(value = "/getShopFloorInfo")
	@ResponseBody
	public JsonContainer getShopFloorInfo(@RequestBody ShopFloorInfo shopFloorInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getShopFloorInfo(shopFloorInfo);
		setSuccessMessage(jsonContainer, shopFloorInfo);
		return jsonContainer;
	}
}