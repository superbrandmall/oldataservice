package com.sbm.module.onlineleasing.api.admin.merchantdetail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.admin.merchantdetail.biz.IMerchantDetailService;
import com.sbm.module.onlineleasing.api.admin.merchantdetail.domain.MerchantDetail;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
//@Authorization(type = UserConstant.ADMIN)
@Controller
@RequestMapping("/ol/api/merchantdetail")
public class MerchantDetailController extends BaseController {

	@Autowired
	private IMerchantDetailService service;

	/******************************************************************************************/
	// 条件查询分页

	/**
	 * 
	 * findAllByConditionPage:条件查询分页
	 * 
	 * @author junkai.zhang
	 * @param obj
	 * @return
	 */
	@RequestMapping(value = "/findAllByConditionPage")
	@ResponseBody
	public JsonContainer findAllByConditionPage(@RequestBody MerchantDetail obj) {
		JsonContainer jsonContainer = getJsonContainer();
		service.findAllByConditionPage(obj);
		setSuccessMessage(jsonContainer, obj);
		return jsonContainer;
	}

}