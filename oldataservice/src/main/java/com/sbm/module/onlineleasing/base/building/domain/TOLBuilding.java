package com.sbm.module.onlineleasing.base.building.domain;

import java.math.BigDecimal;

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
@Entity(name = "TOLBuilding")
@Table(name = "T_OL_BUILDING")
public class TOLBuilding extends BaseEntity {

	private String code;

	private String mallCode;

	private String buildingName;

	private BigDecimal grossFloorArea;

	private BigDecimal leasingArea;

	private String description;

	private String hdUuid;

	private String hdCode;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMallCode() {
		return mallCode;
	}

	public void setMallCode(String mallCode) {
		this.mallCode = mallCode;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public BigDecimal getGrossFloorArea() {
		return grossFloorArea;
	}

	public void setGrossFloorArea(BigDecimal grossFloorArea) {
		this.grossFloorArea = grossFloorArea;
	}

	public BigDecimal getLeasingArea() {
		return leasingArea;
	}

	public void setLeasingArea(BigDecimal leasingArea) {
		this.leasingArea = leasingArea;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHdCode() {
		return hdCode;
	}

	public void setHdCode(String hdCode) {
		this.hdCode = hdCode;
	}

	public String getHdUuid() {
		return hdUuid;
	}

	public void setHdUuid(String hdUuid) {
		this.hdUuid = hdUuid;
	}

}
