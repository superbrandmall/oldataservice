package com.sbm.module.partner.hd.job.shop.biz.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.base.util.dateutil.DifferentDays;
import com.sbm.module.common.business.util.AppPropertyUtils;
import com.sbm.module.onlineleasing.api.upload.biz.IUploadService;
import com.sbm.module.onlineleasing.api.upload.constant.UploadConstant;
import com.sbm.module.onlineleasing.base.merchantbankaccount.domain.TOLMerchantBankAccount;
import com.sbm.module.onlineleasing.base.shopengineeringimages.biz.ITOLShopEngineeringImagesService;
import com.sbm.module.onlineleasing.base.shopengineeringimages.dao.ITOLShopEngineeringImagesDao;
import com.sbm.module.onlineleasing.base.shopengineeringimages.domain.TOLShopEngineeringImages;
import com.sbm.module.onlineleasing.base.shopengineeringspecifications.biz.ITOLShopEngineeringSpecificationsService;
import com.sbm.module.onlineleasing.base.shopengineeringspecifications.domain.TOLShopEngineeringSpecifications;
import com.sbm.module.partner.hd.rest.base.domain.*;
import com.sbm.module.partner.hd.rest.merchant.domain.HdBank;
import com.sbm.module.partner.hd.rest.shop.domain.HdConditionTemplate;
import com.sbm.module.partner.hd.rest.shop.domain.HdProjectCondition;
import com.sbm.module.partner.hd.rest.shop.domain.HdProjectContent;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.onlineleasing.base.brand.biz.ITOLBrandService;
import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;
import com.sbm.module.onlineleasing.base.building.biz.ITOLBuildingService;
import com.sbm.module.onlineleasing.base.building.domain.TOLBuilding;
import com.sbm.module.onlineleasing.base.floor.biz.ITOLFloorService;
import com.sbm.module.onlineleasing.base.floor.domain.TOLFloor;
import com.sbm.module.onlineleasing.base.mall.biz.ITOLMallService;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;
import com.sbm.module.onlineleasing.base.shop.biz.ISyncShopService;
import com.sbm.module.onlineleasing.base.shop.biz.ITOLShopService;
import com.sbm.module.onlineleasing.base.shop.constant.ShopConstant;
import com.sbm.module.onlineleasing.base.shop.domain.TOLShop;
import com.sbm.module.partner.hd.job.base.biz.impl.HdSyncServiceImpl;
import com.sbm.module.partner.hd.job.base.domain.HdSyncDetail;
import com.sbm.module.partner.hd.rest.base.constant.HdConstant;
import com.sbm.module.partner.hd.rest.shop.biz.IHdShopService;
import com.sbm.module.partner.hd.rest.shop.domain.HdShop;

/*****************************************************************************/

/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.job.sync.mall.biz.impl<br/>
 * File Name:HdSyncMallServiceImpl.java<br/>
 * <p>
 * 作成日 ：2017-10-11 下午1:29:23 <br/>
 *
 * @author ：junkai.zhang
 */
@Component("hdSyncShopServiceImpl")
public class HdSyncShopServiceImpl extends HdSyncServiceImpl implements ISyncShopService {

	private static final String MALL_MESSAGE = "mall is missing, hduuid:{0}";
	private static final String BUILDING_MESSAGE = "building is missing, hduuid:{0}";
	private static final String FLOOR_MESSAGE = "floor is missing, hduuid:{0}";
	private static final String BIZTYPE_MESSAGE = "biztype is missing, shopuuid:{0}";
	private static final String BRAND_MESSAGE = "brand is missing, hduuid:{0}";

	@Autowired
	private ITOLMallService mallService;
	@Autowired
	private ITOLBuildingService buildingService;
	@Autowired
	private ITOLFloorService floorService;
	@Autowired
	private ITOLBrandService brandService;
	@Autowired
	private ITOLShopService service;
	@Autowired
	private ITOLShopEngineeringImagesService shopEngineeringImagesService;
	@Autowired
	private ITOLShopEngineeringSpecificationsService shopEngineeringSpecificationsService;

	@Autowired
	private IUploadService uploadService;

	@Autowired
	private IHdShopService hdShopService;

	public void sync() {
		// 查询条件
		QueryFilter queryFilter = new QueryFilter();
		queryFilter.getFilter().put("type", "shoppe");
		// 项目
		String storeUuid = AppPropertyUtils.getProperty("storeUuid");
		if (StringUtils.isNotBlank(storeUuid)) {
			queryFilter.getFilter().put("storeUuid", storeUuid);
		}

		// 第一次查询
		HdResult<HdResultBody<HdShop>> result = query(queryFilter);
		// 遍历查询
		for (int i = 1; i < result.getBody().getPageCount(); i++) {
//			// TODO
//			if (i >= 3) {
//				break;
//			}
			queryFilter.setPage(i);
			query(queryFilter);
		}
	}

