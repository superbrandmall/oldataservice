package com.sbm.module.onlineleasing.api.shopinfo.domain;

import java.util.List;

import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;
import com.sbm.module.onlineleasing.base.myfavourite.domain.TOLMyFavourite;
import com.sbm.module.onlineleasing.base.shop.domain.TOLShop;
import com.sbm.module.onlineleasing.base.shopengineeringimages.domain.TOLShopEngineeringImages;
import com.sbm.module.onlineleasing.base.shopengineeringspecifications.domain.TOLShopEngineeringSpecifications;
import com.sbm.module.onlineleasing.base.shopimages.domain.TOLShopImages;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.onlineleasingapi.login.domain<br/>
 * File Name:Login.java<br/>
 * 
 * 作成日 ：2017-8-3 上午10:13:05 <br/>
 * 
 * @author ：junkai.zhang
 */
public class ShopInfo {

	private TOLShop shop;

	private List<TOLShopImages> images;

	private List<TOLShopEngineeringImages> engineeringImages;

	private List<TOLShopEngineeringSpecifications> engineeringSpecifications;

	private TOLMyFavourite myFavourite;

	private TOLMall mall;

	public TOLShop getShop() {
		return shop;
	}

	public void setShop(TOLShop shop) {
		this.shop = shop;
	}

	public List<TOLShopImages> getImages() {
		return images;
	}

	public void setImages(List<TOLShopImages> images) {
		this.images = images;
	}

	public TOLMyFavourite getMyFavourite() {
		return myFavourite;
	}

	public void setMyFavourite(TOLMyFavourite myFavourite) {
		this.myFavourite = myFavourite;
	}

	public List<TOLShopEngineeringImages> getEngineeringImages() {
		return engineeringImages;
	}

	public void setEngineeringImages(List<TOLShopEngineeringImages> engineeringImages) {
		this.engineeringImages = engineeringImages;
	}

	public List<TOLShopEngineeringSpecifications> getEngineeringSpecifications() {
		return engineeringSpecifications;
	}

	public void setEngineeringSpecifications(List<TOLShopEngineeringSpecifications> engineeringSpecifications) {
		this.engineeringSpecifications = engineeringSpecifications;
	}

	public TOLMall getMall() {
		return mall;
	}

	public void setMall(TOLMall mall) {
		this.mall = mall;
	}
}
