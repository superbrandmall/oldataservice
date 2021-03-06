package com.sbm.module.partner.hl95.rest.base.configuration;

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
import com.sbm.module.partner.hl95.rest.base.interceptor.Hl95Interceptor;

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
public class Hl95Configuration {

	@Value("#{propertiesReader['hl95.ConnectionRequestTimeout']}")
	private String ConnectionRequestTimeout;
	@Value("#{propertiesReader['hl95.ConnectTimeout']}")
	private String ConnectTimeout;
	@Value("#{propertiesReader['hl95.ReadTimeout']}")
	private String ReadTimeout;

	@Bean(name = "hl95RestTemplate")
	public RestTemplate hl95RestTemplate(
			@Qualifier("hl95HttpComponentsClientHttpRequestFactory") HttpComponentsClientHttpRequestFactory httpRequestFactory,
			@Qualifier("hl95Interceptor") Hl95Interceptor hl95Interceptor) throws KeyManagementException,
			KeyStoreException, NoSuchAlgorithmException {
		RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
		// restTemplate.getMessageConverters().add(0, new
		// StringHttpMessageConverter(Charset.forName("UTF-8")));
		List<ClientHttpRequestInterceptor> list = new ArrayList<ClientHttpRequestInterceptor>();
		// 添加拦截器
		list.add(hl95Interceptor);
		restTemplate.setInterceptors(list);
		return restTemplate;
	}

	@Bean(name = "hl95HttpComponentsClientHttpRequestFactory")
	public HttpComponentsClientHttpRequestFactory hl95HttpComponentsClientHttpRequestFactory(
			@Qualifier("hl95HttpClient") HttpClient httpClient) {
		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				httpClient);
		httpRequestFactory.setConnectionRequestTimeout(Integer.valueOf(ConnectionRequestTimeout));
		httpRequestFactory.setConnectTimeout(Integer.valueOf(ConnectTimeout));
		httpRequestFactory.setReadTimeout(Integer.valueOf(ReadTimeout));
		return httpRequestFactory;
	}

	@Bean(name = "hl95HttpClient")
	public HttpClient hl95HttpClient() throws Exception {
		CloseableHttpClient client = HttpsClientUtil.acceptsUntrustedCertsHttpClient();
		return client;
	}

	@Bean(name = "hl95Interceptor")
	public Hl95Interceptor hl95Interceptor() {
		Hl95Interceptor bean = new Hl95Interceptor();
		return bean;
	}

}
