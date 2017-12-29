package com.sbm.module.common.base.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.common.util<br/>
 * File Name:SpringBeanUtil.java<br/>
 * 
 * 作成日 ：2017-8-17 下午5:45:42 <br/>
 * 
 * @author ：junkai.zhang
 */
@Component
public class SpringBeanUtil implements ApplicationContextAware {

	private ApplicationContext ctx = null;

	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
	}

	public ApplicationContext getApplicationContext() {
		return ctx;
	}

	@SuppressWarnings("unchecked")
	public <T> T getBean(String prop) {
		Object obj = ctx.getBean(prop);
		return (T) obj;
	}

}
