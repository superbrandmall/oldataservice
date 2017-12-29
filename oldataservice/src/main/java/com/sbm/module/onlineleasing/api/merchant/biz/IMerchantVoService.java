package com.sbm.module.onlineleasing.api.merchant.biz;

import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.api.building.domain.BuildingVo;
import com.sbm.module.onlineleasing.api.merchant.domain.MerchantVo;
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
public interface IMerchantVoService {

	void findAllByConditionPage(MerchantVo vo);

	void findByCode(MerchantVo vo);

}
