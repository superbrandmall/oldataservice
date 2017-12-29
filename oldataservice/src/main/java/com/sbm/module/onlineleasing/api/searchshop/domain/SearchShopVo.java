package com.sbm.module.onlineleasing.api.searchshop.domain;

import java.util.Date;
import java.util.List;

import com.sbm.module.common.business.domain.BaseEntity;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.onlineleasingapi.login.domain<br/>
 * File Name:Login.java<br/>
 * 
 * 作成日 ：2017-8-3 上午10:13:05 <br/>
 * 
 * @author ：junkai.zhang
 */
public class SearchShopVo extends BaseEntity {

	private String code;

	private String userCode;

	private String brandCode;

	private String brandName;

	private Integer minArea;

	private Integer maxArea;

	private String start;

	// 用来存储开始日期
	private Date startDate;

	private String end;

	private List<String> mallCodes;

	// 查询mall对象
	private List<TOLMall> malls;

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

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public List<String> getMallCodes() {
		return mallCodes;
	}

	public void setMallCodes(List<String> mallCodes) {
		this.mallCodes = mallCodes;
	}

	public List<TOLMall> getMalls() {
		return malls;
	}

	public void setMalls(List<TOLMall> malls) {
		this.malls = malls;
	}

}
