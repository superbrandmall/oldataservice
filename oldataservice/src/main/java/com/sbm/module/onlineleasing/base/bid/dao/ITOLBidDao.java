/**
 * Project Name:posUploadData
 * File Name:IEdiInteractiveDetailDao.java
 * Package Name:com.sbm.module.postsales.dao
 * Date:2016-1-4下午4:41:20
 * Copyright (c) 2016, Super Brand Mail Inc All Rights Reserved.
 *
 */

package com.sbm.module.onlineleasing.base.bid.dao;

import java.util.List;

import com.sbm.module.common.business.dao.IBaseHibernateDao;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.bid.domain.TOLBid;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/
/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.dao<br/>
 * File Name:IEdiInteractiveDetailDao.java<br/>
 * 
 * 作成日 ：2016-1-4 下午4:41:20 <br/>
 * 
 * @author ：junkai.zhang
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
public interface ITOLBidDao extends IBaseHibernateDao<TOLBid> {

	List<TOLBid> findAll();

	TOLBid findByCode(String code);

	TOLBid findByBillNumber(String billNumber);

	List<TOLBid> findAllByUserCodeAndApprove(TOLBid obj);

	Pagination<TOLBid> findAllByUserCodeAndApprovePage(TOLBid obj);

	List<TOLBid> findAllBeforeNonStandardSubmit(String shopCode);

	List<TOLBid> findAllByCondition(TOLBid obj);

	Pagination<TOLBid> findAllByConditionPage(TOLBid obj);
}
