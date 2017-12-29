package com.sbm.module.partner.hd.rest.base.domain;

import java.util.HashMap;
import java.util.Map;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.rest.base.domain<br/>
 * File Name:QueryFilter.java<br/>
 * 
 * 作成日 ：2017-10-24 下午3:47:30 <br/>
 * 
 * @author ：junkai.zhang
 */
public class QueryFilter {

	/**
	 * 每页最大显示记录数，0表示包含全部结果集
	 */
	private Integer pageSize = 10;

	/**
	 * 当前页号，从0计数
	 */
	private Integer page = 0;

	private Map<String, Object> filter = new HashMap<String, Object>();

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Map<String, Object> getFilter() {
		return filter;
	}

	public void setFilter(Map<String, Object> filter) {
		this.filter = filter;
	}

}
