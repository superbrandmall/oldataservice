package com.sbm.module.partner.hd.rest.base.domain;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.rest.base.domain<br/>
 * File Name:HdFloor.java<br/>
 * 
 * 作成日 ：2017-11-7 下午2:35:44 <br/>
 * 
 * @author ：junkai.zhang
 */
public class HdUCN {

	private String uuid;

	private String code;

	private String name;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HdUCN() {
	}

	public HdUCN(String uuid, String code, String name) {
		this.uuid = uuid;
		this.code = code;
		this.name = name;
	}
}
