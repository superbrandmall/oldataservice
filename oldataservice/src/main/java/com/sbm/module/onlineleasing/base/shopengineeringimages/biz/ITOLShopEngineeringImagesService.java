package com.sbm.module.onlineleasing.base.shopengineeringimages.biz;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.onlineleasing.base.shopengineeringimages.domain.TOLShopEngineeringImages;
import com.sbm.module.onlineleasing.base.shopimages.domain.TOLShopImages;

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
public interface ITOLShopEngineeringImagesService extends IDaoSupportService<TOLShopEngineeringImages> {

	List<TOLShopEngineeringImages> findAll();

	List<TOLShopEngineeringImages> findAllByCode(String code);
}
