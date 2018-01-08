package com.sbm.module.onlineleasing.api.admin.merchantdetail.biz.impl;

import java.text.MessageFormat;

import com.sbm.module.onlineleasing.api.admin.merchantdetail.biz.IProcessCourtAccountmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.onlineleasing.base.merchantdetail.courtannouncement.biz.ITOLMerchantCourtAnnouncementService;
import com.sbm.module.onlineleasing.base.merchantdetail.courtannouncement.domain.TOLMerchantCourtAnnouncement;
import com.sbm.module.partner.tianyancha.rest.courtannouncement.biz.ICourtAnnouncementService;
import com.sbm.module.partner.tianyancha.rest.courtannouncement.domain.CourtAnnouncement;
import com.sbm.module.partner.tianyancha.rest.courtannouncement.domain.CourtAnnouncements;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.onlineleasing.api.merchantdetail.biz.impl<br/>
 * File Name:ProcessCourtAccountmentServiceImpl.java<br/>
 * 
 * 作成日 ：2017-10-20 下午3:33:57 <br/>
 * 
 * @author ：junkai.zhang
 */
@Component
@Transactional(value = TransactionConstant.OL, propagation = Propagation.REQUIRED)
public class ProcessCourtAccountmentServiceImpl extends BusinessServiceImpl implements IProcessCourtAccountmentService {

	@Autowired
	private ITOLMerchantCourtAnnouncementService service;

	@Autowired
	private ICourtAnnouncementService tycService;

	public void process(TOLMerchant obj) {
		// 删除记录
		service.deleteByCode(obj.getCode());
		// 添加记录
		TOLMerchantCourtAnnouncement po = null;
		try {
			// 查询记录
			CourtAnnouncements tmpList = tycService.findResultByName(obj.getName(), null);
			for (CourtAnnouncement tmp : tmpList.getCourtAnnouncements()) {
				po = new TOLMerchantCourtAnnouncement();
				// 设置code
				po.setCode(obj.getCode());
				// 转换
				convert(po, tmp);
				service.save(po);
			}
			CommonConstant.FRAMEWORK.info(MessageFormat.format("{0}: save {1} ", this.getClass().getSimpleName(),
					String.valueOf(tmpList.getCourtAnnouncements().size())));
		} catch (Exception e) {
			CommonConstant.FRAMEWORK.info(MessageFormat.format("{0}: {1}", this.getClass().getSimpleName(),
					e.getMessage()));
		}
	}

	private void convert(TOLMerchantCourtAnnouncement po, CourtAnnouncement tmp) {
		po.setAnnounceId(tmp.getAnnounce_id());
		po.setBltnno(tmp.getBltnno());
		po.setBltnstate(tmp.getBltnstate());
		po.setBltntype(tmp.getBltntype());
		po.setBltntypename(tmp.getBltntypename());
		po.setCaseno(tmp.getCaseno());
		po.setContent(tmp.getContent());
		po.setCourtcode(tmp.getCourtcode());
		po.setDealgrade(tmp.getDealgrade());
		po.setDealgradename(tmp.getDealgradename());
		po.setJudge(tmp.getJudge());
		po.setJudgephone(tmp.getJudgephone());
		po.setMobilephone(tmp.getMobilephone());
		po.setParty1(tmp.getParty1());
		po.setParty2(tmp.getParty2());
		po.setProvince(tmp.getProvince());
		po.setPublishdate(tmp.getPublishdate());
		po.setPublishpage(tmp.getPublishpage());
	}

}
