package com.sbm.module.partner.hd.rest.shop.biz.impl;

import com.sbm.module.partner.hd.rest.base.biz.impl.HdInteractiveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.restinteractive.annotation.RestInteractive;
import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.partner.hd.rest.base.constant.HdConstant;
import com.sbm.module.partner.hd.rest.base.domain.HdResult;
import com.sbm.module.partner.hd.rest.base.domain.HdResultBody;
import com.sbm.module.partner.hd.rest.base.domain.QueryFilter;
import com.sbm.module.partner.hd.rest.shop.biz.IHdShopService;
import com.sbm.module.partner.hd.rest.shop.domain.HdShop;

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
public class HdShopServiceImpl extends HdInteractiveServiceImpl implements IHdShopService {

	@Autowired
	@Qualifier("hdRestTemplate")
	private RestTemplate restTemplate;

	private static final String QUERY_METHOD = "/rest/onlineleasing/position/query";

	@RestInteractive
	public HdResult<HdResultBody<HdShop>> query(QueryFilter queryFilter) {
		String uri = HdConstant.BASE_URL + QUERY_METHOD;
		CommonConstant.FRAMEWORK.info("uri: " + uri);
		String request = JSON.toJSONString(queryFilter);
		HttpEntity<String> entity = getHttpHeader(request);

		ResponseEntity<HdResult<HdResultBody<HdShop>>> result = restTemplate.exchange(uri, HttpMethod.POST, entity,
				new ParameterizedTypeReference<HdResult<HdResultBody<HdShop>>>() {
				});
		CommonConstant.FRAMEWORK.info("vo: " + JSON.toJSONString(result));
		return result.getBody();
	}

}
