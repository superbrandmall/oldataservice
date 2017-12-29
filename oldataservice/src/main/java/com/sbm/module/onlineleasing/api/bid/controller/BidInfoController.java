package com.sbm.module.onlineleasing.api.bid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.api.frequency.annotation.Frequency;
import com.sbm.module.common.api.jsonwebtoken.annotation.Authorization;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.onlineleasing.api.bid.biz.IBidInfoService;
import com.sbm.module.onlineleasing.api.bid.domain.BidInfo;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Frequency
@Authorization
@Controller
@RequestMapping("/ol/api/bid")
public class BidInfoController extends BaseController {

	@Autowired
	private IBidInfoService service;

	/********************************************************************/
	// 出价页信息

	/**
	 * 
	 * info:获取出价信息（商铺和查询记录）
	 * 
	 * @author junkai.zhang
	 * @param bidInfo
	 * @return
	 */
	@RequestMapping(value = "/info")
	@ResponseBody
	public JsonContainer info(@RequestBody BidInfo bidInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getBidInfo(bidInfo);
		setSuccessMessage(jsonContainer, bidInfo);
		return jsonContainer;
	}

	/********************************************************************/
	// 保存出价信息

	@RequestMapping(value = "/save")
	@ResponseBody
	public JsonContainer save(@RequestBody BidInfo bidInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.saveBidInfo(bidInfo);
		setSuccessMessage(jsonContainer, bidInfo);
		return jsonContainer;
	}

	/********************************************************************/
	// 出价列表

	@RequestMapping(value = "/details")
	@ResponseBody
	public JsonContainer details(@RequestBody BidInfo bidInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getDetails(bidInfo);
		setSuccessMessage(jsonContainer, bidInfo);
		return jsonContainer;
	}

	// 合同列表

	@RequestMapping(value = "/contractdetails")
	@ResponseBody
	public JsonContainer contractdetails(@RequestBody BidInfo bidInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.getContractDetails(bidInfo);
		setSuccessMessage(jsonContainer, bidInfo);
		return jsonContainer;
	}

	/********************************************************************/
	// 预览合同

	@RequestMapping(value = "/preview")
	@ResponseBody
	public JsonContainer preview(@RequestBody BidInfo bidInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.preview(bidInfo);
		setSuccessMessage(jsonContainer, bidInfo);
		return jsonContainer;
	}

	@RequestMapping(value = "/view")
	@ResponseBody
	public JsonContainer view(@RequestBody BidInfo bidInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.view(bidInfo);
		setSuccessMessage(jsonContainer, bidInfo);
		return jsonContainer;
	}

	/********************************************************************/
	// 保存异议

	// 保存商务异议
	@RequestMapping(value = "/saveBusinessSuggest")
	@ResponseBody
	public JsonContainer saveBusinessSuggest(@RequestBody BidInfo bidInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.saveBusinessSuggest(bidInfo);
		setSuccessMessage(jsonContainer, bidInfo);
		return jsonContainer;
	}

	// 保存法务异议
	@RequestMapping(value = "/saveLegalSuggest")
	@ResponseBody
	public JsonContainer saveLegalSuggest(@RequestBody BidInfo bidInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.saveLegalSuggest(bidInfo);
		setSuccessMessage(jsonContainer, bidInfo);
		return jsonContainer;
	}

	/********************************************************************/
	// 提交出价

	@RequestMapping(value = "/submit")
	@ResponseBody
	public JsonContainer submit(@RequestBody BidInfo bidInfo) {
		JsonContainer jsonContainer = getJsonContainer();
		service.submit(bidInfo);
		setSuccessMessage(jsonContainer, bidInfo);
		return jsonContainer;
	}

}