package com.sbm.module.onlineleasing.api.baseinfo.bidparam.domain;

import java.util.List;

import com.sbm.module.onlineleasing.base.bidparam.acctype.domain.TOLBidAcctype;
import com.sbm.module.onlineleasing.base.bidparam.cashiermode.domain.TOLBidCashierMode;
import com.sbm.module.onlineleasing.base.bidparam.comparefrequency.domain.TOLBidCompareFrequency;
import com.sbm.module.onlineleasing.base.bidparam.leasemodule.domain.TOLBidLeasemodule;
import com.sbm.module.onlineleasing.base.bidparam.leasetermname.domain.TOLBidLeasetermname;
import com.sbm.module.onlineleasing.base.bidparam.leasetype.domain.TOLBidLeasetype;
import com.sbm.module.onlineleasing.base.bidparam.promotionkind.domain.TOLBidPromotionKind;
import com.sbm.module.onlineleasing.base.bidparam.rentmethod.domain.TOLBidRentMethod;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.onlineleasing.api.bidparam.domain<br/>
 * File Name:BidParam.java<br/>
 * 
 * 作成日 ：2017-10-31 上午11:40:48 <br/>
 * 
 * @author ：junkai.zhang
 */
public class BidParam {

	private List<TOLBidAcctype> acctypes;

	private List<TOLBidCashierMode> cashierModes;

	private List<TOLBidCompareFrequency> compareFrequencys;

	private List<TOLBidLeasemodule> leasemodules;

	private List<TOLBidLeasetermname> leasetermnames;

	private List<TOLBidLeasetype> leasetypes;

	private List<TOLBidPromotionKind> promotionKinds;

	private List<TOLBidRentMethod> rentMethods;

	public List<TOLBidAcctype> getAcctypes() {
		return acctypes;
	}

	public void setAcctypes(List<TOLBidAcctype> acctypes) {
		this.acctypes = acctypes;
	}

	public List<TOLBidCashierMode> getCashierModes() {
		return cashierModes;
	}

	public void setCashierModes(List<TOLBidCashierMode> cashierModes) {
		this.cashierModes = cashierModes;
	}

	public List<TOLBidCompareFrequency> getCompareFrequencys() {
		return compareFrequencys;
	}

	public void setCompareFrequencys(List<TOLBidCompareFrequency> compareFrequencys) {
		this.compareFrequencys = compareFrequencys;
	}

	public List<TOLBidLeasemodule> getLeasemodules() {
		return leasemodules;
	}

	public void setLeasemodules(List<TOLBidLeasemodule> leasemodules) {
		this.leasemodules = leasemodules;
	}

	public List<TOLBidLeasetype> getLeasetypes() {
		return leasetypes;
	}

	public void setLeasetypes(List<TOLBidLeasetype> leasetypes) {
		this.leasetypes = leasetypes;
	}

	public List<TOLBidPromotionKind> getPromotionKinds() {
		return promotionKinds;
	}

	public void setPromotionKinds(List<TOLBidPromotionKind> promotionKinds) {
		this.promotionKinds = promotionKinds;
	}

	public List<TOLBidRentMethod> getRentMethods() {
		return rentMethods;
	}

	public void setRentMethods(List<TOLBidRentMethod> rentMethods) {
		this.rentMethods = rentMethods;
	}

	public List<TOLBidLeasetermname> getLeasetermnames() {
		return leasetermnames;
	}

	public void setLeasetermnames(List<TOLBidLeasetermname> leasetermnames) {
		this.leasetermnames = leasetermnames;
	}
}
