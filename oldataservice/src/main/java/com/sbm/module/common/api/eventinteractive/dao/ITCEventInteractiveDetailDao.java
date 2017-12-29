package com.sbm.module.common.api.eventinteractive.dao;

import com.sbm.module.common.api.eventinteractive.domain.TCEventInteractiveDetail;
import com.sbm.module.common.api.jobinteractive.domain.TCJobInteractiveDetail;
import com.sbm.module.common.business.dao.IBaseHibernateDao;

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
public interface ITCEventInteractiveDetailDao extends IBaseHibernateDao<TCEventInteractiveDetail> {

	public List<TCEventInteractiveDetail> findAll();

	public TCEventInteractiveDetail findByCondition(TCEventInteractiveDetail obj);

}
