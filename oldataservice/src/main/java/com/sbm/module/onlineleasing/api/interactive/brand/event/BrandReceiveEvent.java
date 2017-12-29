package com.sbm.module.onlineleasing.api.interactive.brand.event;

import com.sbm.module.common.api.mail.event.ISendMailEvent;
import com.sbm.module.common.base.pulisher.event.BusinessEvent;
import com.sbm.module.common.base.pulisher.template.BusinessEventTemplate;
import com.sbm.module.onlineleasing.api.sysmessage.event.ISendSysMessageEvent;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.onlineleasing.api.interactive.merchant.event<br/>
 * File Name:MerchantReceiveEvent.java<br/>
 * 
 * 作成日 ：2017-9-25 下午5:49:44 <br/>
 * 
 * @author ：junkai.zhang
 */
public class BrandReceiveEvent extends BusinessEvent implements ISendMailEvent, ISendSysMessageEvent {

	private static final long serialVersionUID = -8142497275838643406L;

	public BrandReceiveEvent(BusinessEventTemplate template) {
		super(template);
	}

}
