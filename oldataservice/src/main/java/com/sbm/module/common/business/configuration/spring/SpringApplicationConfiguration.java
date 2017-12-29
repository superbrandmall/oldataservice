package com.sbm.module.common.business.configuration.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.common.base.configuration<br/>
 * File Name:SpringApplicationConfiguration.java<br/>
 * 
 * 作成日 ：2017-8-31 下午4:48:23 <br/>
 * 
 * @author ：junkai.zhang
 */
@Configuration
@ComponentScan(basePackages = { "com.sbm.module.common", 
		"com.sbm.module.onlineleasing",
		"com.sbm.module.partner.hd.rest", 
		"com.sbm.module.partner.hd.mediaservice", 
		
		"com.sbm.module.partner.hd.job",
		"com.sbm.module.partner.hd.view",
		
		"com.sbm.module.partner.tianyancha",
		"com.sbm.module.partner.hl95",
		"com.sbm.module.partner.nuozhengtong"},
		excludeFilters = { @Filter(type = FilterType.ANNOTATION, value = {
		Controller.class, ControllerAdvice.class }) })
// AOP
@EnableAspectJAutoProxy(proxyTargetClass=true)
// 异步处理器
@EnableAsync
public class SpringApplicationConfiguration {

}
