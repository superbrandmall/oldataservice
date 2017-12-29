package com.sbm.module.partner.hd.rest.brand.domain;

import com.sbm.module.partner.hd.rest.base.domain.HdBizType;

import java.math.BigDecimal;

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
public class HdBrand {

	private String uuid;

	private String code;

	private String name;

	private String foreignName;

	private String state;

	/**
	 * 城市
	 */
	private String local;


	/**
	 * 业态
	 */
	private HdBizType bizType = new HdBizType();

	private HdBrandProperties properties = new HdBrandProperties();

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

	public String getForeignName() {
		return foreignName;
	}

	public void setForeignName(String foreignName) {
		this.foreignName = foreignName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public HdBizType getBizType() {
		return bizType;
	}

	public void setBizType(HdBizType bizType) {
		this.bizType = bizType;
	}

	public HdBrandProperties getProperties() {
		return properties;
	}

	public void setProperties(HdBrandProperties properties) {
		this.properties = properties;
	}
}
