package com.sbm.module.onlineleasing.api.shopinfo.biz.impl;

import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.shopinfo.biz.IShopInfoService;
import com.sbm.module.onlineleasing.api.shopinfo.domain.ShopFloorDetail;
import com.sbm.module.onlineleasing.api.shopinfo.domain.ShopFloorInfo;
import com.sbm.module.onlineleasing.api.shopinfo.domain.ShopInfo;
import com.sbm.module.onlineleasing.base.brand.biz.ITOLBrandService;
import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;
import com.sbm.module.onlineleasing.base.mall.biz.ITOLMallService;
import com.sbm.module.onlineleasing.base.myfavourite.biz.ITOLMyFavouriteService;
import com.sbm.module.onlineleasing.base.shop.biz.ITOLShopService;
import com.sbm.module.onlineleasing.base.shop.domain.TOLShop;
import com.sbm.module.onlineleasing.base.shopcoords.biz.ITOLShopCoordsService;
import com.sbm.module.onlineleasing.base.shopcoords.domain.TOLShopCoords;
import com.sbm.module.onlineleasing.base.shopengineeringimages.biz.ITOLShopEngineeringImagesService;
import com.sbm.module.onlineleasing.base.shopengineeringspecifications.biz.ITOLShopEngineeringSpecificationsService;
import com.sbm.module.onlineleasing.base.shopimages.biz.ITOLShopImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
public class ShopInfoServiceImpl extends BusinessServiceImpl implements IShopInfoService {

	@Autowired
	private ITOLMyFavouriteService service;
	@Autowired
	private ITOLShopService shopService;
	@Autowired
	private ITOLBrandService brandService;
	@Autowired
	private ITOLShopImagesService shopImagesService;
	@Autowired
	private ITOLShopEngineeringImagesService shopEngineeringImagesService;
	@Autowired
	private ITOLShopEngineeringSpecificationsService shopEngineeringSpecificationsService;
	@Autowired
	private ITOLShopCoordsService shopCoordsService;
	@Autowired
	private ITOLMallService mallService;

	public void getShopInfo(ShopInfo shopInfo) {
		// 商铺信息
		setShop(shopInfo);
		// 是否关注
		shopInfo.setMyFavourite(service.findByUserCodeAndShopCode(shopInfo.getMyFavourite()));
	}

	/**
	 * 
	 * setShop:获取商铺信息
	 * 
	 * @author junkai.zhang
	 * @param shopInfo
	 */
	private void setShop(ShopInfo shopInfo) {
		TOLShop shop = shopService.findByCode(shopInfo.getMyFavourite().getShopCode());
		if (null != shop) {
			// 设置品牌名称
			TOLBrand brand = brandService.findByCode(shop.getBrandCode());
			if (null != brand) {
				shop.setBrandName(brand.getName());
			}
			// 商铺图片
			shopInfo.setImages(shopImagesService.findAllByCode(shop.getCode()));
			if (null == shopInfo.getImages() || shopInfo.getImages().isEmpty()) {
				shopInfo.setMall(mallService.findByCode(shop.getMallCode()));
			}

			// 工程图
			shopInfo.setEngineeringImages(shopEngineeringImagesService.findAllByCode(shop.getCode()));
			// 工程条件
			shopInfo.setEngineeringSpecifications(shopEngineeringSpecificationsService.findAllByCode(shop.getCode()));
		}
		shopInfo.setShop(shop);
	}

	/*****************************************************************/

	public void getShopInfoBeforeLogin(ShopInfo shopInfo) {
		// 商铺信息
		setShop(shopInfo);
		removeSensitiveInfo(shopInfo.getShop());
	}

	/**
	 * 
	 * removeSensitiveInfo:去除敏感信息
	 * 
	 * @author junkai.zhang
	 * @param shop
	 */
	private void removeSensitiveInfo(TOLShop shop) {
		if (null != null) {
			shop.setContractExpireDate(null);
			shop.setDeadRent(null);
			shop.setFloatingRentalRate(null);
		}
	}

	/*****************************************************************/

	@Override
	public void getShopFloorInfo(ShopFloorInfo shopFloorInfo) {
		List<ShopFloorDetail> details = new ArrayList<>();
		ShopFloorDetail detail;
		List<TOLShop> shops = shopService.findAllByFloorCodes(shopFloorInfo.getFloorCodes());
		for (TOLShop shop : shops) {
			detail = new ShopFloorDetail();
			// shopCode
			detail.setCode(shop.getCode());
			// state
			detail.setState(shop.getState());
			// shopState
			detail.setShopState(shop.getShopState());
			// 单元
			detail.setUnit(shop.getUnit());
			// 设置品牌名称
			TOLBrand brand = brandService.findByCode(shop.getBrandCode());
			if (null != brand) {
				detail.setBrandName(brand.getName());
			}
			// coords
			TOLShopCoords coords = shopCoordsService.findByCode(shop.getCode());
			if (null != coords) {
				detail.setCoords(coords.getCoords());
			}

			details.add(detail);
		}
		shopFloorInfo.setDetails(details);
	}
}
