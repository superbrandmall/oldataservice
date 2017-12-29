package com.sbm.module.common.api.sms.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.api.serialcode.constant.SerialCodeConstant;
import com.sbm.module.common.api.sms.biz.ITCSMSSendDetailService;
import com.sbm.module.common.api.sms.dao.ITCSMSSendDetailDao;
import com.sbm.module.common.api.sms.domain.TCSMSSendDetail;
import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
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
public class TCSMSSendDetailServiceImpl extends DaoSupportServiceImpl<TCSMSSendDetail> implements
		ITCSMSSendDetailService {

	@Autowired
	private ITCSMSSendDetailDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TCSMSSendDetail> findAll() {
		List<TCSMSSendDetail> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TCSMSSendDetail findByCode(String code) {
		return dao.findByCode(code);
	}

	public void saveSMSSendDetail(TCSMSSendDetail obj) {
		obj.setCode(serialCodeService.nextBizId(SerialCodeConstant.CSMSDETAIL).getNextBizId());
		save(obj);
	}

}
