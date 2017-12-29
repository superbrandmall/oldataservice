package com.sbm.module.partner.hd.job.shop.biz.impl;

import java.text.MessageFormat;
import java.util.Date;

import com.sbm.module.common.base.util.dateutil.DifferentDays;
import com.sbm.module.common.business.util.AppPropertyUtils;
import com.sbm.module.partner.hd.rest.base.domain.HdUCN;
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
import com.sbm.module.partner.hd.rest.base.domain.HdResult;
import com.sbm.module.partner.hd.rest.base.domain.HdResultBody;
import com.sbm.module.partner.hd.rest.base.domain.QueryFilter;
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
			// 不存在新增
			if (null == po) {
				po = new TOLShop();
				convert(po, obj);
				service.saveShop(po);
				detail.getInsertList().add(po);
			}
			// 存在更新
			else {
				convert(po, obj);
				service.update(po);
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
		po.setDeadRent(obj.getDear_rent());
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

		// TODO 附件
		// TODO 工程条件系列
	}

}
