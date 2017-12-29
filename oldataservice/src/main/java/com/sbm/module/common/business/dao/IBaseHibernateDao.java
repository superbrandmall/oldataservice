package com.sbm.module.common.business.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseHibernateDao<T> {

	public T get(Class<T> entityClass, Serializable id);

	public void saveOrUpdate(T t);

	public List<T> find(String hql);

	public void save(T t);

	public void update(T t);

	public void delete(T t);

	public void flushAndClear();
}
