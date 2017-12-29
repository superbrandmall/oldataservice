package com.sbm.module.common.api.verificationcode.event;

import com.sbm.module.common.api.mail.event.ISendMailEvent;
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
public class EmailVerificationCodeEvent extends BusinessEvent implements ISendMailEvent {

	private static final long serialVersionUID = 6559830334228453740L;

	public EmailVerificationCodeEvent(BusinessEventTemplate template) {
		super(template);
	}

}
