package com.sbm.module.partner.hd.job.brand;

import com.sbm.module.common.base.constant.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sbm.module.common.api.jobinteractive.job.BaseJob;
import com.sbm.module.onlineleasing.base.brand.biz.ISyncBrandService;

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
@Component("hdBrandJob")
public class HdBrandJob extends BaseJob {

	@Autowired
	@Qualifier("hdSyncBrandServiceImpl")
	private ISyncBrandService syncBrandService;

	protected void execute() {
		CommonConstant.FRAMEWORK.info("品牌使用新版同步");
		// 同步商户
//		syncBrandService.sync();
	}

}
