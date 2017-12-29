package com.sbm.module.common.business.init;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.sbm.module.common.business.configuration.spring.SpringApplicationConfiguration;
import com.sbm.module.common.business.configuration.spring.SpringMVCConfiguration;
import com.sbm.module.common.business.constant.ApplicationConstant;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.common.base.init<br/>
 * File Name:WebInitializer.java<br/>
 * spring DispatcherServlet的配置,其它servlet和监听器等需要额外声明，用@Order注解设定启动顺序 作成日
 * ：2017-8-31 下午4:41:50 <br/>
 * 
 * @author ：junkai.zhang
 */
@Order(2)
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SpringApplicationConfiguration.class };
	}

	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringMVCConfiguration.class };
	}

	// DispatcherServlet的映射路径
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(getMultipartConfigElement());
		super.customizeRegistration(registration);
	}

	/**
	 * 
	 * getMultipartConfigElement:文件上传配置
	 * 
	 * @author junkai.zhang
	 * @return
	 */
	private MultipartConfigElement getMultipartConfigElement() {
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(LOCATION, MAX_FILE_SIZE,
				MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
		return multipartConfigElement;
	}

	/**
	 * Temporary location where files will be stored
	 */
	public static final String LOCATION = ApplicationConstant.TMP;

	/**
	 * 50MB : Max file size. Beyond that size spring will throw exception.
	 */
	private static final long MAX_FILE_SIZE = 52428800;

	/**
	 * // 200MB : Total request size containing Multi part.
	 */
	private static final long MAX_REQUEST_SIZE = 209715200;

	/**
	 * Size threshold after which files will be written to disk
	 */
	private static final int FILE_SIZE_THRESHOLD = 0;
}
