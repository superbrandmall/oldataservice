package com.sbm.module.onlineleasing.base.shop.test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sbm.module.common.business.configuration.spring.SpringApplicationConfiguration;
import com.sbm.module.common.business.util.SpringLog4jJUnit4ClassRunner;
import com.sbm.module.onlineleasing.base.shop.biz.ITOLShopService;
import com.sbm.module.onlineleasing.base.shop.domain.TOLShop;

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
	private ITOLShopService service;

	@org.junit.Test
	public void test() {

		try {
			// List<TOLShop> list =
			// service.findCountGroupByMall("OLMALL170717000001");
			// for (TOLShop obj : list) {
			// System.out.println(JSON.toJSONString(obj));
			// }

			// List<TOLShop> list =
			// service.findCountGroupByMallBuildingFloor("OLMALL170717000001",
			// "OLBUILDING170717000001", "04F");
			// for (TOLShop obj : list) {
			// System.out.println(JSON.toJSONString(obj));
			// }

			List<TOLShop> list = service.findAll();
			for (TOLShop obj : list) {
				if (!"OLBUILDING170717000001".equals(obj.getBuildingCode())) {
					continue;
				}
				obj.setFloorCode(getS(obj.getFloorCode()));
				// System.out.println(JSON.toJSONString(obj));
				service.update(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String getS(String floor) {
		switch (floor) {
		case "B01":
			return "OLFLOOR171115000004";
		case "B03":
			return "OLFLOOR171115000005";
		case "01F":
			return "OLFLOOR171115000006";
		case "04F":
			return "OLFLOOR171115000007";
		case "07F":
			return "OLFLOOR171115000008";
		case "09F":
			return "OLFLOOR171115000009";
		case "10F":
			return "OLFLOOR171115000010";
		case "B02":
			return "OLFLOOR171115000011";
		case "02F":
			return "OLFLOOR171115000012";
		case "03F":
			return "OLFLOOR171115000013";
		case "05F":
			return "OLFLOOR171115000014";
		case "06F":
			return "OLFLOOR171115000015";
		case "08F":
			return "OLFLOOR171115000016";
		}
		return null;
	}

}
