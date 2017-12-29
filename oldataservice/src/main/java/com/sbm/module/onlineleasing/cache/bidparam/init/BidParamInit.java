package com.sbm.module.onlineleasing.cache.bidparam.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.common.base.init.InitAfterLoad;
import com.sbm.module.onlineleasing.api.baseinfo.bidparam.biz.IBidParamService;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.onlineleasingjob.cache.modality.init<br/>
 * File Name:ModalityInit.java<br/>
 * 
 * 作成日 ：2017-8-17 下午5:54:14 <br/>
 * 
 * @author ：junkai.zhang
 */
@Component
public class BidParamInit implements InitAfterLoad {

	@Autowired
	private IBidParamService service;

	public void init() {
		service.refreshCache();
	}

}
