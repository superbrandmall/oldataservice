package com.sbm.module.partner.tianyancha.rest.executioninfo.domain;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.tianyancha.rest.lawsuit.domain<br/>
 * File Name:LawSuit.java<br/>
 * 
 * 作成日 ：2017-10-18 上午10:19:18 <br/>
 * 
 * @author ：junkai.zhang
 */
public class ExecutionInfo {

	private String state;

	private String message;

	private ExecutionInfoData data;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ExecutionInfoData getData() {
		return data;
	}

	public void setData(ExecutionInfoData data) {
		this.data = data;
	}

}
