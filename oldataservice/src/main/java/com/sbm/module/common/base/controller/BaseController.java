package com.sbm.module.common.base.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.sbm.module.common.api.apiinteractive.domain.TCApiInteractiveDetail;
import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.common.base.exception.BusinessException;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
public class BaseController {

	/************** 创建json容器 ***************/
	public JsonContainer getJsonContainer() {
		return new JsonContainer();
	}

	/************** 返回成功信息 ***************/
	public JsonContainer setSuccessMessage(Object data) {
		return setSuccessMessage(getJsonContainer(), data);
	}

	public JsonContainer setSuccessMessage(JsonContainer jsonContainer, Object data) {
		jsonContainer.setCode(BusinessCode.C0.getCode());
		jsonContainer.setMessage(BusinessCode.C0.getMessage());
		jsonContainer.setData(data);
		return jsonContainer;
	}

	/************** 返回失败信息 ***************/
	public JsonContainer setErrorMessage(Object data) {
		return setErrorMessage(getJsonContainer(), data, null);
	}

	public JsonContainer setErrorMessage(Object data, Exception e) {
		return setErrorMessage(getJsonContainer(), data, e);
	}

	public JsonContainer setErrorMessage(JsonContainer jsonContainer, Object data) {
		return setErrorMessage(jsonContainer, data, null);
	}

	public JsonContainer setErrorMessage(JsonContainer jsonContainer, Object data, Exception e) {
		// 判断e是不是businessException
		e = BusinessException.convert(BusinessCode.C9999, e);
		jsonContainer.setCode(((BusinessException) e).getCode());
		jsonContainer.setMessage(((BusinessException) e).getMessage());
		jsonContainer.setData(data);
		CommonConstant.ERRORDATA.error(data, e);
		// 线程保存错误
		TCApiInteractiveDetail detail = TCApiInteractiveDetail.get();
		detail.setErrorMessage(ExceptionUtils.getStackTrace(e));
		return jsonContainer;
	}

}
