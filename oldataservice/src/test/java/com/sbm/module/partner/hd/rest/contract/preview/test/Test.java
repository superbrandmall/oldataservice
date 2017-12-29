package com.sbm.module.partner.hd.rest.contract.preview.test;

import com.sbm.module.partner.hd.rest.base.domain.HdResult;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sbm.module.common.business.configuration.spring.SpringApplicationConfiguration;
import com.sbm.module.common.business.util.SpringLog4jJUnit4ClassRunner;
import com.sbm.module.partner.hd.rest.contract.base.domain.HdContract;
import com.sbm.module.partner.hd.rest.contract.preview.biz.IHdContractPreviewService;

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
	private IHdContractPreviewService service;

	@org.junit.Test
	public void test() {
		try {
			HdContract hdContract = new HdContract();
			HdResult<String> result = service.preview(hdContract);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
