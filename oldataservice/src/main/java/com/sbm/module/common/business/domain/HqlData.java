package com.sbm.module.common.business.domain;

import java.util.List;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.common.domain<br/>
 * File Name:HqlData.java<br/>
 * 
 * 作成日 ：2017-8-4 下午6:05:13 <br/>
 * 
 * @author ：junkai.zhang
 */
public class HqlData {

	private String hql;

	private BaseEntity baseEntity;

	private List<Object> objs;

	public String getHql() {
		return hql;
	}

	public void setHql(String hql) {
		this.hql = hql;
	}

	public BaseEntity getBaseEntity() {
		return baseEntity;
	}

	public void setBaseEntity(BaseEntity baseEntity) {
		this.baseEntity = baseEntity;
	}

	public List<Object> getObjs() {
		return objs;
	}

	public void setObjs(List<Object> objs) {
		this.objs = objs;
	}

}
