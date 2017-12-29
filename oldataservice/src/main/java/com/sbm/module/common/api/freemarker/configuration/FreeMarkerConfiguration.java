package com.sbm.module.common.api.freemarker.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import com.sbm.module.common.business.constant.ApplicationConstant;

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
public class FreeMarkerConfiguration {

	@Bean(name = "freemarkerConfiguration")
	public FreeMarkerConfigurationFactoryBean freemarkerConfigurationBean() {
		FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
		bean.setTemplateLoaderPath("classpath:application/freemarker");
		bean.setDefaultEncoding(ApplicationConstant.defaultEncode);
		return bean;
	}

}
