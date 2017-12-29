package com.sbm.module.onlineleasing.base.searchshopdetail.domain;

import java.util.Date;

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
@Entity(name = "TOLSearchShopDetail")
@Table(name = "T_OL_SEARCH_SHOP_DETAIL")
public class TOLSearchShopDetail extends BaseEntity {

	private String code;

	private String userCode;

	private String brandCode;

	private Integer minArea;

	private Integer maxArea;

	@Column(columnDefinition = "timestamp")
	private Date start;

	@Column(columnDefinition = "timestamp")
	private Date end;

	@Column(columnDefinition = "text")
	private String mallCodes;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public Integer getMinArea() {
		return minArea;
	}

	public void setMinArea(Integer minArea) {
		this.minArea = minArea;
	}

	public Integer getMaxArea() {
		return maxArea;
	}

	public void setMaxArea(Integer maxArea) {
		this.maxArea = maxArea;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getMallCodes() {
		return mallCodes;
	}

	public void setMallCodes(String mallCodes) {
		this.mallCodes = mallCodes;
	}

}
