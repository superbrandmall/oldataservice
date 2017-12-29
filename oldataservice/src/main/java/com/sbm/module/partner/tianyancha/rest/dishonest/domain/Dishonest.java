package com.sbm.module.partner.tianyancha.rest.dishonest.domain;

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
public class Dishonest {

	private String state;

	private String message;

	private DishonestData data;

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

	public DishonestData getData() {
		return data;
	}

	public void setData(DishonestData data) {
		this.data = data;
	}

}
