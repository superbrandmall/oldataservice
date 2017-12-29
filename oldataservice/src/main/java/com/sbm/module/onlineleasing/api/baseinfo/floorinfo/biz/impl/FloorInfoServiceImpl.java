package com.sbm.module.onlineleasing.api.baseinfo.floorinfo.biz.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.redis.constant.RedisConstant;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.util.ParamsUtil;
import com.sbm.module.onlineleasing.api.baseinfo.base.domain.ModalityProportion;
import com.sbm.module.onlineleasing.api.baseinfo.base.domain.ModalityProportionDetail;
import com.sbm.module.onlineleasing.api.baseinfo.floorinfo.biz.IFloorInfoService;
import com.sbm.module.onlineleasing.api.baseinfo.floorinfo.domain.FloorInfo;
import com.sbm.module.onlineleasing.api.baseinfo.floorinfo.domain.FloorInfoVo;
import com.sbm.module.onlineleasing.base.building.biz.ITOLBuildingService;
import com.sbm.module.onlineleasing.base.floor.biz.ITOLFloorService;
import com.sbm.module.onlineleasing.base.floor.domain.TOLFloor;
import com.sbm.module.onlineleasing.base.mall.biz.ITOLMallService;
import com.sbm.module.onlineleasing.base.malltraffic.biz.ITOLMallTrafficService;
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
public class FloorInfoServiceImpl extends BusinessServiceImpl implements IFloorInfoService {

	@Autowired
	private ITOLMallService mallService;
	@Autowired
	private ITOLMallTrafficService mallTrafficService;
	@Autowired
	private ITOLBuildingService buildingService;
	@Autowired
	private ITOLFloorService floorService;
	@Autowired
	private ITOLShopService shopService;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<FloorInfo> findAll() {
		List<FloorInfo> floorInfos = new ArrayList<FloorInfo>();
		// 查询所有mall
		List<TOLFloor> floors = floorService.findAll();
		for (TOLFloor floor : floors) {
			FloorInfo floorInfo = find(floor.getCode());
			floorInfos.add(floorInfo);
		}
		return floorInfos;
	}

	/**
	 * 
	 * find:查询一个floor的数据
	 * 
	 * @author junkai.zhang
	 * @param floorCode
	 * @return
	 */
	private FloorInfo find(String floorCode) {
		// 判断非空
		ParamsUtil.canNotBeEmpty(floorCode);
		
		FloorInfo floorInfo = new FloorInfo();
		// 查询floor
		floorInfo.setFloor(floorService.findByCode(floorCode));
		// floor业态分布
		floorInfo.setProportion(getFloorProportion(floorCode));
		return floorInfo;
	}

	/**
	 * 
	 * getFloorProportion:获取floor业态占比
	 * 
	 * @author junkai.zhang
	 * @param floorCode
	 * @return
	 */
	private ModalityProportion getFloorProportion(String floorCode) {
		ModalityProportion proportion = new ModalityProportion();
		proportion.setFloorCode(floorCode);
		List<TOLShop> shops = shopService.findCountGroupByFloor(floorCode);
		convert(proportion.getDetails(), shops);
		return proportion;
	}

	/**************************************************************************************************/
	// 转换

	private void convert(List<ModalityProportionDetail> vos, List<TOLShop> pos) {
		Long total = 0L;
		for (TOLShop po : pos) {
			total += po.getCount();
		}
		for (TOLShop po : pos) {
			ModalityProportionDetail vo = new ModalityProportionDetail();
			convert(vo, po, total);
			vos.add(vo);
		}
	}

	private void convert(ModalityProportionDetail vo, TOLShop po, Long total) {
		vo.setCode(po.getModality());
		vo.setCount(po.getCount());
		// 保留两位小数
		vo.setPercentage(new BigDecimal(po.getCount()).divide(new BigDecimal(total), 2, BigDecimal.ROUND_HALF_EVEN));
	}

	/**************************************************************************************************/

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public FloorInfo get(String code) {
		String valuer = (String) redisService.get(RedisConstant.PREFIX_FLOOR_INFO + code);
		if (StringUtils.isNotBlank(valuer)) {
			FloorInfo obj = JSON.parseObject(valuer, FloorInfo.class);
			return obj;
		}
		return find(code);
	}

	public void refreshCache() {
		List<FloorInfo> list = findAll();
		for (FloorInfo obj : list) {
			set2redis(RedisConstant.PREFIX_FLOOR_INFO + obj.getFloor().getCode(), JSON.toJSONString(obj), 2L,
					TimeUnit.DAYS);
		}
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public void getFloorInfo(FloorInfoVo vo) {
		vo.setFloorInfo(get(vo.getCode()));
	}

}
