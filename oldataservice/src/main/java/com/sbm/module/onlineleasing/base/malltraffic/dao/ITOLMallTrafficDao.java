/**
 * Project Name:posUploadData
 * File Name:IEdiInteractiveDetailDao.java
 * Package Name:com.sbm.module.postsales.dao
 * Date:2016-1-4下午4:41:20
 * Copyright (c) 2016, Super Brand Mail Inc All Rights Reserved.
 *
 */

package com.sbm.module.onlineleasing.base.malltraffic.dao;

import java.util.List;

import com.sbm.module.common.business.dao.IBaseHibernateDao;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;
import com.sbm.module.onlineleasing.base.malltraffic.domain.TOLMallTraffic;

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
public interface ITOLMallTrafficDao extends IBaseHibernateDao<TOLMallTraffic> {

	List<TOLMallTraffic> findAll();

	List<TOLMallTraffic> findAllByCode(String code);

	List<TOLMallTraffic> findAllByCondition(TOLMallTraffic obj);

	Pagination<TOLMallTraffic> findAllByConditionPage(TOLMallTraffic obj);
}
