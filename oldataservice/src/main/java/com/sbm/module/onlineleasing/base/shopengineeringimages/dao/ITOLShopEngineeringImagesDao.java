package com.sbm.module.onlineleasing.base.shopengineeringimages.dao;

import com.sbm.module.common.business.dao.IBaseHibernateDao;
import com.sbm.module.onlineleasing.base.shopengineeringimages.domain.TOLShopEngineeringImages;
import com.sbm.module.onlineleasing.base.shopimages.domain.TOLShopImages;

import java.util.List;

/*****************************************************************************/

/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.onlineleasing.shop.dao<br/>
 * File Name:ITOLShopDao.java<br/>
 * 
 * 作成日 ：2017-5-18 下午4:22:16 <br/>
 * 
 * @author ：junkai.zhang
 */
public interface ITOLShopEngineeringImagesDao extends IBaseHibernateDao<TOLShopEngineeringImages> {

	List<TOLShopEngineeringImages> findAll();

	List<TOLShopEngineeringImages> findAllByCode(String code);

}
