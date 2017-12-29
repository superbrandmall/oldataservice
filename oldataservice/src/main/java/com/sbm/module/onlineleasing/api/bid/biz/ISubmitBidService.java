package com.sbm.module.onlineleasing.api.bid.biz;

import com.sbm.module.onlineleasing.api.bid.domain.BidInfo;

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
public interface ISubmitBidService {

	/**
	 * 
	 * preSave:保存前校验
	 * 
	 * @author junkai.zhang
	 * @param bidInfo
	 */
	void preSave(BidInfo bidInfo);

	/**
	 * 
	 * preSubmit:提交前校验
	 * 
	 * @author junkai.zhang
	 * @param bidInfo
	 */
	void preSubmit(BidInfo bidInfo);

	/**
	 * 判断标准/非标准
	 * @param bidInfo
	 * @return
	 */
	boolean isStandard(BidInfo bidInfo);

	/**
	 * 
	 * submit:提交出价
	 * 
	 * @author junkai.zhang
	 * @param bidInfo
	 */
	void submit(BidInfo bidInfo);
}
