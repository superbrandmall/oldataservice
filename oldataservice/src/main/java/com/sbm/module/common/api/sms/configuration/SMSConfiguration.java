package com.sbm.module.common.api.sms.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/*****************************************************************************/
/**
 * Project Name:posUploadDataService<br/>
 * Package Name:com.sbm.module.common.configutation<br/>
 * File Name:PropertiesReaderConfiguration.java<br/>
 * 
 * 作成日 ：2016-4-21 上午10:38:07 <br/>
 * 
 * @author ：junkai.zhang
 */
@Configuration
public class SMSConfiguration {

	@Value("#{propertiesReader['sms.task.corePoolSize']}")
	private String corePoolSize;

	@Value("#{propertiesReader['sms.task.maxPoolSize']}")
	private String maxPoolSize;

	/**
	 * 
	 * taskExecutor4smsBean:短信线程池
	 * 
	 * @author junkai.zhang
	 * @return
	 */
	@Bean(name = "taskExecutor4sms")
	public ThreadPoolTaskExecutor taskExecutor4smsBean() {
		ThreadPoolTaskExecutor bean = new ThreadPoolTaskExecutor();
		bean.setCorePoolSize(Integer.valueOf(corePoolSize));
		bean.setMaxPoolSize(Integer.valueOf(maxPoolSize));
		return bean;
	}

}
