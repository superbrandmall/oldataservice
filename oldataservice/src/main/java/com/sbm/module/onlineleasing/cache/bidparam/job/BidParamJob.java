package com.sbm.module.onlineleasing.cache.bidparam.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.common.api.jobinteractive.job.BaseJob;
import com.sbm.module.onlineleasing.cache.bidparam.init.BidParamInit;

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
@Component("bidParamJob")
public class BidParamJob extends BaseJob {

	@Autowired
	private BidParamInit init;

	protected void execute() {
		init.init();
	}

}
