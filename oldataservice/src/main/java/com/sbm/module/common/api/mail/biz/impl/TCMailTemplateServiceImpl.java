package com.sbm.module.common.api.mail.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.api.mail.biz.ITCMailTemplateService;
import com.sbm.module.common.api.mail.dao.ITCMailTemplateDao;
import com.sbm.module.common.api.mail.domain.TCMailTemplate;
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
public class TCMailTemplateServiceImpl extends DaoSupportServiceImpl<TCMailTemplate> implements ITCMailTemplateService {

	@Autowired
	private ITCMailTemplateDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TCMailTemplate> findAll() {
		List<TCMailTemplate> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TCMailTemplate findByCode(String code) {
		return dao.findByCode(code);
	}

	public void saveMailTemplate(TCMailTemplate obj) {
		obj.setCode(serialCodeService.nextBizId(SerialCodeConstant.CMAILTEMP).getNextBizId());
		save(obj);
	}

}
