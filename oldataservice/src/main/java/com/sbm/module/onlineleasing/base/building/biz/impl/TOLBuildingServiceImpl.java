package com.sbm.module.onlineleasing.base.building.biz.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;
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
import com.sbm.module.onlineleasing.base.building.biz.ITOLBuildingService;
import com.sbm.module.onlineleasing.base.building.dao.ITOLBuildingDao;
import com.sbm.module.onlineleasing.base.building.domain.TOLBuilding;

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
public class TOLBuildingServiceImpl extends DaoSupportServiceImpl<TOLBuilding> implements ITOLBuildingService {

	@Autowired
	private ITOLBuildingDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLBuilding> findAll() {
		List<TOLBuilding> list = dao.findAll();
		return list;
	}
	
	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLBuilding> findAllByMallCode(String mallCode) {
		List<TOLBuilding> list = dao.findAllByMallCode(mallCode);
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLBuilding findByCode(String code) {
		String valuer = (String) redisService.get(RedisConstant.PREFIX_BUILDING + code);
		if (StringUtils.isNotBlank(valuer)) {
			TOLBuilding obj = JSON.parseObject(valuer, TOLBuilding.class);
			return obj;
		}
		return dao.findByCode(code);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLBuilding findByHdUuid(String hdUuid) {
		return dao.findByHdUuid(hdUuid);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLBuilding> findAllByCondition(TOLBuilding obj) {
		return dao.findAllByCondition(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Pagination<TOLBuilding> findAllByConditionPage(TOLBuilding obj) {
		return dao.findAllByConditionPage(obj);
	}

	public void saveBuilding(TOLBuilding obj) {
		obj.setCode(serialCodeService.nextBizId(SerialCodeConstant.OLBUILDING).getNextBizId());
		save(obj);
	}

	public void refreshCache() {
		List<TOLBuilding> list = findAll();
		for (TOLBuilding obj : list) {
			set2redis(RedisConstant.PREFIX_BUILDING + obj.getCode(), JSON.toJSONString(obj), 2L, TimeUnit.DAYS);
		}
	}
}
