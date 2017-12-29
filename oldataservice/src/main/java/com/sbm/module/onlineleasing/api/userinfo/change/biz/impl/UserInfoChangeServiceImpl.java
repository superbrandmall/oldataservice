package com.sbm.module.onlineleasing.api.userinfo.change.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.api.verificationcode.biz.IVerificationCodeService;
import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.base.util.CodecUtil;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.userinfo.change.biz.IUserInfoChangeService;
import com.sbm.module.onlineleasing.api.userinfo.change.domain.UserInfoChange;
import com.sbm.module.onlineleasing.base.user.biz.ITOLUserService;
import com.sbm.module.onlineleasing.base.user.constant.UserConstant;
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
public class UserInfoChangeServiceImpl extends BusinessServiceImpl implements IUserInfoChangeService {

	@Autowired
	private ITOLUserService userService;
	@Autowired
	private IVerificationCodeService verificationCodeService;

	public void forgetPassword(UserInfoChange userInfoChange) {
		TOLUser user = userService.findByUsername(userInfoChange.getUsername());
		if (null == user) {
			throw new BusinessException(BusinessCode.C0202, null);
		}
		// 校验验证码
		verificationCodeService.checkVerificationCode(userInfoChange.getVerificationCode(), true);
		user.setPassword(userInfoChange.getPassword());
		userService.changePassword(user);
	}

	public void changePassword(UserInfoChange userInfoChange) {
		TOLUser user = userService.findByCode(userInfoChange.getUserCode());
		if (null == user) {
			throw new BusinessException(BusinessCode.C0206, new Object[] { userInfoChange.getUserCode() }, null);
		}
		if (!CodecUtil.sha1Hex(userInfoChange.getOldPassword()).equals(user.getPassword())) {
			throw new BusinessException(BusinessCode.C0203, null);
		}
		user.setPassword(userInfoChange.getPassword());
		userService.changePassword(user);
	}

	public void changeMobile(UserInfoChange userInfoChange) {
		TOLUser user = userService.findByCode(userInfoChange.getUserCode());
		if (null == user) {
			throw new BusinessException(BusinessCode.C0206, new Object[] { userInfoChange.getUserCode() }, null);
		}
		// 校验验证码
		verificationCodeService.checkVerificationCode(userInfoChange.getVerificationCode(), true);
		user.setMobile(userInfoChange.getUsername());
		// 设置手机验证通过
		user.setMobileVerified(UserConstant.VERIFIED_1);
		userService.update(user);
	}

	public void changeEmail(UserInfoChange userInfoChange) {
		TOLUser user = userService.findByCode(userInfoChange.getUserCode());
		if (null == user) {
			throw new BusinessException(BusinessCode.C0206, new Object[] { userInfoChange.getUserCode() }, null);
		}
		// 校验验证码
		verificationCodeService.checkVerificationCode(userInfoChange.getVerificationCode(), true);
		user.setEmail(userInfoChange.getUsername());
		// 设置邮箱验证通过
		user.setEmailVerified(UserConstant.VERIFIED_1);
		userService.update(user);
	}
}
