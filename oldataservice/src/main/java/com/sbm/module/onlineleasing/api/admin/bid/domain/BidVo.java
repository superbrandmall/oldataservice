package com.sbm.module.onlineleasing.api.admin.bid.domain;

import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.bid.domain.TOLBid;
import com.sbm.module.onlineleasing.base.bidcontract.domain.TOLBidContract;
import com.sbm.module.onlineleasing.base.biddetail.domain.TOLBidDetail;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;
import com.sbm.module.onlineleasing.base.mallbidstandard.domain.TOLMallBidStandard;
import com.sbm.module.onlineleasing.base.malltraffic.domain.TOLMallTraffic;

import java.util.List;

public class BidVo {

	private TOLBid bid;

	private Pagination<TOLBid> pagination;

	private List<TOLBidDetail> details;

	private TOLBidContract contract;

	public TOLBid getBid() {
		return bid;
	}

	public void setBid(TOLBid bid) {
		this.bid = bid;
	}

	public Pagination<TOLBid> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<TOLBid> pagination) {
		this.pagination = pagination;
	}

	public List<TOLBidDetail> getDetails() {
		return details;
	}

	public void setDetails(List<TOLBidDetail> details) {
		this.details = details;
	}

	public TOLBidContract getContract() {
		return contract;
	}

	public void setContract(TOLBidContract contract) {
		this.contract = contract;
	}
}
