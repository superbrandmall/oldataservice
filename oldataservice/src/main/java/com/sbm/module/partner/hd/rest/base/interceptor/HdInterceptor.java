package com.sbm.module.partner.hd.rest.base.interceptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.partner.tianyancha.rest.base.interceptor<br/>
 * File Name:AuthorizationInterceptor.java<br/>
 * 
 * 作成日 ：2017-8-29 下午3:54:57 <br/>
 * 
 * @author ：junkai.zhang
 */
public class HdInterceptor implements ClientHttpRequestInterceptor {

	private String key = null;
	
	public void init(String username, String password){
		String tmp = username + ":" + password;
		key = "Basic " + Base64.getEncoder().encodeToString(tmp.getBytes());
	}
	
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		HttpHeaders headers = request.getHeaders();

//		System.out.println(" i am in intercept 1: " + JSON.toJSONString(headers) );

		// 设置头文件
//		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
//		headers.setContentType(type);
//
//		List<MediaType> acceptableMediaTypes = new ArrayList<>();
//		acceptableMediaTypes.add(type);
//		headers.setAccept(acceptableMediaTypes);

		headers.add(HttpHeaders.AUTHORIZATION, key);

//		System.out.println(" i am in intercept 2: " + JSON.toJSONString(headers) );

		return execution.execute(request, body);
	}

}
