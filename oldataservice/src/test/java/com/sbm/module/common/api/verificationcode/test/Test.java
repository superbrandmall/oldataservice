package com.sbm.module.common.api.verificationcode.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sbm.module.common.api.verificationcode.biz.IVerificationCodeService;
import com.sbm.module.common.api.verificationcode.domain.VerificationCode;
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
	private IVerificationCodeService service;

	@org.junit.Test
	public void test() {
		VerificationCode verificationCode = new VerificationCode();
		verificationCode.setKey("junkai.zhang@superbrandmall.com");
		service.getEmailVerificationCode(verificationCode);
	}

}
