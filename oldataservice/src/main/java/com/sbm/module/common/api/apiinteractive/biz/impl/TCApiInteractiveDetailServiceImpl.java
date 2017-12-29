package com.sbm.module.common.api.apiinteractive.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.api.apiinteractive.biz.ITCApiInteractiveDetailService;
import com.sbm.module.common.api.apiinteractive.dao.ITCApiInteractiveDetailDao;
import com.sbm.module.common.api.apiinteractive.domain.TCApiInteractiveDetail;
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
public class TCApiInteractiveDetailServiceImpl extends DaoSupportServiceImpl<TCApiInteractiveDetail> implements
		ITCApiInteractiveDetailService {

	@Autowired
	private ITCApiInteractiveDetailDao dao;

	@Override
	public void save(TCApiInteractiveDetail tcApiInteractiveDetail) {
		super.save(tcApiInteractiveDetail);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TCApiInteractiveDetail> findAll() {
		List<TCApiInteractiveDetail> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TCApiInteractiveDetail findByCondition(TCApiInteractiveDetail obj) {
		return dao.findByCondition(obj);
	}

}
