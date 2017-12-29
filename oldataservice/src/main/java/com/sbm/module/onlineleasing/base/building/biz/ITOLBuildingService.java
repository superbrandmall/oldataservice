package com.sbm.module.onlineleasing.base.building.biz;

import java.util.List;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.building.domain.TOLBuilding;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/
/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.biz<br/>
 * File Name:IEdiInteractiveDetailService.java<br/>
 * 
 * 作成日 ：2016-1-4 下午5:05:39 <br/>
 * 
 * @author ：junkai.zhang
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
public interface ITOLBuildingService extends IDaoSupportService<TOLBuilding> {

	List<TOLBuilding> findAll();

	List<TOLBuilding> findAllByMallCode(String mallCode);

	TOLBuilding findByCode(String code);

	TOLBuilding findByHdUuid(String hdUuid);

	List<TOLBuilding> findAllByCondition(TOLBuilding obj);

	Pagination<TOLBuilding> findAllByConditionPage(TOLBuilding obj);

	/**
	 * 
	 * saveBuilding:保存building
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	void saveBuilding(TOLBuilding obj);

	/**
	 * 
	 * refreshCache:更新缓存
	 * 
	 * @author junkai.zhang
	 */
	void refreshCache();

}
