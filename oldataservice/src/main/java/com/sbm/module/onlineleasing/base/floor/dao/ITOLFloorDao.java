/**
 * Project Name:posUploadData
 * File Name:IEdiInteractiveDetailDao.java
 * Package Name:com.sbm.module.postsales.dao
 * Date:2016-1-4下午4:41:20
 * Copyright (c) 2016, Super Brand Mail Inc All Rights Reserved.
 *
 */

package com.sbm.module.onlineleasing.base.floor.dao;

import java.util.List;

import com.sbm.module.common.business.dao.IBaseHibernateDao;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.building.domain.TOLBuilding;
import com.sbm.module.onlineleasing.base.floor.domain.TOLFloor;

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
public interface ITOLFloorDao extends IBaseHibernateDao<TOLFloor> {

	List<TOLFloor> findAll();

	List<TOLFloor> findAllByBuildingCode(String buildingCode);

	List<TOLFloor> findAllByBuildingCodesAndDescription(List<String> buildingCodes, String description);

	TOLFloor findByCode(String code);

	TOLFloor findByHdUuid(String hdUuid);

	List<TOLFloor> findAllByCondition(TOLFloor obj);

	Pagination<TOLFloor> findAllByConditionPage(TOLFloor obj);
}
