package com.sbm.module.onlineleasing.api.bid.domain;

import java.util.List;

import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.onlineleasing.api.bid.domain<br/>
 * File Name:BidMerchanBrandVo.java<br/>
 * 
 * 作成日 ：2017-11-1 下午4:43:54 <br/>
 * 
 * @author ：junkai.zhang
 */
public class BidMerchantBrandVo {

	private String code;

	private String name;

	private List<TOLBrand> brands;

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

	public List<TOLBrand> getBrands() {
		return brands;
	}

	public void setBrands(List<TOLBrand> brands) {
		this.brands = brands;
	}

}
