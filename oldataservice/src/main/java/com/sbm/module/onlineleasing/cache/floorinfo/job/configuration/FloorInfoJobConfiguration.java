package com.sbm.module.onlineleasing.cache.floorinfo.job.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

import com.sbm.module.common.api.jobinteractive.job.BaseJob;
import com.sbm.module.common.api.jobinteractive.job.configuration.BaseJobConfiguration;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.job.sync.floor.configuration<br/>
 * File Name:FloorJobConfiguration.java<br/>
 * 
 * 作成日 ：2017-9-25 上午10:48:12 <br/>
 * 
 * @author ：junkai.zhang
 */
@Configuration
public class FloorInfoJobConfiguration extends BaseJobConfiguration {

	@Value("#{propertiesReader['onlineleasing.cache.floorinfo.CRON_EXPRESSION']}")
	private String CRON_EXPRESSION;

	@Autowired
	@Qualifier("floorInfoJob")
	private BaseJob job;

	@Bean(name = "floorInfoJobDetail")
	public MethodInvokingJobDetailFactoryBean jobDetail() {
		MethodInvokingJobDetailFactoryBean jobDetail = jobDetailFactoryBean(job);
		return jobDetail;
	}

	// cron触发器配置
	@Bean(name = "floorInfoJobTrigger")
	public CronTriggerFactoryBean jobTrigger() {
		CronTriggerFactoryBean trigger = cronTriggerFactoryBean(jobDetail(), CRON_EXPRESSION);
		return trigger;
	}

}
