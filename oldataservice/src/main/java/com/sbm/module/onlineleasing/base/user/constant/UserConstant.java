package com.sbm.module.onlineleasing.base.user.constant;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.onlineleasing.base.user.constant<br/>
 * File Name:UserConstant.java<br/>
 * 
 * 作成日 ：2017-9-19 上午11:22:17 <br/>
 * 
 * @author ：junkai.zhang
 */
public class UserConstant {

	/**
	 * 1-管理员
	 */
	public static final int ADMIN = 1;

	/**
	 * 2-用户
	 */
	public static final int USER = 2;

	/******************************************************************/
	// 不需要

	// /**
	// * 阶段1完成
	// */
	// public static final Integer STEP1 = 1;
	//
	// /**
	// * 阶段2完成
	// */
	// public static final Integer STEP2 = 2;

	// 没有第三阶段，第三阶段的判断通过判断merchantBrandCount实现
	// /**
	// * 阶段3完成
	// */
	// public static final Integer STEP3 = 3;

	/******************************************************************/

	/**
	 * 校验不通过
	 */
	public static final Integer VERIFIED_0 = 0;

	/**
	 * 校验通过
	 */
	public static final Integer VERIFIED_1 = 1;

	/******************************************************************/

	/**
	 * 境内人士
	 */
	public static final Integer INTERNATIONAL_0 = 0;

	/**
	 * 境外人士
	 */
	public static final Integer INTERNATIONAL_1 = 1;
}
