package com.sbm.module.onlineleasing.api.register.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.api.apiinteractive.domain.TCApiInteractiveDetail;
import com.sbm.module.common.api.verificationcode.biz.IVerificationCodeService;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.brandinfo.biz.IBrandInfoService;
import com.sbm.module.onlineleasing.api.merchantinfo.biz.IMerchantInteractiveService;
import com.sbm.module.onlineleasing.api.register.biz.IRegisterService;
import com.sbm.module.onlineleasing.api.register.domain.Register;
import com.sbm.module.onlineleasing.api.userinfo.check.biz.IUserInfoCheckService;
import com.sbm.module.onlineleasing.base.brand.biz.ITOLBrandService;
import com.sbm.module.onlineleasing.base.merchant.biz.ITOLMerchantService;
import com.sbm.module.onlineleasing.base.merchantaddress.biz.ITOLMerchantAddressService;
import com.sbm.module.onlineleasing.base.merchantbankaccount.biz.ITOLMerchantBankAccountService;
import com.sbm.module.onlineleasing.base.merchantbrand.biz.ITOLMerchantBrandService;
import com.sbm.module.onlineleasing.base.merchantbrand.domain.TOLMerchantBrand;
import com.sbm.module.onlineleasing.base.merchantbusinesslicense.biz.ITOLMerchantBusinessLicenseService;
import com.sbm.module.onlineleasing.base.user.biz.ITOLUserService;
import com.sbm.module.onlineleasing.base.user.constant.UserConstant;
import com.sbm.module.onlineleasing.base.user.domain.TOLUser;
import com.sbm.module.onlineleasing.base.usercontacts.biz.ITOLUserContactsService;

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
public class RegisterServiceImpl extends BusinessServiceImpl implements IRegisterService {

	// 用户相关
	@Autowired
	private ITOLUserService userService;
	@Autowired
	private ITOLUserContactsService userContactsService;
	@Autowired
	private IUserInfoCheckService userInfoCheckService;
	@Autowired
	private IVerificationCodeService verificationCodeService;

	// 租户相关
	@Autowired
	private ITOLMerchantService merchantService;
	@Autowired
	private ITOLMerchantAddressService merchantAddressService;
	@Autowired
	private ITOLMerchantBankAccountService merchantBankAccountService;
	@Autowired
	private ITOLMerchantBusinessLicenseService merchantBusinessLicenseService;
	@Autowired
	private IMerchantInteractiveService merchantInteractiveService;
	@Autowired
	private ITOLMerchantBrandService merchantBrandService;

	// 品牌相关
	@Autowired
	private ITOLBrandService brandService;
	@Autowired
	private IBrandInfoService brandInfoService;

	public void step1(Register register) {
		// step1校验
		checkStep1(register);
		// 存user 设置类型为用户（1-管理员 2-用户）
		register.getUser().setType(UserConstant.USER);
		// 设置注册状态为阶段1完成 不需要
		// register.getUser().setRegState(UserConstant.STEP1);
		// 如果是境内人士，默认手机号校验成功
		if (UserConstant.INTERNATIONAL_0.equals(register.getUser().getInternational())) {
			register.getUser().setMobileVerified(UserConstant.VERIFIED_1);
		}
		// 其他情况默认邮箱校验成功
		else {
			register.getUser().setEmailVerified(UserConstant.VERIFIED_1);
		}
		// 设置默认语言
		if (null == register.getUser().getLang()) {
			register.getUser().setLang(TCApiInteractiveDetail.get().getLang());
		}

		userService.saveUser(register.getUser());
		// 存usercontacts setp1不录入相关信息
		// register.getUserContacts().setCode(register.getUser().getCode());
		// userContactsService.save(register.getUserContacts());
	}

	/**
	 * 
	 * checkStep1:step1校验
	 * 
	 * @author junkai.zhang
	 * @param register
	 */
	private void checkStep1(Register register) {
		// 手机不存在
		userInfoCheckService.isNotExistMobile(register.getUser().getMobile());
		// 邮箱不存在
		userInfoCheckService.isNotExistEmail(register.getUser().getEmail());
		// 证件不存在 setp1不录入证件
		// userInfoCheckService.isNotExistIdCard(register.getUserContacts().getIdCard());
		// 检查验证码
		verificationCodeService.checkVerificationCode(register.getVerificationCode(), true);
	}

	/****************************************************************************************/

	public void step2(Register register) {
		// 准入标志
		Boolean accessFlag = false;
		// step2校验
		checkStep2(register);
		// 判断merchant
		if (null != register.getMerchant().getId()) {
			// 注册时不允许修改merchant，所以不更新
		} else {
			// 存merchant
			merchantService.saveMerchant(register.getMerchant());
			accessFlag = true;
		}
		// 判断merchantAddress
		if (null != register.getMerchantAddress().getId()) {
			// 注册时不允许修改merchantAddress，所以不更新
		} else {
			// 存merchantAddress
			register.getMerchantAddress().setCode(register.getMerchant().getCode());
			merchantAddressService.save(register.getMerchantAddress());
		}
		// 判断merchantBusinessLicense
		if (null != register.getMerchantBusinessLicense().getId()) {
			// 注册时不允许修改merchantBusinessLicense，所以不更新
		} else {
			register.getMerchantBusinessLicense().setCode(register.getMerchant().getCode());
			merchantBusinessLicenseService.save(register.getMerchantBusinessLicense());
		}
		// 更新user表 加入merchantCode，设置注册状态为阶段2完成
		TOLUser user = userService.findByCode(getUserCode());
		user.setMerchantCode(register.getMerchant().getCode());
		// 不需要
		// user.setRegState(UserConstant.STEP2);
		userService.update(user);
		register.setUser(user);
		// 存usercontacts setp1不录入相关信息
		register.getUserContacts().setCode(user.getCode());
		userContactsService.save(register.getUserContacts());

		// 插入商户品牌数量
		List<TOLMerchantBrand> merchantBrands = merchantBrandService.findAllByMerchantCode(register.getMerchant()
				.getCode());
		register.setMerchantBrandCount(merchantBrands.size());

		// 发起商户准入流程
		if (accessFlag) {
			// 新建时才发起准入流程
			merchantInteractiveService.merchantAccress(register.getMerchant());
		}
	}

	/**
	 * 
	 * checkStep2:step2校验
	 * 
	 * @author junkai.zhang
	 * @param register
	 */
	private void checkStep2(Register register) {
		// 证件不存在
		userInfoCheckService.isNotExistIdCard(register.getUserContacts().getIdCard());
	}

	/****************************************************************************************/
	// 已有品牌

	// 没修改
	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public void step3AddExistingBrandWithoutUpdate(Register register) {
		brandInfoService.addExistingBrandWithoutUpdate(register.getBrandInfo());
		// 插入商户品牌数量
		List<TOLMerchantBrand> merchantBrands = merchantBrandService.findAllByMerchantCode(register.getBrandInfo().getMerchantBrand()
				.getMerchantCode());
		register.setMerchantBrandCount(merchantBrands.size());
	}

	// 新增品牌
	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public void step3AddNewBrand(Register register) {
		brandInfoService.addNewBrand(register.getBrandInfo());
		// 插入商户品牌数量
		List<TOLMerchantBrand> merchantBrands = merchantBrandService.findAllByMerchantCode(register.getBrandInfo().getMerchantBrand()
				.getMerchantCode());
		register.setMerchantBrandCount(merchantBrands.size());
	}

}
