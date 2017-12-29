package com.sbm.module.common.business.init;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.util.Log4jConfigListener;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.sbm.module.common.business.listener.ContextListener;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.common.base.init<br/>
 * File Name:CommonInitializer.java<br/>
 * 
 * 作成日 ：2017-8-31 下午3:59:05 <br/>
 * 
 * @author ：junkai.zhang
 */
@SuppressWarnings("deprecation")
@Order(1)
public class CommonInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		// 自定义监听先执行 注意先后顺序
		initContextListener(servletContext);
		initLog4jConfigListener(servletContext);
		initDruid(servletContext);
	}

	/**
	 * 
	 * initDruid:druid配置
	 * 
	 * @author junkai.zhang
	 * @param servletContext
	 */
	private void initDruid(ServletContext servletContext) {
		// TODO 目前拦截器失效，无法统计，需要排查
		WebStatFilter filter = new WebStatFilter();
		FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("DruidWebStatFilter", filter);
		filterRegistration.setInitParameter(WebStatFilter.PARAM_NAME_EXCLUSIONS,
				"*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		filterRegistration.addMappingForUrlPatterns(
				EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "/");

		ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("DruidStatView",
				new StatViewServlet());
		servletRegistration.addMapping("/druid/*");
	}

	/**
	 * 
	 * initContextListener:初始化自定义监听
	 * 
	 * @author junkai.zhang
	 * @param servletContext
	 */
	private void initContextListener(ServletContext servletContext) {
		servletContext.addListener(ContextListener.class);
	}

	/**
	 * 
	 * initLog4jConfigListener:初始化log4j
	 * 
	 * @author junkai.zhang
	 * @param servletContext
	 */
	private void initLog4jConfigListener(ServletContext servletContext) {
		// Log4jConfigListener
		servletContext.setInitParameter("log4jConfigLocation", "classpath:common/log4j/log4j.properties");
		// TODO 使用log4j2
		servletContext.addListener(Log4jConfigListener.class);
	}

}
