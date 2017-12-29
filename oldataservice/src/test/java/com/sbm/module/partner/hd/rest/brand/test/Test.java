package com.sbm.module.partner.hd.rest.brand.test;

import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.partner.hd.rest.base.domain.HdResult;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.business.configuration.spring.SpringApplicationConfiguration;
import com.sbm.module.common.business.util.SpringLog4jJUnit4ClassRunner;
import com.sbm.module.onlineleasing.base.brand.biz.ITOLBrandService;
import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;
import com.sbm.module.partner.hd.rest.base.constant.HdConstant;
import com.sbm.module.partner.hd.rest.base.domain.QueryFilter;
import com.sbm.module.partner.hd.rest.brand.biz.IHdBrandService;
import com.sbm.module.partner.hd.rest.brand.domain.HdBrand;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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
@SuppressWarnings("unused")
public class Test {

	@Autowired
	private IHdBrandService service;

	@Autowired
	private ITOLBrandService brandService;
	
	@org.junit.Test
	public void test() {
		try {
			//query();
			 save();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void query() {
		QueryFilter queryFilter = new QueryFilter();
		queryFilter.setPage(1);
		queryFilter.setPageSize(10);

		service.query(queryFilter);
	}



	private void save() {
		TOLBrand merchant = brandService.findByCode("OLBRAND170717000032");

		HdBrand obj = new HdBrand();
		obj.setCode(merchant.getCode());
		obj.setName(merchant.getName());
		obj.setState(HdConstant.HD_STATE_USING);
		System.out.println(JSON.toJSONString(obj));
		service.save(obj);
		//savelocal(obj);
	}

	private static final String SAVE_METHOD = "/rest/onlineleasing/brand";

	@Autowired
	@Qualifier("hdRestTemplate")
	private RestTemplate restTemplate;

	private void savelocal(HdBrand obj){
		String uri = HdConstant.BASE_URL + SAVE_METHOD;
		CommonConstant.FRAMEWORK.info("uri: " + uri);
		String request = JSON.toJSONString(obj);

		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);

		List<MediaType> acceptableMediaTypes = new ArrayList<>();
		acceptableMediaTypes.add(type);
		headers.setAccept(acceptableMediaTypes);

		HttpEntity<String> entity = new HttpEntity<>(request, headers);
//		HttpEntity<String> entity = new HttpEntity<>(request);
		System.out.println(JSON.toJSONString(entity));
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, entity,
				new ParameterizedTypeReference<String>() {
				});
		CommonConstant.FRAMEWORK.info("vo: " + JSON.toJSONString(result));
	}
}
