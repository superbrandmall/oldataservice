package com.sbm.module.onlineleasing.api.bidparam.test;

import com.sbm.module.onlineleasing.api.baseinfo.bidparam.domain.BidParamVo;
import com.sbm.module.onlineleasing.base.bidparam.leasetype.domain.TOLBidLeasetype;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.business.configuration.spring.SpringApplicationConfiguration;
import com.sbm.module.common.business.util.SpringLog4jJUnit4ClassRunner;
import com.sbm.module.onlineleasing.api.baseinfo.bidparam.biz.IBidParamService;
import com.sbm.module.onlineleasing.api.baseinfo.bidparam.domain.BidParam;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

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
	private IBidParamService service;

	@org.junit.Test
	public void test() {
		try {
			BidParam param = service.get();
			System.out.println(JSON.toJSON(param));

			System.out.println(JSON.toJSON(param.getLeasetypes()));
			List<TOLBidLeasetype> leasetypes = param.getLeasetypes().stream().filter(t->t.getItemValue().equals(String.valueOf(0))).collect(Collectors.toList());

			System.out.println(JSON.toJSONString(leasetypes));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
