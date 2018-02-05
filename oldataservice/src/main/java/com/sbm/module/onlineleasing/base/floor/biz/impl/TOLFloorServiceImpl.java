package com.sbm.module.onlineleasing.base.floor.biz.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.building.domain.TOLBuilding;
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
import com.sbm.module.onlineleasing.base.floor.biz.ITOLFloorService;
import com.sbm.module.onlineleasing.base.floor.dao.ITOLFloorDao;
import com.sbm.module.onlineleasing.base.floor.domain.TOLFloor;

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
public class TOLFloorServiceImpl extends DaoSupportServiceImpl<TOLFloor> implements ITOLFloorService {

	@Autowired
	private ITOLFloorDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLFloor> findAll() {
		List<TOLFloor> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLFloor> findAllByBuildingCode(String buildingCode) {
		List<TOLFloor> list = dao.findAllByBuildingCode(buildingCode);
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLFloor> findAllByBuildingCodesAndDescription(List<String> buildingCodes, String description) {
		List<TOLFloor> list = dao.findAllByBuildingCodesAndDescription(buildingCodes, description);
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLFloor findByCode(String code) {
		String valuer = (String) redisService.get(RedisConstant.PREFIX_FLOOR + code);
		if (StringUtils.isNotBlank(valuer)) {
			TOLFloor obj = JSON.parseObject(valuer, TOLFloor.class);
			return obj;
		}
		return dao.findByCode(code);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLFloor findByHdUuid(String hdUuid) {
		return dao.findByHdUuid(hdUuid);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLFloor> findAllByCondition(TOLFloor obj) {
		return dao.findAllByCondition(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Pagination<TOLFloor> findAllByConditionPage(TOLFloor obj) {
		return dao.findAllByConditionPage(obj);
	}


	public void saveFloor(TOLFloor obj) {
		obj.setCode(serialCodeService.nextBizId(SerialCodeConstant.OLFLOOR).getNextBizId());
		save(obj);
	}

	public void refreshCache() {
		List<TOLFloor> list = findAll();
		for (TOLFloor obj : list) {
			set2redis(RedisConstant.PREFIX_FLOOR + obj.getCode(), JSON.toJSONString(obj), 2L, TimeUnit.DAYS);
		}
	}
}
