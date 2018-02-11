package com.sbm.module.partner.hd.rest.shop.test;

import com.alibaba.fastjson.JSON;
import com.sbm.module.partner.hd.rest.base.domain.HdResult;
import com.sbm.module.partner.hd.rest.base.domain.HdResultBody;
import com.sbm.module.partner.hd.rest.shop.domain.HdConditionTemplate;
import com.sbm.module.partner.hd.rest.shop.domain.HdProjectCondition;
import com.sbm.module.partner.hd.rest.shop.domain.HdProjectContent;
import com.sbm.module.partner.hd.rest.shop.domain.HdShop;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sbm.module.common.business.configuration.spring.SpringApplicationConfiguration;
import com.sbm.module.common.business.util.SpringLog4jJUnit4ClassRunner;
import com.sbm.module.partner.hd.rest.base.domain.QueryFilter;
import com.sbm.module.partner.hd.rest.shop.biz.IHdShopService;

import java.util.List;

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
	private IHdShopService service;

	@org.junit.Test
	public void test() {
		try {
			QueryFilter queryFilter = new QueryFilter();
			queryFilter.setPage(0);
			queryFilter.setPageSize(1000);
			queryFilter.getFilter().put("type", "shoppe");
			queryFilter.getFilter().put("storeUuid", "8a028c965f243968015f5176ea26003b");

			HdResult<HdResultBody<HdShop>> result = service.query(queryFilter);

			for (HdShop shop : result.getBody().getRecords()){
				for (HdConditionTemplate template : shop.getTemplates()) {
					for (HdProjectCondition condition : template.getConditions()) {
						List<HdProjectContent> content = JSON.parseArray(condition.getContent(), HdProjectContent.class);
						System.out.println(content.toString());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
