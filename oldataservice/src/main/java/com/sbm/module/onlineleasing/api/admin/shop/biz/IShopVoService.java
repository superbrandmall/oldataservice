package com.sbm.module.onlineleasing.api.admin.shop.biz;

import com.sbm.module.onlineleasing.api.admin.shop.domain.ShopVo;

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

	void findAllByConditionPage(ShopVo vo);

	void findByCode(ShopVo vo);

	void saveOrUpdate(ShopVo vo);

	void lock(ShopVo vo);

	void unlock(ShopVo vo);
}
