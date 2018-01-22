package com.sbm.module.onlineleasing.api.shopinfo.domain;

public class ShopFloorDetail {

	private String code;

	private Integer state;

	private Integer shopState;

	private String unit;

	private String brandName;

	private String coords;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getShopState() {
		return shopState;
	}

	public void setShopState(Integer shopState) {
		this.shopState = shopState;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getCoords() {
		return coords;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setCoords(String coords) {
		this.coords = coords;
	}
}
