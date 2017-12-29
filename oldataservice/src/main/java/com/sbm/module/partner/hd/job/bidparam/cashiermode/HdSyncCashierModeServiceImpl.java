package com.sbm.module.partner.hd.job.bidparam.cashiermode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.onlineleasing.base.bidparam.cashiermode.biz.ISyncCashierModeService;
import com.sbm.module.onlineleasing.base.bidparam.cashiermode.biz.ITOLBidCashierModeService;
import com.sbm.module.onlineleasing.base.bidparam.cashiermode.domain.TOLBidCashierMode;
import com.sbm.module.partner.hd.job.base.biz.impl.HdSyncServiceImpl;
import com.sbm.module.partner.hd.job.base.domain.HdSyncDetail;
import com.sbm.module.partner.hd.view.cashiermode.biz.ICashierModeService;
import com.sbm.module.partner.hd.view.cashiermode.domain.CashierMode;

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
@Component("hdSyncCashierModeServiceImpl")
public class HdSyncCashierModeServiceImpl extends HdSyncServiceImpl implements ISyncCashierModeService {

	@Autowired
	private ITOLBidCashierModeService service;

	@Autowired
	private ICashierModeService cashierModeService;

	public void sync() {
		HdSyncDetail<TOLBidCashierMode> detail = getSyncDetail();
		List<CashierMode> list = cashierModeService.findAll();
		for (CashierMode obj : list) {
			TOLBidCashierMode po = service.findByItemNo(obj.getItemno());
			// 不存在新增
			if (null == po) {
				po = new TOLBidCashierMode();
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
		log(detail, TOLBidCashierMode.class);
	}

	/**
	 * 
	 * convert:转换
	 * 
	 * @author junkai.zhang
	 * @param po
	 * @param obj
	 */
	private void convert(TOLBidCashierMode po, CashierMode obj) {
		po.setItemNo(obj.getItemno());
		po.setItemKey(obj.getKey());
		po.setItemValue(obj.getValue());
	}

}
