package com.sbm.module.partner.hd.rest.merchant.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.business.configuration.spring.SpringApplicationConfiguration;
import com.sbm.module.common.business.util.SpringLog4jJUnit4ClassRunner;
import com.sbm.module.onlineleasing.base.merchant.biz.ITOLMerchantService;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.partner.hd.rest.base.constant.HdConstant;
import com.sbm.module.partner.hd.rest.base.domain.QueryFilter;
import com.sbm.module.partner.hd.rest.merchant.biz.IHdMerchantService;
import com.sbm.module.partner.hd.rest.merchant.domain.HdMerchant;

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
@SuppressWarnings("unused")
public class Test {

	@Autowired
	private IHdMerchantService service;

	@Autowired
	private ITOLMerchantService merchantService;

	@org.junit.Test
	public void test() {
		try {
			// query();
			save();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void query() {
		QueryFilter queryFilter = new QueryFilter();
		queryFilter.setPage(1);
		queryFilter.setPageSize(10);

		service.query(queryFilter);
	}

	private void save() {
		TOLMerchant merchant = merchantService.findByCode("OLMERCHANT170718000024");

		HdMerchant obj = new HdMerchant();
		obj.setCode(merchant.getCode());
		obj.setName(merchant.getName());
		obj.setState(HdConstant.HD_STATE_USING);
		System.out.println(JSON.toJSONString(obj));
		service.save(obj);
	}
}
