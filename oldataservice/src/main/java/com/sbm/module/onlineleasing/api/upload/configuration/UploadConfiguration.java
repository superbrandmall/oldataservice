package com.sbm.module.onlineleasing.api.upload.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

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
public class UploadConfiguration {

	@Bean(name = "multipartResolver")
	public StandardServletMultipartResolver multipartResolverBean() {
		StandardServletMultipartResolver bean = new StandardServletMultipartResolver();
		return bean;
	}

}
