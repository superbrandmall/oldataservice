package com.sbm.module.onlineleasing.base.brandshopsample.domain;

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
@Entity(name = "TOLBrandShopSample")
@Table(name = "T_OL_BRAND_SHOP_SAMPLE")
public class TOLBrandShopSample extends BaseEntity {

	private String code;

	@Column(columnDefinition = "text")
	private String shopSample;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getShopSample() {
		return shopSample;
	}

	public void setShopSample(String shopSample) {
		this.shopSample = shopSample;
	}

}
