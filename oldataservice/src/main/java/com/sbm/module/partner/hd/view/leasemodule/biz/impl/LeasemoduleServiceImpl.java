package com.sbm.module.partner.hd.view.leasemodule.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.partner.hd.view.base.biz.impl.HdDaoSupportServiceImpl;
import com.sbm.module.partner.hd.view.leasemodule.biz.ILeasemoduleService;
import com.sbm.module.partner.hd.view.leasemodule.dao.ILeasemoduleDao;
import com.sbm.module.partner.hd.view.leasemodule.domain.Leasemodule;

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
@Transactional(value = TransactionConstant.HD, propagation = Propagation.REQUIRED)
public class LeasemoduleServiceImpl extends HdDaoSupportServiceImpl<Leasemodule> implements ILeasemoduleService {

	@Autowired
	private ILeasemoduleDao dao;

	@Transactional(value = TransactionConstant.HD, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<Leasemodule> findAll() {
		return dao.findAll();
	}

	@Transactional(value = TransactionConstant.HD, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Leasemodule findByItemno(Integer itemno) {
		return dao.findByItemno(itemno);
	}

}
