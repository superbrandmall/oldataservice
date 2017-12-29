package com.sbm.module.onlineleasing.base.myfavourite.dao;

import java.util.List;

import com.sbm.module.common.business.dao.IBaseHibernateDao;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.myfavourite.domain.TOLMyFavourite;

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
public interface ITOLMyFavouriteDao extends IBaseHibernateDao<TOLMyFavourite> {

	public List<TOLMyFavourite> findAll();

	public List<TOLMyFavourite> findAllByUserCode(TOLMyFavourite obj);

	public Pagination<TOLMyFavourite> findAllByUserCodePage(TOLMyFavourite obj);

	/**
	 * 
	 * findByUserCodeAndShopCode:根据用户code和商铺code查询
	 * 
	 * @author junkai.zhang
	 * @param obj
	 * @return
	 */
	public TOLMyFavourite findByUserCodeAndShopCode(TOLMyFavourite obj);

}
