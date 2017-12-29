package com.sbm.module.onlineleasing.api.interactive.bidresult.domain;

import java.util.List;

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
public class BidResultReceiveVo {

	private List<BidResultReceive> bidResultReceives;

	public List<BidResultReceive> getBidResultReceives() {
		return bidResultReceives;
	}

	public void setBidResultReceives(List<BidResultReceive> bidResultReceives) {
		this.bidResultReceives = bidResultReceives;
	}

}
