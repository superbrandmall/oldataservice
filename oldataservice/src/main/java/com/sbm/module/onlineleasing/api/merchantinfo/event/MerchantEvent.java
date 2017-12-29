package com.sbm.module.onlineleasing.api.merchantinfo.event;

import com.sbm.module.common.base.pulisher.event.BusinessEvent;
import com.sbm.module.common.base.pulisher.template.BusinessEventTemplate;
import com.sbm.module.onlineleasing.api.merchantdetail.event.IDownloadMerchantDetailEvent;
import com.sbm.module.onlineleasing.api.sysmessage.event.ISendSysMessageEvent;

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
public class MerchantEvent extends BusinessEvent implements ISendSysMessageEvent, IDownloadMerchantDetailEvent,
		IMerchantEvent {

	private static final long serialVersionUID = -2403794594506870479L;

	public MerchantEvent(BusinessEventTemplate template) {
		super(template);
	}

}
