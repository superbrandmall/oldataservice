package com.sbm.module.partner.hd.view.acctype.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.partner.hd.view.acctype.biz.IAcctypeService;
import com.sbm.module.partner.hd.view.acctype.dao.IAcctypeDao;
import com.sbm.module.partner.hd.view.acctype.domain.Acctype;
import com.sbm.module.partner.hd.view.base.biz.impl.HdDaoSupportServiceImpl;

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
public class AcctypeServiceImpl extends HdDaoSupportServiceImpl<Acctype> implements IAcctypeService {

	@Autowired
	private IAcctypeDao dao;

	@Transactional(value = TransactionConstant.HD, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<Acctype> findAll() {
		return dao.findAll();
	}

	@Transactional(value = TransactionConstant.HD, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Acctype findByItemno(Integer itemno) {
		return dao.findByItemno(itemno);
	}

}
