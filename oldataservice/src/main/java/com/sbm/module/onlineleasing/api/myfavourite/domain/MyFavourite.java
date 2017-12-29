package com.sbm.module.onlineleasing.api.myfavourite.domain;

import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.myfavourite.domain.TOLMyFavourite;
import com.sbm.module.onlineleasing.base.shop.domain.TOLShop;

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
public class MyFavourite {

	private TOLMyFavourite myFavourite;

	private Pagination<TOLShop> shops;

	public TOLMyFavourite getMyFavourite() {
		return myFavourite;
	}

	public void setMyFavourite(TOLMyFavourite myFavourite) {
		this.myFavourite = myFavourite;
	}

	public Pagination<TOLShop> getShops() {
		return shops;
	}

	public void setShops(Pagination<TOLShop> shops) {
		this.shops = shops;
	}

}
