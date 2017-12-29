package com.sbm.module.common.base.pulisher.listener;

import com.sbm.module.common.api.eventinteractive.biz.ITCEventInteractiveDetailService;
import com.sbm.module.common.api.eventinteractive.domain.TCEventInteractiveDetail;
import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.base.pulisher.constant.BusinessEventListenerConstant;
import com.sbm.module.common.base.pulisher.event.BusinessEvent;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;

import java.text.MessageFormat;

/*****************************************************************************/

/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.common.base.pulisher.listener<br/>
 * File Name:BusinessEventListener.java<br/>
 * 
 * 作成日 ：2017-9-26 上午9:36:27 <br/>
 * 
 * @author ：junkai.zhang
 */
public abstract class BaseEventListener {

	@Autowired
	@Qualifier(BusinessEventListenerConstant.taskExecutor)
	private TaskExecutor taskExecutor;

	@SuppressWarnings("rawtypes")
	protected Class clazz = null;
	protected String clazzname;
	{
		clazz = this.getClass();
		clazzname = clazz.getName();
	}

	private TCEventInteractiveDetail detail;

	/**
	 *
	 * execute:执行任务
	 *
	 * @author junkai.zhang
	 * @param event
	 */
	protected abstract void execute(BusinessEvent event);

	/**
	 *
	 * async:异步
	 *
	 * @author junkai.zhang
	 * @param event
	 */
	// @Async(BusinessEventListenerConstant.taskExecutor)
	protected void async(final BusinessEvent event) {
		// 提高junit测试速度
		String s = System.getProperty("ASYNC_FLAG");
		if (StringUtils.isBlank(s) || Boolean.valueOf(s)) {
			taskExecutor.execute(new Runnable() {
				public void run() {
					sync(event);
				}
			});
		} else {
			sync(event);
		}
	}

	/**
	 *
	 * before:执行前
	 *
	 * @author junkai.zhang
	 */
	protected void before(final BusinessEvent event) {

	}

	protected void sync(final BusinessEvent event) {
		before(event);
		try {
			execute(event);
		} catch (Exception e) {
			error(e);
		}
		after();
		// System.out.println(Thread.currentThread().getName());
	}

	/**
	 *
	 * after:执行后
	 *
	 * @author junkai.zhang
	 */
	protected void after() {

	}

	/**
	 *
	 * error:异常处理
	 *
	 * @param e
	 */
	protected void error(Exception e) {

	}

}
