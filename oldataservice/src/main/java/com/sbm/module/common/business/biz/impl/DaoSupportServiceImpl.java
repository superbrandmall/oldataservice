package com.sbm.module.common.business.biz.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.dao.IBaseHibernateDao;
import com.sbm.module.common.business.domain.BaseEntity;

/*****************************************************************************/
/**
 * Project Name:upload2luis<br/>
 * Package Name:com.sbm.module.common.biz.impl<br/>
 * File Name:CommonServiceImpl.java<br/>
 * 
 * 作成日 ：2017-4-7 下午4:17:11 <br/>
 * 
 * @author ：junkai.zhang
 */
@Transactional(value = TransactionConstant.OL, propagation = Propagation.REQUIRED)
public class DaoSupportServiceImpl<T> extends AbstractDaoSupportServiceImpl<T> implements IDaoSupportService<T> {

	@Autowired
	@Qualifier("baseHibernateDaoImpl")
	private IBaseHibernateDao<T> dao;

	protected void injectDao() {
		super.setDao(dao);
	}

	public IBaseHibernateDao<T> getDao() {
		return super.getDao();
	}

	public void setDao(IBaseHibernateDao<T> dao) {
		super.setDao(dao);
	}

	protected void setBaseEntity(BaseEntity obj) {
		super.setBaseEntity(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public T get(Class<T> entityClass, Serializable id) {
		return super.get(entityClass, id);
	}

	public void saveOrUpdate(T t) {
		super.saveOrUpdate(t);
	}

	public void save(T t) {
		super.save(t);
	}

	public void update(T t) {
		super.update(t);
	}

	public void delete(T t) {
		super.delete(t);
	}

	public void flushAndClear() {
		super.flushAndClear();
	}

}
