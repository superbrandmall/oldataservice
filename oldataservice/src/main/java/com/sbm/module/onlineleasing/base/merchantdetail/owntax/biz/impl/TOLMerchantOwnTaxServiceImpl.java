package com.sbm.module.onlineleasing.base.merchantdetail.owntax.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.merchantdetail.owntax.biz.ITOLMerchantOwnTaxService;
import com.sbm.module.onlineleasing.base.merchantdetail.owntax.dao.ITOLMerchantOwnTaxDao;
import com.sbm.module.onlineleasing.base.merchantdetail.owntax.domain.TOLMerchantOwnTax;

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
public class TOLMerchantOwnTaxServiceImpl extends DaoSupportServiceImpl<TOLMerchantOwnTax> implements
		ITOLMerchantOwnTaxService {

	@Autowired
	private ITOLMerchantOwnTaxDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLMerchantOwnTax> findAll() {
		List<TOLMerchantOwnTax> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLMerchantOwnTax> findAllByCondition(TOLMerchantOwnTax obj) {
		return dao.findAllByCondition(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Pagination<TOLMerchantOwnTax> findAllByConditionPage(TOLMerchantOwnTax obj) {
		return dao.findAllByConditionPage(obj);
	}

	public void deleteByCode(String code) {
		dao.deleteByCode(code);
	}
}
