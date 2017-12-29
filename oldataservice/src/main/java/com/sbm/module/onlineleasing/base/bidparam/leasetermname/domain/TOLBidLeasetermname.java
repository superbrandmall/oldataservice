package com.sbm.module.onlineleasing.base.bidparam.leasetermname.domain;

import com.sbm.module.common.business.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

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
@Entity(name = "TOLBidLeasetermname")
@Table(name = "T_OL_BID_LEASETERMNAME")
public class TOLBidLeasetermname extends BaseEntity {

	private Integer itemNo;

	private String leasemodulename;

	private String feename;

	private String termname;

	private String remark;


	public Integer getItemNo() {
		return itemNo;
	}

	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}

	public String getLeasemodulename() {
		return leasemodulename;
	}

	public void setLeasemodulename(String leasemodulename) {
		this.leasemodulename = leasemodulename;
	}

	public String getFeename() {
		return feename;
	}

	public void setFeename(String feename) {
		this.feename = feename;
	}

	public String getTermname() {
		return termname;
	}

	public void setTermname(String termname) {
		this.termname = termname;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
