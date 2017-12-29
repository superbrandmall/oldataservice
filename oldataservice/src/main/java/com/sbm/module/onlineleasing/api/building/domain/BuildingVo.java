package com.sbm.module.onlineleasing.api.building.domain;

import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.building.domain.TOLBuilding;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;
import com.sbm.module.onlineleasing.base.mallbidstandard.domain.TOLMallBidStandard;
import com.sbm.module.onlineleasing.base.malltraffic.domain.TOLMallTraffic;

public class BuildingVo {

	private TOLBuilding building;

	private Pagination<TOLBuilding> pagination;

	public TOLBuilding getBuilding() {
		return building;
	}

	public void setBuilding(TOLBuilding building) {
		this.building = building;
	}

	public Pagination<TOLBuilding> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<TOLBuilding> pagination) {
		this.pagination = pagination;
	}
}
