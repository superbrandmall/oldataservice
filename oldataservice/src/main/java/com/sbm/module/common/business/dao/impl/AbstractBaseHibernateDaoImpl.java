package com.sbm.module.common.business.dao.impl;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sbm.module.common.business.domain.BaseEntity;
import com.sbm.module.common.business.domain.HqlData;
import com.sbm.module.common.business.domain.Pagination;

/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.common.business.dao.impl<br/>
 * File Name:AbstractBaseHibernateDaoImpl.java<br/>
 * 
 * 作成日 ：2017-9-19 上午9:42:49 <br/>
 * 
 * @author ：junkai.zhang
 */
public abstract class AbstractBaseHibernateDaoImpl<T> extends HibernateDaoSupport {

	/**
	 * 
	 * injectSessionFactory:注入session
	 * 
	 * @author junkai.zhang
	 */
	@PostConstruct
	protected abstract void injectSessionFactory();

	/**********************************************************************/
	// 常规操作

	public T get(Class<T> entityClass, Serializable id) {
		T t = this.getHibernateTemplate().get(entityClass, id);
		this.getHibernateTemplate().evict(t);
		return t;
	}

	public void saveOrUpdate(T t) {
		this.getHibernateTemplate().saveOrUpdate(t);
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String hql) {
		return (List<T>) this.getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object... values) {
		return (List<T>) this.getHibernateTemplate().find(hql, values);
	}

	public List<T> find(HqlData data) {
		return find(data.getHql(), data.getObjs().toArray());
	}

	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	/**********************************************************************/
	// 执行hql

	public Integer execute(HqlData data) {
		return execute(data.getHql(), data.getObjs().toArray());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Integer execute(final String hql, final Object... values) {
		return (Integer) this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session s) throws HibernateException {
				Query query = s.createQuery(hql);
				// 设置参数
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						query.setParameter(i, values[i]);
					}
				}
				int i = query.executeUpdate();
				return i;
			}
		});
	}

	/**********************************************************************/
	// 分页查询

	public Pagination<T> pageQuery(String hql, BaseEntity vo, Object... values) {
		// 分页对象
		Pagination<T> pagination = new Pagination<T>();

		// 设置明细
		pagination.setDetails(query(hql, vo, values));
		// 设置总数
		StringBuffer totalHql = new StringBuffer("");
		totalHql.append(" select new com.sbm.module.common.business.domain.BaseEntity(count(*) as count) ");
		totalHql.append(hql);
		pagination.setTotalCount(((BaseEntity) (query(totalHql.toString(), new BaseEntity(), values).get(0))).getCount());

		return pagination;
	}

	public Pagination<T> pageQuery(HqlData data) {
		return pageQuery(data.getHql(), data.getBaseEntity(), data.getObjs().toArray());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> query(String hql, BaseEntity vo, Object... values) {
		// 获取session
		Session s = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = s.createQuery(hql);
		// 开始
		query.setFirstResult((vo.getPage() - 1) * vo.getPageCount());
		// 最大
		query.setMaxResults(vo.getPageCount());
		// 设置参数
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query.list();
	}

	/**********************************************************************/
	// 刷新

	/**
	 * 
	 * flushAndClear:单一session处理大量数据时，清除缓存保证不会内存溢出。
	 * 
	 * @author junkai.zhang
	 */
	public void flushAndClear() {
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
	}

	/**********************************************************************/
	// hql处理对象

	/**
	 * 
	 * getHqlData:hql处理对象
	 * 
	 * @author junkai.zhang
	 * @param baseEntity
	 * @return
	 */
	protected HqlData getHqlData(BaseEntity baseEntity) {
		HqlData data = new HqlData();
		data.setBaseEntity(baseEntity);
		data.setObjs(new ArrayList<Object>());
		return data;
	}

	/**
	 * 
	 * likeStr:模糊查询处理
	 * 
	 * @author junkai.zhang
	 * @param str
	 * @return
	 */
	protected String likeStr(String str) {
		return MessageFormat.format("%{0}%", str);
	}

	/**
	 * 
	 * likeStrLeft:左模糊
	 * 
	 * @author junkai.zhang
	 * @param str
	 * @return
	 */
	protected String likeStrLeft(String str) {
		return MessageFormat.format("%{0}", str);
	}

	/**
	 * 
	 * likeStrRigth:右模糊
	 * 
	 * @author junkai.zhang
	 * @param str
	 * @return
	 */
	protected String likeStrRigth(String str) {
		return MessageFormat.format("{0}%", str);
	}

}
