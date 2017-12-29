package com.sbm.module.onlineleasing.base.modality.biz.impl;

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
import com.sbm.module.onlineleasing.base.modality.biz.ITOLModalityService;
import com.sbm.module.onlineleasing.base.modality.constant.ModalityConstant;
import com.sbm.module.onlineleasing.base.modality.dao.ITOLModalityDao;
import com.sbm.module.onlineleasing.base.modality.domain.TOLModality;

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
public class TOLModalityServiceImpl extends DaoSupportServiceImpl<TOLModality> implements ITOLModalityService {

	@Autowired
	private ITOLModalityDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLModality> findAll() {
		List<TOLModality> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLModality> findAllByLvAndCode(String lv, String code) {
		List<TOLModality> list = dao.findAllByLvAndCode(lv, code);
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLModality> findModalityList() {
		// 一级业态
		List<TOLModality> lv1s = findAllByLvAndCode(ModalityConstant.LV_1, null);
		for (TOLModality lv1 : lv1s) {
			// 二级业态
			List<TOLModality> lv2s = findAllByLvAndCode(ModalityConstant.LV_2, lv1.getCode());
			for (TOLModality lv2 : lv2s) {
				// 三级业态
				List<TOLModality> lv3s = findAllByLvAndCode(ModalityConstant.LV_3, lv2.getCode());
				for (TOLModality lv3 : lv3s) {
					// 四级业态
					List<TOLModality> lv4s = findAllByLvAndCode(ModalityConstant.LV_4, lv3.getCode());
					lv3.setList(lv4s);
				}
				lv2.setList(lv3s);
			}
			lv1.setList(lv2s);
		}
		return lv1s;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLModality findByCode(String code, boolean cacheFlag) {
		if (cacheFlag) {
			String valuer = (String) redisService.get(RedisConstant.PREFIX_MODALITY + code);
			if (StringUtils.isNotBlank(valuer)) {
				TOLModality obj = JSON.parseObject(valuer, TOLModality.class);
				return obj;
			}
		}
		return dao.findByCode(code);
	}

	/********************************************************************/
	// 缓存

	public void refreshCache() {
		single();
		modalityList();
	}

	// 单条缓存
	private void single() {
		List<TOLModality> list = findAll();
		for (TOLModality obj : list) {
			set2redis(RedisConstant.PREFIX_MODALITY + obj.getCode(), JSON.toJSONString(obj), 2L, TimeUnit.DAYS);
		}
	}

	// 业态列表
	private void modalityList() {
		List<TOLModality> lvs = findModalityList();
		set2redis(RedisConstant.MODALITY_LIST, JSON.toJSONString(lvs), 2L, TimeUnit.DAYS);
	}

	/********************************************************************/

	public String getModalityName(TOLModality obj) {
		if (null != obj) {
			String name = StringUtils.isBlank(obj.getName()) ? StringUtils.EMPTY : obj.getName();
			return name;
		} else {
			return StringUtils.EMPTY;
		}
	}

	public List<TOLModality> getModalityList() {
		String valuer = (String) redisService.get(RedisConstant.MODALITY_LIST);
		if (StringUtils.isNotBlank(valuer)) {
			List<TOLModality> obj = JSON.parseArray(valuer, TOLModality.class);
			return obj;
		}
		return findModalityList();
	}
}
