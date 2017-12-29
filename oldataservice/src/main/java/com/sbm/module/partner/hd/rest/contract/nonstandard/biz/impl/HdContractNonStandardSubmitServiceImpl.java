package com.sbm.module.partner.hd.rest.contract.nonstandard.biz.impl;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.restinteractive.annotation.RestInteractive;
import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.partner.hd.rest.base.biz.impl.HdInteractiveServiceImpl;
import com.sbm.module.partner.hd.rest.base.constant.HdConstant;
import com.sbm.module.partner.hd.rest.base.domain.HdResult;
import com.sbm.module.partner.hd.rest.contract.base.domain.HdContract;
import com.sbm.module.partner.hd.rest.contract.nonstandard.biz.IHdContractNonStandardSubmitService;
import com.sbm.module.partner.hd.rest.contract.nonstandard.domain.HdContractNonStandardResult;
import com.sbm.module.partner.hd.rest.contract.preview.biz.IHdContractPreviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
public class HdContractNonStandardSubmitServiceImpl extends HdInteractiveServiceImpl implements IHdContractNonStandardSubmitService {

	@Autowired
	@Qualifier("hdRestTemplate")
	private RestTemplate restTemplate;

//	private static final String METHOD = "/rest/onlineleasing/contract/saveNewIntentionRequest";
	private static final String METHOD = "/rest/onlineleasing/contract/saveNewIntentionRequest?time=2016-06-13  11:11:11&operator.id=lixiaohong&operator.fullname=李小红&operator.namespace=hd";

	@RestInteractive
	public HdResult<HdContractNonStandardResult> nonstandardSubmit(List<HdContract> hdContracts) {
		String uri = HdConstant.BASE_URL + METHOD;
		CommonConstant.FRAMEWORK.info("uri: " + uri);
		String request = JSON.toJSONString(hdContracts);
		CommonConstant.FRAMEWORK.info("request: " + request);
		HttpEntity<String> entity = getHttpHeader(request);
		ResponseEntity<HdResult<HdContractNonStandardResult>> result = restTemplate.exchange(uri, HttpMethod.POST, entity,
				new ParameterizedTypeReference<HdResult<HdContractNonStandardResult>>() {
				});
		CommonConstant.FRAMEWORK.info("vo: " + JSON.toJSONString(result));
		return result.getBody();
	}

}
