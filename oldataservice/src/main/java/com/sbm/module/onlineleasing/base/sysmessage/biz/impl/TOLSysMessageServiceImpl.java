package com.sbm.module.onlineleasing.base.sysmessage.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.api.serialcode.constant.SerialCodeConstant;
import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.sysmessage.biz.ITOLSysMessageService;
import com.sbm.module.onlineleasing.base.sysmessage.constant.SysMessageConstant;
import com.sbm.module.onlineleasing.base.sysmessage.dao.ITOLSysMessageDao;
import com.sbm.module.onlineleasing.base.sysmessage.domain.TOLSysMessage;

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
public class TOLSysMessageServiceImpl extends DaoSupportServiceImpl<TOLSysMessage> implements ITOLSysMessageService {

	@Autowired
	private ITOLSysMessageDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLSysMessage> findAll() {
		List<TOLSysMessage> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLSysMessage findByCondition(TOLSysMessage obj) {
		return dao.findByCondition(obj);
	}

	public void sendSysMessage(TOLSysMessage obj) {
		obj.setCode(serialCodeService.nextBizId(SerialCodeConstant.OLSYSMESSAGE).getNextBizId());
		obj.setType(SysMessageConstant.UNREAD);
		save(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLSysMessage> findAllByUserCodeAndType(TOLSysMessage obj) {
		return dao.findAllByUserCodeAndType(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Pagination<TOLSysMessage> findAllByUserCodeAndTypePage(TOLSysMessage obj) {
		return dao.findAllByUserCodeAndTypePage(obj);
	}
}
