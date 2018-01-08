package com.sbm.module.onlineleasing.api.admin.building.biz.impl;

import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.admin.building.biz.IBuildingVoService;
import com.sbm.module.onlineleasing.api.admin.building.domain.BuildingVo;
import com.sbm.module.onlineleasing.base.building.biz.ITOLBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
public class BuildingVoServiceImpl extends BusinessServiceImpl implements IBuildingVoService {

	@Autowired
	private ITOLBuildingService buildingService;

	@Override
	public void findAllByConditionPage(BuildingVo vo) {
		vo.setPagination(buildingService.findAllByConditionPage(vo.getBuilding()));
	}

	@Override
	public void findByCode(BuildingVo vo) {
		vo.setBuilding(buildingService.findByCode(vo.getBuilding().getCode()));
	}
}
