package com.sbm.module.onlineleasing.api.searchshop.biz;

import com.sbm.module.onlineleasing.api.searchshop.domain.SearchShop;

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
public interface IShopScoreService {

	/**
	 * 
	 * calShopScore:计算商铺评分结果
	 * 
	 * @author junkai.zhang
	 * @param searchShop
	 */
	public void calShopScore(SearchShop searchShop);

}
