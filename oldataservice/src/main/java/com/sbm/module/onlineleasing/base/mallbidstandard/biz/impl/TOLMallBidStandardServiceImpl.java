package com.sbm.module.onlineleasing.base.mallbidstandard.biz.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.redis.constant.RedisConstant;
import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.base.mallbidstandard.biz.ITOLMallBidStandardService;
import com.sbm.module.onlineleasing.base.mallbidstandard.dao.ITOLMallBidStandardDao;
import com.sbm.module.onlineleasing.base.mallbidstandard.domain.TOLMallBidStandard;

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
public class TOLMallBidStandardServiceImpl extends DaoSupportServiceImpl<TOLMallBidStandard> implements
		ITOLMallBidStandardService {

	@Autowired
	private ITOLMallBidStandardDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLMallBidStandard> findAll() {
		List<TOLMallBidStandard> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLMallBidStandard findByCode(String code) {
		String valuer = (String) redisService.get(RedisConstant.PREFIX_MALL_BID_STANDARD + code);
		if (StringUtils.isNotBlank(valuer)) {
			TOLMallBidStandard obj = JSON.parseObject(valuer, TOLMallBidStandard.class);
			return obj;
		}
		return dao.findByCode(code);
	}

	public void refreshCache() {
		List<TOLMallBidStandard> list = findAll();
		for (TOLMallBidStandard obj : list) {
			set2redis(RedisConstant.PREFIX_MALL_BID_STANDARD + obj.getCode(), JSON.toJSONString(obj), 2L, TimeUnit.DAYS);
		}
	}
}
