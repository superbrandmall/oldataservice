package com.sbm.module.onlineleasing.api.sysmessage.listener;

import java.text.MessageFormat;
import java.util.List;

import com.sbm.module.common.api.eventinteractive.listener.BusinessEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.base.pulisher.constant.BusinessEventListenerConstant;
import com.sbm.module.common.base.pulisher.event.BusinessEvent;
import com.sbm.module.onlineleasing.api.sysmessage.event.ISendSysMessageEvent;
import com.sbm.module.onlineleasing.base.sysmessage.biz.ITOLSysMessageService;
import com.sbm.module.onlineleasing.base.sysmessage.domain.TOLSysMessage;

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
public class SendSysMessageListener extends BusinessEventListener {

	private static final String MESSAGE = "{0} is not TOLSysMessage or List<TOLSysMessage>";

	@Autowired
	private ITOLSysMessageService service;

	@EventListener
	public void onApplicationEvent(BusinessEvent event) {
		if (event instanceof ISendSysMessageEvent) {
			async(event);
		}
	}

	@SuppressWarnings("unchecked")
	protected void execute(BusinessEvent event) {
		if (event.isNotNull(BusinessEventListenerConstant.SysMessage)) {
			Object obj = event.getTemplate().get(BusinessEventListenerConstant.SysMessage);
			if (obj instanceof TOLSysMessage) {
				TOLSysMessage sysMessage = (TOLSysMessage) obj;
				service.sendSysMessage(sysMessage);
			} else if (obj instanceof List) {
				List<TOLSysMessage> list = (List<TOLSysMessage>) obj;
				for (TOLSysMessage sysMessage : list) {
					service.sendSysMessage(sysMessage);
				}
			} else {
				CommonConstant.FRAMEWORK.warn(MessageFormat.format(MESSAGE, BusinessEventListenerConstant.SysMessage));
			}
		}
	}
}
