package com.sbm.module.onlineleasing.base.modality.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sbm.module.common.business.domain.BaseEntity;

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
@Entity(name = "TOLModality")
@Table(name = "T_OL_MODALITY")
public class TOLModality extends BaseEntity {

	private String name;

	private String code;

	private String lv;

	private String hdUuid;

	private String jdeModalityId;

	private String hdLevelid;

	@Transient
	private List<TOLModality> list;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLv() {
		return lv;
	}

	public void setLv(String lv) {
		this.lv = lv;
	}

	public String getJdeModalityId() {
		return jdeModalityId;
	}

	public void setJdeModalityId(String jdeModalityId) {
		this.jdeModalityId = jdeModalityId;
	}

	public List<TOLModality> getList() {
		return list;
	}

	public void setList(List<TOLModality> list) {
		this.list = list;
	}

	public String getHdUuid() {
		return hdUuid;
	}

	public void setHdUuid(String hdUuid) {
		this.hdUuid = hdUuid;
	}

	public String getHdLevelid() {
		return hdLevelid;
	}

	public void setHdLevelid(String hdLevelid) {
		this.hdLevelid = hdLevelid;
	}

}
