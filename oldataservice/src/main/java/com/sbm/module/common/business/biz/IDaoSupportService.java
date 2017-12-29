package com.sbm.module.common.business.biz;

import java.io.Serializable;

/*****************************************************************************/
/**
 * Project Name:upload2luis<br/>
 * Package Name:com.sbm.module.common.biz<br/>
 * File Name:ICommonService.java<br/>
 * 
 * 作成日 ：2017-4-7 下午4:16:50 <br/>
 * 
 * @author ：junkai.zhang
 */
public interface IDaoSupportService<T> extends IBusinessService {

	public T get(Class<T> entityClass, Serializable id);

	public void saveOrUpdate(T t);

	public void save(T t);

	/**
	 * 
	 * update:更新，乐观锁
	 * 
	 * @author junkai.zhang
	 * @param t
	 */
	public void update(T t);

	public void delete(T t);

	public void flushAndClear();

}
