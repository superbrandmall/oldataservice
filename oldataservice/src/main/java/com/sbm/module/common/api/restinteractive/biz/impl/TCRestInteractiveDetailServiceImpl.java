package com.sbm.module.common.api.restinteractive.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.api.restinteractive.biz.ITCRestInteractiveDetailService;
import com.sbm.module.common.api.restinteractive.dao.ITCRestInteractiveDetailDao;
import com.sbm.module.common.api.restinteractive.domain.TCRestInteractiveDetail;
import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
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
@Transactional(value = TransactionConstant.OL, propagation = Propagation.REQUIRES_NEW)
public class TCRestInteractiveDetailServiceImpl extends DaoSupportServiceImpl<TCRestInteractiveDetail> implements
		ITCRestInteractiveDetailService {

	@Autowired
	private ITCRestInteractiveDetailDao dao;

	@Override
	public void save(TCRestInteractiveDetail tcRestInteractiveDetail) {
		super.save(tcRestInteractiveDetail);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TCRestInteractiveDetail> findAll() {
		List<TCRestInteractiveDetail> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TCRestInteractiveDetail findByCondition(TCRestInteractiveDetail obj) {
		return dao.findByCondition(obj);
	}

}
