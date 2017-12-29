package com.sbm.module.partner.hd.rest.brand.domain;

import java.math.BigDecimal;

public class HdBrandProperties {

	/**
	 * 品牌属性
	 */
	private String introductions;

	/**
	 * 品牌价位
	 */
	private String brandGrade;


	/**
	 * 标准店面积
	 */
	private String areaLow;

	/**
	 * 主要客户群
	 */
	private String target;

	/**
	 * 开店区域
	 */
	private String location;

	/**
	 * 当前已开店数
	 */
	private String shopCount;

	/**
	 * 品牌发展历史
	 */
	private String history;

	/**
	 * 口碑
	 */
	private String reputation;

	/**
	 * 是否有旗下品牌已入驻
	 */
	private String joined;

	/**
	 * 是否有意进驻正大其它门店
	 */
	private String join_other_mall;

	/**
	 * 月均销售额坪效
	 */
	private String compare;

	/**
	 * 品牌信息来源
	 */
	private String source;

	/**
	 * 平均客单价
	 */
	private BigDecimal priceLow;

	public String getIntroductions() {
		return introductions;
	}

	public void setIntroductions(String introductions) {
		this.introductions = introductions;
	}

	public String getBrandGrade() {
		return brandGrade;
	}

	public void setBrandGrade(String brandGrade) {
		this.brandGrade = brandGrade;
	}

	public String getAreaLow() {
		return areaLow;
	}

	public void setAreaLow(String areaLow) {
		this.areaLow = areaLow;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getShopCount() {
		return shopCount;
	}

	public void setShopCount(String shopCount) {
		this.shopCount = shopCount;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getReputation() {
		return reputation;
	}

	public void setReputation(String reputation) {
		this.reputation = reputation;
	}

	public String getJoined() {
		return joined;
	}

	public void setJoined(String joined) {
		this.joined = joined;
	}

	public String getJoin_other_mall() {
		return join_other_mall;
	}

	public void setJoin_other_mall(String join_other_mall) {
		this.join_other_mall = join_other_mall;
	}

	public String getCompare() {
		return compare;
	}

	public BigDecimal getPriceLow() {
		return priceLow;
	}

	public void setPriceLow(BigDecimal priceLow) {
		this.priceLow = priceLow;
	}

	public void setCompare(String compare) {
		this.compare = compare;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
