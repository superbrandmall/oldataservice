package com.sbm.module.onlineleasing.cache.shop.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.base.init.InitAfterLoad;
import com.sbm.module.onlineleasing.base.shop.biz.ITOLShopService;

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
public class ShopInit implements InitAfterLoad {

	@Autowired
	private ITOLShopService service;

	public void init() {
		// service.refreshCache();
		// 因为商铺会修改，暂不入缓存
		CommonConstant.FRAMEWORK.info("因为商铺会修改，暂不入缓存");
	}

}
