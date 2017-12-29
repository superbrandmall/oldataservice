package com.sbm.module.onlineleasing.api.shopinfo.biz;

import com.sbm.module.onlineleasing.api.shopinfo.domain.ShopInfo;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.onlineleasing.shop.biz<br/>
 * File Name:ITOLShopService.java<br/>
 * 
 * 作成日 ：2017-5-18 下午4:34:06 <br/>
 * 
 * @author ：junkai.zhang
 */
public interface IShopInfoService {

	/**
	 * 
	 * getShopInfo:获取商铺信息
	 * 
	 * @author junkai.zhang
	 * @param shopInfo
	 */
	public void getShopInfo(ShopInfo shopInfo);

	/**
	 * 
	 * getShopInfoBeforeLogin:获取商铺信息before登陆
	 * 
	 * @author junkai.zhang
	 * @param shopInfo
	 */
	public void getShopInfoBeforeLogin(ShopInfo shopInfo);

}
