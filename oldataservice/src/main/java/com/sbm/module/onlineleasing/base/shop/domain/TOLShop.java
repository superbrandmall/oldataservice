package com.sbm.module.onlineleasing.base.shop.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Entity(name = "TOLShop")
@Table(name = "T_OL_SHOP")
public class TOLShop extends BaseEntity {

	private String code;

	private String brandCode;

	@Transient
	private String brandName;

	private String mallCode;

	private String buildingCode;

	private String floorCode;

	private String unit;

	private BigDecimal area;

	private String modality;

	private Integer shopState;

	@Column(columnDefinition = "timestamp")
	private Date contractExpireDate;

	private BigDecimal deadRent;

	private BigDecimal floatingRentalRate;

	private String shopName;

	private String mallName;

	private String buildingName;

	private String floorName;

	private String hdUuid;

	private String hdCode;

	private String hdState;

	@Column(columnDefinition = "text")
	private String vr;

	private String subType;

	@Transient
	private String firstImage;

	public TOLShop() {
		super();
	}

	public TOLShop(String mallCode, String modality, Long count) {
		super();
		this.mallCode = mallCode;
		this.modality = modality;
		setCount(count);
	}

	public TOLShop(String mallCode, String buildingCode, String floorCode, String modality, Long count) {
		super();
		this.mallCode = mallCode;
		this.buildingCode = buildingCode;
		this.floorCode = floorCode;
		this.modality = modality;
		setCount(count);
	}

	public String getCode() {
		return code;
	}

	public String getFirstImage() {
		return firstImage;
	}

	public void setFirstImage(String firstImage) {
		this.firstImage = firstImage;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getMallCode() {
		return mallCode;
	}

	public void setMallCode(String mallCode) {
		this.mallCode = mallCode;
	}

	public String getBuildingCode() {
		return buildingCode;
	}

	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}

	public String getFloorCode() {
		return floorCode;
	}

	public void setFloorCode(String floorCode) {
		this.floorCode = floorCode;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public String getModality() {
		return modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}

	public Integer getShopState() {
		return shopState;
	}

	public void setShopState(Integer shopState) {
		this.shopState = shopState;
	}

	public Date getContractExpireDate() {
		return contractExpireDate;
	}

	public void setContractExpireDate(Date contractExpireDate) {
		this.contractExpireDate = contractExpireDate;
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

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getMallName() {
		return mallName;
	}

	public void setMallName(String mallName) {
		this.mallName = mallName;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public String getHdCode() {
		return hdCode;
	}

	public void setHdCode(String hdCode) {
		this.hdCode = hdCode;
	}

	public String getHdState() {
		return hdState;
	}

	public void setHdState(String hdState) {
		this.hdState = hdState;
	}

	public String getHdUuid() {
		return hdUuid;
	}

	public void setHdUuid(String hdUuid) {
		this.hdUuid = hdUuid;
	}

	public String getVr() {
		return vr;
	}

	public void setVr(String vr) {
		this.vr = vr;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}
}
