package com.sbm.module.onlineleasing.api.register.biz;

import com.sbm.module.onlineleasing.api.register.domain.RegisterMerchantCheck;

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
public interface IRegisterMerchantCheckService {

	/**
	 * 
	 * getSearch:查询结果
	 * 
	 * @author junkai.zhang
	 * @param registerMerchantCheck
	 */
	public void getSearch(RegisterMerchantCheck registerMerchantCheck);

	/**
	 * 
	 * getBaseInfo:返回信息
	 * 
	 * @author junkai.zhang
	 * @param registerMerchantCheck
	 */
	public void getBaseInfo(RegisterMerchantCheck registerMerchantCheck);
	
	/**
	 * 
	 * getBaseInfoV2:返回信息V2
	 * 
	 * @author junkai.zhang
	 * @param registerMerchantCheck
	 */
	public void getBaseInfoV2(RegisterMerchantCheck registerMerchantCheck);

}
