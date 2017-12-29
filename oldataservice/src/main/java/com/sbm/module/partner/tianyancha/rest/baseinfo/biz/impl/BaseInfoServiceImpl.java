package com.sbm.module.partner.tianyancha.rest.baseinfo.biz.impl;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.restinteractive.annotation.RestInteractive;
import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.partner.tianyancha.rest.base.constant.TianYanChaConstant;
import com.sbm.module.partner.tianyancha.rest.baseinfo.biz.IBaseInfoService;
import com.sbm.module.partner.tianyancha.rest.baseinfo.domain.BaseInfo;
import com.sbm.module.partner.tianyancha.rest.baseinfo.domain.BaseInfoVo;

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
public class BaseInfoServiceImpl extends BusinessServiceImpl implements IBaseInfoService {

	@Autowired
	@Qualifier("tycRestTemplate")
	private RestTemplate restTemplate;

	private static final String METHOD = "/newopen/baseinfo.json?id={0}";

	public void getVo(BaseInfoVo vo) {
		BaseInfo result = findResultById(vo.getId());
		vo.setResult(result);
	}

	@RestInteractive
	public BaseInfo findResultById(String id) {
		String uri = TianYanChaConstant.BASE_URL + METHOD;
		uri = MessageFormat.format(uri, id);
		CommonConstant.FRAMEWORK.info("uri: " + uri);
		BaseInfo result = restTemplate.getForObject(uri, BaseInfo.class);
		result.setUri(uri);
		CommonConstant.FRAMEWORK.info("vo: " + JSON.toJSONString(result));

		return result;
	}

	public void check(BaseInfo result) {
		// 没有查到相关信息抛出异常
		if (null == result || null == result.getResult()) {
			throw new BusinessException(BusinessCode.C0300, new Object[] { result.getUri() }, null);
		}
	}

}
