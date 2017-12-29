package com.sbm.module.common.api.sms.domain;

import java.util.List;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.commonapi.mail.domain<br/>
 * File Name:MailData.java<br/>
 * 
 * 作成日 ：2017-8-3 下午2:11:23 <br/>
 * 
 * @author ：junkai.zhang
 */
public class SMSData {

	/**
	 * 模板信息
	 */
	private TCSMSTemplate smsTemplate;

	/**
	 * 短信明细列表
	 */
	private List<TCSMSSendDetail> details;

	public TCSMSTemplate getSmsTemplate() {
		return smsTemplate;
	}

	public void setSmsTemplate(TCSMSTemplate smsTemplate) {
		this.smsTemplate = smsTemplate;
	}

	public List<TCSMSSendDetail> getDetails() {
		return details;
	}

	public void setDetails(List<TCSMSSendDetail> details) {
		this.details = details;
	}

}
