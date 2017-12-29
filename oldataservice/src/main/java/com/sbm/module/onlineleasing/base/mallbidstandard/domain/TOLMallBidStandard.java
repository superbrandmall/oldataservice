package com.sbm.module.onlineleasing.base.mallbidstandard.domain;

import java.math.BigDecimal;

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
@Entity(name = "TOLMallBidStandard")
@Table(name = "T_OL_MALL_BID_STANDARD")
public class TOLMallBidStandard extends BaseEntity {

	private String code;

	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal limitRetail_1;
	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal limitRetail_2;
	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal limitRetail_3;
	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal limitNonretail_1;
	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal limitNonretail_2;
	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal limitNonretail_3;

	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal rentFreeRetail_1;
	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal rentFreeRetail_2;
	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal rentFreeRetail_3;
	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal rentFreeNonretail_1;
	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal rentFreeNonretail_2;
	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal rentFreeNonretail_3;

	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal rentIncrease_1;
	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal rentIncrease_2;
	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal promotionBudget;

	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal maintenanceFee;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getLimitRetail_1() {
		return limitRetail_1;
	}

	public void setLimitRetail_1(BigDecimal limitRetail_1) {
		this.limitRetail_1 = limitRetail_1;
	}

	public BigDecimal getLimitRetail_2() {
		return limitRetail_2;
	}

	public void setLimitRetail_2(BigDecimal limitRetail_2) {
		this.limitRetail_2 = limitRetail_2;
	}

	public BigDecimal getLimitRetail_3() {
		return limitRetail_3;
	}

	public void setLimitRetail_3(BigDecimal limitRetail_3) {
		this.limitRetail_3 = limitRetail_3;
	}

	public BigDecimal getLimitNonretail_1() {
		return limitNonretail_1;
	}

	public void setLimitNonretail_1(BigDecimal limitNonretail_1) {
		this.limitNonretail_1 = limitNonretail_1;
	}

	public BigDecimal getLimitNonretail_2() {
		return limitNonretail_2;
	}

	public void setLimitNonretail_2(BigDecimal limitNonretail_2) {
		this.limitNonretail_2 = limitNonretail_2;
	}

	public BigDecimal getLimitNonretail_3() {
		return limitNonretail_3;
	}

	public void setLimitNonretail_3(BigDecimal limitNonretail_3) {
		this.limitNonretail_3 = limitNonretail_3;
	}

	public BigDecimal getRentFreeRetail_1() {
		return rentFreeRetail_1;
	}

	public void setRentFreeRetail_1(BigDecimal rentFreeRetail_1) {
		this.rentFreeRetail_1 = rentFreeRetail_1;
	}

	public BigDecimal getRentFreeRetail_2() {
		return rentFreeRetail_2;
	}

	public void setRentFreeRetail_2(BigDecimal rentFreeRetail_2) {
		this.rentFreeRetail_2 = rentFreeRetail_2;
	}

	public BigDecimal getRentFreeRetail_3() {
		return rentFreeRetail_3;
	}

	public void setRentFreeRetail_3(BigDecimal rentFreeRetail_3) {
		this.rentFreeRetail_3 = rentFreeRetail_3;
	}

	public BigDecimal getRentFreeNonretail_1() {
		return rentFreeNonretail_1;
	}

	public void setRentFreeNonretail_1(BigDecimal rentFreeNonretail_1) {
		this.rentFreeNonretail_1 = rentFreeNonretail_1;
	}

	public BigDecimal getRentFreeNonretail_2() {
		return rentFreeNonretail_2;
	}

	public void setRentFreeNonretail_2(BigDecimal rentFreeNonretail_2) {
		this.rentFreeNonretail_2 = rentFreeNonretail_2;
	}

	public BigDecimal getRentFreeNonretail_3() {
		return rentFreeNonretail_3;
	}

	public void setRentFreeNonretail_3(BigDecimal rentFreeNonretail_3) {
		this.rentFreeNonretail_3 = rentFreeNonretail_3;
	}

	public BigDecimal getRentIncrease_1() {
		return rentIncrease_1;
	}

	public void setRentIncrease_1(BigDecimal rentIncrease_1) {
		this.rentIncrease_1 = rentIncrease_1;
	}

	public BigDecimal getRentIncrease_2() {
		return rentIncrease_2;
	}

	public void setRentIncrease_2(BigDecimal rentIncrease_2) {
		this.rentIncrease_2 = rentIncrease_2;
	}

	public BigDecimal getPromotionBudget() {
		return promotionBudget;
	}

	public void setPromotionBudget(BigDecimal promotionBudget) {
		this.promotionBudget = promotionBudget;
	}

	public BigDecimal getMaintenanceFee() {
		return maintenanceFee;
	}

	public void setMaintenanceFee(BigDecimal maintenanceFee) {
		this.maintenanceFee = maintenanceFee;
	}

}
