package com.sbm.module.partner.hd.job.bidparam.leasetype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.onlineleasing.base.bidparam.leasetype.biz.ISyncLeasetypeService;
import com.sbm.module.onlineleasing.base.bidparam.leasetype.biz.ITOLBidLeasetypeService;
import com.sbm.module.onlineleasing.base.bidparam.leasetype.domain.TOLBidLeasetype;
import com.sbm.module.partner.hd.job.base.biz.impl.HdSyncServiceImpl;
import com.sbm.module.partner.hd.job.base.domain.HdSyncDetail;
import com.sbm.module.partner.hd.view.leasetype.biz.ILeasetypeService;
import com.sbm.module.partner.hd.view.leasetype.domain.Leasetype;

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
@Component("hdSyncLeasetypeServiceImpl")
public class HdSyncLeasetypeServiceImpl extends HdSyncServiceImpl implements ISyncLeasetypeService {

	@Autowired
	private ITOLBidLeasetypeService service;

	@Autowired
	private ILeasetypeService leasetypeService;

	public void sync() {
		HdSyncDetail<TOLBidLeasetype> detail = getSyncDetail();
		List<Leasetype> list = leasetypeService.findAll();
		for (Leasetype obj : list) {
			TOLBidLeasetype po = service.findByItemNo(obj.getItemno());
			// 不存在新增
			if (null == po) {
				po = new TOLBidLeasetype();
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
		log(detail, TOLBidLeasetype.class);
	}

	/**
	 * 
	 * convert:转换
	 * 
	 * @author junkai.zhang
	 * @param po
	 * @param obj
	 */
	private void convert(TOLBidLeasetype po, Leasetype obj) {
		po.setItemNo(obj.getItemno());
		po.setItemKey(obj.getKey());
		po.setItemValue(obj.getValue());
	}

}
