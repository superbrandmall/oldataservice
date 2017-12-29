package com.sbm.module.onlineleasing.base.biddetail.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sbm.module.common.business.domain.BaseEntity;

/*****************************************************************************/
/**
 * Project Name:CRMDataProcess<br/>
 * Package Name:com.sbm.module.gag.domain<br/>
 * File Name:GAGReceipt.java<br/>
 * 
 * 作成日 ：2017-4-13 下午5:58:11 <br/>
 * 
 * @author ：junkai.zhang
 */
@Entity(name = "TOLBidDetail")
@Table(name = "T_OL_BID_DETAIL")
public class TOLBidDetail extends BaseEntity {

	private String code;

	@Column(columnDefinition = "timestamp")
	private Date startDate;

	@Column(columnDefinition = "timestamp")
	private Date endDate;

	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal deadRent;

	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal floatingRentalRate;

	private Integer orders;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getDeadRent() {
		return deadRent;
	}

	public void setDeadRent(BigDecimal deadRent) {
		this.deadRent = deadRent;
	}

	public BigDecimal getFloatingRentalRate() {
		return floatingRentalRate;
	}

	public void setFloatingRentalRate(BigDecimal floatingRentalRate) {
		this.floatingRentalRate = floatingRentalRate;
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

}
