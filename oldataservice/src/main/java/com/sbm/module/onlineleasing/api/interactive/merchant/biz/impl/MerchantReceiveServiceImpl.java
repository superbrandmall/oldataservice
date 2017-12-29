package com.sbm.module.onlineleasing.api.interactive.merchant.biz.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.api.mail.domain.MailData;
import com.sbm.module.common.api.mail.domain.TCMailSendDetail;
import com.sbm.module.common.api.mail.domain.TCMailTemplate;
import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.base.pulisher.constant.BusinessEventListenerConstant;
import com.sbm.module.common.base.pulisher.template.BusinessEventTemplate;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.util.ParamsUtil;
import com.sbm.module.onlineleasing.api.interactive.merchant.biz.IMerchantReceiveService;
import com.sbm.module.onlineleasing.api.interactive.merchant.constant.MerchantReceiveConstant;
import com.sbm.module.onlineleasing.api.interactive.merchant.domain.MerchantReceiveVo;
import com.sbm.module.onlineleasing.api.interactive.merchant.event.MerchantReceiveEvent;
import com.sbm.module.onlineleasing.base.merchant.biz.ITOLMerchantService;
import com.sbm.module.onlineleasing.base.merchant.constant.MerchantConstant;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.onlineleasing.base.sysmessage.domain.TOLSysMessage;
import com.sbm.module.onlineleasing.base.user.biz.ITOLUserService;
import com.sbm.module.onlineleasing.base.user.domain.TOLUser;

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
public class MerchantReceiveServiceImpl extends BusinessServiceImpl implements IMerchantReceiveService {

	@Value("#{propertiesReader['application.MerchantReceiveServiceImpl.mailTemplateCode']}")
	private String mailTemplateCode;

	@Autowired
	private ITOLMerchantService merchantService;
	@Autowired
	private ITOLUserService userService;

	public void receive(MerchantReceiveVo vo) {
		// 准入
		if (MerchantReceiveConstant.ACCRESS.equalsIgnoreCase(vo.getMethod())) {
			doAccress(vo);
		}
		// 修改
		else if (MerchantReceiveConstant.UPDATE.equalsIgnoreCase(vo.getMethod())) {
			// TODO
			doUpdate(vo);
		}
		// 操作码不正确
		else {
			throw new BusinessException(BusinessCode.C11000, new Object[] { vo.getMethod() }, null);
		}
	}

	/****************************************************************************/

	/**
	 * 
	 * doAccress:商户准入
	 * 
	 * @author junkai.zhang
	 * @param vo
	 */
	private void doAccress(MerchantReceiveVo vo) {
		ParamsUtil.canNotBeEmpty(vo.getMerchant().getCode());
		TOLMerchant merchant = merchantService.findByCode(vo.getMerchant().getCode());
		if (null == merchant) {
			throw new BusinessException(BusinessCode.C5200, new Object[] { vo.getMerchant().getCode() }, null);
		}
		// 目前全部成功
		// TODO
		if (true) {
			merchant.setAuthState(MerchantConstant.AUTHENTICATED);
		}
		merchantService.update(merchant);
		accressInfo(merchant);
	}

	/**
	 * 
	 * accressInfo:准入通知
	 * 
	 * @author junkai.zhang
	 * @param merchant
	 */
	private void accressInfo(TOLMerchant merchant) {
		List<TOLUser> list = userService.findAllByMerchantCode(merchant.getCode());
		String message = MessageFormat.format("您的商户（{0}）审核已通过", merchant.getName());
		// 发送邮件
		MailData mailData = new MailData();
		// 设置邮件模板
		mailData.setMailTemplate(new TCMailTemplate(mailTemplateCode));
		// 创建发送列表
		List<TCMailSendDetail> details = new ArrayList<TCMailSendDetail>();
		// 创建系统消息列表
		List<TOLSysMessage> sysMessages = new ArrayList<TOLSysMessage>();

		TCMailSendDetail detail = null;
		TOLSysMessage sysMessage = null;
		for (TOLUser user : list) {
			// 创建发送明细
			detail = new TCMailSendDetail();
			// 设置发送明细发送人
			detail.setSentTo(user.getEmail());
			// 创建发送明细参数
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			// 设置发送明细参数
			paramsMap.put(MerchantReceiveConstant.MESSAGE, message);
			// 设置参数到明细
			detail.setParamsMap(paramsMap);
			// 设置明细到列表
			details.add(detail);

			// 创建系统消息明细
			sysMessage = new TOLSysMessage(user.getCode(), message);
			// 设置明细到列表
			sysMessages.add(sysMessage);
		}
		// 设置列表
		mailData.setDetails(details);
		// 设置模板
		BusinessEventTemplate template = getTemplate().put(BusinessEventListenerConstant.MAIL, mailData).put(
				BusinessEventListenerConstant.SysMessage, sysMessages);
		publishEvent(new MerchantReceiveEvent(template));

	}

	/****************************************************************************/

	/**
	 * 
	 * doUpdate:商户更新
	 * 
	 * @author junkai.zhang
	 * @param vo
	 */
	private void doUpdate(MerchantReceiveVo vo) {

	}

}
