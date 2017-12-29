package com.sbm.module.common.api.sms.listener;

import com.sbm.module.common.api.eventinteractive.listener.BusinessEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.sbm.module.common.api.sms.biz.ISMSService;
import com.sbm.module.common.api.sms.domain.SMSData;
import com.sbm.module.common.api.sms.event.ISendSMSEvent;
import com.sbm.module.common.base.pulisher.constant.BusinessEventListenerConstant;
import com.sbm.module.common.base.pulisher.event.BusinessEvent;

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
public class SendSMSListener extends BusinessEventListener {

	@Autowired
	private ISMSService service;

	@EventListener
	public void onApplicationEvent(BusinessEvent event) {
		if (event instanceof ISendSMSEvent) {
			async(event);
		}
	}

	protected void execute(BusinessEvent event) {
		if (event.isNotNull(BusinessEventListenerConstant.SMS)) {
			SMSData smsData = (SMSData) event.getTemplate().get(BusinessEventListenerConstant.SMS);
			service.sendSMS(smsData);
		}
	}
}
