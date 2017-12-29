package com.sbm.module.onlineleasing.base.tempparam.domain;

import com.sbm.module.common.business.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/*****************************************************************************/

/**
 * Project Name:CRMDataProcess<br/>
 * Package Name:com.sbm.module.gag.domain<br/>
 * File Name:GAGReceipt.java<br/>
 * 
 * 作成日 ：2017-4-13 下午5:58:11 <br/>
 * 
 * @author ：junkai.zhang
 */
@Entity(name = "TOLTempParam")
@Table(name = "T_OL_TEMP_PARAM")
public class TOLTempParam extends BaseEntity {

	private String param;

	private Integer key;

	private String value;

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
