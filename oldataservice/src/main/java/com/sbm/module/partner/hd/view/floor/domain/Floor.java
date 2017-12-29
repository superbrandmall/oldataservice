package com.sbm.module.partner.hd.view.floor.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity(name = "Floor")
@Table(name = "hd40.T_OL_FLOOR")
public class Floor {

	/**
	 * UUID
	 */
	@Id
	private String hdUuid;

	/**
	 * 楼层代码
	 */
	private String hdCode;

	/**
	 * 楼层名称
	 */
	private String floorName;

	/**
	 * 所属建筑物
	 */
	private String buildingUuid;

	/**
	 * 所属项目
	 */
	private String mallUuid;

	/**
	 * 状态
	 */
	private String state;

	/**
	 * 建筑面积
	 */
	private BigDecimal grossFloorArea;

	/**
	 * 租赁面积
	 */
	private BigDecimal leasingArea;

	/**
	 * 备注
	 */
	private String description;

	public String getHdUuid() {
		return hdUuid;
	}

	public void setHdUuid(String hdUuid) {
		this.hdUuid = hdUuid;
	}

	public String getHdCode() {
		return hdCode;
	}

	public void setHdCode(String hdCode) {
		this.hdCode = hdCode;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public String getBuildingUuid() {
		return buildingUuid;
	}

	public void setBuildingUuid(String buildingUuid) {
		this.buildingUuid = buildingUuid;
	}

	public String getMallUuid() {
		return mallUuid;
	}

	public void setMallUuid(String mallUuid) {
		this.mallUuid = mallUuid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

}
