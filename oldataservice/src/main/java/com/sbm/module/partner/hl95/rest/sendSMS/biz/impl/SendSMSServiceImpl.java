package com.sbm.module.partner.hl95.rest.sendSMS.biz.impl;

import java.net.URLEncoder;
import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.restinteractive.annotation.RestInteractive;
import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.partner.hl95.rest.base.constant.Hl95Constant;
import com.sbm.module.partner.hl95.rest.sendSMS.biz.ISendSMSService;
import com.sbm.module.partner.hl95.rest.sendSMS.constant.SendSMSCode;
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
public class SendSMSServiceImpl extends BusinessServiceImpl implements ISendSMSService {

	@Autowired
	@Qualifier("hl95RestTemplate")
	private RestTemplate restTemplate;

	private static final String METHOD = "?username={0}&password={1}&epid={2}&phone={3}&message={4}&linkid={5}&subcode={6}";

	@Value("#{propertiesReader['hl95.username']}")
	private String username;
	@Value("#{propertiesReader['hl95.password']}")
	private String password;
	@Value("#{propertiesReader['hl95.epid']}")
	private String epid;

	private static final String ERR_IP = "ERR IP";
	private static final String PREFIX = "C";

	@RestInteractive
	public SendSMSResult sendSMS(SendSMS sms) {
		String uri = Hl95Constant.BASE_URL + METHOD;
		try {
			uri = MessageFormat.format(uri, username, password, epid, sms.getPhone(),
					URLEncoder.encode(sms.getMessage(), Hl95Constant.ENCODE), sms.getLinkid(), sms.getSubcode());
		} catch (Exception e) {
			throw new BusinessException(BusinessCode.C9999, e);
		}
		CommonConstant.FRAMEWORK.info("uri: " + uri);
		String returnCode = restTemplate.getForObject(uri, String.class);
		// result.setUri(uri);
		CommonConstant.FRAMEWORK.info("vo: " + JSON.toJSONString(returnCode));

		SendSMSResult result = new SendSMSResult();
		result.setReturnCode(returnCode);
		if (returnCode.contains(ERR_IP)) {
			result.setReturnMessage(SendSMSCode.CERRIP.getReturnMessage());
		} else {
			try {
				SendSMSCode code = SendSMSCode.valueOf(PREFIX + returnCode);
				result.setReturnMessage(code.getReturnMessage());
			} catch (Exception e) {
				CommonConstant.FRAMEWORK.warn("hl95 sendSMS returnCode is unrecognized ");
			}
		}
		return result;
	}

}
