package com.sbm.module.common.api.apiinteractive.handler;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.apiinteractive.domain.TCApiInteractiveDetail;
import com.sbm.module.common.base.domain.JsonContainer;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.commonapi.apiinteractive.advice<br/>
 * File Name:ResponseBodyAdvice.java<br/>
 * 
 * 作成日 ：2017-8-10 上午9:45:10 <br/>
 * 
 * @author ：junkai.zhang
 */
@ControllerAdvice
public class ApiInteractiveResponseBodyHandler implements ResponseBodyAdvice {

	@Override
	public boolean supports(MethodParameter returnType, Class converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

		// 返回jsonContainer
		if (body instanceof JsonContainer) {
			TCApiInteractiveDetail detail = TCApiInteractiveDetail.get();
			JsonContainer jsonContainer = (JsonContainer) body;
			if (null != jsonContainer) {
				detail.setCode(jsonContainer.getCode());
				detail.setResponseBody(JSON.toJSONString(body));
			}
			//System.out.println("i am in JsonContainer");
		}
		// 返回其他
		else {
			//System.out.println("i am in else");
		}
		return body;
	}

}
