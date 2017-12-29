package com.sbm.module.onlineleasing.base.merchant.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

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
@Entity(name = "TOLMerchant")
@Table(name = "T_OL_MERCHANT")
public class TOLMerchant extends BaseEntity {

	private String code;

	private String name;

	private Integer type;

	/**
	 * 注册资金
	 */
	private String capital;

	private String shareholder;

	private String uscc;

	private Integer authState;

	private String businessScope;

	private Long tianyanchaId;

	private String hdUuid;

	private String hdCode;

	private String hdState;

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getShareholder() {
		return shareholder;
	}

	public void setShareholder(String shareholder) {
		this.shareholder = shareholder;
	}

	public String getUscc() {
		return uscc;
	}

	public void setUscc(String uscc) {
		this.uscc = uscc;
	}

	public Integer getAuthState() {
		return authState;
	}

	public void setAuthState(Integer authState) {
		this.authState = authState;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public Long getTianyanchaId() {
		return tianyanchaId;
	}

	public void setTianyanchaId(Long tianyanchaId) {
		this.tianyanchaId = tianyanchaId;
	}

	public String getHdCode() {
		return hdCode;
	}

	public void setHdCode(String hdCode) {
		this.hdCode = hdCode;
	}

	public String getHdState() {
		return hdState;
	}

	public void setHdState(String hdState) {
		this.hdState = hdState;
	}

	public String getHdUuid() {
		return hdUuid;
	}

	public void setHdUuid(String hdUuid) {
		this.hdUuid = hdUuid;
	}

}
