package com.sbm.module.partner.tianyancha.rest.punishmentinfo.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.business.configuration.spring.SpringApplicationConfiguration;
import com.sbm.module.common.business.util.SpringLog4jJUnit4ClassRunner;
import com.sbm.module.partner.tianyancha.rest.punishmentinfo.biz.IPunishmentInfoService;
import com.sbm.module.partner.tianyancha.rest.punishmentinfo.domain.PunishmentInfo;

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
	private IPunishmentInfoService service;

	@org.junit.Test
	public void test() {
		PunishmentInfo result = service.findResultByName("德化县孙壁电器商店", null);
		System.out.println(JSON.toJSONString(result));
	}
}
