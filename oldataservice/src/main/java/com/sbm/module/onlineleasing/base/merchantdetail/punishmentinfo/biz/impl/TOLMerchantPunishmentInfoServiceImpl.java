package com.sbm.module.onlineleasing.base.merchantdetail.punishmentinfo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.merchantdetail.punishmentinfo.biz.ITOLMerchantPunishmentInfoService;
import com.sbm.module.onlineleasing.base.merchantdetail.punishmentinfo.dao.ITOLMerchantPunishmentInfoDao;
import com.sbm.module.onlineleasing.base.merchantdetail.punishmentinfo.domain.TOLMerchantPunishmentInfo;

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
public class TOLMerchantPunishmentInfoServiceImpl extends DaoSupportServiceImpl<TOLMerchantPunishmentInfo> implements
		ITOLMerchantPunishmentInfoService {

	@Autowired
	private ITOLMerchantPunishmentInfoDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLMerchantPunishmentInfo> findAll() {
		List<TOLMerchantPunishmentInfo> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLMerchantPunishmentInfo> findAllByCondition(TOLMerchantPunishmentInfo obj) {
		return dao.findAllByCondition(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Pagination<TOLMerchantPunishmentInfo> findAllByConditionPage(TOLMerchantPunishmentInfo obj) {
		return dao.findAllByConditionPage(obj);
	}

	public void deleteByCode(String code) {
		dao.deleteByCode(code);
	}
}
