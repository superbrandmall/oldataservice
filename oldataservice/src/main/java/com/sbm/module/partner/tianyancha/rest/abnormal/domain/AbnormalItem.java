package com.sbm.module.partner.tianyancha.rest.abnormal.domain;

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
public class AbnormalItem {

	/**
	 * 列入经营异常名录原因
	 */
	private String putReason;

	/**
	 * 列入日期
	 */
	private String putDate;

	/**
	 * 列入部门
	 */
	private String putDepartment;

	/**
	 * 移出原因
	 */
	private String removeReason;

	/**
	 * 移出日期
	 */
	private String removeDate;

	/**
	 * 移出部门
	 */
	private String removeDepartment;

	/**
	 * 创建时间
	 */
	private String createTime;

	public String getPutReason() {
		return putReason;
	}

	public void setPutReason(String putReason) {
		this.putReason = putReason;
	}

	public String getPutDate() {
		return putDate;
	}

	public void setPutDate(String putDate) {
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

	public String getRemoveDate() {
		return removeDate;
	}

	public void setRemoveDate(String removeDate) {
		this.removeDate = removeDate;
	}

	public String getRemoveDepartment() {
		return removeDepartment;
	}

	public void setRemoveDepartment(String removeDepartment) {
		this.removeDepartment = removeDepartment;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
