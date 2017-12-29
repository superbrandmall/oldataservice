package com.sbm.module.onlineleasing.api.brand.domain;

import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;
import com.sbm.module.onlineleasing.base.building.domain.TOLBuilding;

public class BrandVo {

	private TOLBrand brand;

	private Pagination<TOLBrand> pagination;

	public TOLBrand getBrand() {
		return brand;
	}

	public void setBrand(TOLBrand brand) {
		this.brand = brand;
	}

	public Pagination<TOLBrand> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<TOLBrand> pagination) {
		this.pagination = pagination;
	}
}
