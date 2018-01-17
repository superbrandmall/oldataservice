package com.sbm.module.onlineleasing.base.shopengineeringspecifications.biz;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.onlineleasing.base.shopengineeringimages.domain.TOLShopEngineeringImages;
import com.sbm.module.onlineleasing.base.shopengineeringspecifications.domain.TOLShopEngineeringSpecifications;

import java.util.List;

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
public interface ITOLShopEngineeringSpecificationsService extends IDaoSupportService<TOLShopEngineeringSpecifications> {

	List<TOLShopEngineeringSpecifications> findAll();

	List<TOLShopEngineeringSpecifications> findAllByCode(String code);
}
