package com.sbm.module.common.api.verificationcode.util;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.commonapi.verificationcode.util<br/>
 * File Name:VerificationCodeUtil.java<br/>
 * 
 * 作成日 ：2017-8-7 上午9:44:04 <br/>
 * 
 * @author ：junkai.zhang
 */
@Component
public class VerificationCodeUtil {

	@Value("#{propertiesReader['verificationcode.verificationCodes']}")
	private String verificationCodes;

	@Value("#{propertiesReader['verificationcode.verificationSize']}")
	private String verificationSize;

	/**
	 * 
	 * generateStandardVerificationCode:使用系统默认字符源生成6位验证码
	 * 
	 * @author junkai.zhang
	 * @return
	 */
	public String generateStandardVerificationCode() {
		return generateVerificationCode(Integer.valueOf(verificationSize));
	}

	/**
	 * 
	 * generateVerifyCode:使用系统默认字符源生成验证码
	 * 
	 * @author junkai.zhang
	 * @param verificationSize
	 *            验证码长度
	 * @return
	 */
	public String generateVerificationCode(Integer verificationSize) {
		return generateVerificationCode(verificationSize, verificationCodes);
	}

	/**
	 * 
	 * generateVerificationCode:使用指定源生成验证码
	 * 
	 * @author junkai.zhang
	 * @param verifySize
	 *            验证码长度
	 * @param sources
	 *            验证码字符源
	 * @return
	 */
	public String generateVerificationCode(Integer verifySize, String sources) {
		if (sources == null || sources.length() == 0) {
			sources = verificationCodes;
		}
		Random rand = new Random(System.currentTimeMillis());
		StringBuilder verificationCode = new StringBuilder(verifySize);
		for (int i = 0; i < verifySize; i++) {
			verificationCode.append(sources.charAt(rand.nextInt(sources.length() - 1)));
		}
		return verificationCode.toString();
	}

}
