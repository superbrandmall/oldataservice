package com.sbm.module.onlineleasing.base.merchantdetail.lawsuit.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sbm.module.common.business.domain.BaseEntity;

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
@Entity(name = "TOLMerchantLawsuit")
@Table(name = "T_OL_MERCHANT_LAWSUIT")
public class TOLMerchantLawsuit extends BaseEntity {

	private String code;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 提交时间
	 */
	@Column(columnDefinition = "timestamp")
	private Date submittime;

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
	@Column(columnDefinition = "text")
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getSubmittime() {
		return submittime;
	}

	public void setSubmittime(Date submittime) {
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
