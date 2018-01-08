package com.sbm.module.onlineleasing.api.admin.shop.biz.impl;

import com.sbm.module.common.business.util.ParamsUtil;
import com.sbm.module.onlineleasing.api.admin.shop.domain.ShopVo;
import com.sbm.module.onlineleasing.base.shopcoords.biz.ITOLShopCoordsService;
import com.sbm.module.onlineleasing.base.shopimages.biz.ITOLShopImagesService;
import com.sbm.module.onlineleasing.base.shopimages.domain.TOLShopImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.admin.shop.biz.IShopVoService;
import com.sbm.module.onlineleasing.base.shop.biz.ITOLShopService;

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
public class ShopVoServiceImpl extends BusinessServiceImpl implements IShopVoService {

	@Autowired
	private ITOLShopService shopService;
	@Autowired
	private ITOLShopImagesService shopImagesService;
	@Autowired
	private ITOLShopCoordsService shopCoordsService;

	/******************************************************************************************/

	@Override
	public void findAllByConditionPage(ShopVo vo) {
		vo.setPagination(shopService.findAllByConditionPage(vo.getShop()));
	}

	/******************************************************************************************/

	@Override
	public void findByCode(ShopVo vo) {
		vo.setShop(shopService.findByCode(vo.getShop().getCode()));
		if (null != vo.getShop()) {
			vo.setImages(shopImagesService.findAllByCode(vo.getShop().getCode()));
			vo.setCoords(shopCoordsService.findByCode(vo.getShop().getCode()));
		}
	}

	/******************************************************************************************/

	@Override
	public void saveOrUpdate(ShopVo vo) {
		// 遍历图片明细
		for (TOLShopImages image : vo.getImages()) {
			// 删除原有出价记录
			if (ParamsUtil.isTrue(image.getDeleteFlag())) {
				if (null != image.getId()) {
					shopImagesService.delete(image);
				}
			}
			// 修改/保存商铺图片
			else {
				image.setCode(vo.getShop().getCode());
				if (null != image.getId()) {
					shopImagesService.update(image);
				} else {
					shopImagesService.save(image);
				}
			}
		}
		// 新增/保存shopCoords
		if (null != vo.getCoords()) {
			vo.getCoords().setCode(vo.getShop().getCode());
			if (null != vo.getCoords().getId()) {
				shopCoordsService.update(vo.getCoords());
			} else {
				shopCoordsService.save(vo.getCoords());
			}
		}
	}
}
