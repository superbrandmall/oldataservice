package com.sbm.module.common.api.verificationcode.event;

import com.sbm.module.common.api.sms.event.ISendSMSEvent;
import com.sbm.module.common.base.pulisher.event.BusinessEvent;
import com.sbm.module.common.base.pulisher.template.BusinessEventTemplate;

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
public class SMSVerificationCodeEvent extends BusinessEvent implements ISendSMSEvent {

	private static final long serialVersionUID = 5629604129055941790L;

	public SMSVerificationCodeEvent(BusinessEventTemplate template) {
		super(template);
	}

}
