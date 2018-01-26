package com.sbm.module.onlineleasing.base.mall.domain;

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
@Entity(name = "TOLMall")
@Table(name = "T_OL_MALL")
public class TOLMall extends BaseEntity {

	private String code;

	private String mallName;

	private String location;

	private BigDecimal grossFloorArea;

	private BigDecimal leasingArea;

	private String description;

	private String hdUuid;

	private String hdCode;

	private Integer position;

	@Column(columnDefinition = "text")
	private String img;

	private String hdState;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMallName() {
		return mallName;
	}

	public void setMallName(String mallName) {
		this.mallName = mallName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getHdState() {
		return hdState;
	}

	public void setHdState(String hdState) {
		this.hdState = hdState;
	}
}
