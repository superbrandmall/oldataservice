package com.sbm.module.partner.hd.view.leasemodule.domain;

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
@Entity(name = "Leasemodule")
@Table(name = "hd40.T_OL_LEASEMODULE")
public class Leasemodule {

	@Id
	private Integer itemno;

	private Integer leasetype;

	private Integer acctype;

	private String leasemodulename;

	public Integer getItemno() {
		return itemno;
	}

	public void setItemno(Integer itemno) {
		this.itemno = itemno;
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
