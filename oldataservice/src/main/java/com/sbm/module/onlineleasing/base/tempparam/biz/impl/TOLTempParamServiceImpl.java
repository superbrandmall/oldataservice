package com.sbm.module.onlineleasing.base.tempparam.biz.impl;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.base.bidparam.rentmethod.biz.ITOLBidRentMethodService;
import com.sbm.module.onlineleasing.base.bidparam.rentmethod.dao.ITOLBidRentMethodDao;
import com.sbm.module.onlineleasing.base.bidparam.rentmethod.domain.TOLBidRentMethod;
import com.sbm.module.onlineleasing.base.tempparam.biz.ITOLTempParamService;
import com.sbm.module.onlineleasing.base.tempparam.dao.ITOLTempParamDao;
import com.sbm.module.onlineleasing.base.tempparam.domain.TOLTempParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
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
@Transactional(value = TransactionConstant.OL, propagation = Propagation.REQUIRED)
public class TOLTempParamServiceImpl extends DaoSupportServiceImpl<TOLTempParam> implements
		ITOLTempParamService {

	@Autowired
	private ITOLTempParamDao dao;

	private static final String KEY_MESSAGE = "没有查询到参数。param:{0}, key: {1}";
	private static final String VALUE_MESSAGE = "没有查询到参数。param:{0}, value: {1}";


	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLTempParam> findAll() {
		return dao.findAll();
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLTempParam findByParamAndKey(String param, Integer key) {
		if (null == key) {
			return new TOLTempParam();
		}
		TOLTempParam obj = dao.findByParamAndKey(param, key);
		if (null == obj){
			CommonConstant.FRAMEWORK.warn(MessageFormat.format(KEY_MESSAGE, param, key));
			return new TOLTempParam();
		}
		obj.setValue(obj.getValue().trim());
		return obj;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLTempParam findByParamAndValue(String param, String value) {
		if (null == value) {
			return new TOLTempParam();
		}
		value = value.trim();
		TOLTempParam obj = dao.findByParamAndValue(param, value);
		if (null == obj){
			CommonConstant.FRAMEWORK.warn(MessageFormat.format(VALUE_MESSAGE, param, value));
			return new TOLTempParam();
		}
		obj.setValue(obj.getValue().trim());
		return obj;
	}
}
