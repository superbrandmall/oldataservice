package com.sbm.module.onlineleasing.api.mall.biz;

import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.api.mall.domain.MallVo;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;
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
public interface IMallVoService {

	void findAllByConditionPage(MallVo vo);

	void findByCode(MallVo vo);

}
