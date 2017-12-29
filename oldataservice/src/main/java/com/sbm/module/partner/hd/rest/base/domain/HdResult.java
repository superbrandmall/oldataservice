package com.sbm.module.partner.hd.rest.base.domain;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.rest.base.domain<br/>
 * File Name:HdReturn.java<br/>
 * 
 * 作成日 ：2017-11-7 上午9:50:43 <br/>
 * 
 * @author ：junkai.zhang
 */
public class HdResult<T> {

	private String success;

	private Integer statusCode;

	private String message;

	private T body;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

}
