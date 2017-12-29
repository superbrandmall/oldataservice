package com.sbm.module.onlineleasing.api.searchshop.domain;

import java.util.List;

import com.sbm.module.common.business.domain.Pagination;

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
public class SearchShop {

	private SearchShopVo vo;

	private List<ShopScore> shopScores;

	private Pagination<SearchShopVo> histories;

	public SearchShopVo getVo() {
		return vo;
	}

	public void setVo(SearchShopVo vo) {
		this.vo = vo;
	}

	public List<ShopScore> getShopScores() {
		return shopScores;
	}

	public void setShopScores(List<ShopScore> shopScores) {
		this.shopScores = shopScores;
	}

	public Pagination<SearchShopVo> getHistories() {
		return histories;
	}

	public void setHistories(Pagination<SearchShopVo> histories) {
		this.histories = histories;
	}

}
