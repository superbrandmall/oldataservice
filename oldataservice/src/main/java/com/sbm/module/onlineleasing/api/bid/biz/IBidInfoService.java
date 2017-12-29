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
public interface IBidInfoService {

	/**
	 * 
	 * getBidInfo:获取出价信息
	 * 
	 * @author junkai.zhang
	 * @param bidInfo
	 */
	void getBidInfo(BidInfo bidInfo);

	/*********************************************************************/

	/**
	 * 
	 * saveBidInfo:保存出价信息
	 * 
	 * @author junkai.zhang
	 * @param bidInfo
	 */
	void saveBidInfo(BidInfo bidInfo);

	/*********************************************************************/

	/**
	 * 
	 * getDetails:获取出价列表
	 * 
	 * @author junkai.zhang
	 * @param bidInfo
	 */
	void getDetails(BidInfo bidInfo);

	/**
	 *
	 * getContractDetails:获取合同列表
	 *
	 * @author junkai.zhang
	 * @param bidInfo
	 */
	void getContractDetails(BidInfo bidInfo);

	/*********************************************************************/

	/**
	 * 
	 * preview:预览合同
	 * 
	 * @author junkai.zhang
	 * @param bidInfo
	 */
	void preview(BidInfo bidInfo);

	/**
	 * 
	 * view:查看
	 * 
	 * @author junkai.zhang
	 * @param bidInfo
	 */
	void view(BidInfo bidInfo);

	/*********************************************************************/

	/**
	 * 
	 * saveBusinessSuggest:保存商务异议
	 * 
	 * @author junkai.zhang
	 * @param bidInfo
	 */
	void saveBusinessSuggest(BidInfo bidInfo);

	/**
	 * 
	 * saveLegalSuggest:保存法务异议
	 * 
	 * @author junkai.zhang
	 * @param bidInfo
	 */
	void saveLegalSuggest(BidInfo bidInfo);

	/*********************************************************************/

	/**
	 * 
	 * submit:提交出价
	 * 
	 * @author junkai.zhang
	 * @param bidInfo
	 */
	void submit(BidInfo bidInfo);

}
