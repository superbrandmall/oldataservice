package com.sbm.module.onlineleasing.base.floor.biz;

import java.util.List;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.building.domain.TOLBuilding;
import com.sbm.module.onlineleasing.base.floor.domain.TOLFloor;

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
public interface ITOLFloorService extends IDaoSupportService<TOLFloor> {

	List<TOLFloor> findAll();

	List<TOLFloor> findAllByBuildingCode(String buildingCode);

	List<TOLFloor> findAllByBuildingCodesAndDescription(List<String> buildingCodes, String description);

	TOLFloor findByCode(String code);
	
	TOLFloor findByHdUuid(String hdUuid);

	List<TOLFloor> findAllByCondition(TOLFloor obj);

	Pagination<TOLFloor> findAllByConditionPage(TOLFloor obj);

	/**
	 * 
	 * saveFloor:保存floor
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	void saveFloor(TOLFloor obj);

	/**
	 * 
	 * refreshCache:更新缓存
	 * 
	 * @author junkai.zhang
	 */
	void refreshCache();

}
