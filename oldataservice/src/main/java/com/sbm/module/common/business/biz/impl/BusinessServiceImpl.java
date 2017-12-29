package com.sbm.module.common.business.biz.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.apiinteractive.domain.TCApiInteractiveDetail;
import com.sbm.module.common.api.redis.biz.IRedisService;
import com.sbm.module.common.api.serialcode.biz.ITCSerialCodeService;
import com.sbm.module.common.base.biz.impl.CommonServiceImpl;
import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.base.pulisher.template.BusinessEventTemplate;
import com.sbm.module.common.business.biz.IBusinessService;
import com.sbm.module.common.business.biz.IThreadSleepExecuteCallBack;
import com.sbm.module.common.business.domain.Pagination;

/*****************************************************************************/
/**
 * Project Name:upload2luis<br/>
 * Package Name:com.sbm.module.common.biz.impl<br/>
 * File Name:CommonServiceImpl.java<br/>
 * 
 * 作成日 ：2017-4-7 下午4:17:11 <br/>
 * 
 * @author ：junkai.zhang
 */
public class BusinessServiceImpl extends CommonServiceImpl implements IBusinessService {

	/**
	 * 获取code
	 */
	@Autowired
	protected ITCSerialCodeService serialCodeService;

	/**
	 * 缓存
	 */
	@Autowired
	protected IRedisService redisService;

	/**
	 * 
	 * getUserCode:获取当前线程userCode
	 * 
	 * @author junkai.zhang
	 * @return
	 */
	protected String getUserCode() {
		String userCode = null;
		try {
			userCode = TCApiInteractiveDetail.get().getUserCode();
		} catch (Exception e) {
			userCode = CommonConstant.SYSTEM;
		}
		return userCode;
	}

	/**
	 * 
	 * getPagination:获取分页模板
	 * 
	 * @author junkai.zhang
	 * @return
	 */
	protected <T> Pagination<T> getPagination() {
		return new Pagination<T>();
	}

	/**
	 * 
	 * save2RequestBody:存入线程requestBody
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	protected void save2RequestBody(Object obj) {
		TCApiInteractiveDetail detail = TCApiInteractiveDetail.get();
		detail.setRequestBody(JSON.toJSONString(obj));
	}

	/************************************************************************/
	// redis

	/**
	 * 
	 * set2redis:存入redis
	 * 
	 * @author junkai.zhang
	 * @param key
	 * @param value
	 */
	protected void set2redis(String key, Object value) {
		set2redis(key, value, null, TimeUnit.SECONDS);
	}

	/**
	 * 
	 * set2redis:存入redis
	 * 
	 * @author junkai.zhang
	 * @param key
	 * @param value
	 * @param timeout
	 * @param unit
	 */
	protected void set2redis(String key, Object value, Long timeout, TimeUnit unit) {
		redisService.set(key, value);
		// 设置有效期
		if (null == timeout) {
			redisService.defaultExpire(key);
		} else {
			redisService.expire(key, timeout, unit);
		}
	}

	/************************************************************************/
	// event

	/**
	 * 
	 * getTemplate:获取模板
	 * 
	 * @author junkai.zhang
	 * @return
	 */
	protected BusinessEventTemplate getTemplate() {
		return new BusinessEventTemplate();
	}

	/************************************************************************/
	// 多线程睡眠
	
	private static final Integer LIMIT = 5;

	// 3秒
	private static final Integer SLEEP = 3000;

	public <T> T threadSleepExecute(BusinessException businessException, IThreadSleepExecuteCallBack<T> callback) {
		return threadSleepExecute(businessException, callback, 0, LIMIT, SLEEP);
	}

	public <T> T threadSleepExecute(BusinessException businessException, IThreadSleepExecuteCallBack<T> callback,
			Integer i, Integer limit, Integer sleep) {
		if (i >= limit) {
			throw businessException;
		}
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			throw new BusinessException(BusinessCode.C9999, e);
		}
		T t = callback.execute();
		if (null == t) {
			i++;
			t = threadSleepExecute(businessException, callback, i, limit, sleep);
		}
		return t;
	}

}
