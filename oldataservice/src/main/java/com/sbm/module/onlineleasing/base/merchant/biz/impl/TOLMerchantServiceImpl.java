package com.sbm.module.onlineleasing.base.merchant.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.api.serialcode.constant.SerialCodeConstant;
import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.merchant.biz.ITOLMerchantService;
import com.sbm.module.onlineleasing.base.merchant.dao.ITOLMerchantDao;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;

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
public class TOLMerchantServiceImpl extends DaoSupportServiceImpl<TOLMerchant> implements ITOLMerchantService {

	@Autowired
	private ITOLMerchantDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLMerchant> findAll() {
		List<TOLMerchant> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLMerchant findByCode(String code) {
		return dao.findByCode(code);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLMerchant findByHdUuid(String hdUuid) {
		return dao.findByHdUuid(hdUuid);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLMerchant findByUscc(String uscc) {
		return dao.findByUscc(uscc);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLMerchant> findAllByCondition(TOLMerchant obj) {
		return dao.findAllByCondition(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Pagination<TOLMerchant> findAllByConditionPage(TOLMerchant obj) {
		return dao.findAllByConditionPage(obj);
	}

	public void saveMerchant(TOLMerchant obj) {
		obj.setCode(serialCodeService.nextBizId(SerialCodeConstant.OLMERCHANT).getNextBizId());
		save(obj);
	}

}
