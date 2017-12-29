package com.sbm.module.common.api.mail.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sbm.module.common.api.mail.biz.ITCMailTemplateService;
import com.sbm.module.common.api.mail.domain.TCMailTemplate;
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
	private ITCMailTemplateService templateService;

	@org.junit.Test
	public void mailTemplate() {
		TCMailTemplate mailTemplate = new TCMailTemplate();
		mailTemplate.setTemplateName("品牌信息修改确认");
		mailTemplate.setFilePrefix("mail");
		mailTemplate.setFileName("brandtreceive.ftl");
		mailTemplate.setSubject("品牌信息修改确认");
		templateService.saveMailTemplate(mailTemplate);
	}

}
