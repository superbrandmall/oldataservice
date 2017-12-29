package com.sbm.module.onlineleasing.api.register.domain;

import java.util.ArrayList;
import java.util.List;

import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.onlineleasing.base.merchantaddress.domain.TOLMerchantAddress;
import com.sbm.module.onlineleasing.base.merchantbusinesslicense.domain.TOLMerchantBusinessLicense;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.onlineleasing.api.register.domain<br/>
 * File Name:RegisterMerchantCheck.java<br/>
 * 
 * 作成日 ：2017-9-20 上午11:43:48 <br/>
 * 
 * @author ：junkai.zhang
 */
public class RegisterMerchantCheck {

	/****************************************************************/
	// 通过uscc查询商户列表

	/**
	 * 社会统一信用代码证
	 */
	private String uscc;

	/**
	 * 公司名称
	 */
	private String name;

	private List<TOLMerchant> list = new ArrayList<TOLMerchant>();

	/****************************************************************/
	// 通过merchantCode或者tianyanchaId查询相关租户信息

	private String merchantCode;

	private String tianyanchaId;

	private TOLMerchant merchant;

	private TOLMerchantAddress merchantAddress;

	private TOLMerchantBusinessLicense merchantBusinessLicense;

	/****************************************************************/

	public String getUscc() {
		return uscc;
	}

	public void setUscc(String uscc) {
		this.uscc = uscc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TOLMerchant> getList() {
		return list;
	}

	public void setList(List<TOLMerchant> list) {
		this.list = list;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getTianyanchaId() {
		return tianyanchaId;
	}

	public void setTianyanchaId(String tianyanchaId) {
		this.tianyanchaId = tianyanchaId;
	}

	public TOLMerchant getMerchant() {
		return merchant;
	}

	public void setMerchant(TOLMerchant merchant) {
		this.merchant = merchant;
	}

	public TOLMerchantAddress getMerchantAddress() {
		return merchantAddress;
	}

	public void setMerchantAddress(TOLMerchantAddress merchantAddress) {
		this.merchantAddress = merchantAddress;
	}

	public TOLMerchantBusinessLicense getMerchantBusinessLicense() {
		return merchantBusinessLicense;
	}

	public void setMerchantBusinessLicense(TOLMerchantBusinessLicense merchantBusinessLicense) {
		this.merchantBusinessLicense = merchantBusinessLicense;
	}

}
