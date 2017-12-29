package com.sbm.module.onlineleasing.api.bid.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.sbm.module.common.business.domain.BaseEntity;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.onlineleasingapi.bid.domain<br/>
 * File Name:BidDetail.java<br/>
 * 
 * 作成日 ：2017-8-18 上午10:23:05 <br/>
 * 
 * @author ：junkai.zhang
 */
public class BidInfoVo extends BaseEntity {

	private String code;

	private String shopCode;

	private Date created;

	private String unit;

	private String mallName;

	private String floorName;

	private BigDecimal area;

	private Date startDate;

	private Date endDate;

	private BigDecimal deadRentMin;

	private BigDecimal deadRentMax;

	private BigDecimal floatingRentalRateMin;

	private BigDecimal floatingRentalRateMax;

	/************************************************************************/

	private Integer processState;

	private Integer isApprove;

	private Integer isEffect;

	/************************************************************************/

//	private String pdfTemp;
//
//	private String pdf;
//
//	private String depositBillPdf;

	/************************************************************************/

	private String firstImage;

	private String brandName;

	/************************************************************************/

	public String getFirstImage() {
		return firstImage;
	}

	public void setFirstImage(String firstImage) {
		this.firstImage = firstImage;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getMallName() {
		return mallName;
	}

	public void setMallName(String mallName) {
		this.mallName = mallName;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
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

	public BigDecimal getDeadRentMin() {
		return deadRentMin;
	}

	public void setDeadRentMin(BigDecimal deadRentMin) {
		this.deadRentMin = deadRentMin;
	}

	public BigDecimal getDeadRentMax() {
		return deadRentMax;
	}

	public void setDeadRentMax(BigDecimal deadRentMax) {
		this.deadRentMax = deadRentMax;
	}

	public BigDecimal getFloatingRentalRateMin() {
		return floatingRentalRateMin;
	}

	public void setFloatingRentalRateMin(BigDecimal floatingRentalRateMin) {
		this.floatingRentalRateMin = floatingRentalRateMin;
	}

	public BigDecimal getFloatingRentalRateMax() {
		return floatingRentalRateMax;
	}

	public void setFloatingRentalRateMax(BigDecimal floatingRentalRateMax) {
		this.floatingRentalRateMax = floatingRentalRateMax;
	}

	public Integer getProcessState() {
		return processState;
	}

	public void setProcessState(Integer processState) {
		this.processState = processState;
	}

	public Integer getIsApprove() {
		return isApprove;
	}

	public void setIsApprove(Integer isApprove) {
		this.isApprove = isApprove;
	}

	public Integer getIsEffect() {
		return isEffect;
	}

	public void setIsEffect(Integer isEffect) {
		this.isEffect = isEffect;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