	private HdResult<HdResultBody<HdShop>> query(QueryFilter queryFilter) {
		HdSyncDetail<TOLShop> detail = getSyncDetail();
		HdResult<HdResultBody<HdShop>> result = hdShopService.query(queryFilter);
		// 校对返回结果
		checkResult(result);
		// 遍历结果
		for (HdShop obj : result.getBody().getRecords()) {
			TOLShop po = service.findByHdUuid(obj.getUuid());
			TOLShopEngineeringImages shopEngineeringImages;
			TOLShopEngineeringSpecifications shopEngineeringSpecifications;
			// 不存在新增
			if (null == po) {
				po = new TOLShop();
				convert(po, obj);
				service.saveShop(po);
				detail.getInsertList().add(po);

				// 工程图
				for (HdMediaFile file : obj.getMediaFiles()) {
					shopEngineeringImages = new TOLShopEngineeringImages();
					shopEngineeringImages.setCode(po.getCode());
					convert(shopEngineeringImages, file);
					shopEngineeringImagesService.save(shopEngineeringImages);
				}

				// 工程条件
				List<TOLShopEngineeringSpecifications> vos = getSpecifications(obj, po);
				for (TOLShopEngineeringSpecifications vo : vos) {
					shopEngineeringSpecificationsService.save(vo);
				}
			}
			// 存在更新
			else {
				convert(po, obj);
				service.update(po);

				// 工程图
				List<TOLShopEngineeringImages> list = shopEngineeringImagesService.findAllByCode(po.getCode());
				if (list.size() <= obj.getMediaFiles().size()) {
					for (int i = 0; i < obj.getMediaFiles().size(); i++) {
						if (i < list.size()) {
							shopEngineeringImages = list.get(i);
							convert(shopEngineeringImages, obj.getMediaFiles().get(i));
							shopEngineeringImagesService.update(shopEngineeringImages);
						} else {
							shopEngineeringImages = new TOLShopEngineeringImages();
							shopEngineeringImages.setCode(po.getCode());
							convert(shopEngineeringImages, obj.getMediaFiles().get(i));
							shopEngineeringImagesService.save(shopEngineeringImages);
						}
					}
				} else {
					for (int i = 0; i < list.size(); i++) {
						if (i < obj.getMediaFiles().size()) {
							shopEngineeringImages = list.get(i);
							convert(shopEngineeringImages, obj.getMediaFiles().get(i));
							shopEngineeringImagesService.update(shopEngineeringImages);
						} else {
							shopEngineeringImages = list.get(i);
							shopEngineeringImagesService.delete(shopEngineeringImages);
						}
					}
				}

				// 工程条件 123
				List<TOLShopEngineeringSpecifications> pos = shopEngineeringSpecificationsService.findAllByCode(po.getCode());
				List<TOLShopEngineeringSpecifications> vos = getSpecifications(obj, po);
				if (pos.size() <= vos.size()) {
					for (int i = 0; i < vos.size(); i++) {
						if (i < pos.size()) {
							shopEngineeringSpecifications = pos.get(i);
							convert(shopEngineeringSpecifications, vos.get(i));
							shopEngineeringSpecificationsService.update(shopEngineeringSpecifications);
						} else {
							shopEngineeringSpecifications = new TOLShopEngineeringSpecifications();
							shopEngineeringSpecifications.setCode(po.getCode());
							convert(shopEngineeringSpecifications, vos.get(i));
							shopEngineeringSpecificationsService.save(shopEngineeringSpecifications);
						}
					}
				} else {
					for (int i = 0; i < pos.size(); i++) {
						if (i < vos.size()) {
							shopEngineeringSpecifications = pos.get(i);
							convert(shopEngineeringSpecifications, vos.get(i));
							shopEngineeringSpecificationsService.update(shopEngineeringSpecifications);
						} else {
							shopEngineeringSpecifications = pos.get(i);
							shopEngineeringSpecificationsService.delete(shopEngineeringSpecifications);
						}
					}
				}

				detail.getUpdateList().add(po);
			}
		}
		log(detail, result, TOLShop.class);
		return result;
	}

