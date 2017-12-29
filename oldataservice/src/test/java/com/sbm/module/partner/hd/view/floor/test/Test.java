package com.sbm.module.partner.hd.view.floor.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.business.configuration.spring.SpringApplicationConfiguration;
import com.sbm.module.common.business.util.SpringLog4jJUnit4ClassRunner;
import com.sbm.module.partner.hd.view.floor.biz.IFloorService;
import com.sbm.module.partner.hd.view.floor.domain.Floor;

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
	private IFloorService service;

	@org.junit.Test
	public void test() {
		try {
			Floor obj = service.findByUuid("8a028c965de8e0e9015de8fa3855002a");
			System.out.println(JSON.toJSONString(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
