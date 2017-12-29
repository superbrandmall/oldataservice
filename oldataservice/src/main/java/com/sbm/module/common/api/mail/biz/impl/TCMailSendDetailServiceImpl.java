package com.sbm.module.common.api.mail.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.api.mail.biz.ITCMailSendDetailService;
import com.sbm.module.common.api.mail.dao.ITCMailSendDetailDao;
import com.sbm.module.common.api.mail.domain.TCMailSendDetail;
import com.sbm.module.common.api.serialcode.constant.SerialCodeConstant;
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
@Transactional(value = TransactionConstant.OL, propagation = Propagation.REQUIRED)
public class TCMailSendDetailServiceImpl extends DaoSupportServiceImpl<TCMailSendDetail> implements
		ITCMailSendDetailService {

	@Autowired
	private ITCMailSendDetailDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TCMailSendDetail> findAll() {
		List<TCMailSendDetail> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TCMailSendDetail findByCode(String code) {
		return dao.findByCode(code);
	}

	public void saveMailSendDetail(TCMailSendDetail obj) {
		obj.setCode(serialCodeService.nextBizId(SerialCodeConstant.CMAILDETAIL).getNextBizId());
		save(obj);
	}

}
