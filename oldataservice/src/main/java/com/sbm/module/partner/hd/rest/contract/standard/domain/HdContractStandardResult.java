package com.sbm.module.partner.hd.rest.contract.standard.domain;

import java.util.Date;

public class HdContractStandardResult {

	/**
	 * ol bid code
	 */
	private String contractId;

	/**
	 * 单据号
	 */
	private String billNumber;

	/**
	 * 文件id
	 */
	private String fileId;

	/**
	 * 预存款单编号
	 */
	private String depositBillNumber;

	/**
	 * 预存款单文件id
	 */
	private String depositFileId;

	/**
	 * 合同过期日期
	 */
	private Date date;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDepositBillNumber() {
		return depositBillNumber;
	}

	public void setDepositBillNumber(String depositBillNumber) {
		this.depositBillNumber = depositBillNumber;
	}

	public String getDepositFileId() {
		return depositFileId;
	}

	public void setDepositFileId(String depositFileId) {
		this.depositFileId = depositFileId;
	}
}
