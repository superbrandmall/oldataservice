package com.sbm.module.onlineleasing.api.baseinfo.bidparam.biz.impl;

import java.util.concurrent.TimeUnit;

import com.sbm.module.onlineleasing.base.bidparam.leasetermname.biz.ITOLBidLeasetermnameService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.redis.constant.RedisConstant;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.baseinfo.bidparam.biz.IBidParamService;
import com.sbm.module.onlineleasing.api.baseinfo.bidparam.domain.BidParam;
import com.sbm.module.onlineleasing.api.baseinfo.bidparam.domain.BidParamVo;
import com.sbm.module.onlineleasing.base.bidparam.acctype.biz.ITOLBidAcctypeService;
import com.sbm.module.onlineleasing.base.bidparam.cashiermode.biz.ITOLBidCashierModeService;
import com.sbm.module.onlineleasing.base.bidparam.comparefrequency.biz.ITOLBidCompareFrequencyService;
import com.sbm.module.onlineleasing.base.bidparam.leasemodule.biz.ITOLBidLeasemoduleService;
import com.sbm.module.onlineleasing.base.bidparam.leasetype.biz.ITOLBidLeasetypeService;
import com.sbm.module.onlineleasing.base.bidparam.promotionkind.biz.ITOLBidPromotionKindService;
import com.sbm.module.onlineleasing.base.bidparam.rentmethod.biz.ITOLBidRentMethodService;

/*****************************************************************************/
/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.biz.impl<br/>
 * File Name:EdiInteractiveDetailServiceImpl.java<br/>
 * 
 * 作成日 ：2016-1-4 下午5:05:55 <br/>
 * 
 * @author ：junkai.zhang 
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
/**
 * @preserve public
 */
@Component
@Transactional(value = TransactionConstant.OL, propagation = Propagation.REQUIRED)
public class BidParamServiceImpl extends BusinessServiceImpl implements IBidParamService {

	@Autowired
	private ITOLBidAcctypeService acctypeService;
	@Autowired
	private ITOLBidCashierModeService cashierModeService;
	@Autowired
	private ITOLBidCompareFrequencyService compareFrequencyService;
	@Autowired
	private ITOLBidLeasemoduleService leasemoduleService;
	@Autowired
	private ITOLBidLeasetypeService leasetypeService;
	@Autowired
	private ITOLBidLeasetermnameService leasetermnameService;
	@Autowired
	private ITOLBidPromotionKindService promotionKindService;
	@Autowired
	private ITOLBidRentMethodService rentMethodService;

	public BidParam find() {
		BidParam bidParam = new BidParam();
		bidParam.setAcctypes(acctypeService.findAll());
		bidParam.setCashierModes(cashierModeService.findAll());
		bidParam.setCompareFrequencys(compareFrequencyService.findAll());
		bidParam.setLeasemodules(leasemoduleService.findAll());
		bidParam.setLeasetypes(leasetypeService.findAll());
		bidParam.setPromotionKinds(promotionKindService.findAll());
		bidParam.setRentMethods(rentMethodService.findAll());
		bidParam.setLeasetermnames(leasetermnameService.findAll());
		return bidParam;
	}

	public void refreshCache() {
		BidParam bidParam = find();
		set2redis(RedisConstant.PREFIX_BID_PARAM, JSON.toJSONString(bidParam), 2L, TimeUnit.DAYS);
	}

	/************************************************************************/

	public BidParam get() {
		String valuer = (String) redisService.get(RedisConstant.PREFIX_BID_PARAM);
		if (StringUtils.isNotBlank(valuer)) {
			BidParam bidParam = JSON.parseObject(valuer, BidParam.class);
			return bidParam;
		}
		return find();
	}

	/************************************************************************/

	public void getBidParam(BidParamVo vo) {
		vo.setBidParam(get());
	}

}
