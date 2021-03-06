package com.sbm.module.onlineleasing.api.interactive.bidresult.biz;

import com.sbm.module.onlineleasing.api.interactive.bidresult.domain.BidResultReceiveVo;

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
public interface IBidResultReceiveService {

	/**
	 * 
	 * approve:审批结果
	 * 
	 * @author junkai.zhang
	 * @param vo
	 */
	public void approve(BidResultReceiveVo vo);

	/**
	 * 
	 * effect:是否生效
	 * 
	 * @author junkai.zhang
	 * @param vo
	 */
	public void effect(BidResultReceiveVo vo);

}
