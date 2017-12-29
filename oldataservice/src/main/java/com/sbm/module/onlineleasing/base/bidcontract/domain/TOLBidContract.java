package com.sbm.module.onlineleasing.base.bidcontract.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Entity(name = "TOLBidContract")
@Table(name = "T_OL_BID_CONTRACT")
public class TOLBidContract extends BaseEntity {

	private String code;

	@Column(columnDefinition = "text")
	private String pdfTemp;

	@Column(columnDefinition = "text")
	private String pdf;

	private String depositBillNumber;

	@Column(columnDefinition = "text")
	private String depositBillPdf;

	@Transient
	private String fileId;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPdfTemp() {
		return pdfTemp;
	}

	public void setPdfTemp(String pdfTemp) {
		this.pdfTemp = pdfTemp;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public String getDepositBillNumber() {
		return depositBillNumber;
	}

	public void setDepositBillNumber(String depositBillNumber) {
		this.depositBillNumber = depositBillNumber;
	}

	public String getDepositBillPdf() {
		return depositBillPdf;
	}

	public void setDepositBillPdf(String depositBillPdf) {
		this.depositBillPdf = depositBillPdf;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

}
