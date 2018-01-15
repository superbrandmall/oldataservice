package com.sbm.module.onlineleasing.base.user.biz.impl;

import java.util.Date;
import java.util.List;

import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.floor.domain.TOLFloor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.api.serialcode.constant.SerialCodeConstant;
import com.sbm.module.common.base.util.CodecUtil;
import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.base.user.biz.ITOLUserService;
import com.sbm.module.onlineleasing.base.user.dao.ITOLUserDao;
import com.sbm.module.onlineleasing.base.user.domain.TOLUser;

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
public class TOLUserServiceImpl extends DaoSupportServiceImpl<TOLUser> implements ITOLUserService {

	@Autowired
	private ITOLUserDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLUser> findAll() {
		List<TOLUser> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLUser> findAllByMerchantCode(String merchantCode) {
		return dao.findAllByMerchantCode(merchantCode);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLUser> findAllByMerchantCodes(List<String> merchantCodes) {
		return dao.findAllByMerchantCodes(merchantCodes);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLUser> findAllByCondition(TOLUser obj) {
		return dao.findAllByCondition(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Pagination<TOLUser> findAllByConditionPage(TOLUser obj) {
		return dao.findAllByConditionPage(obj);
	}


	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLUser findByCondition(TOLUser obj) {
		return dao.findByCondition(obj);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLUser findByCode(String code) {
		return dao.findByCode(code);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLUser findByMobile(String mobile) {
		return dao.findByMobile(mobile);
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLUser findByEmail(String email) {
		return dao.findByEmail(email);
	}

	public void saveUser(TOLUser obj) {
		obj.setCode(serialCodeService.nextBizId(SerialCodeConstant.OLUSER).getNextBizId());
		// 密码加密
		setPassword(obj);
		// 最后登陆时间
		obj.setLastLogin(new Date());
		save(obj);
	}

	/**
	 * 
	 * setPassword:密码加密
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	private void setPassword(TOLUser obj) {
		obj.setPassword(CodecUtil.sha1Hex(obj.getPassword()));
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLUser findByUsername(String username) {
		return dao.findByUsername(username);
	}

	public void changePassword(TOLUser obj) {
		// 密码加密
		setPassword(obj);
		update(obj);
	}
}
