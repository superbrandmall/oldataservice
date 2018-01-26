package com.sbm.module.onlineleasing.api.shopinfo.domain;

import java.util.List;

public class ShopFloorInfo {

	private List<String> floorCodes;

	private List<ShopFloorDetail> details;

	public List<String> getFloorCodes() {
		return floorCodes;
	}

	public void setFloorCodes(List<String> floorCodes) {
		this.floorCodes = floorCodes;
	}

	public List<ShopFloorDetail> getDetails() {
		return details;
	}

	public void setDetails(List<ShopFloorDetail> details) {
		this.details = details;
	}
}
