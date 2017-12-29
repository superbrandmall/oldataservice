package com.sbm.module.partner.hd.rest.base.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.business.configuration.spring.SpringApplicationConfiguration;
import com.sbm.module.common.business.util.SpringLog4jJUnit4ClassRunner;

/*****************************************************************************/
/**
 * Project Name:CRMDataProcess<br/>
 * Package Name:com.sbm.module.common<br/>
 * File Name:FileUtilTest.java<br/>
 * 
 * 作成日 ：2017-4-13 下午5:25:17 <br/>
 * 
 * @author ：junkai.zhang
 */
@WebAppConfiguration
@RunWith(SpringLog4jJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringApplicationConfiguration.class })
public class Test {

	@Autowired
	@Qualifier("hdRestTemplate")
	private RestTemplate restTemplate;

	@SuppressWarnings("rawtypes")
	@org.junit.Test
	public void test() {
		String uri = "http://10.130.11.55:9010/interface/flow/MallReport.html";
		Map<String, String> map = new HashMap<String, String>();
		map.put("MallIds", "cead3b5b2ac54ef8be6433db6c96bd85");
		map.put("Period", "0");
		map.put("ReportKey", "bed9001fad9042158e2fda97614607e1");

		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);

		String requestJson = JSON.toJSONString(map);
		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);

		ResponseEntity<HashMap> response = restTemplate.exchange(uri, HttpMethod.POST, entity, HashMap.class);

		System.out.println(JSON.toJSONString(response));
		// JsonContainer result = restTemplate.postForObject(uri, entity,
		// JsonContainer.class);
		// System.out.println(JSON.toJSONString(result));
	}
}
