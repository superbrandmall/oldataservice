package com.sbm.module.common.base.pulisher.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.sbm.module.common.base.pulisher.constant.BusinessEventListenerConstant;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.common.base.pulisher.configuration<br/>
 * File Name:BusinessEventListenerConfiguration.java<br/>
 * 
 * 作成日 ：2017-9-26 下午2:47:00 <br/>
 * 
 * @author ：junkai.zhang
 */
@Configuration
public class BusinessEventListenerConfiguration {

	@Value("#{propertiesReader['base.BusinessEventListenerConfiguration.corePoolSize']}")
	private String corePoolSize;

	@Value("#{propertiesReader['base.BusinessEventListenerConfiguration.maxPoolSize']}")
	private String maxPoolSize;

	/**
	 * 
	 * taskExecutor:事件线程池
	 * 
	 * @author junkai.zhang
	 * @return
	 */
	@Bean(name = BusinessEventListenerConstant.taskExecutor)
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor bean = new ThreadPoolTaskExecutor();
		bean.setCorePoolSize(Integer.valueOf(corePoolSize));
		bean.setMaxPoolSize(Integer.valueOf(maxPoolSize));
		return bean;
	}

}
