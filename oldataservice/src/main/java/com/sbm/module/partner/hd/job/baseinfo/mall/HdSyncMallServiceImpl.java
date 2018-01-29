package com.sbm.module.partner.hd.job.baseinfo.mall;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.onlineleasing.base.mall.biz.ISyncMallService;
import com.sbm.module.onlineleasing.base.mall.biz.ITOLMallService;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;
import com.sbm.module.partner.hd.job.base.biz.impl.HdSyncServiceImpl;
import com.sbm.module.partner.hd.job.base.domain.HdSyncDetail;
import com.sbm.module.partner.hd.view.mall.biz.IMallService;
import com.sbm.module.partner.hd.view.mall.domain.Mall;

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
@Component("hdSyncMallServiceImpl")
public class HdSyncMallServiceImpl extends HdSyncServiceImpl implements ISyncMallService {

	@Autowired
	private ITOLMallService service;

	@Autowired
	private IMallService mallService;

	public void sync() {
		HdSyncDetail<TOLMall> detail = getSyncDetail();
		List<Mall> list = mallService.findAll();
		for (Mall obj : list) {
			TOLMall po = service.findByHdUuid(obj.getHdUuid());
			// 不存在新增
			if (null == po) {
				po = new TOLMall();
				convert(po, obj);
				service.saveMall(po);
				detail.getInsertList().add(po);
			}
			// 存在更新
			else {
				convert(po, obj);
				service.update(po);
				detail.getUpdateList().add(po);
			}
		}
		log(detail, TOLMall.class);
	}

	/**
	 * 
	 * convert:转换
	 * 
	 * @author junkai.zhang
	 * @param po
	 * @param obj
	 */
	private void convert(TOLMall po, Mall obj) {
		// 项目名称
		po.setMallName(obj.getHdName());
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
