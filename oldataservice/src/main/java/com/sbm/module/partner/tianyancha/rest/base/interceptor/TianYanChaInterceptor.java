package com.sbm.module.partner.tianyancha.rest.base.interceptor;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
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
public class TianYanChaInterceptor implements ClientHttpRequestInterceptor {

	private String key;

	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		HttpHeaders headers = request.getHeaders();
		// 设置头文件
		headers.add(HttpHeaders.AUTHORIZATION, key);
		return execution.execute(request, body);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
