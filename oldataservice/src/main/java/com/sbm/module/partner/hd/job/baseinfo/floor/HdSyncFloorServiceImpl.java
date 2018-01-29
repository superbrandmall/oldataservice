package com.sbm.module.partner.hd.job.baseinfo.floor;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.onlineleasing.base.building.biz.ITOLBuildingService;
import com.sbm.module.onlineleasing.base.building.domain.TOLBuilding;
import com.sbm.module.onlineleasing.base.floor.biz.ISyncFloorService;
import com.sbm.module.onlineleasing.base.floor.biz.ITOLFloorService;
import com.sbm.module.onlineleasing.base.floor.domain.TOLFloor;
import com.sbm.module.partner.hd.job.base.biz.impl.HdSyncServiceImpl;
import com.sbm.module.partner.hd.job.base.domain.HdSyncDetail;
import com.sbm.module.partner.hd.view.floor.biz.IFloorService;
import com.sbm.module.partner.hd.view.floor.domain.Floor;

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
@Component("hdSyncFloorServiceImpl")
public class HdSyncFloorServiceImpl extends HdSyncServiceImpl implements ISyncFloorService {

	private static final String MESSAGE = "building is missing, hduuid:{0}";

	@Autowired
	private ITOLBuildingService buildingService;
	@Autowired
	private ITOLFloorService service;

	@Autowired
	private IFloorService floorService;

	public void sync() {
		HdSyncDetail<TOLFloor> detail = getSyncDetail();
		List<Floor> list = floorService.findAll();
		for (Floor obj : list) {
			TOLFloor po = service.findByHdUuid(obj.getHdUuid());
			// 不存在新增
			if (null == po) {
				po = new TOLFloor();
				convert(po, obj);
				service.saveFloor(po);
				detail.getInsertList().add(po);
			}
			// 存在更新
			else {
				convert(po, obj);
				service.update(po);
				detail.getUpdateList().add(po);
			}
		}
		log(detail, TOLFloor.class);
	}

	/**
	 * 
	 * convert:转换
	 * 
	 * @author junkai.zhang
	 * @param po
	 * @param obj
	 */
	private void convert(TOLFloor po, Floor obj) {
		// 楼宇编号
		TOLBuilding building = buildingService.findByHdUuid(obj.getBuildingUuid());
		if (null != building) {
			po.setBuildingCode(building.getCode());
		} else {
			CommonConstant.FRAMEWORK.warn(MessageFormat.format(MESSAGE, obj.getBuildingUuid()));
		}

		// 项目名称
		po.setFloorName(obj.getFloorName());
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
