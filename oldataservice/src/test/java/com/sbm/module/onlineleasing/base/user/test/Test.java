package com.sbm.module.onlineleasing.base.user.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.business.configuration.spring.SpringApplicationConfiguration;
import com.sbm.module.common.business.util.SpringLog4jJUnit4ClassRunner;
import com.sbm.module.onlineleasing.base.user.biz.ITOLUserService;
import com.sbm.module.onlineleasing.base.user.domain.TOLUser;

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
	private ITOLUserService service;

	@org.junit.Test
	public void test() {

		try {
			TOLUser obj = service.findByUsername("sadfasd@afd.com");
			System.out.println(JSON.toJSONString(obj));
			System.out.println(obj.getId());
			obj.setMobile("29854564733");
			service.update(obj);
			// obj = service.findByUsername("safa@asf.com");
			obj.setMobile("18854564733");
			service.update(obj);
			// service.delete(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
