package com.sbm.module.onlineleasing.base.bidparam.promotionkind.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.base.bidparam.promotionkind.biz.ITOLBidPromotionKindService;
import com.sbm.module.onlineleasing.base.bidparam.promotionkind.dao.ITOLBidPromotionKindDao;
import com.sbm.module.onlineleasing.base.bidparam.promotionkind.domain.TOLBidPromotionKind;

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
public class TOLBidPromotionKindServiceImpl extends DaoSupportServiceImpl<TOLBidPromotionKind> implements
		ITOLBidPromotionKindService {

	@Autowired
	private ITOLBidPromotionKindDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLBidPromotionKind> findAll() {
		return dao.findAll();
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLBidPromotionKind findByItemNo(Integer itemNo) {
		return dao.findByItemNo(itemNo);
	}

}
