package com.sbm.module.partner.hd.job.bidparam.acctype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.onlineleasing.base.bidparam.acctype.biz.ISyncAcctypeService;
import com.sbm.module.onlineleasing.base.bidparam.acctype.biz.ITOLBidAcctypeService;
import com.sbm.module.onlineleasing.base.bidparam.acctype.domain.TOLBidAcctype;
import com.sbm.module.partner.hd.job.base.biz.impl.HdSyncServiceImpl;
import com.sbm.module.partner.hd.job.base.domain.HdSyncDetail;
import com.sbm.module.partner.hd.view.acctype.biz.IAcctypeService;
import com.sbm.module.partner.hd.view.acctype.domain.Acctype;

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
@Component("hdSyncAcctypeServiceImpl")
public class HdSyncAcctypeServiceImpl extends HdSyncServiceImpl implements ISyncAcctypeService {

	@Autowired
	private ITOLBidAcctypeService service;

	@Autowired
	private IAcctypeService acctypeService;

	public void sync() {
		HdSyncDetail<TOLBidAcctype> detail = getSyncDetail();
		List<Acctype> list = acctypeService.findAll();
		for (Acctype obj : list) {
			TOLBidAcctype po = service.findByItemNo(obj.getItemno());
			// 不存在新增
			if (null == po) {
				po = new TOLBidAcctype();
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
		log(detail, TOLBidAcctype.class);
	}

	/**
	 * 
	 * convert:转换
	 * 
	 * @author junkai.zhang
	 * @param po
	 * @param obj
	 */
	private void convert(TOLBidAcctype po, Acctype obj) {
		po.setItemNo(obj.getItemno());
		po.setItemKey(obj.getKey());
		po.setItemValue(obj.getValue());
	}

}
