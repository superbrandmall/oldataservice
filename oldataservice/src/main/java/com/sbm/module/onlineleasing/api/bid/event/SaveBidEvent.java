package com.sbm.module.onlineleasing.api.bid.event;

import com.sbm.module.common.base.pulisher.event.BusinessEvent;
import com.sbm.module.common.base.pulisher.template.BusinessEventTemplate;
import com.sbm.module.onlineleasing.api.bidcontract.event.IContractPreviewEvent;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.commonapi.mail.event<br/>
 * File Name:SendMailEvent.java<br/>
 * 
 * 作成日 ：2017-8-28 下午4:03:37 <br/>
 * 
 * @author ：junkai.zhang
 */
public class SaveBidEvent extends BusinessEvent implements IContractPreviewEvent {

	private static final long serialVersionUID = 6271055869941229452L;

	public SaveBidEvent(BusinessEventTemplate template) {
		super(template);
	}
}
