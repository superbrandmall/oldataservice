package com.sbm.module.partner.hd.rest.contract.base.domain;

import java.util.ArrayList;
import java.util.List;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.rest.contract.base.domain<br/>
 * File Name:HdMonthFixedTerm.java<br/>
 * 
 * 作成日 ：2017-11-20 下午4:25:55 <br/>
 * 
 * @author ：junkai.zhang
 */
public class HdNormalSaleRateTerm {

	/**
	 * 条款名称
	 */
	private String caption;

	/**
	 * 说明
	 */
	private String remark;

	/**
	 * 明细
	 */
	private List<HdDateRangeDetail> details = new ArrayList<>();

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<HdDateRangeDetail> getDetails() {
		return details;
	}

	public void setDetails(List<HdDateRangeDetail> details) {
		this.details = details;
	}

}
