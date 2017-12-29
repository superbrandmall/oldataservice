package com.sbm.module.onlineleasing.api.login.biz.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.base.util.CodecUtil;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.login.biz.ILoginService;
import com.sbm.module.onlineleasing.api.login.domain.Login;
import com.sbm.module.onlineleasing.base.merchant.biz.ITOLMerchantService;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.onlineleasing.base.merchantbrand.biz.ITOLMerchantBrandService;
import com.sbm.module.onlineleasing.base.merchantbrand.domain.TOLMerchantBrand;
import com.sbm.module.onlineleasing.base.user.biz.ITOLUserService;
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
public class LoginServiceImpl extends BusinessServiceImpl implements ILoginService {

	@Autowired
	private ITOLUserService userService;
	@Autowired
	private ITOLMerchantService merchantService;
	@Autowired
	private ITOLMerchantBrandService merchantBrandService;

	public void login(Login login, int type) {
		TOLUser user = userService.findByUsername(login.getUsername());
		// 用户名或者密码错误
		if (null == user) {
			throw new BusinessException(BusinessCode.C0202, null);
		}
		// 用户类型错误
		if (type != user.getType().intValue()) {
			throw new BusinessException(BusinessCode.C0006, null);
		}
		// 密码错误
		if (!CodecUtil.sha1Hex(login.getPassword()).equals(user.getPassword())) {
			throw new BusinessException(BusinessCode.C0203, null);
		}
		// 去除password
		login.setPassword(null);
		// 设置返回值
		login.setCode(user.getCode());
		login.setEmail(user.getEmail());
		login.setMobile(user.getMobile());
		login.setMerchantCode(user.getMerchantCode());
		// 设置语言
		login.setLang(user.getLang());
		// 用户状态 不需要
		// login.setRegState(user.getRegState());
		// 用户类型
		login.setType(user.getType());
		// 境内境外
		login.setInternational(user.getInternational());
		if (StringUtils.isNotBlank(user.getMerchantCode())) {
			// 商户品牌数量
			List<TOLMerchantBrand> merchantBrands = merchantBrandService.findAllByMerchantCode(user.getMerchantCode());
			login.setMerchantBrandCount(merchantBrands.size());
			// 设置返回名称
			TOLMerchant merchant = merchantService.findByCode(user.getMerchantCode());
			if (null != merchant) {
				login.setMerchantName(merchant.getName());
			}
		}

		// 更新最后登录时间
		user.setLastLogin(new Date());
		userService.update(user);
	}

	public void updateLanguage(Login login) {
		TOLUser user = userService.findByCode(login.getCode());
		Integer lang = login.getLang();
		if (null == lang) {
			lang = 1;
		}
		user.setLang(lang);
		userService.update(user);
	}

}
