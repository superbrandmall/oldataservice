package com.sbm.module.partner.tianyancha.rest.base.configuration;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.sbm.module.common.base.util.HttpsClientUtil;
import com.sbm.module.partner.tianyancha.rest.base.interceptor.TianYanChaInterceptor;

/*****************************************************************************/
/**
 * Project Name:posUploadDataService<br/>
 * Package Name:com.sbm.module.common.configutation<br/>
 * File Name:PropertiesReaderConfiguration.java<br/>
 * 
 * 作成日 ：2016-4-21 上午10:38:07 <br/>
 * 
 * @author ：junkai.zhang
 */
@Configuration
public class TianYanChaConfiguration {

	@Value("#{propertiesReader['tianyancha.ConnectionRequestTimeout']}")
	private String ConnectionRequestTimeout;
	@Value("#{propertiesReader['tianyancha.ConnectTimeout']}")
	private String ConnectTimeout;
	@Value("#{propertiesReader['tianyancha.ReadTimeout']}")
	private String ReadTimeout;

	@Value("#{propertiesReader['tianyancha.key']}")
	private String key;

	@Bean(name = "tycRestTemplate")
	public RestTemplate tycRestTemplate(
			@Qualifier("tycHttpComponentsClientHttpRequestFactory") HttpComponentsClientHttpRequestFactory httpRequestFactory,
			@Qualifier("tycAuthorizationInterceptor") TianYanChaInterceptor tycAuthorizationInterceptor)
			throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException {
		RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
		// restTemplate.getMessageConverters().add(0, new
		// StringHttpMessageConverter(Charset.forName("UTF-8")));
		List<ClientHttpRequestInterceptor> list = new ArrayList<ClientHttpRequestInterceptor>();
		// 添加拦截器
		list.add(tycAuthorizationInterceptor);
		restTemplate.setInterceptors(list);
		return restTemplate;
	}

	@Bean(name = "tycHttpComponentsClientHttpRequestFactory")
	public HttpComponentsClientHttpRequestFactory tycHttpComponentsClientHttpRequestFactory(
			@Qualifier("tycHttpClient") HttpClient httpClient) {
		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				httpClient);
		httpRequestFactory.setConnectionRequestTimeout(Integer.valueOf(ConnectionRequestTimeout));
		httpRequestFactory.setConnectTimeout(Integer.valueOf(ConnectTimeout));
		httpRequestFactory.setReadTimeout(Integer.valueOf(ReadTimeout));
		return httpRequestFactory;
	}

	@Bean(name = "tycHttpClient")
	public HttpClient tycHttpClient() throws Exception {
		CloseableHttpClient client = HttpsClientUtil.acceptsUntrustedCertsHttpClient();
		return client;
	}

	@Bean(name = "tycAuthorizationInterceptor")
	public TianYanChaInterceptor tycAuthorizationInterceptor() {
		TianYanChaInterceptor bean = new TianYanChaInterceptor();
		bean.setKey(key);
		return bean;
	}

}
