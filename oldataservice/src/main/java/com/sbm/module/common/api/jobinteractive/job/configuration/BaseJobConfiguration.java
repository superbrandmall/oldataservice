package com.sbm.module.common.api.jobinteractive.job.configuration;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

import com.sbm.module.common.api.jobinteractive.job.BaseJob;
import com.sbm.module.common.base.constant.CommonConstant;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.common.base.job<br/>
 * File Name:BaseJob.java<br/>
 * 
 * 作成日 ：2017-9-25 上午10:30:45 <br/>
 * 
 * @author ：junkai.zhang
 */
public abstract class BaseJobConfiguration {

	private static final String DEFAULT_CRON_EXPRESSION = "30 */1 * * * ?";

	private static final String METHOD = "work";

	private static final String MESSAGE = "{0} is using default cron expression";

	protected MethodInvokingJobDetailFactoryBean jobDetailFactoryBean(BaseJob job) {
		MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
		bean.setTargetObject(job);
		bean.setTargetMethod(METHOD);
		// 对于相同的JobDetail，当指定多个Trigger时,
		// 很可能第一个job完成之前，第二个job就开始了。指定concurrent设为false，多个job不会并发运行，第二个job将不会在第一个job完成之前开始。
		bean.setConcurrent(false);
		return bean;
	}

	protected CronTriggerFactoryBean cronTriggerFactoryBean(MethodInvokingJobDetailFactoryBean jobFactoryBean,
			String CRON_EXPRESSION) {
		CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
		trigger.setJobDetail(jobFactoryBean.getObject());
		// 根据配置设置
		if (StringUtils.isEmpty(CRON_EXPRESSION)) {
			CommonConstant.FRAMEWORK.warn(MessageFormat.format(MESSAGE, jobFactoryBean.getTargetObject().getClass()
					.getName()));
			CRON_EXPRESSION = DEFAULT_CRON_EXPRESSION;
		}
		trigger.setCronExpression(CRON_EXPRESSION);
		return trigger;
	}

}
