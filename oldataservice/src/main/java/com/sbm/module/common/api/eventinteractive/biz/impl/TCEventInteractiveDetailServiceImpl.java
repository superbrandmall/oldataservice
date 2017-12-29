package com.sbm.module.common.api.eventinteractive.biz.impl;

import com.sbm.module.common.api.eventinteractive.biz.ITCEventInteractiveDetailService;
import com.sbm.module.common.api.eventinteractive.dao.ITCEventInteractiveDetailDao;
import com.sbm.module.common.api.eventinteractive.domain.TCEventInteractiveDetail;
import com.sbm.module.common.api.jobinteractive.biz.ITCJobInteractiveDetailService;
import com.sbm.module.common.api.jobinteractive.dao.ITCJobInteractiveDetailDao;
import com.sbm.module.common.api.jobinteractive.domain.TCJobInteractiveDetail;
import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
public class TCEventInteractiveDetailServiceImpl extends DaoSupportServiceImpl<TCEventInteractiveDetail> implements
		ITCEventInteractiveDetailService {

	@Autowired
	private ITCEventInteractiveDetailDao dao;

	@Override
	public void save(TCEventInteractiveDetail tcEventInteractiveDetail) {
		super.save(tcEventInteractiveDetail);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TCEventInteractiveDetail> findAll() {
		List<TCEventInteractiveDetail> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TCEventInteractiveDetail findByCondition(TCEventInteractiveDetail obj) {
		return dao.findByCondition(obj);
	}

}
