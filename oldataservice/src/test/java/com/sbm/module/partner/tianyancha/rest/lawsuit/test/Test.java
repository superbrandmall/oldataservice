package com.sbm.module.partner.tianyancha.rest.lawsuit.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sbm.module.common.business.configuration.spring.SpringApplicationConfiguration;
import com.sbm.module.common.business.util.SpringLog4jJUnit4ClassRunner;
import com.sbm.module.partner.tianyancha.rest.lawsuit.biz.ILawSuitService;

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
	private ILawSuitService service;

	@org.junit.Test
	public void test() {
		// LawSuitVo vo = new LawSuitVo();
		// vo.setName("新智认知数据服务有限公司");
		// service.getLawSuit(vo);
		// System.out.println(JSON.toJSONString(vo));
	}
}
