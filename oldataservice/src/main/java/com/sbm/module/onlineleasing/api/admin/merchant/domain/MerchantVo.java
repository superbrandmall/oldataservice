package com.sbm.module.onlineleasing.api.admin.merchant.domain;

import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.building.domain.TOLBuilding;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.onlineleasing.base.merchantaddress.domain.TOLMerchantAddress;
import com.sbm.module.onlineleasing.base.merchantbankaccount.domain.TOLMerchantBankAccount;
import com.sbm.module.onlineleasing.base.merchantbrand.domain.TOLMerchantBrand;
import com.sbm.module.onlineleasing.base.merchantbusinesslicense.domain.TOLMerchantBusinessLicense;

import java.util.List;

public class MerchantVo {

	private TOLMerchant merchant;

	private TOLMerchantAddress merchantAddress;

	private List<TOLMerchantBankAccount> merchantBankAccounts;

	private List<TOLMerchantBrand> merchantBrands;

	private TOLMerchantBusinessLicense merchantBusinessLicense;

	public TOLMerchantAddress getMerchantAddress() {
		return merchantAddress;
	}

	public void setMerchantAddress(TOLMerchantAddress merchantAddress) {
		this.merchantAddress = merchantAddress;
	}

	public List<TOLMerchantBankAccount> getMerchantBankAccounts() {
		return merchantBankAccounts;
	}

	public void setMerchantBankAccounts(List<TOLMerchantBankAccount> merchantBankAccounts) {
		this.merchantBankAccounts = merchantBankAccounts;
	}

	public List<TOLMerchantBrand> getMerchantBrands() {
		return merchantBrands;
	}

	public void setMerchantBrands(List<TOLMerchantBrand> merchantBrands) {
		this.merchantBrands = merchantBrands;
	}

	public TOLMerchantBusinessLicense getMerchantBusinessLicense() {
		return merchantBusinessLicense;
	}

	public void setMerchantBusinessLicense(TOLMerchantBusinessLicense merchantBusinessLicense) {
		this.merchantBusinessLicense = merchantBusinessLicense;
	}

	private Pagination<TOLMerchant> pagination;

	public TOLMerchant getMerchant() {
		return merchant;
	}

	public void setMerchant(TOLMerchant merchant) {
		this.merchant = merchant;
	}

	public Pagination<TOLMerchant> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<TOLMerchant> pagination) {
		this.pagination = pagination;
	}
}
