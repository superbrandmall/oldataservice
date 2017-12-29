/**
 * Project Name:posUploadData
 * File Name:IEdiInteractiveDetailDao.java
 * Package Name:com.sbm.module.postsales.dao
 * Date:2016-1-4下午4:41:20
 * Copyright (c) 2016, Super Brand Mail Inc All Rights Reserved.
 *
 */

package com.sbm.module.onlineleasing.base.tempparam.dao;

import com.sbm.module.common.business.dao.IBaseHibernateDao;
import com.sbm.module.onlineleasing.base.bidparam.rentmethod.domain.TOLBidRentMethod;
import com.sbm.module.onlineleasing.base.tempparam.domain.TOLTempParam;

import java.util.List;

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
public interface ITOLTempParamDao extends IBaseHibernateDao<TOLTempParam> {

	public List<TOLTempParam> findAll();

	public TOLTempParam findByParamAndKey(String param, Integer key);

	public TOLTempParam findByParamAndValue(String param, String value);
}
