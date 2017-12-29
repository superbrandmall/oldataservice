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
public interface ISearchShopService {

	/**
	 * 
	 * getDetails:搜索店铺
	 * 
	 * @author junkai.zhang
	 * @param searchShop
	 */
	public void getDetails(SearchShop searchShop);

	/**
	 * 
	 * getHistories:获取搜索店铺历史记录
	 * 
	 * @author junkai.zhang
	 * @param searchShop
	 */
	public void getHistories(SearchShop searchShop);
}
