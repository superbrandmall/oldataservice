package com.sbm.module.onlineleasing.api.merchantdetail.biz;

import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;

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
public interface IDownloadMerchantDetailService {

	/**
	 * 
	 * download:下载租户详细信息
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	public void download(TOLMerchant obj);

}
