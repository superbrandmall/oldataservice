package com.sbm.module.onlineleasing.api.myfavourite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.myfavourite.biz.IMyFavouriteService;
import com.sbm.module.onlineleasing.api.myfavourite.domain.MyFavourite;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency
@Authorization
@Controller
@RequestMapping("/ol/api/myfavourite")
public class MyFavouriteController extends BaseController {

	@Autowired
	private IMyFavouriteService service;

	/**
	 * 
	 * details:我的关注明细
	 * 
	 * @author junkai.zhang
	 * @param myFavourite
	 * @return
	 */
	@RequestMapping(value = "/details")
	@ResponseBody
	public JsonContainer details(@RequestBody MyFavourite myFavourite) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getDetails(myFavourite);
		setSuccessMessage(jsonContainer, myFavourite);
		return jsonContainer;
	}

	/********************************************************************/

	/**
	 * 
	 * save:添加关注
	 * 
	 * @author junkai.zhang
	 * @param myFavourite
	 * @return
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public JsonContainer save(@RequestBody MyFavourite myFavourite) {
		JsonContainer jsonContainer = getJsonContainer();
		service.save(myFavourite);
		setSuccessMessage(jsonContainer, myFavourite);
		return jsonContainer;
	}

	/********************************************************************/

	/**
	 * 
	 * delete:取消关注
	 * 
	 * @author junkai.zhang
	 * @param myFavourite
	 * @return
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public JsonContainer delete(@RequestBody MyFavourite myFavourite) {
		JsonContainer jsonContainer = getJsonContainer();
		service.delete(myFavourite);
		setSuccessMessage(jsonContainer, myFavourite);
		return jsonContainer;
	}

}