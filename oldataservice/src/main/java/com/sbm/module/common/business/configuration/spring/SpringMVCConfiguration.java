package com.sbm.module.common.business.configuration.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.sbm.module.common.base.util.SpringBeanUtil;
import com.sbm.module.common.business.constant.ApplicationConstant;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.common.base.configuration<br/>
 * File Name:SpringMVCConfiguration.java<br/>
 * 
 * 作成日 ：2017-8-31 下午4:50:46 <br/>
 * 
 * @author ：junkai.zhang
 */
// @Configuration 如果使用confinguration webroot会重复扫描
@EnableWebMvc
@ComponentScan(basePackages = { "com.sbm.module.common", 
		"com.sbm.module.onlineleasing",
		"com.sbm.module.partner.hd.rest", 
		"com.sbm.module.partner.hd.mediaservice",

		"com.sbm.module.partner.hd.job",
		"com.sbm.module.partner.hd.view",

		"com.sbm.module.partner.tianyancha", 
		"com.sbm.module.partner.hl95",
		"com.sbm.module.partner.nuozhengtong"}, useDefaultFilters = false, includeFilters = { @Filter(type = FilterType.ANNOTATION, value = {
		Controller.class, ControllerAdvice.class }) })
//@EnableSwagger2
public class SpringMVCConfiguration extends WebMvcConfigurationSupport {

	@Autowired
	private SpringBeanUtil util;

	/**
	 * 
	 * viewResolver:解析器
	 * 
	 * @author junkai.zhang
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean(name = "multipartResolver")
	public StandardServletMultipartResolver standardServletMultipartResolver() {
		StandardServletMultipartResolver standardServletMultipartResolver = new StandardServletMultipartResolver();
		return standardServletMultipartResolver;
	}

	/***********************************************************/
	// <mvc:annotation-driven />

	@Bean
	public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
		return super.requestMappingHandlerAdapter();
	}

	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		StringHttpMessageConverter bean = new StringHttpMessageConverter(ApplicationConstant.defaultCharset);
		return bean;
	}

	@Bean
	public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
		FastJsonHttpMessageConverter bean = new FastJsonHttpMessageConverter();
		bean.setCharset(ApplicationConstant.defaultCharset);

		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		supportedMediaTypes.add(MediaType.valueOf("application/json"));
		supportedMediaTypes.add(MediaType.valueOf("text/html;charset=UTF-8"));
		bean.setSupportedMediaTypes(supportedMediaTypes);

		bean.setFeatures(SerializerFeature.WriteMapNullValue, SerializerFeature.QuoteFieldNames,
				SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteEnumUsingToString);
		return bean;
	}

	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		converters.add(stringHttpMessageConverter());
		converters.add(fastJsonHttpMessageConverter());
	}

	/***********************************************************/
	// <mvc:default-servlet-handler />

	@Bean
	public HandlerMapping defaultServletHandlerMapping() {
		return super.defaultServletHandlerMapping();
	}

	protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/***********************************************************/
	// inteceptor 拦截器注册在前

	// /**
	// *
	// * CORSInterceptor:跨域拦截器
	// *
	// * @author junkai.zhang
	// * @return
	// */
	// @Bean("CORSInterceptor")
	// public CORSInterceptor CORSInterceptor() {
	// CORSInterceptor bean = new CORSInterceptor();
	// return bean;
	// }
	//
	// /**
	// *
	// * apiInteractiveInterceptor:耗时拦截器
	// *
	// * @author junkai.zhang
	// * @return
	// */
	// @Bean("apiInteractiveInterceptor")
	// public ApiInteractiveInterceptor apiInteractiveInterceptor() {
	// ApiInteractiveInterceptor bean = new ApiInteractiveInterceptor();
	// return bean;
	// }
	//
	// /**
	// *
	// * JSONWebTokenInterceptor:jwt拦截器
	// *
	// * @author junkai.zhang
	// * @return
	// */
	// @Bean("JSONWebTokenInterceptor")
	// public JSONWebTokenInterceptor JSONWebTokenInterceptor() {
	// JSONWebTokenInterceptor bean = new JSONWebTokenInterceptor();
	// return bean;
	// }

	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		return super.requestMappingHandlerMapping();
	}

	@Bean
	public HandlerMapping viewControllerHandlerMapping() {
		return super.viewControllerHandlerMapping();
	}

	@Bean
	public BeanNameUrlHandlerMapping beanNameHandlerMapping() {
		return super.beanNameHandlerMapping();
	}

	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor((HandlerInterceptor) util.getBean("CORSInterceptor")).addPathPatterns("/ol/**");
		registry.addInterceptor((HandlerInterceptor) util.getBean("apiInteractiveInterceptor")).addPathPatterns(
				"/ol/**");
		registry.addInterceptor((HandlerInterceptor) util.getBean("JSONWebTokenInterceptor")).addPathPatterns("/ol/**");
		registry.addInterceptor((HandlerInterceptor) util.getBean("frequencyInterceptor")).addPathPatterns("/ol/**");
		// registry.addInterceptor(CORSInterceptor()).addPathPatterns("/ol/**");
		// registry.addInterceptor(apiInteractiveInterceptor()).addPathPatterns("/ol/**");
		// registry.addInterceptor(JSONWebTokenInterceptor()).addPathPatterns("/ol/**");
	}

//	@Bean
//	public Docket createRestApi() {
//
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(apiInfo())
//				.select()
////				.apis(RequestHandlerSelectors.any())
//				.apis(RequestHandlerSelectors.basePackage("com.sbm.module.onlineleasing.api.interactive.bidresult"))
//				.paths(PathSelectors.any())
//				.build();
//	}
//
//	private ApiInfo apiInfo() {
//		return new ApiInfoBuilder()
//				.title("Spring MVC中使用Swagger2构建RESTful APIs test")
//				.description("这是一个测试用例")
//				.termsOfServiceUrl("https://www.baidu.com/")
//				.contact(new Contact("张骏恺", "https://www.baidu.com/", "295322187@qq.com"))
//				.version("1.0")
//				.build();
//	}

}
