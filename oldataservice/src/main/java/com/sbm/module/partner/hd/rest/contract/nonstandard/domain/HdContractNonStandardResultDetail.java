package com.sbm.module.partner.hd.rest.contract.nonstandard.domain;

public class HdContractNonStandardResultDetail {

	/**
	 * ol bid code
	 */
	private String contractId;

	/**
	 * 文件id
	 */
	private String fileId;

	/**
	 * 单据号
	 */
	private String billNumber;

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
}
