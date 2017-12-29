package com.sbm.module.onlineleasing.api.shop.biz;

import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.api.shop.domain.ShopVo;
import com.sbm.module.onlineleasing.base.shop.domain.TOLShop;

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
public interface IShopVoService {

	public void findAllByConditionPage(ShopVo vo);

	public void findByCode(ShopVo vo);

	public void saveOrUpdate(ShopVo vo);

}
