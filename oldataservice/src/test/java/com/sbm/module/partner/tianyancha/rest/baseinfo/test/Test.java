package com.sbm.module.partner.tianyancha.rest.baseinfo.test;

import java.text.MessageFormat;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.sbm.module.common.business.configuration.spring.SpringApplicationConfiguration;
import com.sbm.module.common.business.util.SpringLog4jJUnit4ClassRunner;
import com.sbm.module.partner.tianyancha.rest.base.constant.TianYanChaConstant;

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
	@Qualifier("tycRestTemplate")
	private RestTemplate restTemplate;

	private static final String METHOD = "/newopen/baseinfo.json?id={0}";

	@org.junit.Test
	public void test() {
		// String id = "2986195851";
		String id = "2358839225";
		String uri = TianYanChaConstant.BASE_URL + METHOD;
		uri = MessageFormat.format(uri, id);
		System.out.println(uri);
		String str = restTemplate.getForObject(uri, String.class);
		System.out.println(str);
	}
}
