package com.sbm.module.partner.tianyancha.rest.owntax.biz.impl;

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
import com.sbm.module.partner.tianyancha.rest.owntax.biz.IOwnTaxService;
import com.sbm.module.partner.tianyancha.rest.owntax.domain.OwnTax;
import com.sbm.module.partner.tianyancha.rest.owntax.domain.OwnTaxVo;

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
public class OwnTaxServiceImpl extends BusinessServiceImpl implements IOwnTaxService {

	@Autowired
	@Qualifier("tycRestTemplate")
	private RestTemplate restTemplate;

	private static final String METHOD_NAME = "/newopen/ownTax.json?name={0}&pageNum={1}";
	private static final String METHOD_ID = "/newopen/ownTax.json?id={0}&pageNum={1}";

	public void getVo(OwnTaxVo vo) {
		OwnTax result = null;
		if (null != vo.getId()) {
			result = findResultById(vo.getId(), vo.getPageNum());
		} else {
			result = findResultByName(vo.getName(), vo.getPageNum());
		}
		vo.setResult(result);
	}

	@RestInteractive
	public OwnTax findResultByName(String name, Integer pageNum) {
		if (null == pageNum) {
			pageNum = 1;
		}
		String uri = TianYanChaConstant.BASE_URL + METHOD_NAME;
		uri = MessageFormat.format(uri, name, pageNum);
		return findResult(uri);
	}

	@RestInteractive
	public OwnTax findResultById(Long id, Integer pageNum) {
		if (null == pageNum) {
			pageNum = 1;
		}
		String uri = TianYanChaConstant.BASE_URL + METHOD_ID;
		uri = MessageFormat.format(uri, id.toString(), pageNum);
		return findResult(uri);
	}

	private OwnTax findResult(String uri) {
		CommonConstant.FRAMEWORK.info("uri: " + uri);
		OwnTax result = restTemplate.getForObject(uri, OwnTax.class);
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
