package com.sbm.module.onlineleasing.api.brandinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.brandinfo.biz.IBrandInfoService;
import com.sbm.module.onlineleasing.api.brandinfo.domain.BrandInfo;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency
@Authorization
@Controller
@RequestMapping("/ol/api/brandinfo")
public class BrandInfoController extends BaseController {

	@Autowired
	private IBrandInfoService service;

	/******************************************************************************************/
	// 获取merchantBrand列表

	/**
	 * 
	 * getBrandList:获取getBrandList
	 * 
	 * @author junkai.zhang
	 * @param brandInfo
	 * @return
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public JsonContainer getBrandList(@RequestBody BrandInfo brandInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getBrandList(brandInfo);
		setSuccessMessage(jsonContainer, brandInfo);
		return jsonContainer;
	}

	/******************************************************************************************/
	// 获取brand信息

	/**
	 * 
	 * getByCode:获取BrandInfoByCode
	 * 
	 * @author junkai.zhang
	 * @param brandInfo
	 * @return
	 */
	@RequestMapping(value = "/getByCode")
	@ResponseBody
	public JsonContainer getByCode(@RequestBody BrandInfo brandInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getByCode(brandInfo);
		setSuccessMessage(jsonContainer, brandInfo);
		return jsonContainer;
	}

	/**
	 * 
	 * getByName:获取BrandInfoByName
	 * 
	 * @author junkai.zhang
	 * @param brandInfo
	 * @return
	 */
	@RequestMapping(value = "/getByName")
	@ResponseBody
	public JsonContainer getByName(@RequestBody BrandInfo brandInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getByName(brandInfo);
		setSuccessMessage(jsonContainer, brandInfo);
		return jsonContainer;
	}

	/******************************************************************************************/
	// 新增

	/**
	 * 
	 * addExistingBrandWithoutUpdate:添加已经存在的品牌，不修改
	 * 
	 * @author junkai.zhang
	 * @param brandInfo
	 * @return
	 */
	@RequestMapping(value = "/addExistingBrandWithoutUpdate")
	@ResponseBody
	public JsonContainer addExistingBrandWithoutUpdate(@RequestBody BrandInfo brandInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.addExistingBrandWithoutUpdate(brandInfo);
		setSuccessMessage(jsonContainer, brandInfo);
		return jsonContainer;
	}

	/**
	 * 
	 * addExistingBrandWithUpdate:添加已经存在的品牌，修改
	 * 
	 * @author junkai.zhang
	 * @param brandInfo
	 * @return
	 */
	@RequestMapping(value = "/addExistingBrandWithUpdate")
	@ResponseBody
	public JsonContainer addExistingBrandWithUpdate(@RequestBody BrandInfo brandInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.addExistingBrandWithUpdate(brandInfo);
		setSuccessMessage(jsonContainer, brandInfo);
		return jsonContainer;
	}

	/**
	 * 
	 * addNewBrand:添加新品牌
	 * 
	 * @author junkai.zhang
	 * @param brandInfo
	 * @return
	 */
	@RequestMapping(value = "/addNewBrand")
	@ResponseBody
	public JsonContainer addNewBrand(@RequestBody BrandInfo brandInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.addNewBrand(brandInfo);
		setSuccessMessage(jsonContainer, brandInfo);
		return jsonContainer;
	}

	/******************************************************************************************/
	// 修改

	/**
	 * 
	 * updateExistingBrand:修改现有品牌信息
	 * 
	 * @author junkai.zhang
	 * @param brandInfo
	 * @return
	 */
	@RequestMapping(value = "/updateExistingBrand")
	@ResponseBody
	public JsonContainer updateExistingBrand(@RequestBody BrandInfo brandInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.updateExistingBrand(brandInfo);
		setSuccessMessage(jsonContainer, brandInfo);
		return jsonContainer;
	}

	/******************************************************************************************/
	// 删除

	/**
	 * 
	 * delete:删除merchantBrand
	 * 
	 * @author junkai.zhang
	 * @param brandInfo
	 * @return
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public JsonContainer delete(@RequestBody BrandInfo brandInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.delete(brandInfo);
		setSuccessMessage(jsonContainer, brandInfo);
		return jsonContainer;
	}
}