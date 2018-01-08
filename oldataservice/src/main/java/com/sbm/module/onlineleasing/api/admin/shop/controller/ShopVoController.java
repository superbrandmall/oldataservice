package com.sbm.module.onlineleasing.api.admin.shop.controller;

import com.sbm.module.onlineleasing.api.admin.shop.biz.IShopVoService;
import com.sbm.module.onlineleasing.api.admin.shop.domain.ShopVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.base.user.constant.UserConstant;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Authorization(type = UserConstant.ADMIN)
@Controller
@RequestMapping("/ol/api/shop")
public class ShopVoController extends BaseController {

	@Autowired
	private IShopVoService service;

	/******************************************************************************************/
	// 条件查询分页

	/**
	 * 
	 * findAllByConditionPage:条件查询分页
	 * 
	 * @author junkai.zhang
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/findAllByConditionPage")
	@ResponseBody
	public JsonContainer findAllByConditionPage(@RequestBody ShopVo vo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.findAllByConditionPage(vo);
		setSuccessMessage(jsonContainer, vo);
		return jsonContainer;
	}

	/******************************************************************************************/
	// 明细

	/**
	 *
	 * findByCode:通过code查询
	 *
	 * @author junkai.zhang
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/findByCode")
	@ResponseBody
	public JsonContainer findByCode(@RequestBody ShopVo vo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.findByCode(vo);
		setSuccessMessage(jsonContainer, vo);
		return jsonContainer;
	}

	/******************************************************************************************/

	/**
	 *
	 * saveOrUpdate:saveOrUpdate
	 *
	 * @author junkai.zhang
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/saveOrUpdate")
	@ResponseBody
	public JsonContainer saveOrUpdate(@RequestBody ShopVo vo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.saveOrUpdate(vo);
		setSuccessMessage(jsonContainer, vo);
		return jsonContainer;
	}




}