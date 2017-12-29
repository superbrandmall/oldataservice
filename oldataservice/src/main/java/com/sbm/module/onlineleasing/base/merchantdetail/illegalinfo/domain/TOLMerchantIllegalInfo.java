package com.sbm.module.onlineleasing.base.merchantdetail.illegalinfo.domain;

import java.util.Date;

import javax.persistence.Column;
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
@Entity(name = "TOLIllegalInfo")
@Table(name = "T_OL_MERCHANT_ILLEGAL_INFO")
public class TOLMerchantIllegalInfo extends BaseEntity {

	private String code;

	/**
	 * 列入原因
	 */
	private String putReason;

	/**
	 * 列入日期
	 */
	@Column(columnDefinition = "timestamp")
	private Date putDate;

	/**
	 * 决定列入部门(作出决定机关)
	 */
	private String putDepartment;

	/**
	 * 移除原因
	 */
	private String removeReason;

	/**
	 * 决定移除部门
	 */
	private String removeDepartment;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPutReason() {
		return putReason;
	}

	public void setPutReason(String putReason) {
		this.putReason = putReason;
	}

	public Date getPutDate() {
		return putDate;
	}

	public void setPutDate(Date putDate) {
		this.putDate = putDate;
	}

	public String getPutDepartment() {
		return putDepartment;
	}

	public void setPutDepartment(String putDepartment) {
		this.putDepartment = putDepartment;
	}

	public String getRemoveReason() {
		return removeReason;
	}

	public void setRemoveReason(String removeReason) {
		this.removeReason = removeReason;
	}

	public String getRemoveDepartment() {
		return removeDepartment;
	}

	public void setRemoveDepartment(String removeDepartment) {
		this.removeDepartment = removeDepartment;
	}

}
