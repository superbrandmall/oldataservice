package com.sbm.module.partner.tianyancha.rest.search.biz.impl;

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
import com.sbm.module.partner.tianyancha.rest.search.biz.ISearchService;
import com.sbm.module.partner.tianyancha.rest.search.domain.Search;
import com.sbm.module.partner.tianyancha.rest.search.domain.SearchVo;

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
public class SearchServiceImpl extends BusinessServiceImpl implements ISearchService {

	@Autowired
	@Qualifier("tycRestTemplate")
	private RestTemplate restTemplate;

	private static final String METHOD = "/newopen/searchV2.json?word={0}";

	public void getVo(SearchVo vo) {
		Search result = findResultByWord(vo.getWord());
		vo.setResult(result);
	}

	@RestInteractive
	public Search findResultByWord(String word) {
		String uri = TianYanChaConstant.BASE_URL + METHOD;
		uri = MessageFormat.format(uri, word);
		CommonConstant.FRAMEWORK.info("uri: " + uri);
		Search result = restTemplate.getForObject(uri, Search.class);
		result.setUri(uri);
		CommonConstant.FRAMEWORK.info("vo: " + JSON.toJSONString(result));
		return result;
	}

	public void check(Search result) {
		// 没有查到相关信息抛出异常
		if (null == result || null == result.getData() || result.getData().isEmpty()) {
			throw new BusinessException(BusinessCode.C0300, new Object[] { result.getUri() }, null);
		}
	}

}
