package com.sbm.module.onlineleasing.base.brand.domain;

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
@Entity(name = "TOLBrand")
@Table(name = "T_OL_BRAND")
public class TOLBrand extends BaseEntity {

	private String code;

	private String name;

	private String city;

	private Integer attribute;

	@Column(name = "class")
	private Integer brandClass;

	private Integer standardArea;

	private String modality_1;

	private String modality_2;

	private String modality_3;

	private Integer target;

	private BigDecimal averageUnitPrice;

	private Integer location;

	private Integer shopAmount;

	private Integer history;

	private Integer reputation;

	private String marketShare;

	private Integer rank;

	private Integer compare;

	private Integer lawsuit;

	private Integer arrearsOfRent;

	private Integer taxEvasion;

	private Integer qualityProblem;

	private Integer joined;

	private Integer joinOtherMall;

	private Integer source;

	private String nameEng;

	@Column(columnDefinition = "text")
	private String logo;

	private Integer status;

	private String hdUuid;

	private String hdCode;

	private String hdState;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getAttribute() {
		return attribute;
	}

	public void setAttribute(Integer attribute) {
		this.attribute = attribute;
	}

	public Integer getBrandClass() {
		return brandClass;
	}

	public void setBrandClass(Integer brandClass) {
		this.brandClass = brandClass;
	}

	public Integer getStandardArea() {
		return standardArea;
	}

	public void setStandardArea(Integer standardArea) {
		this.standardArea = standardArea;
	}

	public String getModality_1() {
		return modality_1;
	}

	public void setModality_1(String modality_1) {
		this.modality_1 = modality_1;
	}

	public String getModality_2() {
		return modality_2;
	}

	public void setModality_2(String modality_2) {
		this.modality_2 = modality_2;
	}

	public String getModality_3() {
		return modality_3;
	}

	public void setModality_3(String modality_3) {
		this.modality_3 = modality_3;
	}

	public Integer getTarget() {
		return target;
	}

	public void setTarget(Integer target) {
		this.target = target;
	}

	public BigDecimal getAverageUnitPrice() {
		return averageUnitPrice;
	}

	public void setAverageUnitPrice(BigDecimal averageUnitPrice) {
		this.averageUnitPrice = averageUnitPrice;
	}

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	public Integer getShopAmount() {
		return shopAmount;
	}

	public void setShopAmount(Integer shopAmount) {
		this.shopAmount = shopAmount;
	}

	public Integer getHistory() {
		return history;
	}

	public void setHistory(Integer history) {
		this.history = history;
	}

	public Integer getReputation() {
		return reputation;
	}

	public void setReputation(Integer reputation) {
		this.reputation = reputation;
	}

	public String getMarketShare() {
		return marketShare;
	}

	public void setMarketShare(String marketShare) {
		this.marketShare = marketShare;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getCompare() {
		return compare;
	}

	public void setCompare(Integer compare) {
		this.compare = compare;
	}

	public Integer getLawsuit() {
		return lawsuit;
	}

	public void setLawsuit(Integer lawsuit) {
		this.lawsuit = lawsuit;
	}

	public Integer getArrearsOfRent() {
		return arrearsOfRent;
	}

	public void setArrearsOfRent(Integer arrearsOfRent) {
		this.arrearsOfRent = arrearsOfRent;
	}

	public Integer getTaxEvasion() {
		return taxEvasion;
	}

	public void setTaxEvasion(Integer taxEvasion) {
		this.taxEvasion = taxEvasion;
	}

	public Integer getQualityProblem() {
		return qualityProblem;
	}

	public void setQualityProblem(Integer qualityProblem) {
		this.qualityProblem = qualityProblem;
	}

	public Integer getJoined() {
		return joined;
	}

	public void setJoined(Integer joined) {
		this.joined = joined;
	}

	public Integer getJoinOtherMall() {
		return joinOtherMall;
	}

	public void setJoinOtherMall(Integer joinOtherMall) {
		this.joinOtherMall = joinOtherMall;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public String getNameEng() {
		return nameEng;
	}

	public void setNameEng(String nameEng) {
		this.nameEng = nameEng;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

}
