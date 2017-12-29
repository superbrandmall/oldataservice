package com.sbm.module.onlineleasing.api.merchantdetail.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.merchantdetail.biz.IMerchantDetailService;
import com.sbm.module.onlineleasing.api.merchantdetail.domain.MerchantDetail;
import com.sbm.module.onlineleasing.base.merchantdetail.courtannouncement.biz.ITOLMerchantCourtAnnouncementService;
import com.sbm.module.onlineleasing.base.merchantdetail.illegalinfo.biz.ITOLMerchantIllegalInfoService;
import com.sbm.module.onlineleasing.base.merchantdetail.lawsuit.biz.ITOLMerchantLawsuitService;
import com.sbm.module.onlineleasing.base.merchantdetail.owntax.biz.ITOLMerchantOwnTaxService;
import com.sbm.module.onlineleasing.base.merchantdetail.punishmentinfo.biz.ITOLMerchantPunishmentInfoService;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/
/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.biz.impl<br/>
 * File Name:EdiInteractiveDetailServiceImpl.java<br/>
 * 
 * 作成日 ：2016-1-4 下午5:05:55 <br/>
 * 
 * @author ：junkai.zhang 
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
/**
 * @preserve public
 */
@Component
@Transactional(value = TransactionConstant.OL, propagation = Propagation.REQUIRED)
public class MerchantDetailServiceImpl extends BusinessServiceImpl implements IMerchantDetailService {

	@Autowired
	private ITOLMerchantCourtAnnouncementService merchantCourtAnnouncementService;
	@Autowired
	private ITOLMerchantIllegalInfoService merchantIllegalInfoService;
	@Autowired
	private ITOLMerchantLawsuitService merchantLawsuitService;
	@Autowired
	private ITOLMerchantOwnTaxService merchantOwnTaxService;
	@Autowired
	private ITOLMerchantPunishmentInfoService merchantPunishmentInfoService;

	public void findAllByConditionPage(MerchantDetail detail) {
		if (null != detail.getMerchantCourtAnnouncement()) {
			detail.setMerchantCourtAnnouncements(merchantCourtAnnouncementService.findAllByConditionPage(detail
					.getMerchantCourtAnnouncement()));
		}
		if (null != detail.getMerchantIllegalInfo()) {
			detail.setMerchantIllegalInfos(merchantIllegalInfoService.findAllByConditionPage(detail
					.getMerchantIllegalInfo()));
		}

		if (null != detail.getMerchantLawsuit()) {
			detail.setMerchantLawsuits(merchantLawsuitService.findAllByConditionPage(detail.getMerchantLawsuit()));
		}

		if (null != detail.getMerchantOwnTax()) {
			detail.setMerchantOwnTaxs(merchantOwnTaxService.findAllByConditionPage(detail.getMerchantOwnTax()));
		}

		if (null != detail.getMerchantPunishmentInfo()) {
			detail.setMerchantPunishmentInfos(merchantPunishmentInfoService.findAllByConditionPage(detail
					.getMerchantPunishmentInfo()));
		}
	}
}
