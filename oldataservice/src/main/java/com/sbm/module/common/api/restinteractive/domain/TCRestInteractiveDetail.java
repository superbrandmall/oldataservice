package com.sbm.module.common.api.restinteractive.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Entity(name = "TCRestInteractiveDetail")
@Table(name = "T_C_REST_INTERACTIVE_DETAIL")
public class TCRestInteractiveDetail extends BaseEntity {

	@Transient
	private static final ThreadLocal<TCRestInteractiveDetail> API_INTERACTIVE_DETAIL_THREAD = new ThreadLocal<TCRestInteractiveDetail>();

	public static TCRestInteractiveDetail get() {
		return API_INTERACTIVE_DETAIL_THREAD.get();
	}

	public static void set(TCRestInteractiveDetail detail) {
		API_INTERACTIVE_DETAIL_THREAD.set(detail);
	}

	public static void remove() {
		API_INTERACTIVE_DETAIL_THREAD.remove();
	}

	private String code;

	private Long beginTime;

	private Long endTime;

	private Long intervalTime;

	private String clazz;

	private String method;

	@Column(columnDefinition = "mediumtext")
	private String requestObj;

	@Column(columnDefinition = "mediumtext")
	private String responseObj;

	private String errorCode;

	@Column(columnDefinition = "mediumtext")
	private String errorMessage;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getRequestObj() {
		return requestObj;
	}

	public void setRequestObj(String requestObj) {
		this.requestObj = requestObj;
	}

	public String getResponseObj() {
		return responseObj;
	}

	public void setResponseObj(String responseObj) {
		this.responseObj = responseObj;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
