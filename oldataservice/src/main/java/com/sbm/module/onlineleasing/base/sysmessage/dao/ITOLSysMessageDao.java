package com.sbm.module.onlineleasing.base.sysmessage.dao;

import java.util.List;

import com.sbm.module.common.business.dao.IBaseHibernateDao;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.sysmessage.domain.TOLSysMessage;

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
public interface ITOLSysMessageDao extends IBaseHibernateDao<TOLSysMessage> {

	public List<TOLSysMessage> findAll();

	public TOLSysMessage findByCondition(TOLSysMessage obj);

	public List<TOLSysMessage> findAllByUserCodeAndType(TOLSysMessage obj);

	public Pagination<TOLSysMessage> findAllByUserCodeAndTypePage(TOLSysMessage obj);
}
