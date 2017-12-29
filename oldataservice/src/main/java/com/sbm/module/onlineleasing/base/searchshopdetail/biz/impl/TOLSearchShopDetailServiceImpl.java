package com.sbm.module.onlineleasing.base.searchshopdetail.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.api.serialcode.constant.SerialCodeConstant;
import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.api.searchshop.domain.SearchShopVo;
import com.sbm.module.onlineleasing.base.searchshopdetail.biz.ITOLSearchShopDetailService;
import com.sbm.module.onlineleasing.base.searchshopdetail.dao.ITOLSearchShopDetailDao;
import com.sbm.module.onlineleasing.base.searchshopdetail.domain.TOLSearchShopDetail;

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
public class TOLSearchShopDetailServiceImpl extends DaoSupportServiceImpl<TOLSearchShopDetail> implements
		ITOLSearchShopDetailService {

	@Autowired
	private ITOLSearchShopDetailDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLSearchShopDetail> findAll() {
		List<TOLSearchShopDetail> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLSearchShopDetail findByCode(String code) {
		return dao.findByCode(code);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLSearchShopDetail findByCondition(TOLSearchShopDetail obj) {
		return dao.findByCondition(obj);
	}

	public void saveSearchShopDetail(TOLSearchShopDetail obj) {
		obj.setCode(serialCodeService.nextBizId(SerialCodeConstant.OLSEARCHSHOP).getNextBizId());
		save(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLSearchShopDetail> findAllBySearchShop(SearchShopVo obj) {
		return dao.findAllBySearchShop(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Pagination<TOLSearchShopDetail> findAllBySearchShopPage(SearchShopVo obj) {
		return dao.findAllBySearchShopPage(obj);
	}

}
