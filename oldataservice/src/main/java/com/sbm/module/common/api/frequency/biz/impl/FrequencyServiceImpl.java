package com.sbm.module.common.api.frequency.biz.impl;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.frequency.biz.IFrequencyService;
import com.sbm.module.common.api.frequency.domian.FrequencyDetail;
import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/
/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.biz.impl<br/>
 * File Name:EdiInteractiveDetailServiceImpl.java<br/>
 * 
 * 作成日 ：2016-1-4 下午5:05:55 <br/>
 * 
 * @author ：junkai.zhang 
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
/**
 * @preserve public
 */
@Component
@Transactional(value = TransactionConstant.OL, propagation = Propagation.REQUIRED)
public class FrequencyServiceImpl extends BusinessServiceImpl implements IFrequencyService {

	public void checkFrequencyDetail(FrequencyDetail obj) {
		// 从redis取
		obj = getFrequencyDetailFromRedis(obj);
		// 次数+1
		obj.setCount(obj.getCount() + 1);
		// 存入redis
		set(obj);
		// 检查次数
		checkLimit(obj);
	}

	/**
	 * 
	 * checkLimit:检查次数
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	private void checkLimit(FrequencyDetail obj) {
		if (obj.getCount() > obj.getLimit()) {
			throw new BusinessException(BusinessCode.C9994, new Object[] { obj.getIp(), obj.getUri(), obj.getCount(),
					obj.getLimit(), redisService.getExpire(obj.getKey()) }, null);
		}
	}

	/**
	 * 
	 * set:存入redis
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	private void set(FrequencyDetail obj) {
		Long timeout = obj.getTimeout();
		// 存在期限则沿用
		if (redisService.hasExpire(obj.getKey())) {
			timeout = redisService.getExpire(obj.getKey());
		}
		// 存入redis
		redisService.set(obj.getKey(), JSON.toJSONString(obj));
		// 设置超时
		redisService.expire(obj.getKey(), timeout, TimeUnit.SECONDS);
	}

	/**
	 * 
	 * getFrequencyDetailFromRedis:从redis下获取frequencyDetail
	 * 
	 * @author junkai.zhang
	 * @param obj
	 * @return
	 */
	private FrequencyDetail getFrequencyDetailFromRedis(FrequencyDetail obj) {
		String valuer = (String) redisService.get(obj.getKey());
		if (StringUtils.isNotBlank(valuer)) {
			obj = JSON.parseObject(valuer, FrequencyDetail.class);
		}
		return obj;
	}
}
