package com.sbm.module.onlineleasing.api.floor.domain;

import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.building.domain.TOLBuilding;
import com.sbm.module.onlineleasing.base.floor.domain.TOLFloor;

public class FloorVo {

	private TOLFloor floor;

	private Pagination<TOLFloor> pagination;

	public TOLFloor getFloor() {
		return floor;
	}

	public void setFloor(TOLFloor floor) {
		this.floor = floor;
	}

	public Pagination<TOLFloor> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<TOLFloor> pagination) {
		this.pagination = pagination;
	}
}
