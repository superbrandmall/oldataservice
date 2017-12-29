package com.sbm.module.partner.tianyancha.rest.dishonest.domain;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.tianyancha.rest.lawsuit.domain<br/>
 * File Name:LawSuitVo.java<br/>
 * 
 * 作成日 ：2017-10-18 上午10:24:17 <br/>
 * 
 * @author ：junkai.zhang
 */
public class DishonestVo {

	/****************************************************/
	// input

	/**
	 * 公司名称
	 */
	private String name;

	/**
	 * 页码
	 */
	private Integer pageNum = 1;

	/****************************************************/
	// output

	private Dishonest result;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Dishonest getResult() {
		return result;
	}

	public void setResult(Dishonest result) {
		this.result = result;
	}

}
