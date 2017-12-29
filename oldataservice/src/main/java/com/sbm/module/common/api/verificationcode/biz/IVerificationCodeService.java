package com.sbm.module.common.api.verificationcode.biz;

import com.sbm.module.common.api.verificationcode.domain.VerificationCode;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.onlineleasing.shop.biz<br/>
 * File Name:ITOLShopService.java<br/>
 * 
 * 作成日 ：2017-5-18 下午4:34:06 <br/>
 * 
 * @author ：junkai.zhang
 */
public interface IVerificationCodeService {

	/**
	 * 
	 * getEmailVerificationCode:获取email验证码
	 * 
	 * @author junkai.zhang
	 * @param verificationCode
	 */
	public void getEmailVerificationCode(VerificationCode verificationCode);

	/**
	 * 
	 * getMobileVerificationCode:获取mobile验证码
	 * 
	 * @author junkai.zhang
	 * @param verificationCode
	 */
	public void getMobileVerificationCode(VerificationCode verificationCode);

	/**
	 * 
	 * checkVerificationCode:校对验证码，不删除
	 * 
	 * @author junkai.zhang
	 * @param verificationCode
	 */
	public void checkVerificationCode(VerificationCode verificationCode);

	/**
	 * 
	 * checkVerificationCode:校对验证码
	 * 
	 * @author junkai.zhang
	 * @param verificationCode
	 * @param delete
	 */
	public void checkVerificationCode(VerificationCode verificationCode, boolean delete);

}
