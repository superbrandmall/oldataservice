package com.sbm.module.partner.tianyancha.rest.search.domain;

import java.util.List;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.partner.tianyancha.rest.search.domain<br/>
 * File Name:SearchVo.java<br/>
 * 
 * 作成日 ：2017-8-29 下午5:55:28 <br/>
 * 
 * @author ：junkai.zhang
 */
public class Search {

	private String uri;

	/**
	 * 错误代码
	 */
	private String state;

	/**
	 * 错误原因
	 */
	private String message;

	/**
	 * 总页数
	 */
	private Integer totalPage;

	/**
	 * 返回人物条数
	 */
	private Integer humanCount;

	/**
	 * 返回公司条数
	 */
	private Integer companyCount;

	/**
	 * 总条数
	 */
	private Integer total;

	/**
	 * 返回内容
	 */
	private List<SearchData> data;

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

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getHumanCount() {
		return humanCount;
	}

	public void setHumanCount(Integer humanCount) {
		this.humanCount = humanCount;
	}

	public Integer getCompanyCount() {
		return companyCount;
	}

	public void setCompanyCount(Integer companyCount) {
		this.companyCount = companyCount;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<SearchData> getData() {
		return data;
	}

	public void setData(List<SearchData> data) {
		this.data = data;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
