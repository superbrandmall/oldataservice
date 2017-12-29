package com.sbm.module.common.api.sms.biz.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.freemarker.biz.IFreeMarkerService;
import com.sbm.module.common.api.freemarker.util.FreeMarkerUtil;
import com.sbm.module.common.api.sms.biz.ISMSService;
import com.sbm.module.common.api.sms.biz.ITCSMSSendDetailService;
import com.sbm.module.common.api.sms.biz.ITCSMSTemplateService;
import com.sbm.module.common.api.sms.constant.SMSConstant;
import com.sbm.module.common.api.sms.domain.SMSData;
import com.sbm.module.common.api.sms.domain.TCSMSSendDetail;
import com.sbm.module.common.api.sms.domain.TCSMSTemplate;
import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.partner.hl95.rest.sendSMS.biz.ISendSMSService;
import com.sbm.module.partner.hl95.rest.sendSMS.domain.SendSMS;
import com.sbm.module.partner.hl95.rest.sendSMS.domain.SendSMSResult;

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
public class SMSServiceImpl extends BusinessServiceImpl implements ISMSService {

	@Autowired
	private FreeMarkerUtil fk;
	@Autowired
	@Qualifier("taskExecutor4sms")
	private TaskExecutor taskExecutor;
	@Autowired
	private IFreeMarkerService freeMarkerService;
	@Autowired
	private ITCSMSTemplateService smsTemplateService;
	@Autowired
	private ITCSMSSendDetailService smsSendDetailService;

	/**
	 * hl95发送
	 */
	@Autowired
	private ISendSMSService sendSMSService;

	public void sendSMS(SMSData smsData) {
		// 根据code查询模板
		smsData.setSmsTemplate(smsTemplateService.findByCode(smsData.getSmsTemplate().getCode()));
		for (TCSMSSendDetail detail : smsData.getDetails()) {
			sendSMSByAsyncMode(smsData.getSmsTemplate(), detail);
		}
	}

	/**
	 * 
	 * sendSMSByAsyncMode:异步发送
	 * 
	 * @author junkai.zhang
	 * @param smsTemplate
	 * @param detail
	 */
	private void sendSMSByAsyncMode(final TCSMSTemplate smsTemplate, final TCSMSSendDetail detail) {
		taskExecutor.execute(new Runnable() {
			public void run() {
				sendSMSBySyncMode(smsTemplate, detail);
			}
		});
	}

	/**
	 * 
	 * sendSMSBySyncMode:同步发送(hl95)
	 * 
	 * @author junkai.zhang
	 * @param smsTemplate
	 * @param detail
	 */
	private void sendSMSBySyncMode(TCSMSTemplate smsTemplate, TCSMSSendDetail detail) {
		try {
			SendSMS sms = new SendSMS();
			// 设置明细
			setDetail(smsTemplate, detail);
			// 设置发送手机
			sms.setPhone(detail.getSentTo());
			// 设置发送内容
			sms.setMessage(detail.getMessage());
			// 发送
			SendSMSResult result = sendSMSService.sendSMS(sms);
			// 设置返回码
			detail.setReturnCode(result.getReturnCode());
			// 设置返回信息
			detail.setReturnMessage(result.getReturnMessage());
		} catch (Exception e) {
			// 发送不成功
			detail.setType(SMSConstant.FAILURE);
			// 保存错误信息
			detail.setErrorMessage(getStackTrace(e));
			// 打印错误日志
			CommonConstant.ERRORDATA.error(detail, e);
		}
		smsSendDetailService.saveSMSSendDetail(detail);
	}

	private void setDetail(TCSMSTemplate smsTemplate, TCSMSSendDetail detail) {
		// 模板代码
		detail.setSmsTemplateCode(smsTemplate.getCode());
		// 参数
		detail.setParams(JSON.toJSONString(detail.getParamsMap()));
		// 发送时间
		detail.setSentDate(new Date());
		// 邮件html
		detail.setMessage(freeMarkerService.getFreeMarkerTemplate(smsTemplate.getFilePrefix(),
				smsTemplate.getFileName(), detail.getParamsMap()));
		// 默认发送状态 1：成功 0：失败
		detail.setType(SMSConstant.SUCCESS);
	}
}
