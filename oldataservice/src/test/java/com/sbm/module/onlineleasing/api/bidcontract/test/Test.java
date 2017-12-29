package com.sbm.module.onlineleasing.api.bidcontract.test;

import com.sbm.module.common.business.configuration.spring.SpringApplicationConfiguration;
import com.sbm.module.common.business.util.SpringLog4jJUnit4ClassRunner;
import com.sbm.module.onlineleasing.api.bid.domain.BidInfo;
import com.sbm.module.onlineleasing.api.bidcontract.biz.IContractPreviewService;
import com.sbm.module.onlineleasing.api.brandinfo.biz.IBrandInteractiveService;
import com.sbm.module.onlineleasing.base.bid.biz.ITOLBidService;
import com.sbm.module.onlineleasing.base.bid.domain.TOLBid;
import com.sbm.module.onlineleasing.base.bidcontract.biz.ITOLBidContractService;
import com.sbm.module.onlineleasing.base.brand.biz.ITOLBrandService;
import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;
import com.sbm.module.onlineleasing.base.modality.domain.TOLModality;
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
	private IContractPreviewService service;

	@org.junit.Test
	public void test() {
		try {
			BidInfo obj = new BidInfo();
			TOLBid bid = new TOLBid();
			bid.setCode("OLBID171205000005");
			obj.setBid(bid);
			service.createContractPreview(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
