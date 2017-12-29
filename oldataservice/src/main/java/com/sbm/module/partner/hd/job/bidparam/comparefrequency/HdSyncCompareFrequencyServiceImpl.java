package com.sbm.module.partner.hd.job.bidparam.comparefrequency;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.onlineleasing.base.bidparam.comparefrequency.biz.ISyncCompareFrequencyService;
import com.sbm.module.onlineleasing.base.bidparam.comparefrequency.biz.ITOLBidCompareFrequencyService;
import com.sbm.module.onlineleasing.base.bidparam.comparefrequency.domain.TOLBidCompareFrequency;
import com.sbm.module.partner.hd.job.base.biz.impl.HdSyncServiceImpl;
import com.sbm.module.partner.hd.job.base.domain.HdSyncDetail;
import com.sbm.module.partner.hd.view.comparefrequency.biz.ICompareFrequencyService;
import com.sbm.module.partner.hd.view.comparefrequency.domain.CompareFrequency;

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
@Component("hdSyncCompareFrequencyServiceImpl")
public class HdSyncCompareFrequencyServiceImpl extends HdSyncServiceImpl implements ISyncCompareFrequencyService {

	@Autowired
	private ITOLBidCompareFrequencyService service;

	@Autowired
	private ICompareFrequencyService compareFrequencyService;

	public void sync() {
		HdSyncDetail<TOLBidCompareFrequency> detail = getSyncDetail();
		List<CompareFrequency> list = compareFrequencyService.findAll();
		for (CompareFrequency obj : list) {
			TOLBidCompareFrequency po = service.findByItemNo(obj.getItemno());
			// 不存在新增
			if (null == po) {
				po = new TOLBidCompareFrequency();
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
		log(detail, TOLBidCompareFrequency.class);
	}

	/**
	 * 
	 * convert:转换
	 * 
	 * @author junkai.zhang
	 * @param po
	 * @param obj
	 */
	private void convert(TOLBidCompareFrequency po, CompareFrequency obj) {
		po.setItemNo(obj.getItemno());
		po.setItemKey(obj.getKey());
		po.setItemValue(obj.getValue());
	}

}
