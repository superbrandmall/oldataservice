package com.sbm.module.partner.hd.rest.base.domain;

import java.util.List;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.rest.base.domain<br/>
 * File Name:HdResultBody.java<br/>
 * 
 * 作成日 ：2017-11-7 上午9:54:29 <br/>
 * 
 * @author ：junkai.zhang
 */
public class HdResultBody<T> {

	private Integer pageSize;

	private Integer page;

	private Integer pageCount;

	private Integer recordCount;

	private List<T> records;

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

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

}
