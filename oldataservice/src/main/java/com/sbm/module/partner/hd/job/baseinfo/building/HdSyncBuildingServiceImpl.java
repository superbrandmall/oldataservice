package com.sbm.module.partner.hd.job.baseinfo.building;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.onlineleasing.base.building.biz.ISyncBuildingService;
import com.sbm.module.onlineleasing.base.building.biz.ITOLBuildingService;
import com.sbm.module.onlineleasing.base.building.domain.TOLBuilding;
import com.sbm.module.onlineleasing.base.mall.biz.ITOLMallService;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;
import com.sbm.module.partner.hd.job.base.biz.impl.HdSyncServiceImpl;
import com.sbm.module.partner.hd.job.base.domain.HdSyncDetail;
import com.sbm.module.partner.hd.view.building.biz.IBuildingService;
import com.sbm.module.partner.hd.view.building.domain.Building;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.job.sync.mall.biz.impl<br/>
 * File Name:HdSyncMallServiceImpl.java<br/>
 * 
 * 作成日 ：2017-10-11 下午1:29:23 <br/>
 * 
 * @author ：junkai.zhang
 */
@Component("hdSyncBuildingServiceImpl")
public class HdSyncBuildingServiceImpl extends HdSyncServiceImpl implements ISyncBuildingService {

	private static final String MESSAGE = "mall is missing, hduuid:{0}";

	@Autowired
	private ITOLMallService mallService;
	@Autowired
	private ITOLBuildingService service;

	@Autowired
	private IBuildingService buildingService;

	public void sync() {
		HdSyncDetail<TOLBuilding> detail = getSyncDetail();
		List<Building> list = buildingService.findAll();
		for (Building obj : list) {
			TOLBuilding po = service.findByHdUuid(obj.getHdUuid());
			// 不存在新增
			if (null == po) {
				po = new TOLBuilding();
				convert(po, obj);
				service.saveBuilding(po);
				detail.getInsertList().add(po);
			}
			// 存在更新
			else {
				convert(po, obj);
				service.update(po);
				detail.getUpdateList().add(po);
			}
		}
		log(detail, TOLBuilding.class);
	}

	/**
	 * 
	 * convert:转换
	 * 
	 * @author junkai.zhang
	 * @param po
	 * @param obj
	 */
	private void convert(TOLBuilding po, Building obj) {
		// 商场编号
		TOLMall mall = mallService.findByHdUuid(obj.getMallUuid());
		if (null != mall) {
			po.setMallCode(mall.getCode());
		} else {
			CommonConstant.FRAMEWORK.warn(MessageFormat.format(MESSAGE, obj.getMallUuid()));
		}

		// 项目名称
		po.setBuildingName(obj.getBuildingName());
		// 建筑面积
		po.setGrossFloorArea(obj.getGrossFloorArea());
		// 租赁面积
		po.setLeasingArea(obj.getLeasingArea());
		// 备注
		po.setDescription(obj.getDescription());
		// 海鼎uuid
		po.setHdUuid(obj.getHdUuid());
		// 海鼎编码
		po.setHdCode(obj.getHdCode());
		// 海鼎状态
		po.setHdState(obj.getState());
	}

}
