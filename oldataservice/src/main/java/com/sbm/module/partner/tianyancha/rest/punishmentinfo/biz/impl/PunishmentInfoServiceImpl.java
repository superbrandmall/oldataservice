package com.sbm.module.partner.tianyancha.rest.punishmentinfo.biz.impl;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.restinteractive.annotation.RestInteractive;
import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.partner.tianyancha.rest.base.constant.TianYanChaConstant;
import com.sbm.module.partner.tianyancha.rest.punishmentinfo.biz.IPunishmentInfoService;
import com.sbm.module.partner.tianyancha.rest.punishmentinfo.domain.PunishmentInfo;
import com.sbm.module.partner.tianyancha.rest.punishmentinfo.domain.PunishmentInfoVo;

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
public class PunishmentInfoServiceImpl extends BusinessServiceImpl implements IPunishmentInfoService {

	@Autowired
	@Qualifier("tycRestTemplate")
	private RestTemplate restTemplate;

	private static final String METHOD = "/newopen/punishmentInfo.json?name={0}&pageNum={1}";

	public void getVo(PunishmentInfoVo vo) {
		PunishmentInfo result = findResultByName(vo.getName(), vo.getPageNum());
		vo.setResult(result);
	}

	@RestInteractive
	public PunishmentInfo findResultByName(String name, Integer pageNum) {
		if (null == pageNum) {
			pageNum = 1;
		}
		String uri = TianYanChaConstant.BASE_URL + METHOD;
		uri = MessageFormat.format(uri, name, pageNum);
		CommonConstant.FRAMEWORK.info("uri: " + uri);
		PunishmentInfo result = restTemplate.getForObject(uri, PunishmentInfo.class);
		CommonConstant.FRAMEWORK.info("vo: " + JSON.toJSONString(result));
		// // 没有查到相关信息抛出异常
		// if (null == result || null == result.getData() || null ==
		// result.getData().getItems()
		// || result.getData().getItems().isEmpty()) {
		// throw new BusinessException(BusinessCode.C0300, new Object[] { uri },
		// null);
		// }
		return result;
	}

}
