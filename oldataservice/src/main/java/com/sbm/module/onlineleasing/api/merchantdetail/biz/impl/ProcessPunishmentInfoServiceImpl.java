package com.sbm.module.onlineleasing.api.merchantdetail.biz.impl;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.merchantdetail.biz.IProcessPunishmentInfoService;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.onlineleasing.base.merchantdetail.punishmentinfo.biz.ITOLMerchantPunishmentInfoService;
import com.sbm.module.onlineleasing.base.merchantdetail.punishmentinfo.domain.TOLMerchantPunishmentInfo;
import com.sbm.module.partner.tianyancha.rest.punishmentinfo.biz.IPunishmentInfoService;
import com.sbm.module.partner.tianyancha.rest.punishmentinfo.domain.PunishmentInfo;
import com.sbm.module.partner.tianyancha.rest.punishmentinfo.domain.PunishmentInfoItem;

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
public class ProcessPunishmentInfoServiceImpl extends BusinessServiceImpl implements IProcessPunishmentInfoService {

	@Autowired
	private ITOLMerchantPunishmentInfoService service;

	@Autowired
	private IPunishmentInfoService tycService;

	public void process(TOLMerchant obj) {
		// 删除记录
		service.deleteByCode(obj.getCode());
		// 添加记录
		TOLMerchantPunishmentInfo po = null;
		try {
			// 查询记录
			PunishmentInfo tmpList = tycService.findResultByName(obj.getName(), null);
			for (PunishmentInfoItem tmp : tmpList.getData().getItems()) {
				po = new TOLMerchantPunishmentInfo();
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

	private void convert(TOLMerchantPunishmentInfo po, PunishmentInfoItem tmp) {
		po.setContent(tmp.getContent());
		po.setPunishNumber(tmp.getPunishNumber());
		po.setRegNum(tmp.getRegNum());
		po.setName(tmp.getName());
		po.setBase(tmp.getBase());
		po.setDecisionDate(tmp.getDecisionDate());
		po.setLegalPersonName(tmp.getLegalPersonName());
		po.setType(tmp.getLegalPersonName());
		po.setDepartmentName(tmp.getDepartmentName());
	}

}
