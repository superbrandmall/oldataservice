package com.sbm.module.onlineleasing.api.admin.brand.biz;

import com.sbm.module.onlineleasing.api.admin.brand.domain.BrandVo;

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
public interface IBrandVoService {

	void findAllByConditionPage(BrandVo vo);

	void findByCode(BrandVo vo);

}
