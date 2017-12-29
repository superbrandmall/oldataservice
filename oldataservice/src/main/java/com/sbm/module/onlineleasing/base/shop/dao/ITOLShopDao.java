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

	public List<TOLShop> findAll();

	public TOLShop findByCode(String code);

	public TOLShop findByHdUuid(String hdUuid);

	public TOLShop findByCondition(TOLShop obj);

	public List<TOLShop> findAllBySearchShop(SearchShopVo vo);

	public List<TOLShop> findAllByCondition(TOLShop obj);

	public Pagination<TOLShop> findAllByConditionPage(TOLShop obj);

	public List<TOLShop> findCountGroupByMall(String mallCode);
	
	public List<TOLShop> findCountGroupByFloor(String floorCode);
	
	public List<TOLShop> findCountGroupByMallBuildingFloor(String mallCode, String buildingCode, String floorCode);
}
