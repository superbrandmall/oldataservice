package com.sbm.module.onlineleasing.base.bidparam.leasetermname.biz.impl;

import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.base.bidparam.leasemodule.biz.ITOLBidLeasemoduleService;
import com.sbm.module.onlineleasing.base.bidparam.leasemodule.dao.ITOLBidLeasemoduleDao;
import com.sbm.module.onlineleasing.base.bidparam.leasemodule.domain.TOLBidLeasemodule;
import com.sbm.module.onlineleasing.base.bidparam.leasetermname.biz.ITOLBidLeasetermnameService;
import com.sbm.module.onlineleasing.base.bidparam.leasetermname.dao.ITOLBidLeasetermnameDao;
import com.sbm.module.onlineleasing.base.bidparam.leasetermname.domain.TOLBidLeasetermname;
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
@Transactional(value = TransactionConstant.OL, propagation = Propagation.REQUIRED)
public class TOLBidLeasetermnameServiceImpl extends DaoSupportServiceImpl<TOLBidLeasetermname> implements
		ITOLBidLeasetermnameService {

	@Autowired
	private ITOLBidLeasetermnameDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLBidLeasetermname> findAll() {
		return dao.findAll();
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLBidLeasetermname findByItemNo(Integer itemNo) {
		return dao.findByItemNo(itemNo);
	}

}
