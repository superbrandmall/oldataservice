package com.sbm.module.partner.hd.view.leasetermname.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
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
@Entity(name = "Leasetermname")
@Table(name = "hd40.T_OL_LEASETERMNAME")
public class Leasetermname {

	@Id
	private Integer itemno;

	private String leasemodulename;

	private String feename;

	private String termname;

	private String remark;

	public Integer getItemno() {
		return itemno;
	}

	public void setItemno(Integer itemno) {
		this.itemno = itemno;
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
