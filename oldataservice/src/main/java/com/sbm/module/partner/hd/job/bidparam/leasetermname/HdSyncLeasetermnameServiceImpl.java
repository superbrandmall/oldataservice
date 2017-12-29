package com.sbm.module.partner.hd.job.bidparam.leasetermname;

import com.sbm.module.onlineleasing.base.bidparam.leasemodule.biz.ISyncLeasemoduleService;
import com.sbm.module.onlineleasing.base.bidparam.leasemodule.biz.ITOLBidLeasemoduleService;
import com.sbm.module.onlineleasing.base.bidparam.leasemodule.domain.TOLBidLeasemodule;
import com.sbm.module.onlineleasing.base.bidparam.leasetermname.biz.ISyncLeasetermnameService;
import com.sbm.module.onlineleasing.base.bidparam.leasetermname.biz.ITOLBidLeasetermnameService;
import com.sbm.module.onlineleasing.base.bidparam.leasetermname.domain.TOLBidLeasetermname;
import com.sbm.module.partner.hd.job.base.biz.impl.HdSyncServiceImpl;
import com.sbm.module.partner.hd.job.base.domain.HdSyncDetail;
import com.sbm.module.partner.hd.view.leasemodule.biz.ILeasemoduleService;
import com.sbm.module.partner.hd.view.leasemodule.domain.Leasemodule;
import com.sbm.module.partner.hd.view.leasetermname.biz.ILeasetermnameService;
import com.sbm.module.partner.hd.view.leasetermname.domain.Leasetermname;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
@Component("hdSyncLeasetermnameServiceImpl")
public class HdSyncLeasetermnameServiceImpl extends HdSyncServiceImpl implements ISyncLeasetermnameService {

	@Autowired
	private ITOLBidLeasetermnameService service;

	@Autowired
	private ILeasetermnameService leasetermnameService;

	public void sync() {
		HdSyncDetail<TOLBidLeasetermname> detail = getSyncDetail();
		List<Leasetermname> list = leasetermnameService.findAll();
		for (Leasetermname obj : list) {
			TOLBidLeasetermname po = service.findByItemNo(obj.getItemno());
			// 不存在新增
			if (null == po) {
				po = new TOLBidLeasetermname();
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
		log(detail, TOLBidLeasetermname.class);
	}

	/**
	 * 
	 * convert:转换
	 * 
	 * @author junkai.zhang
	 * @param po
	 * @param obj
	 */
	private void convert(TOLBidLeasetermname po, Leasetermname obj) {
		po.setItemNo(obj.getItemno());
		po.setLeasemodulename(obj.getLeasemodulename());
		po.setFeename(obj.getFeename());
		po.setTermname(obj.getTermname());
		po.setRemark(obj.getRemark());
	}

}
