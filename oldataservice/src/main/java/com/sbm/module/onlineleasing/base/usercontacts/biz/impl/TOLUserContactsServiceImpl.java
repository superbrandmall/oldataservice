package com.sbm.module.onlineleasing.base.usercontacts.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.base.usercontacts.biz.ITOLUserContactsService;
import com.sbm.module.onlineleasing.base.usercontacts.dao.ITOLUserContactsDao;
import com.sbm.module.onlineleasing.base.usercontacts.domain.TOLUserContacts;

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
public class TOLUserContactsServiceImpl extends DaoSupportServiceImpl<TOLUserContacts> implements
		ITOLUserContactsService {

	@Autowired
	private ITOLUserContactsDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLUserContacts> findAll() {
		return dao.findAll();
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLUserContacts findByCode(String code) {
		return dao.findByCode(code);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLUserContacts findByIdCard(String idCard) {
		return dao.findByIdCard(idCard);
	}

}
