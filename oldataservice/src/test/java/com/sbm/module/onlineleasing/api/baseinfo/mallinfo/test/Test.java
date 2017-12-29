package com.sbm.module.onlineleasing.api.baseinfo.mallinfo.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.business.configuration.spring.SpringApplicationConfiguration;
import com.sbm.module.common.business.util.SpringLog4jJUnit4ClassRunner;
import com.sbm.module.onlineleasing.api.baseinfo.mallinfo.biz.IMallInfoService;
import com.sbm.module.onlineleasing.api.baseinfo.mallinfo.domain.MallInfoVo;

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
	private IMallInfoService service;

	@org.junit.Test
	public void test() {
		try {
			MallInfoVo vo = new MallInfoVo();
			vo.setCode("OLMALL171212000007");
			service.getMallInfo(vo);
			System.out.println(JSON.toJSONString(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
