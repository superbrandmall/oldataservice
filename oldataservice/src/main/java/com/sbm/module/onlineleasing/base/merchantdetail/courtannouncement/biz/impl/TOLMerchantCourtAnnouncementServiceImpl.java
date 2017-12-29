package com.sbm.module.onlineleasing.base.merchantdetail.courtannouncement.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.merchantdetail.courtannouncement.biz.ITOLMerchantCourtAnnouncementService;
import com.sbm.module.onlineleasing.base.merchantdetail.courtannouncement.dao.ITOLMerchantCourtAnnouncementDao;
import com.sbm.module.onlineleasing.base.merchantdetail.courtannouncement.domain.TOLMerchantCourtAnnouncement;

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
public class TOLMerchantCourtAnnouncementServiceImpl extends DaoSupportServiceImpl<TOLMerchantCourtAnnouncement>
		implements ITOLMerchantCourtAnnouncementService {

	@Autowired
	private ITOLMerchantCourtAnnouncementDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLMerchantCourtAnnouncement> findAll() {
		List<TOLMerchantCourtAnnouncement> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLMerchantCourtAnnouncement> findAllByCondition(TOLMerchantCourtAnnouncement obj) {
		return dao.findAllByCondition(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Pagination<TOLMerchantCourtAnnouncement> findAllByConditionPage(TOLMerchantCourtAnnouncement obj) {
		return dao.findAllByConditionPage(obj);
	}

	public void deleteByCode(String code) {
		dao.deleteByCode(code);
	}
}
