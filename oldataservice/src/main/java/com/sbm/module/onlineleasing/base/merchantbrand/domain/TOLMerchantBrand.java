package com.sbm.module.onlineleasing.base.merchantbrand.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Entity(name = "TOLMerchantBrand")
@Table(name = "T_OL_MERCHANT_BRAND")
public class TOLMerchantBrand extends BaseEntity {

	private String brandCode;

	private String merchantCode;

	private Integer creator;

	@Column(columnDefinition = "text")
	private String brandAuthor;

	@Transient
	private String name;

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	public String getBrandAuthor() {
		return brandAuthor;
	}

	public void setBrandAuthor(String brandAuthor) {
		this.brandAuthor = brandAuthor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
