package com.sbm.module.onlineleasing.base.shopengineeringspecifications.dao;

import com.sbm.module.common.business.dao.IBaseHibernateDao;
import com.sbm.module.onlineleasing.base.shopengineeringimages.domain.TOLShopEngineeringImages;
import com.sbm.module.onlineleasing.base.shopengineeringspecifications.domain.TOLShopEngineeringSpecifications;

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
public interface ITOLShopEngineeringSpecificationsDao extends IBaseHibernateDao<TOLShopEngineeringSpecifications> {

	List<TOLShopEngineeringSpecifications> findAll();

	List<TOLShopEngineeringSpecifications> findAllByCode(String code);

}
