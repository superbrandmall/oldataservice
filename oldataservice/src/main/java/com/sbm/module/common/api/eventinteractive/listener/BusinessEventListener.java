package com.sbm.module.common.api.eventinteractive.listener;

import com.sbm.module.common.api.eventinteractive.biz.ITCEventInteractiveDetailService;
import com.sbm.module.common.api.eventinteractive.domain.TCEventInteractiveDetail;
import com.sbm.module.common.api.jobinteractive.biz.ITCJobInteractiveDetailService;
import com.sbm.module.common.api.jobinteractive.domain.TCJobInteractiveDetail;
import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.base.pulisher.constant.BusinessEventListenerConstant;
import com.sbm.module.common.base.pulisher.event.BusinessEvent;
import com.sbm.module.common.base.pulisher.listener.BaseEventListener;
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
public abstract class BusinessEventListener extends BaseEventListener {

	@Autowired
	private ITCEventInteractiveDetailService service;

	private TCEventInteractiveDetail detail;

	/**
	 *
	 * before:执行前
	 *
	 * @author junkai.zhang
	 */
	protected void before(final BusinessEvent event) {
		CommonConstant.FRAMEWORK.info(clazzname + ": eventListener started");
		detail = new TCEventInteractiveDetail();
		detail.setEvent(event.getClass().getName());
		detail.setListener(clazzname);
		detail.setBeginTime(System.currentTimeMillis());
	}

	/**
	 *
	 * after:执行后
	 *
	 * @author junkai.zhang
	 */
	protected void after() {
		detail.setEndTime(System.currentTimeMillis());
		detail.setIntervalTime(detail.getEndTime() - detail.getBeginTime());
		CommonConstant.FRAMEWORK.info(clazzname + ": eventListener completed in " + detail.getIntervalTime() + " ms");
		// 插入记录
		service.save(detail);
	}

	/**
	 *
	 * error:异常处理
	 *
	 * @param e
	 */
	protected void error(Exception e) {
		e = BusinessException.convert(BusinessCode.C9999, e);
		detail.setCode(((BusinessException) e).getCode());
		detail.setErrorMessage(ExceptionUtils.getStackTrace(e));
		CommonConstant.ERRORDATA.error(
				MessageFormat.format("{0} has an exception", this.getClass().getSimpleName()), e);
	}

}
