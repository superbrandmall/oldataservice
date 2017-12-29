package com.sbm.module.partner.hd.job.bidparam.rentmethod;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.onlineleasing.base.bidparam.rentmethod.biz.ISyncRentMethodService;
import com.sbm.module.onlineleasing.base.bidparam.rentmethod.biz.ITOLBidRentMethodService;
import com.sbm.module.onlineleasing.base.bidparam.rentmethod.domain.TOLBidRentMethod;
import com.sbm.module.partner.hd.job.base.biz.impl.HdSyncServiceImpl;
import com.sbm.module.partner.hd.job.base.domain.HdSyncDetail;
import com.sbm.module.partner.hd.view.rentmethod.biz.IRentMethodService;
import com.sbm.module.partner.hd.view.rentmethod.domain.RentMethod;

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
@Component("hdSyncRentMethodServiceImpl")
public class HdSyncRentMethodServiceImpl extends HdSyncServiceImpl implements ISyncRentMethodService {

	@Autowired
	private ITOLBidRentMethodService service;

	@Autowired
	private IRentMethodService rentMethodService;

	public void sync() {
		HdSyncDetail<TOLBidRentMethod> detail = getSyncDetail();
		List<RentMethod> list = rentMethodService.findAll();
		for (RentMethod obj : list) {
			TOLBidRentMethod po = service.findByItemNo(obj.getItemno());
			// 不存在新增
			if (null == po) {
				po = new TOLBidRentMethod();
				convert(po, obj);
				service.save(po);
				detail.getInsertList().add(po);
			}
			// 存在更新
			else {
				convert(po, obj);
				service.update(po);
				detail.getUpdateList().add(po);
			}
		}
		log(detail, TOLBidRentMethod.class);
	}

	/**
	 * 
	 * convert:转换
	 * 
	 * @author junkai.zhang
	 * @param po
	 * @param obj
	 */
	private void convert(TOLBidRentMethod po, RentMethod obj) {
		po.setItemNo(obj.getItemno());
		po.setItemKey(obj.getKey());
		po.setItemValue(obj.getValue());
	}

}
