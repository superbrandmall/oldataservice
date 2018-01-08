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
import com.sbm.module.onlineleasing.api.admin.merchantdetail.biz.IProcessIllegalInfoService;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.onlineleasing.base.merchantdetail.illegalinfo.biz.ITOLMerchantIllegalInfoService;
import com.sbm.module.onlineleasing.base.merchantdetail.illegalinfo.domain.TOLMerchantIllegalInfo;
import com.sbm.module.partner.tianyancha.rest.illegalinfo.biz.IIllegalInfoService;
import com.sbm.module.partner.tianyancha.rest.illegalinfo.domain.IllegalInfo;
import com.sbm.module.partner.tianyancha.rest.illegalinfo.domain.IllegalInfoItem;

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
public class ProcessIllegalInfoServiceImpl extends BusinessServiceImpl implements IProcessIllegalInfoService {

	@Autowired
	private ITOLMerchantIllegalInfoService service;

	@Autowired
	private IIllegalInfoService tycService;

	public void process(TOLMerchant obj) {
		// 删除记录
		service.deleteByCode(obj.getCode());
		// 添加记录
		TOLMerchantIllegalInfo po = null;
		try {
			// 查询记录
			IllegalInfo tmpList = tycService.findResultByName(obj.getName(), null);
			for (IllegalInfoItem tmp : tmpList.getData().getItems()) {
				po = new TOLMerchantIllegalInfo();
				// 设置code
				po.setCode(obj.getCode());
				// 转换
				convert(po, tmp);
				service.save(po);
				CommonConstant.FRAMEWORK.info(MessageFormat.format("{0}: save {1} ", this.getClass().getSimpleName(),
						String.valueOf(tmpList.getData().getItems().size())));
			}
		} catch (Exception e) {
			CommonConstant.FRAMEWORK.info(MessageFormat.format("{0}: {1}", this.getClass().getSimpleName(),
					e.getMessage()));
		}
	}

	private void convert(TOLMerchantIllegalInfo po, IllegalInfoItem tmp) {
		po.setPutReason(tmp.getPutReason());
		if (null != tmp.getPutDate()) {
			po.setPutDate(new Date(tmp.getPutDate()));
		}
		po.setPutDepartment(tmp.getPutDepartment());
		po.setRemoveReason(tmp.getRemoveReason());
		po.setRemoveDepartment(tmp.getRemoveDepartment());
	}

}
