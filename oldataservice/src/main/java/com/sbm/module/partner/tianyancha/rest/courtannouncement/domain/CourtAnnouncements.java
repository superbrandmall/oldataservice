package com.sbm.module.partner.tianyancha.rest.courtannouncement.domain;

import java.util.List;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.tianyancha.rest.courtannouncement.domain<br/>
 * File Name:CourtAnnouncement.java<br/>
 * 
 * 作成日 ：2017-10-18 下午2:37:20 <br/>
 * 
 * @author ：junkai.zhang
 */
public class CourtAnnouncements {

	private String state;

	private String message;

	private Integer total;

	private Integer num;

	private List<CourtAnnouncement> courtAnnouncements;

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

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public List<CourtAnnouncement> getCourtAnnouncements() {
		return courtAnnouncements;
	}

	public void setCourtAnnouncements(List<CourtAnnouncement> courtAnnouncements) {
		this.courtAnnouncements = courtAnnouncements;
	}

}
