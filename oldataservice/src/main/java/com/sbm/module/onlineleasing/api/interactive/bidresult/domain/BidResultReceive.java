package com.sbm.module.onlineleasing.api.interactive.bidresult.domain;

import com.sbm.module.onlineleasing.base.bid.domain.TOLBid;
import com.sbm.module.onlineleasing.base.bidcontract.domain.TOLBidContract;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.onlineleasing.api.interactive.bidresult.domain<br/>
 * File Name:BidResultReceiveVo.java<br/>
 * 
 * 作成日 ：2017-11-9 下午5:15:19 <br/>
 * 
 * @author ：junkai.zhang
 */
public class BidResultReceive {

	private TOLBid bid;

	private TOLBidContract bidContract;

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

}
