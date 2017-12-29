package com.sbm.module.onlineleasing.cache.building.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.common.api.jobinteractive.job.BaseJob;
import com.sbm.module.onlineleasing.cache.building.init.BuildingInit;

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
@Component("buildingJob")
public class BuildingJob extends BaseJob {

	@Autowired
	private BuildingInit init;

	protected void execute() {
		init.init();
	}

}
