package com.sbm.module.partner.tianyancha.rest.baseinfo.domain;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.partner.tianyancha.rest.baseinfo.domain<br/>
 * File Name:Baseinfo.java<br/>
 * 
 * 作成日 ：2017-8-30 下午1:51:45 <br/>
 * 
 * @author ：junkai.zhang
 */
public class BaseInfoVo {

	/****************************************************/
	// input

	/**
	 * 公司id，可通过查询接口获取：关键字可以为公司注册号，统一信用代码，组织结构代码
	 */
	private String id;

	/****************************************************/
	// output

	private BaseInfo result;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BaseInfo getResult() {
		return result;
	}

	public void setResult(BaseInfo result) {
		this.result = result;
	}

}
