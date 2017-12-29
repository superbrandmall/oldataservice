package com.sbm.module.onlineleasing.base.shopcoords.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.base.shopcoords.biz.ITOLShopCoordsService;
import com.sbm.module.onlineleasing.base.shopcoords.dao.ITOLShopCoordsDao;
import com.sbm.module.onlineleasing.base.shopcoords.domain.TOLShopCoords;

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
public class TOLShopCoordsServiceImpl extends DaoSupportServiceImpl<TOLShopCoords> implements ITOLShopCoordsService {

	@Autowired
	private ITOLShopCoordsDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLShopCoords> findAll() {
		List<TOLShopCoords> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLShopCoords findByCode(String code) {
		return dao.findByCode(code);
	}


	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLShopCoords findByCondition(TOLShopCoords obj) {
		return dao.findByCondition(obj);
	}

}
