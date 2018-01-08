package com.sbm.module.onlineleasing.api.admin.floor.biz.impl;

import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.admin.floor.biz.IFloorVoService;
import com.sbm.module.onlineleasing.api.admin.floor.domain.FloorVo;
import com.sbm.module.onlineleasing.base.floor.biz.ITOLFloorService;
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
public class FloorVoServiceImpl extends BusinessServiceImpl implements IFloorVoService {

	@Autowired
	private ITOLFloorService floorService;

	@Override
	public void findAllByConditionPage(FloorVo vo) {
		vo.setPagination(floorService.findAllByConditionPage(vo.getFloor()));
	}

	@Override
	public void findByCode(FloorVo vo) {
		vo.setFloor(floorService.findByCode(vo.getFloor().getCode()));
	}
}
