package com.sbm.module.onlineleasing.api.bid.listener;

import com.sbm.module.common.api.eventinteractive.listener.BusinessEventListener;
import com.sbm.module.common.base.pulisher.constant.BusinessEventListenerConstant;
import com.sbm.module.common.base.pulisher.event.BusinessEvent;
import com.sbm.module.onlineleasing.api.bid.biz.ISubmitBidService;
import com.sbm.module.onlineleasing.api.bid.domain.BidInfo;
import com.sbm.module.onlineleasing.api.bid.event.ISubmitBidEvent;
import com.sbm.module.onlineleasing.api.bidcontract.biz.IContractPreviewService;
import com.sbm.module.onlineleasing.api.bidcontract.event.IContractPreviewEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/*****************************************************************************/

/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.common.listener<br/>
 * File Name:InitListener.java<br/>
 * 
 * 作成日 ：2017-8-17 下午5:33:02 <br/>
 * 
 * @author ：junkai.zhang
 */
@Component
public class SubmitBidListener extends BusinessEventListener {

	@Autowired
	private ISubmitBidService service;

	@EventListener
	public void onApplicationEvent(BusinessEvent event) {
		if (event instanceof ISubmitBidEvent) {
			async(event);
		}
	}

	protected void execute(BusinessEvent event) {
		if (event.isNotNull(BusinessEventListenerConstant.BaseEntity)) {
			BidInfo obj = (BidInfo) event.getTemplate().get(BusinessEventListenerConstant.BaseEntity);
			service.submit(obj);
		}
	}
}
