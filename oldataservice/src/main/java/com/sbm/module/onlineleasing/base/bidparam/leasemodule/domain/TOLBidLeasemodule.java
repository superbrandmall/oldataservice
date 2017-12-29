package com.sbm.module.onlineleasing.base.bidparam.leasemodule.domain;

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
@Entity(name = "TOLBidLeasemodule")
@Table(name = "T_OL_BID_LEASEMODULE")
public class TOLBidLeasemodule extends BaseEntity {

	private Integer itemNo;

	private Integer leasetype;

	private Integer acctype;

	private String leasemodulename;

	public Integer getItemNo() {
		return itemNo;
	}

	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}

	public Integer getLeasetype() {
		return leasetype;
	}

	public void setLeasetype(Integer leasetype) {
		this.leasetype = leasetype;
	}

	public Integer getAcctype() {
		return acctype;
	}

	public void setAcctype(Integer acctype) {
		this.acctype = acctype;
	}

	public String getLeasemodulename() {
		return leasemodulename;
	}

	public void setLeasemodulename(String leasemodulename) {
		this.leasemodulename = leasemodulename;
	}

}
