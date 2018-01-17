package com.sbm.module.onlineleasing.base.shopengineeringspecifications.biz.impl;

import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.base.shopengineeringimages.biz.ITOLShopEngineeringImagesService;
import com.sbm.module.onlineleasing.base.shopengineeringimages.dao.ITOLShopEngineeringImagesDao;
import com.sbm.module.onlineleasing.base.shopengineeringimages.domain.TOLShopEngineeringImages;
import com.sbm.module.onlineleasing.base.shopengineeringspecifications.biz.ITOLShopEngineeringSpecificationsService;
import com.sbm.module.onlineleasing.base.shopengineeringspecifications.dao.ITOLShopEngineeringSpecificationsDao;
import com.sbm.module.onlineleasing.base.shopengineeringspecifications.domain.TOLShopEngineeringSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
public class TOLShopEngineeringSpecificationsServiceImpl extends DaoSupportServiceImpl<TOLShopEngineeringSpecifications> implements ITOLShopEngineeringSpecificationsService {

	@Autowired
	private ITOLShopEngineeringSpecificationsDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLShopEngineeringSpecifications> findAll() {
		List<TOLShopEngineeringSpecifications> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLShopEngineeringSpecifications> findAllByCode(String code) {
		return dao.findAllByCode(code);
	}

}
