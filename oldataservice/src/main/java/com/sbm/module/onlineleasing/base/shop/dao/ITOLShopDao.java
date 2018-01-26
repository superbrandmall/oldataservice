package com.sbm.module.onlineleasing.base.shop.dao;

import java.util.List;

import com.sbm.module.common.business.dao.IBaseHibernateDao;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.api.searchshop.domain.SearchShopVo;
import com.sbm.module.onlineleasing.base.shop.domain.TOLShop;

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
public interface ITOLShopDao extends IBaseHibernateDao<TOLShop> {

	List<TOLShop> findAll();

	TOLShop findByCode(String code);

	TOLShop findByHdUuid(String hdUuid);

	TOLShop findByCondition(TOLShop obj);

	List<TOLShop> findAllBySearchShop(SearchShopVo vo);

	List<TOLShop> findAllByCondition(TOLShop obj);

	Pagination<TOLShop> findAllByConditionPage(TOLShop obj);

	List<TOLShop> findAllByFloorCodes(List<String> floorCodes);

	List<TOLShop> findCountGroupByMall(String mallCode);
	
	List<TOLShop> findCountGroupByFloor(String floorCode);
	
	List<TOLShop> findCountGroupByMallBuildingFloor(String mallCode, String buildingCode, String floorCode);

}
