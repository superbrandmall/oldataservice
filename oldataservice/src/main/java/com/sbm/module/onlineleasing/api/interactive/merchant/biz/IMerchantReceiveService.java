package com.sbm.module.onlineleasing.api.interactive.merchant.biz;

import com.sbm.module.onlineleasing.api.interactive.merchant.domain.MerchantReceiveVo;

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
public interface IMerchantReceiveService {

	/**
	 * 
	 * receive:商户接收
	 * 
	 * @author junkai.zhang
	 * @param vo
	 */
	public void receive(MerchantReceiveVo vo);

}
