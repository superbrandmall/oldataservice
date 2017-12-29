package com.sbm.module.common.api.serialcode.domain;

import java.util.Date;

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
@Entity(name = "TCSerialCode")
@Table(name = "T_C_SERIAL_CODE")
public class TCSerialCode extends BaseEntity {

	private String serialGroup;

	private Integer serialNum;

	@Column(columnDefinition = "timestamp")
	private Date serialDate;

	private String remark;

	@Transient
	private String nextBizId;

	public String getSerialGroup() {
		return serialGroup;
	}

	public void setSerialGroup(String serialGroup) {
		this.serialGroup = serialGroup;
	}

	public Integer getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(Integer serialNum) {
		this.serialNum = serialNum;
	}

	public Date getSerialDate() {
		return serialDate;
	}

	public void setSerialDate(Date serialDate) {
		this.serialDate = serialDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getNextBizId() {
		return nextBizId;
	}

	public void setNextBizId(String nextBizId) {
		this.nextBizId = nextBizId;
	}

}
