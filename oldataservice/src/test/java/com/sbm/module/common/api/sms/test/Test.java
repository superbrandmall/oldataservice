package com.sbm.module.common.api.sms.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sbm.module.common.api.sms.biz.ITCSMSTemplateService;
import com.sbm.module.common.api.sms.domain.TCSMSTemplate;
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
	private ITCSMSTemplateService templateService;

	@org.junit.Test
	public void mailTemplate() {
		TCSMSTemplate template = new TCSMSTemplate();
		template.setTemplateName("短信验证码");
		template.setFilePrefix("sms");
		template.setFileName("smsverificationcode.ftl");
		templateService.saveSMSTemplate(template);
	}

}
