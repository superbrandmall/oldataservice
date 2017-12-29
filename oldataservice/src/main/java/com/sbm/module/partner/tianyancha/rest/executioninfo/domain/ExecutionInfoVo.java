package com.sbm.module.partner.tianyancha.rest.executioninfo.domain;

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
public class ExecutionInfoVo {

	/****************************************************/
	// input

	private Long id;

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

	private ExecutionInfo result;

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

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public ExecutionInfo getResult() {
		return result;
	}

	public void setResult(ExecutionInfo result) {
		this.result = result;
	}

}
