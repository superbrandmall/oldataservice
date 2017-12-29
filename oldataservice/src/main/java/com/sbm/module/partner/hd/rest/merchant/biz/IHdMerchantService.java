package com.sbm.module.partner.hd.rest.merchant.biz;

import com.sbm.module.partner.hd.rest.base.domain.HdResult;
import com.sbm.module.partner.hd.rest.base.domain.HdResultBody;
import com.sbm.module.partner.hd.rest.base.domain.QueryFilter;
import com.sbm.module.partner.hd.rest.merchant.domain.HdMerchant;

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
public interface IHdMerchantService {

	/**
	 * 
	 * query:查询
	 * 
	 * @author junkai.zhang
	 * @param queryFilter
	 * @return
	 */
	public HdResult<HdResultBody<HdMerchant>> query(QueryFilter queryFilter);

	/**
	 * 
	 * save:保存
	 * 
	 * @author junkai.zhang
	 * @param obj
	 * @return
	 */
	public HdResult<HdMerchant> save(HdMerchant obj);
}
