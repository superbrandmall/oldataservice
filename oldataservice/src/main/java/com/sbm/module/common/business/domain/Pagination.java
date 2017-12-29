package com.sbm.module.common.business.domain;

import java.util.List;

/*****************************************************************************/
/**
 * Project Name:upload2luis<br/>
 * Package Name:com.sbm.module.common.domain<br/>
 * File Name:Pagination.java<br/>
 * 
 * 作成日 ：2017-4-11 下午2:31:06 <br/>
 * 
 * @author ：junkai.zhang
 */
public class Pagination<T> {

	private Long totalCount;

	private List<T> details;

	public List<T> getDetails() {
		return details;
	}

	public void setDetails(List<T> details) {
		this.details = details;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

}
