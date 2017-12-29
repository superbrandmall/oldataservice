package com.sbm.module.onlineleasing.base.merchantdetail.owntax.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sbm.module.common.business.domain.BaseEntity;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.tianyancha.rest.lawsuit.domain<br/>
 * File Name:LawSuitItem.java<br/>
 * 
 * 作成日 ：2017-10-18 上午10:15:16 <br/>
 * 
 * @author ：junkai.zhang
 */
@Entity(name = "TOLMerchantOwnTax")
@Table(name = "T_OL_MERCHANT_OWN_TAX")
public class TOLMerchantOwnTax extends BaseEntity {

	private String code;

	/**
	 * 证件号码
	 */
	private String personIdNumber;

	/**
	 * 法人或负责人名称
	 */
	private String legalpersonName;

	/**
	 * 经营地点
	 */
	private String location;

	/**
	 * 当前新发生欠税余额
	 */
	private String newOwnTaxBalance;

	/**
	 * 纳税人名称
	 */
	private String name;

	/**
	 * ownTaxBalance欠税余额
	 */
	private String ownTaxBalance;

	/**
	 * 纳税人识别号
	 */
	private String taxIdNumber;

	/**
	 * 0国税 1地税（这是错的！）
	 */
	private String type;

	/**
	 * 欠税税种（这也是错的！）
	 */
	private String taxCategory;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPersonIdNumber() {
		return personIdNumber;
	}

	public void setPersonIdNumber(String personIdNumber) {
		this.personIdNumber = personIdNumber;
	}

	public String getLegalpersonName() {
		return legalpersonName;
	}

	public void setLegalpersonName(String legalpersonName) {
		this.legalpersonName = legalpersonName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNewOwnTaxBalance() {
		return newOwnTaxBalance;
	}

	public void setNewOwnTaxBalance(String newOwnTaxBalance) {
		this.newOwnTaxBalance = newOwnTaxBalance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnTaxBalance() {
		return ownTaxBalance;
	}

	public void setOwnTaxBalance(String ownTaxBalance) {
		this.ownTaxBalance = ownTaxBalance;
	}

	public String getTaxIdNumber() {
		return taxIdNumber;
	}

	public void setTaxIdNumber(String taxIdNumber) {
		this.taxIdNumber = taxIdNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTaxCategory() {
		return taxCategory;
	}

	public void setTaxCategory(String taxCategory) {
		this.taxCategory = taxCategory;
	}

}
