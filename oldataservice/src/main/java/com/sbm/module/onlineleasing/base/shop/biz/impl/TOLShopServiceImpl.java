package com.sbm.module.onlineleasing.base.shop.biz.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.redis.constant.RedisConstant;
import com.sbm.module.common.api.serialcode.constant.SerialCodeConstant;
import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.api.searchshop.domain.SearchShopVo;
import com.sbm.module.onlineleasing.base.shop.biz.ITOLShopService;
import com.sbm.module.onlineleasing.base.shop.dao.ITOLShopDao;
import com.sbm.module.onlineleasing.base.shop.domain.TOLShop;

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
public class TOLShopServiceImpl extends DaoSupportServiceImpl<TOLShop> implements ITOLShopService {

	@Autowired
	private ITOLShopDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLShop> findAll() {
		List<TOLShop> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLShop findByCode(String code) {
		// 因为商铺会修改，暂不入缓存
		/*
		 * String valuer = (String) redisService.get(RedisConstant.PREFIX_SHOP +
		 * code); if (StringUtils.isNotBlank(valuer)) { TOLShop obj =
		 * JSON.parseObject(valuer, TOLShop.class); return obj; }
		 */
		return dao.findByCode(code);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLShop findByHdUuid(String hdUuid) {
		return dao.findByHdUuid(hdUuid);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLShop> findAllByCondition(TOLShop obj) {
		return dao.findAllByCondition(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Pagination<TOLShop> findAllByConditionPage(TOLShop obj) {
		return dao.findAllByConditionPage(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLShop> findAllByFloorCode(String floorCode) {
		return dao.findAllByFloorCode(floorCode);
	}

	public void saveShop(TOLShop obj) {
		obj.setCode(serialCodeService.nextBizId(SerialCodeConstant.OLSHOP).getNextBizId());
		save(obj);
	}

	public void refreshCache() {
		List<TOLShop> list = findAll();
		for (TOLShop obj : list) {
			set2redis(RedisConstant.PREFIX_SHOP + obj.getCode(), JSON.toJSONString(obj), 2L, TimeUnit.DAYS);
		}
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLShop findByCondition(TOLShop obj) {
		return dao.findByCondition(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLShop> findAllBySearchShop(SearchShopVo vo) {
		return dao.findAllBySearchShop(vo);
	}

	public void checkShopState(TOLShop obj) {

	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLShop> findCountGroupByMall(String mallCode) {
		return dao.findCountGroupByMall(mallCode);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLShop> findCountGroupByFloor(String floorCode) {
		return dao.findCountGroupByFloor(floorCode);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLShop> findCountGroupByMallBuildingFloor(String mallCode, String buildingCode, String floorCode) {
		return dao.findCountGroupByMallBuildingFloor(mallCode, buildingCode, floorCode);
	}
}
