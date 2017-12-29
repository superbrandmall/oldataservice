package com.sbm.module.common.api.jobinteractive.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sbm.module.common.business.domain.BaseEntity;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.commonapi.apiinteractive.domain<br/>
 * File Name:RequestModel.java<br/>
 * 
 * 作成日 ：2017-8-10 上午9:37:35 <br/>
 * 
 * @author ：junkai.zhang
 */
@Entity(name = "TCJobInteractiveDetail")
@Table(name = "T_C_JOB_INTERACTIVE_DETAIL")
public class TCJobInteractiveDetail extends BaseEntity {

	private String job;

	private Long beginTime;

	private Long endTime;

	private Long intervalTime;

	private String code;

	@Column(columnDefinition = "text")
	private String errorMessage;

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Long getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Long beginTime) {
		this.beginTime = beginTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public Long getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(Long intervalTime) {
		this.intervalTime = intervalTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
