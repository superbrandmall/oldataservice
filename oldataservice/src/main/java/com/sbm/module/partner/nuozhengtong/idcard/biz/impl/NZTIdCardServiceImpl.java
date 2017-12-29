package com.sbm.module.partner.nuozhengtong.idcard.biz.impl;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.restinteractive.annotation.RestInteractive;
import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.base.util.CodecUtil;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.partner.hl95.rest.base.constant.Hl95Constant;
import com.sbm.module.partner.hl95.rest.sendSMS.biz.ISendSMSService;
import com.sbm.module.partner.hl95.rest.sendSMS.constant.SendSMSCode;
import com.sbm.module.partner.hl95.rest.sendSMS.domain.SendSMS;
import com.sbm.module.partner.hl95.rest.sendSMS.domain.SendSMSResult;
import com.sbm.module.partner.nuozhengtong.base.constant.NZTConstant;
import com.sbm.module.partner.nuozhengtong.idcard.biz.INZTIdCardService;
import com.sbm.module.partner.nuozhengtong.idcard.domain.NZTIdCard;
import com.sbm.module.partner.nuozhengtong.idcard.domain.NZTIdCardResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.MessageFormat;
import java.util.Date;

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
public class NZTIdCardServiceImpl extends BusinessServiceImpl implements INZTIdCardService {

	@Autowired
	@Qualifier("nztRestTemplate")
	private RestTemplate restTemplate;

	private static final String SUCCESS_CODE = "1000";

	private static final String METHOD = "/v2/id-server?mall_id={0}&realname={1}&idcard={2}&tm={3}&sign={4}";

	@Value("#{propertiesReader['nzt.mallId']}")
	private String mallId;
	@Value("#{propertiesReader['nzt.appkey']}")
	private String appkey;

	private static final String ERR_IP = "ERR IP";
	private static final String PREFIX = "C";

	@RestInteractive
	public NZTIdCardResult idCardCheck(String name, String idCard) {
		NZTIdCard nztIdCard = new NZTIdCard();
		nztIdCard.setRealname(name);
		nztIdCard.setIdcard(idCard);
		return idCardCheck(nztIdCard);
	}

	@RestInteractive
	public NZTIdCardResult idCardCheck(NZTIdCard nztIdCard) {
		String uri = NZTConstant.BASE_URL + METHOD;
		nztIdCard.setTm(System.currentTimeMillis());
		String md5Param = mallId + nztIdCard.getRealname() + nztIdCard.getIdcard() + nztIdCard.getTm() + appkey;
		nztIdCard.setSign(CodecUtil.md5Hex(md5Param));
		uri = MessageFormat.format(uri, mallId, nztIdCard.getRealname(), nztIdCard.getIdcard(), nztIdCard.getTm().toString(), nztIdCard.getSign());

		CommonConstant.FRAMEWORK.info("uri: " + uri);
		NZTIdCardResult result = restTemplate.getForObject(uri, NZTIdCardResult.class);
		// result.setUri(uri);
		CommonConstant.FRAMEWORK.info("vo: " + JSON.toJSONString(result));

		return result;
	}

	public void check(NZTIdCardResult result){
		if (SUCCESS_CODE.equals(result.getData().getCode())) {

		} else {
			throw new BusinessException(BusinessCode.C0400, new Object[] {JSON.toJSONString(result)}, null);
		}
	}

}
