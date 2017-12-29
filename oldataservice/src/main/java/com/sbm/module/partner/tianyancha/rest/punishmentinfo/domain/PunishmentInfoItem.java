package com.sbm.module.partner.tianyancha.rest.punishmentinfo.domain;

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
public class PunishmentInfoItem {

	/**
	 * 行政处罚内容
	 */
	private String content;

	/**
	 * 行政处罚决定书文号
	 */
	private String punishNumber;

	/**
	 * 注册号
	 */
	private String regNum;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 省份
	 */
	private String base;

	/**
	 * 作出行政处罚决定日期
	 */
	private String decisionDate;

	/**
	 * 法定代表人（负责人）姓名
	 */
	private String legalPersonName;

	/**
	 * 违法行为类型
	 */
	private String type;

	/**
	 * 作出行政处罚决定机关名称
	 */
	private String departmentName;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPunishNumber() {
		return punishNumber;
	}

	public void setPunishNumber(String punishNumber) {
		this.punishNumber = punishNumber;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getDecisionDate() {
		return decisionDate;
	}

	public void setDecisionDate(String decisionDate) {
		this.decisionDate = decisionDate;
	}

	public String getLegalPersonName() {
		return legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
