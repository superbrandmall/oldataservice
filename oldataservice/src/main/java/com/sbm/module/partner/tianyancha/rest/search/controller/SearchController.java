package com.sbm.module.partner.tianyancha.rest.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.base.user.constant.UserConstant;
import com.sbm.module.partner.tianyancha.rest.search.biz.ISearchService;
import com.sbm.module.partner.tianyancha.rest.search.domain.SearchVo;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency
@Authorization(type = UserConstant.ADMIN)
@Controller
@RequestMapping("/ol/api/partner/tianyancha")
public class SearchController extends BaseController {

	@Autowired
	private ISearchService service;

	@RequestMapping(value = "/search")
	@ResponseBody
	public JsonContainer search(@RequestBody SearchVo vo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getVo(vo);
		setSuccessMessage(jsonContainer, vo);
		return jsonContainer;
	}

}