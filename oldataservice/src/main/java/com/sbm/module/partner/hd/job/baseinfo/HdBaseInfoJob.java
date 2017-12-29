package com.sbm.module.partner.hd.job.baseinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sbm.module.common.api.jobinteractive.job.BaseJob;
import com.sbm.module.onlineleasing.base.building.biz.ISyncBuildingService;
import com.sbm.module.onlineleasing.base.floor.biz.ISyncFloorService;
import com.sbm.module.onlineleasing.base.mall.biz.ISyncMallService;

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
@Component("hdBaseInfoJob")
public class HdBaseInfoJob extends BaseJob {

	@Autowired
	@Qualifier("hdSyncMallServiceImpl")
	private ISyncMallService syncMallService;

	@Autowired
	@Qualifier("hdSyncBuildingServiceImpl")
	private ISyncBuildingService syncBuildingService;

	@Autowired
	@Qualifier("hdSyncFloorServiceImpl")
	private ISyncFloorService syncFloorService;

	protected void execute() {
		// 同步项目
		syncMallService.sync();
		// 同步建筑物
		syncBuildingService.sync();
		// 同步楼层
		syncFloorService.sync();
	}

}
