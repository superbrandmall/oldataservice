package com.sbm.module.common.api.jobinteractive.dao;

import java.util.List;

import com.sbm.module.common.api.jobinteractive.domain.TCJobInteractiveDetail;
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
public interface ITCJobInteractiveDetailDao extends IBaseHibernateDao<TCJobInteractiveDetail> {

	public List<TCJobInteractiveDetail> findAll();

	public TCJobInteractiveDetail findByCondition(TCJobInteractiveDetail obj);

}
