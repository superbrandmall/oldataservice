package com.sbm.module.onlineleasing.base.merchantdetail.illegalinfo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.merchantdetail.illegalinfo.biz.ITOLMerchantIllegalInfoService;
import com.sbm.module.onlineleasing.base.merchantdetail.illegalinfo.dao.ITOLMerchantIllegalInfoDao;
import com.sbm.module.onlineleasing.base.merchantdetail.illegalinfo.domain.TOLMerchantIllegalInfo;

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
public class TOLMerchantIllegalInfoServiceImpl extends DaoSupportServiceImpl<TOLMerchantIllegalInfo>
		implements ITOLMerchantIllegalInfoService {

	@Autowired
	private ITOLMerchantIllegalInfoDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLMerchantIllegalInfo> findAll() {
		List<TOLMerchantIllegalInfo> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLMerchantIllegalInfo> findAllByCondition(TOLMerchantIllegalInfo obj) {
		return dao.findAllByCondition(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Pagination<TOLMerchantIllegalInfo> findAllByConditionPage(TOLMerchantIllegalInfo obj) {
		return dao.findAllByConditionPage(obj);
	}

	public void deleteByCode(String code) {
		dao.deleteByCode(code);
	}
}
