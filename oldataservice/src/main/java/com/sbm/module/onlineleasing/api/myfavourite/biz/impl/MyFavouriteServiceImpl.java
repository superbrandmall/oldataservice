package com.sbm.module.onlineleasing.api.myfavourite.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.sbm.module.onlineleasing.base.shopimages.biz.ITOLShopImagesService;
import com.sbm.module.onlineleasing.base.shopimages.domain.TOLShopImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.api.myfavourite.biz.IMyFavouriteService;
import com.sbm.module.onlineleasing.api.myfavourite.domain.MyFavourite;
import com.sbm.module.onlineleasing.base.modality.biz.ITOLModalityService;
import com.sbm.module.onlineleasing.base.myfavourite.biz.ITOLMyFavouriteService;
import com.sbm.module.onlineleasing.base.myfavourite.domain.TOLMyFavourite;
import com.sbm.module.onlineleasing.base.shop.biz.ITOLShopService;
import com.sbm.module.onlineleasing.base.shop.domain.TOLShop;

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
public class MyFavouriteServiceImpl extends BusinessServiceImpl implements IMyFavouriteService {

	@Autowired
	private ITOLMyFavouriteService service;
	@Autowired
	private ITOLShopService shopService;
	@Autowired
	private ITOLShopImagesService shopImagesService;

	public void getDetails(MyFavourite myFavourite) {
		Pagination<TOLMyFavourite> pagination = service.findAllByUserCodePage(myFavourite.getMyFavourite());
		// TODO 添加商铺图片
		Pagination<TOLShop> shops = getPagination();
		// 转换
		convertPagination(pagination, shops);
		myFavourite.setShops(shops);
	}

	/**
	 * 
	 * convertPagination:将Pagination<TOLMyFavourite>转换为Pagination<TOLShop>
	 * 
	 * @author junkai.zhang
	 * @param pagination
	 * @param shops
	 */
	private void convertPagination(Pagination<TOLMyFavourite> pagination, Pagination<TOLShop> shops) {
		shops.setTotalCount(pagination.getTotalCount());
		List<TOLShop> details = new ArrayList<TOLShop>();
		for (TOLMyFavourite myFavourite : pagination.getDetails()) {
			details.add(findShopByMyFavourite(myFavourite));
		}
		shops.setDetails(details);
	}

	private TOLShop findShopByMyFavourite(TOLMyFavourite myFavourite) {
		TOLShop shop = shopService.findByCode(myFavourite.getShopCode());
		// 商铺第一张图片
		List<TOLShopImages> shopImages = shopImagesService.findAllByCode(shop.getCode());
		if (null != shopImages && !shopImages.isEmpty()) {
			shop.setFirstImage(shopImages.get(0).getImage());
		}
		return shop;
	}

	/********************************************************************/

	public void save(MyFavourite myFavourite) {
		checkSave(myFavourite);
		service.save(myFavourite.getMyFavourite());
	}

	/**
	 * 
	 * checkSave:关注校验
	 * 
	 * @author junkai.zhang
	 * @param myFavourite
	 */
	private void checkSave(MyFavourite myFavourite) {
		if (null != service.findByUserCodeAndShopCode(myFavourite.getMyFavourite())) {
			throw new BusinessException(BusinessCode.C5100, new Object[] { myFavourite.getMyFavourite().getUserCode(),
					myFavourite.getMyFavourite().getShopCode() }, null);
		}
	}

	/********************************************************************/

	public void delete(MyFavourite myFavourite) {
		service.delete(myFavourite.getMyFavourite());
	}
}
