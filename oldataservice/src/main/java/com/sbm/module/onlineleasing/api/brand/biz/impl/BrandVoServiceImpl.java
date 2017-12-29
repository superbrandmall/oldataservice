package com.sbm.module.onlineleasing.api.brand.biz.impl;

import com.sbm.module.onlineleasing.api.brand.domain.BrandVo;
import com.sbm.module.onlineleasing.api.building.domain.BuildingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.api.brand.biz.IBrandVoService;
import com.sbm.module.onlineleasing.base.brand.biz.ITOLBrandService;
import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;

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
public class BrandVoServiceImpl extends BusinessServiceImpl implements IBrandVoService {

	@Autowired
	private ITOLBrandService brandService;

	@Override
	public void findAllByConditionPage(BrandVo vo) {
		vo.setPagination(brandService.findAllByConditionPage(vo.getBrand()));
	}

	@Override
	public void findByCode(BrandVo vo) {
		vo.setBrand(brandService.findByCode(vo.getBrand().getCode()));
	}

}
