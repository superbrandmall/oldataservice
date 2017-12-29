package com.sbm.module.common.base.pulisher.event;

import java.text.MessageFormat;

import org.springframework.context.ApplicationEvent;

import com.sbm.module.common.base.constant.CommonConstant;
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
public class BusinessEvent extends ApplicationEvent {

	private static final long serialVersionUID = 6559830334228453740L;

	public BusinessEvent(BusinessEventTemplate template) {
		super(template);
	}

	/**
	 * 
	 * getTemplate:获取模板
	 * 
	 * @author junkai.zhang
	 * @return
	 */
	public BusinessEventTemplate getTemplate() {
		return (BusinessEventTemplate) getSource();
	}

	/**
	 * 
	 * isNotNull:判断非空
	 * 
	 * @author junkai.zhang
	 * @param keys
	 * @return
	 */
	public boolean isNotNull(String... keys) {
		boolean b = true;
		for (String key : keys) {
			if (null == this.getTemplate().get(key)) {
				b = false;
				CommonConstant.FRAMEWORK.warn(MessageFormat.format("{0} is null", key));
			}
		} 
		return b;
	}
}
