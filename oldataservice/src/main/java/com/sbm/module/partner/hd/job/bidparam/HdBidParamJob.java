package com.sbm.module.partner.hd.job.bidparam;

import com.sbm.module.onlineleasing.base.bidparam.leasetermname.biz.ISyncLeasetermnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sbm.module.common.api.jobinteractive.job.BaseJob;
import com.sbm.module.onlineleasing.base.bidparam.acctype.biz.ISyncAcctypeService;
import com.sbm.module.onlineleasing.base.bidparam.cashiermode.biz.ISyncCashierModeService;
import com.sbm.module.onlineleasing.base.bidparam.comparefrequency.biz.ISyncCompareFrequencyService;
import com.sbm.module.onlineleasing.base.bidparam.leasemodule.biz.ISyncLeasemoduleService;
import com.sbm.module.onlineleasing.base.bidparam.leasetype.biz.ISyncLeasetypeService;
import com.sbm.module.onlineleasing.base.bidparam.promotionkind.biz.ISyncPromotionKindService;
import com.sbm.module.onlineleasing.base.bidparam.rentmethod.biz.ISyncRentMethodService;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.job.sync.floor<br/>
 * File Name:FloorJob.java<br/>
 * 
 * 作成日 ：2017-9-25 上午10:42:32 <br/>
 * 
 * @author ：junkai.zhang
 */
@Component("hdBidParamJob")
public class HdBidParamJob extends BaseJob {

	@Autowired
	@Qualifier("hdSyncAcctypeServiceImpl")
	private ISyncAcctypeService syncAcctypeService;

	@Autowired
	@Qualifier("hdSyncCashierModeServiceImpl")
	private ISyncCashierModeService syncCashierModeService;

	@Autowired
	@Qualifier("hdSyncCompareFrequencyServiceImpl")
	private ISyncCompareFrequencyService syncCompareFrequencyService;

	@Autowired
	@Qualifier("hdSyncLeasemoduleServiceImpl")
	private ISyncLeasemoduleService syncLeasemoduleService;

	@Autowired
	@Qualifier("hdSyncLeasetermnameServiceImpl")
	private ISyncLeasetermnameService syncLeasetermnameService;

	@Autowired
	@Qualifier("hdSyncLeasetypeServiceImpl")
	private ISyncLeasetypeService syncLeasetypeService;

	@Autowired
	@Qualifier("hdSyncPromotionKindServiceImpl")
	private ISyncPromotionKindService syncPromotionKindService;

	@Autowired
	@Qualifier("hdSyncRentMethodServiceImpl")
	private ISyncRentMethodService syncRentMethodService;

	protected void execute() {
		// 结算方式
		syncAcctypeService.sync();
		// 收银方式
		syncCashierModeService.sync();
		// 比高频率
		syncCompareFrequencyService.sync();
		// 合同模板
		syncLeasemoduleService.sync();
		// 条款名称
		syncLeasetermnameService.sync();
		// 合作类型
		syncLeasetypeService.sync();
		// 合同模板
		syncPromotionKindService.sync();
		// 计租方式
		syncRentMethodService.sync();
	}

}
