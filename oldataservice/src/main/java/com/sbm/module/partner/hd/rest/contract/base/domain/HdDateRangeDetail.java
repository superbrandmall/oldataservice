package com.sbm.module.partner.hd.rest.contract.base.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.rest.contract.base.domain<br/>
 * File Name:HdDateRangeDetail.java<br/>
 * 
 * 作成日 ：2017-11-20 下午4:26:14 <br/>
 * 
 * @author ：junkai.zhang
 */
public class HdDateRangeDetail {

	/**
	 * 开始日期
	 */
	//@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date beginDate;

	/**
	 * 结束日期
	 */
	//@JSONField (format="yyyy-MM-dd HH:mm:ss")
	private Date endDate;

	/**
	 * 金额或比例值
	 */
	private BigDecimal value;

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public HdDateRangeDetail(Date beginDate, Date endDate, BigDecimal value) {
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.value = value;
	}

	public HdDateRangeDetail() {

	}
}
