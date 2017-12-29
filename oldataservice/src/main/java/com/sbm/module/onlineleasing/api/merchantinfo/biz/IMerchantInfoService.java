package com.sbm.module.onlineleasing.api.merchantinfo.biz;

import com.sbm.module.onlineleasing.api.merchantinfo.domain.MerchantInfo;

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
public interface IMerchantInfoService {

	/**
	 * 
	 * getMerchantInfo:获取商户信息
	 * 
	 * @author junkai.zhang
	 * @param merchantInfo
	 */
	public void getMerchantInfo(MerchantInfo merchantInfo);

	/**
	 * 
	 * updateMerchantInfo:更新商户信息
	 * 
	 * @author junkai.zhang
	 * @param merchantInfo
	 */
	public void updateMerchantInfo(MerchantInfo merchantInfo);
}
