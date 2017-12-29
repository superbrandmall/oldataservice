/**
 * Project Name:posUploadData
 * File Name:JsonContainer.java
 * Package Name:com.sbm.module.postsales.domain
 * Date:2016-1-7下午2:23:21
 * Copyright (c) 2016, Super Brand Mail Inc All Rights Reserved.
 *
 */

package com.sbm.module.onlineleasing.api.bid.domain;

import java.util.List;

import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.bid.domain.TOLBid;
import com.sbm.module.onlineleasing.base.bidcontract.domain.TOLBidContract;
import com.sbm.module.onlineleasing.base.biddetail.domain.TOLBidDetail;
import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;
import com.sbm.module.onlineleasing.base.mallbidstandard.domain.TOLMallBidStandard;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.onlineleasing.base.searchshopdetail.domain.TOLSearchShopDetail;
import com.sbm.module.onlineleasing.base.shop.domain.TOLShop;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/
/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.domain<br/>
 * File Name:JsonContainer.java<br/>
 * 
 * 作成日 ：2016-1-7 下午2:23:21 <br/>
 * 
 * @author ：junkai.zhang
 * @preserve all
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
public class BidInfo {

	/*********************************************************/
	// 展现

	private TOLShop shop;

	private TOLSearchShopDetail searchShopDetail;

	private TOLMallBidStandard mallBidStandard;

	private BidMerchantBrandVo bidMerchantBrandVo;

	/*********************************************************/
	// 出价

	private TOLBid bid;

	private TOLBidContract bidContract;

	private List<TOLBidDetail> bidDetails;

	/*********************************************************/
	// 列表

	private Pagination<BidInfoVo> pagination;

	/********************************************************************/
	// 预览合同

	private String key;

	/*********************************************************/
	// 法务异议

	private SuggestVo suggestVo;

	/*********************************************************/
	// 提交出价

	private String code;

	private TOLMerchant merchant;

	private TOLBrand brand;

	private String processState;

	private String isApprove;

	private String isEffect;


	/*********************************************************/
	
	public TOLShop getShop() {
		return shop;
	}

	public void setShop(TOLShop shop) {
		this.shop = shop;
	}

	public TOLSearchShopDetail getSearchShopDetail() {
		return searchShopDetail;
	}

	public void setSearchShopDetail(TOLSearchShopDetail searchShopDetail) {
		this.searchShopDetail = searchShopDetail;
	}

	public TOLMallBidStandard getMallBidStandard() {
		return mallBidStandard;
	}

	public void setMallBidStandard(TOLMallBidStandard mallBidStandard) {
		this.mallBidStandard = mallBidStandard;
	}

	public BidMerchantBrandVo getBidMerchantBrandVo() {
		return bidMerchantBrandVo;
	}

	public void setBidMerchantBrandVo(BidMerchantBrandVo bidMerchantBrandVo) {
		this.bidMerchantBrandVo = bidMerchantBrandVo;
	}

	public TOLBid getBid() {
		return bid;
	}

	public void setBid(TOLBid bid) {
		this.bid = bid;
	}

	public TOLBidContract getBidContract() {
		return bidContract;
	}

	public void setBidContract(TOLBidContract bidContract) {
		this.bidContract = bidContract;
	}

	public List<TOLBidDetail> getBidDetails() {
		return bidDetails;
	}

	public void setBidDetails(List<TOLBidDetail> bidDetails) {
		this.bidDetails = bidDetails;
	}

	public Pagination<BidInfoVo> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<BidInfoVo> pagination) {
		this.pagination = pagination;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public SuggestVo getSuggestVo() {
		return suggestVo;
	}

	public void setSuggestVo(SuggestVo suggestVo) {
		this.suggestVo = suggestVo;
	}

	public String getCode() {
		return code;
	}

	public TOLMerchant getMerchant() {
		return merchant;
	}

	public void setMerchant(TOLMerchant merchant) {
		this.merchant = merchant;
	}

	public TOLBrand getBrand() {
		return brand;
	}

	public void setBrand(TOLBrand brand) {
		this.brand = brand;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProcessState() {
		return processState;
	}

	public void setProcessState(String processState) {
		this.processState = processState;
	}

	public String getIsApprove() {
		return isApprove;
	}

	public void setIsApprove(String isApprove) {
		this.isApprove = isApprove;
	}

	public String getIsEffect() {
		return isEffect;
	}

	public void setIsEffect(String isEffect) {
		this.isEffect = isEffect;
	}
}
