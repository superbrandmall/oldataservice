package com.sbm.module.partner.hd.job.bidparam.leasemodule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.onlineleasing.base.bidparam.leasemodule.biz.ISyncLeasemoduleService;
import com.sbm.module.onlineleasing.base.bidparam.leasemodule.biz.ITOLBidLeasemoduleService;
import com.sbm.module.onlineleasing.base.bidparam.leasemodule.domain.TOLBidLeasemodule;
import com.sbm.module.partner.hd.job.base.biz.impl.HdSyncServiceImpl;
import com.sbm.module.partner.hd.job.base.domain.HdSyncDetail;
import com.sbm.module.partner.hd.view.leasemodule.biz.ILeasemoduleService;
import com.sbm.module.partner.hd.view.leasemodule.domain.Leasemodule;

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
@Component("hdSyncLeasemoduleServiceImpl")
public class HdSyncLeasemoduleServiceImpl extends HdSyncServiceImpl implements ISyncLeasemoduleService {

	@Autowired
	private ITOLBidLeasemoduleService service;

	@Autowired
	private ILeasemoduleService leasemoduleService;

	public void sync() {
		HdSyncDetail<TOLBidLeasemodule> detail = getSyncDetail();
		List<Leasemodule> list = leasemoduleService.findAll();
		for (Leasemodule obj : list) {
			TOLBidLeasemodule po = service.findByItemNo(obj.getItemno());
			// 不存在新增
			if (null == po) {
				po = new TOLBidLeasemodule();
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
		log(detail, TOLBidLeasemodule.class);
	}

	/**
	 * 
	 * convert:转换
	 * 
	 * @author junkai.zhang
	 * @param po
	 * @param obj
	 */
	private void convert(TOLBidLeasemodule po, Leasemodule obj) {
		po.setItemNo(obj.getItemno());
		po.setLeasetype(obj.getLeasetype());
		po.setAcctype(obj.getAcctype());
		po.setLeasemodulename(obj.getLeasemodulename());
	}

}
