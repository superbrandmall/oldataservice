package com.sbm.module.common.api.freemarker.biz.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.api.freemarker.biz.IFreeMarkerService;
import com.sbm.module.common.api.freemarker.util.FreeMarkerUtil;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;

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
public class FreeMarkerServiceImpl extends BusinessServiceImpl implements IFreeMarkerService {

	@Autowired
	private FreeMarkerUtil util;

	public String getFreeMarkerTemplate(String prefix, String templateName, Map<String, Object> params) {
		return util.getFreeMarkerTemplate(prefix, templateName, params);
	}

}
