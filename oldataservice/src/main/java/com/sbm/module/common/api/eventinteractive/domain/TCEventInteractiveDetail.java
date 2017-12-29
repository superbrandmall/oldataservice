package com.sbm.module.common.api.eventinteractive.domain;

import com.sbm.module.common.business.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
@Entity(name = "TCEventInteractiveDetail")
@Table(name = "T_C_EVENT_INTERACTIVE_DETAIL")
public class TCEventInteractiveDetail extends BaseEntity {

	private String event;

	private String listener;

	private Long beginTime;

	private Long endTime;

	private Long intervalTime;

	private String code;

	@Column(columnDefinition = "text")
	private String errorMessage;


	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getListener() {
		return listener;
	}

	public void setListener(String listener) {
		this.listener = listener;
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
