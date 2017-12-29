package com.sbm.module.onlineleasing.api.merchantinfo.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sbm.module.common.business.configuration.spring.SpringApplicationConfiguration;
import com.sbm.module.common.business.util.SpringLog4jJUnit4ClassRunner;
import com.sbm.module.onlineleasing.api.merchantinfo.biz.IMerchantInteractiveService;
import com.sbm.module.onlineleasing.base.merchant.biz.ITOLMerchantService;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;

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
	private ITOLMerchantService merchantService;
	@Autowired
	private IMerchantInteractiveService service;

	@org.junit.Test
	public void test() {
		try {
			TOLMerchant obj = merchantService.findByCode("OLMERCHANT171212000026");
			//service.merchantAccress(obj);
			service.merchantUpdate(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
