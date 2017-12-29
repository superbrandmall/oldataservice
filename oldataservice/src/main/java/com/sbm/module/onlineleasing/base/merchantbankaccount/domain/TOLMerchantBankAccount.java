package com.sbm.module.onlineleasing.base.merchantbankaccount.domain;

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
@Entity(name = "TOLMerchantBankAccount")
@Table(name = "T_OL_MERCHANT_BANK_ACCOUNT")
public class TOLMerchantBankAccount extends BaseEntity {

	private String code;

	private String bankAccount;

	private String bankAccountDesc;

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBankAccountDesc() {
		return bankAccountDesc;
	}

	public void setBankAccountDesc(String bankAccountDesc) {
		this.bankAccountDesc = bankAccountDesc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
