package com.sbm.module.onlineleasing.base.bid.biz.impl;

import java.util.List;

import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.api.serialcode.constant.SerialCodeConstant;
import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.bid.biz.ITOLBidService;
import com.sbm.module.onlineleasing.base.bid.dao.ITOLBidDao;
import com.sbm.module.onlineleasing.base.bid.domain.TOLBid;

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
public class TOLBidServiceImpl extends DaoSupportServiceImpl<TOLBid> implements ITOLBidService {

	@Autowired
	private ITOLBidDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLBid> findAll() {
		List<TOLBid> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLBid findByCode(String code) {
		return dao.findByCode(code);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLBid findByBillNumber(String billNumber) {
		return dao.findByBillNumber(billNumber);
	}

	public void saveBid(TOLBid obj) {
		obj.setCode(serialCodeService.nextBizId(SerialCodeConstant.OLBID).getNextBizId());
		save(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLBid> findAllByUserCodeAndApprove(TOLBid obj) {
		return dao.findAllByUserCodeAndApprove(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Pagination<TOLBid> findAllByUserCodeAndApprovePage(TOLBid obj) {
		return dao.findAllByUserCodeAndApprovePage(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLBid> findAllBeforeNonStandardSubmit(String shopCode){
		return dao.findAllBeforeNonStandardSubmit(shopCode);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLBid> findAllByCondition(TOLBid obj) {
		return dao.findAllByCondition(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Pagination<TOLBid> findAllByConditionPage(TOLBid obj) {
		return dao.findAllByConditionPage(obj);
	}
}
