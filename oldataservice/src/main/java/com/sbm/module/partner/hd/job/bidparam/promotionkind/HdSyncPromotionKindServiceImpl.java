package com.sbm.module.partner.hd.job.bidparam.promotionkind;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.onlineleasing.base.bidparam.promotionkind.biz.ISyncPromotionKindService;
import com.sbm.module.onlineleasing.base.bidparam.promotionkind.biz.ITOLBidPromotionKindService;
import com.sbm.module.onlineleasing.base.bidparam.promotionkind.domain.TOLBidPromotionKind;
import com.sbm.module.partner.hd.job.base.biz.impl.HdSyncServiceImpl;
import com.sbm.module.partner.hd.job.base.domain.HdSyncDetail;
import com.sbm.module.partner.hd.view.promotionkind.biz.IPromotionKindService;
import com.sbm.module.partner.hd.view.promotionkind.domain.PromotionKind;

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
@Component("hdSyncPromotionKindServiceImpl")
public class HdSyncPromotionKindServiceImpl extends HdSyncServiceImpl implements ISyncPromotionKindService {

	@Autowired
	private ITOLBidPromotionKindService service;

	@Autowired
	private IPromotionKindService promotionKindService;

	public void sync() {
		HdSyncDetail<TOLBidPromotionKind> detail = getSyncDetail();
		List<PromotionKind> list = promotionKindService.findAll();
		for (PromotionKind obj : list) {
			TOLBidPromotionKind po = service.findByItemNo(obj.getItemno());
			// 不存在新增
			if (null == po) {
				po = new TOLBidPromotionKind();
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
		log(detail, TOLBidPromotionKind.class);
	}

	/**
	 * 
	 * convert:转换
	 * 
	 * @author junkai.zhang
	 * @param po
	 * @param obj
	 */
	private void convert(TOLBidPromotionKind po, PromotionKind obj) {
		po.setItemNo(obj.getItemno());
		po.setItemKey(obj.getKey());
		po.setItemValue(obj.getValue());
	}

}
