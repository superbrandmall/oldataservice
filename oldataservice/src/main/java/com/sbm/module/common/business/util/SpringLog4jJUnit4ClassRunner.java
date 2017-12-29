package com.sbm.module.common.business.util;

import java.io.FileNotFoundException;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import com.sbm.module.common.api.apiinteractive.domain.TCApiInteractiveDetail;
import com.sbm.module.common.business.constant.ApplicationConstant;

/*****************************************************************************/
/**
 * Project Name:posUploadDataService<br/>
 * Package Name:com.sbm.module.common.util<br/>
 * File Name:SpringLog4jJUnit4ClassRunner.java<br/>
 * 
 * 作成日 ：2016-4-26 上午11:52:51 <br/>
 * 
 * @author ：junkai.zhang
 */
@SuppressWarnings("deprecation")
public class SpringLog4jJUnit4ClassRunner extends SpringJUnit4ClassRunner {
	/*
	 * Junit加载spring的runner（SpringJUnit4ClassRunner）要优先于spring加载log4j，
	 * 因此采用普通方法，无法实现spring先加载log4j后被Junit加载。
	 * 所以我们需要新建JUnit4ClassRunner类，修改SpringJUnit4ClassRunner加载log4j的策略。
	 * 这样加载log4j就会优先于加载spring了。
	 */
	static {
		try {
			// 全局用户code
			TCApiInteractiveDetail detail = new TCApiInteractiveDetail();
			detail.setUserCode("OLUSER170717000002");
			TCApiInteractiveDetail.set(detail);
			// 不加载启动项
			System.setProperty("INIT_FLAG", "false");
			// 不使用异步
			System.setProperty("ASYNC_FLAG", "false");
			// 日志路径
			System.setProperty("BASE_FILE_PATH", ApplicationConstant.LOG);
			Log4jConfigurer.initLogging("classpath:common/log4j/log4j.properties");
		} catch (FileNotFoundException ex) {
			System.err.println("Cannot Initialize log4j");
		}
	}

	public SpringLog4jJUnit4ClassRunner(Class<?> clazz) throws InitializationError {
		super(clazz);
	}

}
