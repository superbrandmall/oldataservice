package com.sbm.module.common.api.restinteractive.dao;

import java.util.List;

import com.sbm.module.common.api.restinteractive.domain.TCRestInteractiveDetail;
import com.sbm.module.common.business.dao.IBaseHibernateDao;

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
public interface ITCRestInteractiveDetailDao extends IBaseHibernateDao<TCRestInteractiveDetail> {

	public List<TCRestInteractiveDetail> findAll();

	public TCRestInteractiveDetail findByCondition(TCRestInteractiveDetail obj);

}
