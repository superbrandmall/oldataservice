package com.sbm.module.common.api.jobinteractive.job;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.sbm.module.common.api.jobinteractive.biz.ITCJobInteractiveDetailService;
import com.sbm.module.common.api.jobinteractive.domain.TCJobInteractiveDetail;
import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.base.exception.BusinessException;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.common.base.job<br/>
 * File Name:BaseJob.java<br/>
 * 
 * 作成日 ：2017-9-25 上午10:30:45 <br/>
 * 
 * @author ：junkai.zhang
 */
public abstract class BaseJob {

	@Autowired
	private ITCJobInteractiveDetailService service;

	@SuppressWarnings("rawtypes")
	private Class clazz = null;
	private String clazzname;
	{
		clazz = this.getClass();
		clazzname = clazz.getName();
	}

	private TCJobInteractiveDetail detail;

	/**
	 * 
	 * execute:执行任务
	 * 
	 * @author junkai.zhang
	 */
	protected abstract void execute();

	/**
	 * 
	 * before:执行前
	 * 
	 * @author junkai.zhang
	 */
	protected void before() {
		CommonConstant.FRAMEWORK.info(clazzname + ": job started");
		detail = new TCJobInteractiveDetail();
		detail.setJob(clazzname);
		detail.setBeginTime(System.currentTimeMillis());
	}

	/**
	 * 
	 * work:任务主体
	 * 
	 * @author junkai.zhang
	 */
	public void work() {
		before();
		try {
			execute();
		} catch (Exception e) {
			error(e);
		}
		after();
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
		CommonConstant.FRAMEWORK.info(clazzname + ": job completed in " + detail.getIntervalTime() + " ms");
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
		CommonConstant.ERRORDATA.error(clazzname + ": job error", e);
	}
}
