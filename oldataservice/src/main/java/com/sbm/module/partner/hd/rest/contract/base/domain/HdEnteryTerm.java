package com.sbm.module.partner.hd.rest.contract.base.domain;

import java.util.Date;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.rest.contract.base.domain<br/>
 * File Name:HdEnteryTerm.java<br/>
 * 
 * 作成日 ：2017-11-20 下午4:31:42 <br/>
 * 
 * @author ：junkai.zhang
 */
public class HdEnteryTerm {

	/**
	 * 条款名称
	 */
	private String caption;

	/**
	 * 说明
	 */
	private String remark;

	/**
	 * 交付日期
	 */
	private Date deliveryDate;

	/**
	 * 进场日期
	 */
	private Date entryDate;

	/**
	 * 开业日期
	 */
	private Date openDate;

	/**
	 * 装修开始日期
	 */
	private Date fitmentBeginDate;

	/**
	 * 装修结束日期
	 */
	private Date fitmentEndDate;

	/**
	 * 装修天数
	 */
	private Integer fitmentDays;

	/**
	 * 计租日期
	 */
	private Date rentDate;

	/**
	 * 经营免租期天数
	 */
	private Integer freeDays;

	/**
	 * 经营免租期月
	 */
	private Integer freeMonths;

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

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getFitmentBeginDate() {
		return fitmentBeginDate;
	}

	public void setFitmentBeginDate(Date fitmentBeginDate) {
		this.fitmentBeginDate = fitmentBeginDate;
	}

	public Date getFitmentEndDate() {
		return fitmentEndDate;
	}

	public void setFitmentEndDate(Date fitmentEndDate) {
		this.fitmentEndDate = fitmentEndDate;
	}

	public Integer getFitmentDays() {
		return fitmentDays;
	}

	public void setFitmentDays(Integer fitmentDays) {
		this.fitmentDays = fitmentDays;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Integer getFreeDays() {
		return freeDays;
	}

	public void setFreeDays(Integer freeDays) {
		this.freeDays = freeDays;
	}

	public Integer getFreeMonths() {
		return freeMonths;
	}

	public void setFreeMonths(Integer freeMonths) {
		this.freeMonths = freeMonths;
	}

}
