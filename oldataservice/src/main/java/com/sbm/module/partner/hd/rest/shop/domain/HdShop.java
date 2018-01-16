package com.sbm.module.partner.hd.rest.shop.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.sbm.module.partner.hd.rest.base.domain.HdMediaFile;
import com.sbm.module.partner.hd.rest.base.domain.HdUCN;
import com.sbm.module.partner.hd.view.biztype.domain.BizType;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.rest.brand.domain<br/>
 * File Name:HdBrand.java<br/>
 * 
 * 作成日 ：2017-11-7 下午1:55:02 <br/>
 * 
 * @author ：junkai.zhang
 */
public class HdShop {

	private String uuid;

	private String code;

	private String name;

	private String state;

	private HdUCN floor;

	private HdUCN building;

	private HdUCN store;

	private BigDecimal rentArea;

	private BizType modality;

	private Date contract_expire_date;

	private List<HdUCN> currentBrand;

	private BigDecimal dear_rent;

	private BigDecimal floating_rental_rate;

	private List<HdMediaFile> mediaFiles;

	private List<HdConditionTemplate> templates;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public HdUCN getFloor() {
		return floor;
	}

	public void setFloor(HdUCN floor) {
		this.floor = floor;
	}

	public HdUCN getBuilding() {
		return building;
	}

	public void setBuilding(HdUCN building) {
		this.building = building;
	}

	public HdUCN getStore() {
		return store;
	}

	public void setStore(HdUCN store) {
		this.store = store;
	}

	public BigDecimal getRentArea() {
		return rentArea;
	}

	public void setRentArea(BigDecimal rentArea) {
		this.rentArea = rentArea;
	}

	public BizType getModality() {
		return modality;
	}

	public void setModality(BizType modality) {
		this.modality = modality;
	}

	public Date getContract_expire_date() {
		return contract_expire_date;
	}

	public void setContract_expire_date(Date contract_expire_date) {
		this.contract_expire_date = contract_expire_date;
	}

	public void setCurrentBrand(List<HdUCN> currentBrand) {
		this.currentBrand = currentBrand;
	}

	public List<HdUCN> getCurrentBrand() {

		return currentBrand;
	}

	public BigDecimal getDear_rent() {
		return dear_rent;
	}

	public void setDear_rent(BigDecimal dear_rent) {
		this.dear_rent = dear_rent;
	}

	public BigDecimal getFloating_rental_rate() {
		return floating_rental_rate;
	}

	public void setFloating_rental_rate(BigDecimal floating_rental_rate) {
		this.floating_rental_rate = floating_rental_rate;
	}

	public List<HdMediaFile> getMediaFiles() {
		return mediaFiles;
	}

	public void setMediaFiles(List<HdMediaFile> mediaFiles) {
		this.mediaFiles = mediaFiles;
	}

	public List<HdConditionTemplate> getTemplates() {
		return templates;
	}

	public void setTemplates(List<HdConditionTemplate> templates) {
		this.templates = templates;
	}
}
