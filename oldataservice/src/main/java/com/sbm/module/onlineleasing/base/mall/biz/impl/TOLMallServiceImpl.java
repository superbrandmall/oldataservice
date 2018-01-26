package com.sbm.module.onlineleasing.base.mall.biz.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.redis.constant.RedisConstant;
import com.sbm.module.common.api.serialcode.constant.SerialCodeConstant;
import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.base.mall.biz.ITOLMallService;
import com.sbm.module.onlineleasing.base.mall.dao.ITOLMallDao;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;

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
public class TOLMallServiceImpl extends DaoSupportServiceImpl<TOLMall> implements ITOLMallService {

	@Autowired
	private ITOLMallDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLMall> findAll() {
		List<TOLMall> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLMall> findAllOrderByPosition() {
		List<TOLMall> list = dao.findAllOrderByPosition();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLMall findByCode(String code) {
		String valuer = (String) redisService.get(RedisConstant.PREFIX_MALL + code);
		if (StringUtils.isNotBlank(valuer)) {
			TOLMall obj = JSON.parseObject(valuer, TOLMall.class);
			return obj;
		}
		return dao.findByCode(code);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLMall findByHdUuid(String hdUuid) {
		return dao.findByHdUuid(hdUuid);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLMall> findAllByCondition(TOLMall obj) {
		return dao.findAllByCondition(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Pagination<TOLMall> findAllByConditionPage(TOLMall obj) {
		return dao.findAllByConditionPage(obj);
	}

	public void saveMall(TOLMall obj) {
		obj.setCode(serialCodeService.nextBizId(SerialCodeConstant.OLMALL).getNextBizId());
		save(obj);
	}
	
	public void refreshCache() {
		List<TOLMall> list = findAll();
		for (TOLMall obj : list) {
			set2redis(RedisConstant.PREFIX_MALL + obj.getCode(), JSON.toJSONString(obj), 2L, TimeUnit.DAYS);
		}
	}
}
