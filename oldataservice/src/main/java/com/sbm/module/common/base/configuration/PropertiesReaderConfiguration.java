package com.sbm.module.common.base.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

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
public class PropertiesReaderConfiguration {

	@Bean(name = "propertiesReader")
	public PropertiesFactoryBean propertiesFactoryBean() throws IOException {
		List<Resource> locations = new ArrayList<Resource>();
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setFileEncoding(ApplicationConstant.defaultEncode);

		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		// 读取application/hibernate/下所有文件
		Resource[] hibernate = resolver.getResources("classpath*:application/hibernate/*.properties");
		Collections.addAll(locations, hibernate);

		// 读取application/properties/下所有文件
		Resource[] applicationProperties = resolver.getResources("classpath*:application/properties/*.properties");
		Collections.addAll(locations, applicationProperties);

		// 读取common/properties/下所有文件
		Resource[] commonProperties = resolver.getResources("classpath*:common/properties/*.properties");
		Collections.addAll(locations, commonProperties);
		// set
		bean.setLocations(locations.toArray(new Resource[locations.size()]));
		return bean;
	}

}
