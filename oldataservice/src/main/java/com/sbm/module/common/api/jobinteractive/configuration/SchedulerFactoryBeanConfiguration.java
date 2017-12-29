package com.sbm.module.common.api.jobinteractive.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.quartz.CronTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.base.util.SpringBeanUtil;

/*****************************************************************************/
/**
 * Project Name:bbjohn<br/>
 * Package Name:com.bbjohn.web.module.configuration<br/>
 * File Name:VelocityConfigraction.java<br/>
 * 
 * 作成日 ：2016-2-15 下午5:12:40 <br/>
 * 
 * @author ：junkai.zhang
 */
@Configuration
public class SchedulerFactoryBeanConfiguration {

	@Autowired
	private SpringBeanUtil util;

	@Bean(name = "schedulerFactoryBean")
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean bean = new SchedulerFactoryBean();
		// 取所有CronTriggerFactoryBean实例
		Map<String, CronTriggerFactoryBean> map = util.getApplicationContext().getBeansOfType(
				CronTriggerFactoryBean.class);
		List<CronTrigger> list = new ArrayList<CronTrigger>();
		for (String key : map.keySet()) {
			list.add(map.get(key).getObject());
			CommonConstant.FRAMEWORK.info("schedule register: " + key);
		}
		bean.setTriggers(list.toArray(new CronTrigger[list.size()]));
		return bean;
	}

}
