package com.sbm.module.onlineleasing.base.searchshopdetail.dao;

import java.util.List;

import com.sbm.module.common.business.dao.IBaseHibernateDao;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.api.searchshop.domain.SearchShopVo;
import com.sbm.module.onlineleasing.base.searchshopdetail.domain.TOLSearchShopDetail;

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
public interface ITOLSearchShopDetailDao extends IBaseHibernateDao<TOLSearchShopDetail> {

	public List<TOLSearchShopDetail> findAll();

	public TOLSearchShopDetail findByCode(String code);

	public TOLSearchShopDetail findByCondition(TOLSearchShopDetail obj);

	public List<TOLSearchShopDetail> findAllBySearchShop(SearchShopVo obj);

	public Pagination<TOLSearchShopDetail> findAllBySearchShopPage(SearchShopVo obj);

}
