package com.sbm.module.onlineleasing.api.bid.test;

import com.sbm.module.common.business.configuration.spring.SpringApplicationConfiguration;
import com.sbm.module.common.business.util.ParamsUtil;
import com.sbm.module.common.business.util.SpringLog4jJUnit4ClassRunner;
import com.sbm.module.onlineleasing.api.bid.biz.IBidInfoService;
import com.sbm.module.onlineleasing.api.bid.biz.ISubmitBidService;
import com.sbm.module.onlineleasing.api.bid.domain.BidInfo;
import com.sbm.module.onlineleasing.api.bidcontract.biz.IContractPreviewService;
import com.sbm.module.onlineleasing.base.bid.biz.ITOLBidService;
import com.sbm.module.onlineleasing.base.bid.domain.TOLBid;
import com.sbm.module.onlineleasing.base.bidcontract.biz.ITOLBidContractService;
import com.sbm.module.onlineleasing.base.biddetail.biz.ITOLBidDetailService;
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
	private ISubmitBidService service;

	@Autowired
	private ITOLBidService bidService;
	@Autowired
	private ITOLBidContractService bidContractService;
	@Autowired
	private ITOLBidDetailService bidDetailService;

	@org.junit.Test
	public void test() {
		try {
			BidInfo bidInfo = new BidInfo();
			bidInfo.setCode("OLBID171219000001");

			// 判断非空
			ParamsUtil.canNotBeEmpty(bidInfo.getCode());
			// 查询对象
			TOLBid bid = bidService.findByCode(bidInfo.getCode());
			// 校对出价信息
			//checkBid(bidInfo.getCode(), bid);
			// 添加出价
			bidInfo.setBid(bid);
			// 添加出价明细
			bidInfo.setBidDetails(bidDetailService.findAllByCode(bidInfo.getCode()));

			service.preSubmit(bidInfo);
			System.out.println(service.isStandard(bidInfo));
			service.submit(bidInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
