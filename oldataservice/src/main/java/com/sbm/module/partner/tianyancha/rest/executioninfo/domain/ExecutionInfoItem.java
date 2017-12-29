package com.sbm.module.partner.tianyancha.rest.executioninfo.domain;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.tianyancha.rest.lawsuit.domain<br/>
 * File Name:LawSuitItem.java<br/>
 * 
 * 作成日 ：2017-10-18 上午10:15:16 <br/>
 * 
 * @author ：junkai.zhang
 */
public class ExecutionInfoItem {

	private String pname;

	private String execCourtName;

	private String partyCardNum;

	private String caseCode;

	private String caseCreateTime;

	private String execMoney;

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getExecCourtName() {
		return execCourtName;
	}

	public void setExecCourtName(String execCourtName) {
		this.execCourtName = execCourtName;
	}

	public String getPartyCardNum() {
		return partyCardNum;
	}

	public void setPartyCardNum(String partyCardNum) {
		this.partyCardNum = partyCardNum;
	}

	public String getCaseCode() {
		return caseCode;
	}

	public void setCaseCode(String caseCode) {
		this.caseCode = caseCode;
	}

	public String getCaseCreateTime() {
		return caseCreateTime;
	}

	public void setCaseCreateTime(String caseCreateTime) {
		this.caseCreateTime = caseCreateTime;
	}

	public String getExecMoney() {
		return execMoney;
	}

	public void setExecMoney(String execMoney) {
		this.execMoney = execMoney;
	}

}
