package com.sbm.module.partner.hd.view.floor.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.partner.hd.view.base.biz.impl.HdDaoSupportServiceImpl;
import com.sbm.module.partner.hd.view.floor.biz.IFloorService;
import com.sbm.module.partner.hd.view.floor.dao.IFloorDao;
import com.sbm.module.partner.hd.view.floor.domain.Floor;

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
@Transactional(value = TransactionConstant.HD, propagation = Propagation.REQUIRED)
public class FloorServiceImpl extends HdDaoSupportServiceImpl<Floor> implements IFloorService {

	@Autowired
	private IFloorDao dao;

	@Transactional(value = TransactionConstant.HD, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<Floor> findAll() {
		return dao.findAll();
	}

	@Transactional(value = TransactionConstant.HD, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Floor findByUuid(String hdUuid) {
		return dao.findByUuid(hdUuid);
	}

}
