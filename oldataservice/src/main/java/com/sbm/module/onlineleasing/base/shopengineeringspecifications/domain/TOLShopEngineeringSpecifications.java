package com.sbm.module.onlineleasing.base.shopengineeringspecifications.domain;

import com.sbm.module.common.business.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Entity(name = "TOLShopEngineeringSpecifications")
@Table(name = "T_OL_SHOP_ENGINEERING_SPECIFICATIONS")
public class TOLShopEngineeringSpecifications extends BaseEntity {

	private String code;

	private String key;

	private String name;

	private String title;

	private Integer number;

	private String spec;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}
}
