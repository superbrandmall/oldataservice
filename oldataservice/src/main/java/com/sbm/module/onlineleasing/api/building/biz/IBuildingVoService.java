package com.sbm.module.onlineleasing.api.building.biz;

import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.api.building.domain.BuildingVo;
import com.sbm.module.onlineleasing.api.mall.domain.MallVo;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;

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
public interface IBuildingVoService {

	void findAllByConditionPage(BuildingVo vo);

	void findByCode(BuildingVo vo);

}
