package com.sbm.module.onlineleasing.api.admin.merchantdetail.biz.impl;

import java.text.MessageFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.admin.merchantdetail.biz.IProcessLawsuitService;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.onlineleasing.base.merchantdetail.lawsuit.biz.ITOLMerchantLawsuitService;
import com.sbm.module.onlineleasing.base.merchantdetail.lawsuit.domain.TOLMerchantLawsuit;
import com.sbm.module.partner.tianyancha.rest.lawsuit.biz.ILawSuitService;
import com.sbm.module.partner.tianyancha.rest.lawsuit.domain.LawSuit;
import com.sbm.module.partner.tianyancha.rest.lawsuit.domain.LawSuitItem;

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
public class ProcessLawsuitServiceImpl extends BusinessServiceImpl implements IProcessLawsuitService {

	@Autowired
	private ITOLMerchantLawsuitService service;

	@Autowired
	private ILawSuitService tycService;

	public void process(TOLMerchant obj) {
		// 删除记录
		service.deleteByCode(obj.getCode());
		// 添加记录
		TOLMerchantLawsuit po = null;
		try {
			// 查询记录
			LawSuit tmpList = tycService.findResultByName(obj.getName(), null);
			for (LawSuitItem tmp : tmpList.getData().getItems()) {
				po = new TOLMerchantLawsuit();
				// 设置code
				po.setCode(obj.getCode());
				// 转换
				convert(po, tmp);
				service.save(po);
			}
			CommonConstant.FRAMEWORK.info(MessageFormat.format("{0}: save {1} ", this.getClass().getSimpleName(),
					String.valueOf(tmpList.getData().getItems().size())));
		} catch (Exception e) {
			CommonConstant.FRAMEWORK.info(MessageFormat.format("{0}: {1}", this.getClass().getSimpleName(),
					e.getMessage()));
		}
	}

	private void convert(TOLMerchantLawsuit po, LawSuitItem tmp) {
		po.setTitle(tmp.getTitle());
		if (null != tmp.getSubmittime()) {
			po.setSubmittime(new Date(tmp.getSubmittime()));
		}
		po.setCourt(tmp.getCourt());
		po.setDoctype(tmp.getDoctype());
		po.setUrl(tmp.getUrl());
		po.setCaseno(tmp.getCaseno());
		po.setCasetype(tmp.getCasetype());
		po.setUuid(tmp.getUuid());
	}

}
