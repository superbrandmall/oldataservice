package com.sbm.module.partner.hd.job.modality.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.onlineleasing.base.modality.biz.ISyncModalityService;
import com.sbm.module.onlineleasing.base.modality.biz.ITOLModalityService;
import com.sbm.module.onlineleasing.base.modality.domain.TOLModality;
import com.sbm.module.partner.hd.job.base.biz.impl.HdSyncServiceImpl;
import com.sbm.module.partner.hd.job.base.domain.HdSyncDetail;
import com.sbm.module.partner.hd.view.biztype.biz.IBizTypeService;
import com.sbm.module.partner.hd.view.biztype.domain.BizType;

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
@Component("hdSyncModalityServiceImpl")
public class HdSyncModalityServiceImpl extends HdSyncServiceImpl implements ISyncModalityService {

	@Autowired
	private ITOLModalityService service;

	@Autowired
	private IBizTypeService bizTypeService;

	public void sync() {
		HdSyncDetail<TOLModality> detail = getSyncDetail();
		List<BizType> list = bizTypeService.findAll();
		for (BizType obj : list) {
			TOLModality po = service.findByCode(obj.getCode(), false);
			// 不存在新增
			if (null == po) {
				po = new TOLModality();
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
		log(detail, TOLModality.class);
	}

	/**
	 * 
	 * convert:转换
	 * 
	 * @author junkai.zhang
	 * @param po
	 * @param obj
	 */
	private void convert(TOLModality po, BizType obj) {
		po.setName(obj.getName());
		po.setCode(obj.getCode());
		po.setLv(getLv(obj.getCode()));
		po.setHdUuid(obj.getHdUuid());
		po.setHdLevelid(obj.getLevelid());
	}

	private String getLv(String code) {
		String lv = null;
		switch (code.length()) {
		case 2:
			lv = "1";
			break;
		case 4:
			lv = "2";
			break;
		case 6:
			lv = "3";
			break;
		case 8:
			lv = "4";
			break;
		default:
			lv = "";
			break;
		}
		return lv;
	}

}