	/**
	 * convert:转换
	 *
	 * @param po
	 * @param obj
	 * @author junkai.zhang
	 */
	private void convert(TOLShop po, HdShop obj) {
		// 海鼎uuid
		po.setHdUuid(obj.getUuid());
		// 海鼎编码
		po.setHdCode(obj.getCode());
		// 海鼎名称
		po.setShopName(obj.getName());
		// 海鼎状态
		po.setHdState(obj.getState());

		// 商场编号
		if (null != obj.getStore() && StringUtils.isNotBlank(obj.getStore().getUuid())) {
			TOLMall mall = mallService.findByHdUuid(obj.getStore().getUuid());
			if (null != mall) {
				po.setMallCode(mall.getCode());
				po.setMallName(mall.getMallName());
			} else {
				CommonConstant.FRAMEWORK.warn(MessageFormat.format(MALL_MESSAGE, obj.getStore().getUuid()));
			}
		}
		// 楼宇编号
		if (null != obj.getBuilding() && StringUtils.isNotBlank(obj.getBuilding().getUuid())) {
			TOLBuilding building = buildingService.findByHdUuid(obj.getBuilding().getUuid());
			if (null != building) {
				po.setBuildingCode(building.getCode());
				po.setBuildingName(building.getBuildingName());
			} else {
				CommonConstant.FRAMEWORK.warn(MessageFormat.format(BUILDING_MESSAGE, obj.getBuilding().getUuid()));
			}
		}
		// 楼层编号
		if (null != obj.getFloor() && StringUtils.isNotBlank(obj.getFloor().getUuid())) {
			TOLFloor floor = floorService.findByHdUuid(obj.getFloor().getUuid());
			if (null != floor) {
				po.setFloorCode(floor.getCode());
				// 铺位中的楼层名称使用楼层描述
				// po.setFloorName(floor.getFloorName());
				po.setFloorName(floor.getDescription());
			} else {
				CommonConstant.FRAMEWORK.warn(MessageFormat.format(FLOOR_MESSAGE, obj.getFloor().getUuid()));
			}
		}
		// 业态
		if (null != obj.getModality()) {
			po.setModality(obj.getModality().getCode());
		} else {
			CommonConstant.FRAMEWORK.warn(MessageFormat.format(BIZTYPE_MESSAGE, obj.getUuid()));
		}
		// 单元号
		po.setUnit(obj.getCode());
		// 租赁面积
		po.setArea(obj.getRentArea());

		// 商铺状态
		if (null == obj.getContract_expire_date()) {
			po.setShopState(ShopConstant.SHOP_STATE_1);
		} else {
			Integer days = DifferentDays.differentDays(new Date(), obj.getContract_expire_date());
			// 空铺
			if (days < 0) {
				po.setShopState(ShopConstant.SHOP_STATE_1);
			}
			// 待租
			else if (0 <= days && days < 180) {
				po.setShopState(ShopConstant.SHOP_STATE_2);
			}
			// 在租
			else {
				po.setShopState(ShopConstant.SHOP_STATE_0);
			}
		}

		// 最后一份合同到期日
		po.setContractExpireDate(obj.getContract_expire_date());
		// 最低可出价租金
		po.setDeadRent(obj.getDead_rent());
		// 最低可出价扣率
		po.setFloatingRentalRate(obj.getFloating_rental_rate());
		// 最后一份合同的品牌
		if (null != obj.getCurrentBrand() && !obj.getCurrentBrand().isEmpty()) {
			HdUCN cb = obj.getCurrentBrand().get(0);
			if (StringUtils.isNotBlank(cb.getUuid())) {
				TOLBrand brand = brandService.findByHdUuid(cb.getUuid());
				if (null != brand) {
					po.setBrandCode(brand.getCode());
				} else {
					CommonConstant.FRAMEWORK.warn(MessageFormat.format(BRAND_MESSAGE, cb.getUuid()));
				}
			}
		}

		// 铺位类型
		po.setSubType(obj.getSubType());

	}

	/**
	 * 转换工程图
	 * @param shopEngineeringImages
	 * @param obj
	 */
	private void convert(TOLShopEngineeringImages shopEngineeringImages, HdMediaFile obj) {
		// 类型
		shopEngineeringImages.setAttachmentType(obj.getAttachmentType());
		// 生成upload明细
		String uri = uploadService.saveFileUploadDetail(obj.getId(),
				UploadConstant.CONTAINER_NAME_DEFAULT,
				uploadService.getPrefix(shopEngineeringImages.getCode(), UploadConstant.PIC, UploadConstant.ENGINEERING_IMAGE));
		// 地址
		shopEngineeringImages.setImage(uri);
	}


	/**
	 * 转换工程条件
	 * @param shopEngineeringSpecifications
	 * @param obj
	 * @param condition
	 */
	private void convert(TOLShopEngineeringSpecifications shopEngineeringSpecifications, HdProjectContent obj, HdProjectCondition condition ) {
		shopEngineeringSpecifications.setKeyword(condition.getKey());
		shopEngineeringSpecifications.setName(condition.getName());
		shopEngineeringSpecifications.setTitle(obj.getTitle());
		shopEngineeringSpecifications.setNumber(obj.getNumber());
		shopEngineeringSpecifications.setSpec(obj.getSpec());
	}

	private List<TOLShopEngineeringSpecifications> getSpecifications(HdShop obj, TOLShop po) {
		List<TOLShopEngineeringSpecifications> vos = new ArrayList<>();
		TOLShopEngineeringSpecifications shopEngineeringSpecifications;
		for (HdConditionTemplate template : obj.getTemplates()) {
			for (HdProjectCondition condition : template.getConditions()) {
				List<HdProjectContent> contents = JSON.parseArray(condition.getContent(), HdProjectContent.class);
				for (HdProjectContent content : contents) {
					shopEngineeringSpecifications = new TOLShopEngineeringSpecifications();
					shopEngineeringSpecifications.setCode(po.getCode());
					convert(shopEngineeringSpecifications, content, condition);
					vos.add(shopEngineeringSpecifications);
				}
			}
		}
		return vos;
	}

	private void convert(TOLShopEngineeringSpecifications po, TOLShopEngineeringSpecifications vo) {
		po.setKeyword(vo.getKeyword());
		po.setName(vo.getName());
		po.setTitle(vo.getTitle());
		po.setNumber(vo.getNumber());
		po.setSpec(vo.getSpec());
	}
}
