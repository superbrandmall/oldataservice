package com.sbm.module.onlineleasing.api.admin.merchantdetail.biz.impl;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.admin.merchantdetail.biz.IProcessOwnTaxService;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.onlineleasing.base.merchantdetail.owntax.biz.ITOLMerchantOwnTaxService;
import com.sbm.module.onlineleasing.base.merchantdetail.owntax.domain.TOLMerchantOwnTax;
import com.sbm.module.partner.tianyancha.rest.owntax.biz.IOwnTaxService;
import com.sbm.module.partner.tianyancha.rest.owntax.domain.OwnTax;
import com.sbm.module.partner.tianyancha.rest.owntax.domain.OwnTaxItem;

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
public class ProcessOwnTaxServiceImpl extends BusinessServiceImpl implements IProcessOwnTaxService {

	@Autowired
	private ITOLMerchantOwnTaxService service;

	@Autowired
	private IOwnTaxService tycService;

	public void process(TOLMerchant obj) {
		// 删除记录
		service.deleteByCode(obj.getCode());
		// 添加记录
		TOLMerchantOwnTax po = null;
		try {
			// 查询记录
			OwnTax tmpList = tycService.findResultByName(obj.getName(), null);
			for (OwnTaxItem tmp : tmpList.getData().getItems()) {
				po = new TOLMerchantOwnTax();
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

	private void convert(TOLMerchantOwnTax po, OwnTaxItem tmp) {
		po.setPersonIdNumber(tmp.getPersonIdNumber());
		po.setLegalpersonName(tmp.getLegalpersonName());
		po.setLocation(tmp.getLocation());
		po.setNewOwnTaxBalance(tmp.getNewOwnTaxBalance());
		po.setName(tmp.getName());
		po.setOwnTaxBalance(tmp.getOwnTaxBalance());
		po.setTaxIdNumber(tmp.getTaxIdNumber());
		po.setType(tmp.getType());
		po.setTaxCategory(tmp.getTaxCategory());
	}

}
