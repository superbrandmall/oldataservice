package com.sbm.module.onlineleasing.api.searchshop.domain;

import java.math.BigDecimal;

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
public class ShopScore {

	private TOLShop shop;

	private BigDecimal score;

	public TOLShop getShop() {
		return shop;
	}

	public void setShop(TOLShop shop) {
		this.shop = shop;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

}
