package com.sbm.module.onlineleasing.api.shopinfo.domain;

import java.util.List;

public class ShopFloorInfo {

	private String floorCode;

	private List<ShopFloorDetail> details;

	public String getFloorCode() {
		return floorCode;
	}

	public void setFloorCode(String floorCode) {
		this.floorCode = floorCode;
	}

	public List<ShopFloorDetail> getDetails() {
		return details;
	}

	public void setDetails(List<ShopFloorDetail> details) {
		this.details = details;
	}
}
