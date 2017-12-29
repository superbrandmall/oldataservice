package com.sbm.module.partner.tianyancha.rest.lawsuit.domain;

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
public class LawSuitItem {

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 提交时间
	 */
	private Long submittime;

	/**
	 * 法院
	 */
	private String court;

	/**
	 * 文书类型
	 */
	private String doctype;

	/**
	 * 原文链接地址
	 */
	private String url;

	/**
	 * 案件号
	 */
	private String caseno;

	/**
	 * 案件类型
	 */
	private String casetype;

	/**
	 * 唯一标识符
	 */
	private String uuid;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getSubmittime() {
		return submittime;
	}

	public void setSubmittime(Long submittime) {
		this.submittime = submittime;
	}

	public String getCourt() {
		return court;
	}

	public void setCourt(String court) {
		this.court = court;
	}

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCaseno() {
		return caseno;
	}

	public void setCaseno(String caseno) {
		this.caseno = caseno;
	}

	public String getCasetype() {
		return casetype;
	}

	public void setCasetype(String casetype) {
		this.casetype = casetype;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
