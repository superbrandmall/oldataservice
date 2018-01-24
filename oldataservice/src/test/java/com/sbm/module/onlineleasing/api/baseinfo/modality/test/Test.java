package com.sbm.module.onlineleasing.api.baseinfo.modality.test;

import com.sbm.module.onlineleasing.base.modality.biz.ITOLModalityService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.business.configuration.spring.SpringApplicationConfiguration;
import com.sbm.module.common.business.util.SpringLog4jJUnit4ClassRunner;
import com.sbm.module.onlineleasing.api.baseinfo.modality.biz.IModalityService;
import com.sbm.module.onlineleasing.api.baseinfo.modality.domain.ModalityVo;

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
	private IModalityService service;

	@Autowired
	private ITOLModalityService service1;

	@org.junit.Test
	public void test() {
		try {
			service1.refreshCache();

			ModalityVo vo = new ModalityVo();
			service.getModalityList(vo);
			System.out.println(JSON.toJSON(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
