package com.sbm.module.partner.hd.rest.contract.nonstandard.domain;

import java.util.List;

public class HdContractNonStandardResult {

	/**
	 * 编号
	 */
	private String billNumber;

	/**
	 * 明细
	 */
	private List<HdContractNonStandardResultDetail> details;

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public List<HdContractNonStandardResultDetail> getDetails() {
		return details;
	}

	public void setDetails(List<HdContractNonStandardResultDetail> details) {
		this.details = details;
	}
}
