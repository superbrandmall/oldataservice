package com.sbm.module.common.business.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.stereotype.Component;

import com.sbm.module.common.business.constant.ApplicationConstant;

@Component
public class ContextListener implements ServletContextListener {

	private static final String BASE = "base";

	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("-------关闭中--------");
	}

	public void contextInitialized(ServletContextEvent event) {
		event.getServletContext().setAttribute(BASE, event.getServletContext().getContextPath());
		System.setProperty("baseFilePath", ApplicationConstant.LOG);
		//System.setProperty("java.net.preferIPv4Stack", "true");
		System.out.println("-------启动中-------");
	}

}
