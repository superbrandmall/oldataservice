package com.sbm.module.partner.nuozhengtong.base.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.sbm.module.common.base.util.HttpsClientUtil;
import com.sbm.module.partner.hl95.rest.base.interceptor.Hl95Interceptor;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

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
public class NZTConfiguration {

	@Value("#{propertiesReader['nzt.ConnectionRequestTimeout']}")
	private String ConnectionRequestTimeout;
	@Value("#{propertiesReader['nzt.ConnectTimeout']}")
	private String ConnectTimeout;
	@Value("#{propertiesReader['nzt.ReadTimeout']}")
	private String ReadTimeout;

	@Bean(name = "nztRestTemplate")
	public RestTemplate nztRestTemplate(
			@Qualifier("nztHttpComponentsClientHttpRequestFactory") HttpComponentsClientHttpRequestFactory httpRequestFactory) throws KeyManagementException,
			KeyStoreException, NoSuchAlgorithmException {
		RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
		// restTemplate.getMessageConverters().add(0, new
		// StringHttpMessageConverter(Charset.forName("UTF-8")));

		List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
		for (HttpMessageConverter<?> converter : converters) {
			if (converter instanceof MappingJackson2HttpMessageConverter) {
				MappingJackson2HttpMessageConverter jsonConverter = (MappingJackson2HttpMessageConverter) converter;
				jsonConverter.setObjectMapper(new ObjectMapper());
				jsonConverter.setSupportedMediaTypes(ImmutableList.of(new MediaType("application", "json", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET), new MediaType("text", "html", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET)));
			}
		}
		return restTemplate;
	}

	@Bean(name = "nztHttpComponentsClientHttpRequestFactory")
	public HttpComponentsClientHttpRequestFactory nztHttpComponentsClientHttpRequestFactory(
			@Qualifier("nztHttpClient") HttpClient httpClient) {
		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				httpClient);
		httpRequestFactory.setConnectionRequestTimeout(Integer.valueOf(ConnectionRequestTimeout));
		httpRequestFactory.setConnectTimeout(Integer.valueOf(ConnectTimeout));
		httpRequestFactory.setReadTimeout(Integer.valueOf(ReadTimeout));
		return httpRequestFactory;
	}

	@Bean(name = "nztHttpClient")
	public HttpClient nztHttpClient() throws Exception {
		CloseableHttpClient client = HttpsClientUtil.acceptsUntrustedCertsHttpClient();
		return client;
	}


}
