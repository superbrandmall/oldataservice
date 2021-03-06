package com.sbm.module.onlineleasing.cache.mallbidstandard.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.common.base.init.InitAfterLoad;
import com.sbm.module.onlineleasing.base.mallbidstandard.biz.ITOLMallBidStandardService;

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
public class MallBidStandardInit implements InitAfterLoad {

	@Autowired
	private ITOLMallBidStandardService service;

	public void init() {
		service.refreshCache();
	}

}
