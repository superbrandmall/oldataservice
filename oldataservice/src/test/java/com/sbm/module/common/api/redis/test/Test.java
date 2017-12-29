package com.sbm.module.common.api.redis.test;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sbm.module.common.api.redis.biz.IRedisService;
import com.sbm.module.common.api.redis.constant.RedisConstant;
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
	private IRedisService service;

	@org.junit.Test
	public void test() {
		try {
			test1();
			// test2();
			// test3();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void test1() {
		String key = RedisConstant.PREFIX_MALL + "OLMALL170717000001";
		System.out.println((String) service.get(key));

		System.out.println(service.getExpire(key, TimeUnit.DAYS));
	}

	public void test2() {
		String key = "111.222.333.444";
		Long i = 0L;
		service.getAndSet(key, i);

		System.out.println((Long) service.get(key));
		System.out.println(service.getExpire(key));
	}

	public void test3() {

		String key = "111.222.333.444";
		System.out.println((Integer) service.get(key));
		System.out.println(service.getExpire(key));
	}

}
