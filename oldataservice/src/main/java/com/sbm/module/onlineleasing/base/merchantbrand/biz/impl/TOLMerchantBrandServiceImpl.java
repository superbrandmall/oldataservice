package com.sbm.module.onlineleasing.base.merchantbrand.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.base.merchantbrand.biz.ITOLMerchantBrandService;
import com.sbm.module.onlineleasing.base.merchantbrand.dao.ITOLMerchantBrandDao;
import com.sbm.module.onlineleasing.base.merchantbrand.domain.TOLMerchantBrand;

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
public class TOLMerchantBrandServiceImpl extends DaoSupportServiceImpl<TOLMerchantBrand> implements
		ITOLMerchantBrandService {

	@Autowired
	private ITOLMerchantBrandDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLMerchantBrand> findAll() {
		List<TOLMerchantBrand> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLMerchantBrand> findAllByMerchantCode(String merchantCode) {
		return dao.findAllByMerchantCode(merchantCode);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLMerchantBrand> findAllByBrandCode(String brandCode) {
		return dao.findAllByBrandCode(brandCode);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLMerchantBrand findByMerchantCodeAndBrandCode(String merchantCode, String brandCode) {
		return dao.findByMerchantCodeAndBrandCode(merchantCode, brandCode);
	}

}
