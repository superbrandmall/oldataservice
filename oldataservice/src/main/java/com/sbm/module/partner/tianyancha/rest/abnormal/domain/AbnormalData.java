package com.sbm.module.partner.tianyancha.rest.abnormal.domain;

import java.util.List;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.tianyancha.rest.lawsuit.domain<br/>
 * File Name:LawSuitData.java<br/>
 * 
 * 作成日 ：2017-10-18 上午10:17:36 <br/>
 * 
 * @author ：junkai.zhang
 */
public class AbnormalData {

	private Integer total;

	private Integer pagesize;

	private List<AbnormalItem> items;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public List<AbnormalItem> getItems() {
		return items;
	}

	public void setItems(List<AbnormalItem> items) {
		this.items = items;
	}

}
