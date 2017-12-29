package com.sbm.module.partner.hd.job.modality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sbm.module.common.api.jobinteractive.job.BaseJob;
import com.sbm.module.onlineleasing.base.modality.biz.ISyncModalityService;

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
@Component("hdModalityJob")
public class HdModalityJob extends BaseJob {

	@Autowired
	@Qualifier("hdSyncModalityServiceImpl")
	private ISyncModalityService service;

	protected void execute() {
		// 同步业态
		service.sync();
	}

}
