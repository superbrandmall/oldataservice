package com.sbm.module.onlineleasing.base.shopcoords.dao;

import java.util.List;

import com.sbm.module.common.business.dao.IBaseHibernateDao;
import com.sbm.module.onlineleasing.base.shop.domain.TOLShop;
import com.sbm.module.onlineleasing.base.shopcoords.domain.TOLShopCoords;

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
public interface ITOLShopCoordsDao extends IBaseHibernateDao<TOLShopCoords> {

	List<TOLShopCoords> findAll();

	TOLShopCoords findByCode(String code);

	TOLShopCoords findByCondition(TOLShopCoords obj);

}
