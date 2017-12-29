package com.sbm.module.partner.hd.job.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sbm.module.common.api.jobinteractive.job.BaseJob;
import com.sbm.module.onlineleasing.base.merchant.biz.ISyncMerchantService;

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
@Component("hdMerchantJob")
public class HdMerchantJob extends BaseJob {

	@Autowired
	@Qualifier("hdSyncMerchantServiceImpl")
	private ISyncMerchantService syncMerchantService;

	protected void execute() {
		// 同步商户
		syncMerchantService.sync();
	}

}
