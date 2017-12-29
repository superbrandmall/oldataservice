package com.sbm.module.common.business.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.IBaseHibernateDao;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.common.base.dao.impl<br/>
 * File Name:BaseHibernateDao.java<br/>
 * 
 * 作成日 ：2017-9-1 下午3:20:22 <br/>
 * 
 * @author ：junkai.zhang
 */
@Repository("baseHibernateDaoImpl")
public class BaseHibernateDaoImpl<T> extends AbstractBaseHibernateDaoImpl<T> implements IBaseHibernateDao<T> {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	protected void injectSessionFactory() {
		super.setSessionFactory(sessionFactory);
	}

}
