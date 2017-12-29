package com.sbm.module.partner.tianyancha.rest.search.domain;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.partner.tianyancha.rest.search.domain<br/>
 * File Name:SearchData.java<br/>
 * 
 * 作成日 ：2017-8-29 下午5:54:00 <br/>
 * 
 * @author ：junkai.zhang
 */
public class SearchData {

	/**
	 * 公司id 或是人物id（用于其他查询）
	 */
	private Long id;

	/**
	 * 公司名或人名，其中标签中是命中的关键字
	 */
	private String name;

	/**
	 * 1-公司 2-人
	 */
	private Integer type;

	/**
	 * 法人
	 */
	private String legalPersonName;

	/**
	 * 成立时间
	 */
	private String estiblishTime;

	/**
	 * 注册资金
	 */
	private String regCapital;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getLegalPersonName() {
		return legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	public String getEstiblishTime() {
		return estiblishTime;
	}

	public void setEstiblishTime(String estiblishTime) {
		this.estiblishTime = estiblishTime;
	}

	public String getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(String regCapital) {
		this.regCapital = regCapital;
	}

}
