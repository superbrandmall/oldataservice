package com.sbm.module.partner.hd.view.base.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.sbm.module.common.business.configuration.hibernate.ImprovedNamingStrategy;
import com.sbm.module.common.business.constant.TransactionConstant;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.application.base.configuration.hibernate<br/>
 * File Name:CommonSessionFactoryConfiguration.java<br/>
 * 
 * 作成日 ：2017-9-1 上午9:28:38 <br/>
 * 
 * @author ：junkai.zhang
 */
@Configuration
// 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@EnableTransactionManagement(proxyTargetClass = true)
public class HdSessionFactoryConfiguration {

	@Value("#{propertiesReader['hd.hibernate.dialect']}")
	private String dialect;

	@Value("#{propertiesReader['hibernate.show_sql']}")
	private String show_sql;
	@Value("#{propertiesReader['hibernate.format_sql']}")
	private String format_sql;
	@Value("#{propertiesReader['hibernate.use_sql_comments']}")
	private String use_sql_comments;
	@Value("#{propertiesReader['hibernate.connection.release_mode']}")
	private String release_mode;
	@Value("#{propertiesReader['hibernate.autoReconnect']}")
	private String autoReconnect;
	@Value("#{propertiesReader['hibernate.connection.autocommit']}")
	private String autocommit;

	@Value("#{propertiesReader['hibernate.cache.provider_class']}")
	private String provider_class;
	@Value("#{propertiesReader['hibernate.cache.use_query_cache']}")
	private String use_query_cache;
	@Value("#{propertiesReader['hibernate.cache.use_second_level_cache']}")
	private String use_second_level_cache;
	@Value("#{propertiesReader['hibernate.cache.provider_configuration_file_resource_path']}")
	private String provider_configuration_file_resource_path;

	@Bean(name = "hdSessionFactory")
	public LocalSessionFactoryBean sessionFactory(@Qualifier("hdDataSource") DruidDataSource dataSource) {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setPackagesToScan("com.sbm.module.partner.hd.view");
		// bean.setNamingStrategy(new
		// org.hibernate.cfg.ImprovedNamingStrategy());
		bean.setHibernateProperties(getHibernateProperties());
		// 自定义驼峰命名规则
		bean.setPhysicalNamingStrategy(new ImprovedNamingStrategy());
		return bean;
	}

	private Properties getHibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", dialect);
		hibernateProperties.setProperty("hibernate.show_sql", show_sql);
		hibernateProperties.setProperty("hibernate.format_sql", format_sql);
		hibernateProperties.setProperty("hibernate.use_sql_comments", use_sql_comments);
		hibernateProperties.setProperty("hibernate.connection.release_mode", release_mode);
		hibernateProperties.setProperty("hibernate.autoReconnect", autoReconnect);
		hibernateProperties.setProperty("hibernate.connection.autocommit", autocommit);
		hibernateProperties.setProperty("hibernate.cache.provider_class", provider_class);
		hibernateProperties.setProperty("hibernate.cache.use_query_cache", use_query_cache);
		hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", use_second_level_cache);
		hibernateProperties.setProperty("hibernate.cache.provider_configuration_file_resource_path",
				provider_configuration_file_resource_path);

		return hibernateProperties;
	}

	@Bean(name = TransactionConstant.HD)
	public HibernateTransactionManager hibernateTransactionManager(
			@Qualifier("hdSessionFactory") LocalSessionFactoryBean sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory.getObject());
		return hibernateTransactionManager;
	}

}
