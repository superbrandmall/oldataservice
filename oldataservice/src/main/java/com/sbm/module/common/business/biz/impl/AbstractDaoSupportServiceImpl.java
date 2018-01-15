package com.sbm.module.common.business.biz.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;

import javax.annotation.PostConstruct;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.IDaoSupportService;
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
// @Transactional(value = TransactionConstant.OL, propagation =
// Propagation.REQUIRED)
public abstract class AbstractDaoSupportServiceImpl<T> extends BusinessServiceImpl implements IDaoSupportService<T> {

	private IBaseHibernateDao<T> dao;

	public IBaseHibernateDao<T> getDao() {
		return dao;
	}

	public void setDao(IBaseHibernateDao<T> dao) {
		this.dao = dao;
	}

	@PostConstruct
	protected abstract void injectDao();

	/**
	 * 
	 * setBaseEntity:设置基本信息
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	protected void setBaseEntity(BaseEntity obj) {
		obj.setUpdated(new Date());
		// 默认设为1
		obj.setState(1);
	}

	// @Transactional(value = TransactionConstant.OL, propagation =
	// Propagation.NOT_SUPPORTED, readOnly = true)
	public T get(Class<T> entityClass, Serializable id) {
		return dao.get(entityClass, id);
	}

	public void saveOrUpdate(T t) {
		setBaseEntity((BaseEntity) t);
		dao.saveOrUpdate(t);
	}

	public void save(T t) {
		((BaseEntity) t).setCreated(new Date());
		setBaseEntity((BaseEntity) t);
		dao.save(t);
	}

	public void update(T t) {
		BaseEntity obj = (BaseEntity) t;
		// 加入乐观锁
		Class<T> entityClass = getEntityClass();
		BaseEntity tmp = (BaseEntity) get(entityClass, obj.getId());
		if (tmp.getUpdated().getTime() != obj.getUpdated().getTime()) {
			throw new BusinessException(BusinessCode.C9997, new Object[] { entityClass, obj.getId() }, null);
		}
		// 修改基础参数
		setBaseEntity(obj);
		dao.update(t);
	}

	public void lock(T t) {
		BaseEntity obj = (BaseEntity) t;
		Class<T> entityClass = getEntityClass();
		obj = (BaseEntity) get(entityClass, obj.getId());
		obj.setState(0);
		dao.update((T)obj);
	}

	public void unlock(T t) {
		BaseEntity obj = (BaseEntity) t;
		Class<T> entityClass = getEntityClass();
		obj = (BaseEntity) get(entityClass, obj.getId());
		obj.setState(1);
		dao.update((T)obj);
	}

	public void delete(T t) {
		dao.delete(t);
	}

	public void flushAndClear() {
		dao.flushAndClear();
	}

	@SuppressWarnings("unchecked")
	private Class<T> getEntityClass() {
		Class<T> entityClass = null;
		Type t = getClass().getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			entityClass = (Class<T>) p[0];
		}
		return entityClass;
	}

}
