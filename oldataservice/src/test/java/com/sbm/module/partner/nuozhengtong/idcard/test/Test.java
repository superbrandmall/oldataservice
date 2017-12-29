package com.sbm.module.partner.nuozhengtong.idcard.test;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.business.configuration.spring.SpringApplicationConfiguration;
import com.sbm.module.common.business.util.SpringLog4jJUnit4ClassRunner;
import com.sbm.module.partner.hl95.rest.sendSMS.biz.ISendSMSService;
import com.sbm.module.partner.hl95.rest.sendSMS.domain.SendSMS;
import com.sbm.module.partner.hl95.rest.sendSMS.domain.SendSMSResult;
import com.sbm.module.partner.nuozhengtong.idcard.biz.INZTIdCardService;
import com.sbm.module.partner.nuozhengtong.idcard.domain.NZTIdCard;
import com.sbm.module.partner.nuozhengtong.idcard.domain.NZTIdCardResult;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

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
	private INZTIdCardService service;

	@org.junit.Test
	public void test() {
		NZTIdCard obj = new NZTIdCard();
		obj.setRealname("葛勇");
		obj.setIdcard("320926197510100415");
		NZTIdCardResult result = service.idCardCheck(obj);
		System.out.println(JSON.toJSONString(result));
	}

}
