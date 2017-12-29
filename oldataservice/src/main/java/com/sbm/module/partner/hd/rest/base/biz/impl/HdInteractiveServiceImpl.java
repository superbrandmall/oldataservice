package com.sbm.module.partner.hd.rest.base.biz.impl;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.partner.hd.rest.base.domain.HdResult;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.job.base.biz.impl<br/>
 * File Name:SyncServiceImpl.java<br/>
 * 
 * 作成日 ：2017-10-13 上午11:32:52 <br/>
 * 
 * @author ：junkai.zhang
 */
public class HdInteractiveServiceImpl extends BusinessServiceImpl {

	@SuppressWarnings("rawtypes")
	protected void checkResult(HdResult result) {
		if (null != result && 0 == result.getStatusCode() && null != result.getBody()) {

		} else {
			// 查询结果不正确
			throw new BusinessException(BusinessCode.C12000, new Object[] { JSON.toJSONString(result) }, null);
		}
	}

	protected HttpEntity<String> getHttpHeader(String request){
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);

		List<MediaType> acceptableMediaTypes = new ArrayList<>();
		acceptableMediaTypes.add(type);
		headers.setAccept(acceptableMediaTypes);

		HttpEntity<String> entity = new HttpEntity<>(request, headers);
		return entity;
	}

}
