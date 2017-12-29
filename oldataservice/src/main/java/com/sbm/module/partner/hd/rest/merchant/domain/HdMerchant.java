package com.sbm.module.partner.hd.rest.merchant.domain;

import java.util.ArrayList;
import java.util.List;

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
public class HdMerchant {

	private String uuid;

	private String code;

	private String name;

	private String state;

	/**
	 * 类型
	 */
	private String type;

	private HdMerchantProperties properties = new HdMerchantProperties();

	private List<HdBank> banks = new ArrayList<>();

	public String getBrandDealerType() {
		return brandDealerType;
	}

	public void setBrandDealerType(String brandDealerType) {
		this.brandDealerType = brandDealerType;
	}

	/**
	 * 商户类型

	 */
	private String brandDealerType;

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


	public HdMerchantProperties getProperties() {
		return properties;
	}

	public void setProperties(HdMerchantProperties properties) {
		this.properties = properties;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<HdBank> getBanks() {
		return banks;
	}

	public void setBanks(List<HdBank> banks) {
		this.banks = banks;
	}
}
