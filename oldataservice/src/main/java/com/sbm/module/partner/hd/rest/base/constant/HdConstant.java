package com.sbm.module.partner.hd.rest.base.constant;

/*****************************************************************************/

import com.sbm.module.common.business.util.AppPropertyUtils;

/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.partner.tianyancha.rest.base.constant<br/>
 * File Name:TianYanChaConstant.java<br/>
 * 
 * 作成日 ：2017-8-29 下午6:01:19 <br/>
 * 
 * @author ：junkai.zhang
 */
public class HdConstant {

	//public static final String BASE_URL = "http://cre.trunk.hd123.cn/cre-agency-server";
	public static final String BASE_URL =  AppPropertyUtils.getProperty("hdBaseUrl");

	/****************************************************************/

	/**
	 * 使用中
	 */
	public static final String HD_STATE_USING = "using";

	/**
	 * 已拆分
	 */
	public static final String HD_STATE_SPLITTED = "splitted";

	/**
	 * 已合并
	 */
	public static final String HD_STATE_MERGED = "merged";

	/**
	 * 已删除
	 */
	public static final String HD_STATE_DELETED = "deleted";

	/**
	 * 冻结
	 */
	public static final String HD_STATE_FROZEN = "frozen";
}
