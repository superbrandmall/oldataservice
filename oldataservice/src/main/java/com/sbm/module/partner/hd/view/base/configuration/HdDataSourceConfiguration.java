package com.sbm.module.partner.hd.view.base.configuration;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/*****************************************************************************/
/**
 * Project Name:posUploadDataService<br/>
 * Package Name:com.sbm.module.common.configutation<br/>
 * File Name:DataSourceConfiguration.java<br/>
 * 
 * 作成日 ：2016-4-20 下午5:31:30 <br/>
 * 
 * @author ：junkai.zhang
 */
@Configuration
public class HdDataSourceConfiguration {

	/*********************** 通用数据源 ********************************/
	/*
	 * @Value("#{propertiesReader['hd.hibernate.connection.driver_class']}")
	 * private String driver_class;
	 */
	@Value("#{propertiesReader['hd.hibernate.connection.url']}")
	private String url;
	@Value("#{propertiesReader['hd.hibernate.connection.username']}")
	private String username;
	@Value("#{propertiesReader['hd.hibernate.connection.password']}")
	private String password;
	@Value("#{propertiesReader['hd.hibernate.connection.validationQuery']}")
	private String validationQuery;

	// druid 连接池
	@Bean(name = "hdDataSource", destroyMethod = "close")
	public DruidDataSource dataSource() throws SQLException {
		DruidDataSource bean = new DruidDataSource();
		// 连接池名称
		bean.setName("hdDataSource");
		// 基本配置
		// druid不需要配置
		// bean.setDriverClassName(driver_class);
		bean.setUrl(url);
		bean.setUsername(username);
		bean.setPassword(password);

		// 最小连接数
		bean.setMinIdle(20);
		// 初始化连接数
		bean.setInitialSize(20);
		// 最大连接数
		bean.setMaxActive(80);
		// 最大等待时间 毫秒
		bean.setMaxWait(60000);

		// 开启缓存功能
		bean.setPoolPreparedStatements(true);
		// 单个连接拥有的最大缓存数
		bean.setMaxPoolPreparedStatementPerConnectionSize(100);

		// 用来检测连接是否有效的sql，要求是一个查询语句。
		bean.setValidationQuery(validationQuery);
		// 是否超时检测
		bean.setTestWhileIdle(true);

		// sql检测
		bean.setFilters("wall,stat");
		return bean;
	}

	// // C3P0连接池
	// @Bean(name = "hdDataSource", destroyMethod = "close")
	// public ComboPooledDataSource commonComboPooledDataSource() throws
	// PropertyVetoException {
	// ComboPooledDataSource bean = new ComboPooledDataSource();
	// bean.setDriverClass(driver_class);
	// bean.setJdbcUrl(url);
	// bean.setUser(username);
	// bean.setPassword(password);
	// // 连接池中保留的最小连接数。
	// bean.setMinPoolSize(10);
	// // 连接池中保留的最大连接数。Default: 15
	// bean.setMaxPoolSize(15);
	// // 初始化时获取的连接数，取值应在minPoolSize与maxPoolSize之间。Default: 3
	// bean.setInitialPoolSize(10);
	// // 最大空闲时间,60秒内未使用则连接被丢弃。若为0则永不丢弃。Default: 0
	// bean.setMaxIdleTime(60);
	// // 当连接池中的连接耗尽的时候c3p0一次同时获取的连接数。Default: 3
	// bean.setAcquireIncrement(3);
	// /*
	// * JDBC的标准参数，用以控制数据源内加载的PreparedStatements数量。但由于预缓存的statements
	// * 属于单个connection而不是整个连接池。所以设置这个参数需要考虑到多方面的因素。
	// * 如果maxStatements与maxStatementsPerConnection均为0，则缓存被关闭。Default: 0
	// */
	// bean.setMaxStatements(0);
	// bean.setMaxStatementsPerConnection(100);
	// // 每60秒检查所有连接池中的空闲连接。Default: 0
	// bean.setIdleConnectionTestPeriod(60);
	// // 定义在从数据库获取新连接失败后重复尝试的次数。Default: 30
	// bean.setAcquireRetryAttempts(30);
	// /*
	// * 获取连接失败将会引起所有等待连接池来获取连接的线程抛出异常。但是数据源仍有效
	// * 保留，并在下次调用getConnection()的时候继续尝试获取连接。如果设为true，那么在尝试
	// * 获取连接失败后该数据源将申明已断开并永久关闭。Default: false
	// */
	// bean.setBreakAfterAcquireFailure(true);
	// /*
	// * 因性能消耗大请只在需要的时候使用它。如果设为true那么在每个connection提交的
	// * 时候都将校验其有效性。建议使用idleConnectionTestPeriod或automaticTestTable
	// * 等方法来提升连接测试的性能。Default: false
	// */
	// bean.setTestConnectionOnCheckout(false);
	// return bean;
	// }
}
