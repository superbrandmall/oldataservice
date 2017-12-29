package com.sbm.module.onlineleasing.base.malltraffic.biz.impl;

import java.util.List;

import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.base.malltraffic.biz.ITOLMallTrafficService;
import com.sbm.module.onlineleasing.base.malltraffic.dao.ITOLMallTrafficDao;
import com.sbm.module.onlineleasing.base.malltraffic.domain.TOLMallTraffic;

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
public class TOLMallTrafficServiceImpl extends DaoSupportServiceImpl<TOLMallTraffic> implements ITOLMallTrafficService {

	@Autowired
	private ITOLMallTrafficDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLMallTraffic> findAll() {
		List<TOLMallTraffic> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLMallTraffic> findAllByCode(String code) {
		return dao.findAllByCode(code);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLMallTraffic> findAllByCondition(TOLMallTraffic obj) {
		return dao.findAllByCondition(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Pagination<TOLMallTraffic> findAllByConditionPage(TOLMallTraffic obj) {
		return dao.findAllByConditionPage(obj);
	}
}
