package com.sbm.module.partner.tianyancha.rest.illegalinfo.domain;

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
public class IllegalInfoItem {

	/**
	 * 列入原因
	 */
	private String putReason;

	/**
	 * 列入日期
	 */
	private Long putDate;

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

	public String getPutReason() {
		return putReason;
	}

	public void setPutReason(String putReason) {
		this.putReason = putReason;
	}

	public Long getPutDate() {
		return putDate;
	}

	public void setPutDate(Long putDate) {
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
