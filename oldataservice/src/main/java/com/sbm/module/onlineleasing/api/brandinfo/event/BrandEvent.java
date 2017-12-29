package com.sbm.module.onlineleasing.api.brandinfo.event;

import com.sbm.module.common.base.pulisher.event.BusinessEvent;
import com.sbm.module.common.base.pulisher.template.BusinessEventTemplate;
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
public class BrandEvent extends BusinessEvent implements ISendSysMessageEvent, IBrandEvent {

	private static final long serialVersionUID = 6271055869941229452L;

	public BrandEvent(BusinessEventTemplate template) {
		super(template);
	}
}
