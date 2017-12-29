package com.sbm.module.onlineleasing.base.mall.test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.business.configuration.spring.SpringApplicationConfiguration;
import com.sbm.module.common.business.util.SpringLog4jJUnit4ClassRunner;
import com.sbm.module.onlineleasing.base.mall.biz.ITOLMallService;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;

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
	private ITOLMallService service;

	@org.junit.Test
	public void test() {
		try {
			TOLMall mall = service.findByCode("OLMALL170717000001");
			System.out.println(JSON.toJSONString(mall));

			List<TOLMall> list = service.findAll();
			for (TOLMall obj : list) {
				System.out.println(JSON.toJSONString(obj));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
