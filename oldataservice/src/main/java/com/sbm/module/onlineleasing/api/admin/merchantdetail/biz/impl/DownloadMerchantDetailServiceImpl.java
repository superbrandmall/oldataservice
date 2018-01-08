package com.sbm.module.onlineleasing.api.admin.merchantdetail.biz.impl;

import com.sbm.module.onlineleasing.api.admin.merchantdetail.biz.IProcessCourtAccountmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.admin.merchantdetail.biz.IDownloadMerchantDetailService;
import com.sbm.module.onlineleasing.api.admin.merchantdetail.biz.IProcessIllegalInfoService;
import com.sbm.module.onlineleasing.api.admin.merchantdetail.biz.IProcessLawsuitService;
import com.sbm.module.onlineleasing.api.admin.merchantdetail.biz.IProcessOwnTaxService;
import com.sbm.module.onlineleasing.api.admin.merchantdetail.biz.IProcessPunishmentInfoService;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;

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
public class DownloadMerchantDetailServiceImpl extends BusinessServiceImpl implements IDownloadMerchantDetailService {

	@Autowired
	private IProcessCourtAccountmentService processCourtAccountmentService;
	@Autowired
	private IProcessIllegalInfoService processIllegalInfoService;
	@Autowired
	private IProcessLawsuitService processLawsuitService;
	@Autowired
	private IProcessOwnTaxService processOwnTaxService;
	@Autowired
	private IProcessPunishmentInfoService punishmentInfoService;

	public void download(TOLMerchant obj) {
		processCourtAccountmentService.process(obj);
		processIllegalInfoService.process(obj);
		processLawsuitService.process(obj);
		processOwnTaxService.process(obj);
		punishmentInfoService.process(obj);
	}

}
