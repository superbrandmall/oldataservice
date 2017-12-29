package com.sbm.module.common.api.verificationcode.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.api.mail.domain.MailData;
import com.sbm.module.common.api.mail.domain.TCMailSendDetail;
import com.sbm.module.common.api.mail.domain.TCMailTemplate;
import com.sbm.module.common.api.redis.constant.RedisConstant;
import com.sbm.module.common.api.sms.domain.SMSData;
import com.sbm.module.common.api.sms.domain.TCSMSSendDetail;
import com.sbm.module.common.api.sms.domain.TCSMSTemplate;
import com.sbm.module.common.api.verificationcode.biz.IVerificationCodeService;
import com.sbm.module.common.api.verificationcode.constant.VerificationCodeConstant;
import com.sbm.module.common.api.verificationcode.domain.VerificationCode;
import com.sbm.module.common.api.verificationcode.event.EmailVerificationCodeEvent;
import com.sbm.module.common.api.verificationcode.event.SMSVerificationCodeEvent;
import com.sbm.module.common.api.verificationcode.util.VerificationCodeUtil;
import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.base.pulisher.constant.BusinessEventListenerConstant;
import com.sbm.module.common.base.pulisher.template.BusinessEventTemplate;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.util.ParamsUtil;

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
public class VerificationCodeServiceImpl extends BusinessServiceImpl implements IVerificationCodeService {

	@Autowired
	private VerificationCodeUtil util;

	/**
	 * 邮件模板code
	 */
	@Value("#{propertiesReader['verificationcode.emailVerificationCode']}")
	private String emailVerificationCode;
	/**
	 * 短信模板code
	 */
	@Value("#{propertiesReader['verificationcode.smsVerificationCode']}")
	private String smsVerificationCode;

	/***********************************************************************************************/
	// 发送邮件验证码

	public void getEmailVerificationCode(VerificationCode verificationCode) {
		setKey(RedisConstant.PREFIX_EMAIL, verificationCode);
		setValue(verificationCode);
		set2redis(verificationCode.getKey(), verificationCode.getValue());
		// 发送邮件
		MailData mailData = new MailData();
		// 设置邮件模板
		mailData.setMailTemplate(new TCMailTemplate(emailVerificationCode));
		// 创建发送列表
		List<TCMailSendDetail> details = new ArrayList<TCMailSendDetail>();
		// 创建发送明细
		TCMailSendDetail detail = new TCMailSendDetail();
		// 设置发送明细发送人
		detail.setSentTo(verificationCode.getKeyword());
		// 创建发送明细参数
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		// 设置发送明细参数
		paramsMap.put(VerificationCodeConstant.VERIFICATIONCODE, verificationCode.getValue());
		// 设置参数到明细
		detail.setParamsMap(paramsMap);
		// 设置明细到列表
		details.add(detail);
		// 设置列表
		mailData.setDetails(details);
		// 发送邮件
		BusinessEventTemplate template = getTemplate().put(BusinessEventListenerConstant.MAIL, mailData);
		publishEvent(new EmailVerificationCodeEvent(template));
		// 清除验证码
		verificationCode.setValue(null);
	}

	/***********************************************************************************************/
	// 发送手机验证码

	public void getMobileVerificationCode(VerificationCode verificationCode) {
		setKey(RedisConstant.PREFIX_MOBILE, verificationCode);
		setValue(verificationCode);
		set2redis(verificationCode.getKey(), verificationCode.getValue());
		// 发送短信
		SMSData smsData = new SMSData();
		// 设置短信模板
		smsData.setSmsTemplate(new TCSMSTemplate(smsVerificationCode));
		// 创建发送列表
		List<TCSMSSendDetail> details = new ArrayList<TCSMSSendDetail>();
		// 创建发送明细
		TCSMSSendDetail detail = new TCSMSSendDetail();
		// 设置发送明细发送人
		detail.setSentTo(verificationCode.getKeyword());
		// 创建发送明细参数
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		// 设置发送明细参数
		paramsMap.put(VerificationCodeConstant.VERIFICATIONCODE, verificationCode.getValue());
		// 设置参数到明细
		detail.setParamsMap(paramsMap);
		// 设置明细到列表
		details.add(detail);
		// 设置列表
		smsData.setDetails(details);
		// 发送邮件
		BusinessEventTemplate template = getTemplate().put(BusinessEventListenerConstant.SMS, smsData);
		publishEvent(new SMSVerificationCodeEvent(template));
		// 清除验证码 TODO
		verificationCode.setValue(null);
	}

	/***********************************************************************************************/
	// 公共方法

	/**
	 * 
	 * setKey:设置key
	 * 
	 * @author junkai.zhang
	 * @param prefix
	 * @param verificationCode
	 */
	private void setKey(String prefix, VerificationCode verificationCode) {
		if (StringUtils.isEmpty(verificationCode.getKeyword())) {
			throw new BusinessException(BusinessCode.C0100, null);
		}
		verificationCode.setKey(prefix + verificationCode.getKeyword() + RedisConstant.UNDER_LINE + getUUID());
	}

	/**
	 * 
	 * setValue:设置值
	 * 
	 * @author junkai.zhang
	 * @param verificationCode
	 */
	private void setValue(VerificationCode verificationCode) {
		verificationCode.setValue(util.generateStandardVerificationCode());
	}

	/***********************************************************************************************/
	// 校验验证码

	public void checkVerificationCode(VerificationCode verificationCode) {
		checkVerificationCode(verificationCode, false);
	}

	public void checkVerificationCode(VerificationCode verificationCode, boolean delete) {
		ParamsUtil.canNotBeNull(verificationCode);
		if (StringUtils.isBlank(verificationCode.getKey())) {
			throw new BusinessException(BusinessCode.C0101, null);
		}
		String valuec = (String) verificationCode.getValue();
		String valuer = (String) redisService.get(verificationCode.getKey());
		if (!valuec.equalsIgnoreCase(valuer)) {
			throw new BusinessException(BusinessCode.C0102, new Object[] { valuec }, null);
		}
		if (delete) {
			// 删除key
			redisService.delete(verificationCode.getKey());
		}
	}

}
