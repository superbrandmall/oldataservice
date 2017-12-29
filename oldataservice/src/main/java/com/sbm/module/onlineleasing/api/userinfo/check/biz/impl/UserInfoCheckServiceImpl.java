package com.sbm.module.onlineleasing.api.userinfo.check.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.util.ParamsUtil;
import com.sbm.module.onlineleasing.api.userinfo.check.biz.IUserInfoCheckService;
import com.sbm.module.onlineleasing.base.user.biz.ITOLUserService;
import com.sbm.module.onlineleasing.base.user.domain.TOLUser;
import com.sbm.module.onlineleasing.base.usercontacts.biz.ITOLUserContactsService;
import com.sbm.module.onlineleasing.base.usercontacts.domain.TOLUserContacts;

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
public class UserInfoCheckServiceImpl extends BusinessServiceImpl implements IUserInfoCheckService {

	@Autowired
	private ITOLUserService userService;
	@Autowired
	private ITOLUserContactsService userContactsService;

	public void isNotExistMobile(String mobile) {
		ParamsUtil.canNotBeEmpty(mobile);
		TOLUser obj = userService.findByMobile(mobile);
		// 查到则检查不通过
		if (null != obj) {
			throw new BusinessException(BusinessCode.C0200, new Object[] { mobile }, null);
		}
	}

	public void isNotExistEmail(String email) {
		ParamsUtil.canNotBeEmpty(email);
		TOLUser obj = userService.findByEmail(email);
		// 查到则检查不通过
		if (null != obj) {
			throw new BusinessException(BusinessCode.C0201, new Object[] { email }, null);
		}
	}

	public void isNotExistIdCard(String idCard) {
		ParamsUtil.canNotBeEmpty(idCard);
		TOLUserContacts obj = userContactsService.findByIdCard(idCard);
		// 查到则检查不通过
		if (null != obj) {
			throw new BusinessException(BusinessCode.C0207, new Object[] { idCard }, null);
		}
	}

	/*****************************************************************/

	public void existMobile(String mobile) {
		ParamsUtil.canNotBeEmpty(mobile);
		TOLUser obj = userService.findByMobile(mobile);
		// 查不到则检查不通过
		if (null == obj) {
			throw new BusinessException(BusinessCode.C0204, new Object[] { mobile }, null);
		}
	}

	public void existEmail(String email) {
		ParamsUtil.canNotBeEmpty(email);
		TOLUser obj = userService.findByEmail(email);
		// 查不到则检查不通过
		if (null == obj) {
			throw new BusinessException(BusinessCode.C0205, new Object[] { email }, null);
		}
	}

	public void existIdCard(String idCard) {
		ParamsUtil.canNotBeEmpty(idCard);
		TOLUserContacts obj = userContactsService.findByIdCard(idCard);
		// 查到则检查不通过
		if (null == obj) {
			throw new BusinessException(BusinessCode.C0208, new Object[] { idCard }, null);
		}
	}
}
