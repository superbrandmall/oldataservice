package com.sbm.module.common.business.util;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.common.business.util<br/>
 * File Name:ParamsUtil.java<br/>
 * 
 * 作成日 ：2017-9-19 上午11:02:58 <br/>
 * 
 * @author ：junkai.zhang
 */
public class ParamsUtil {

	public static final BigDecimal ZERO = new BigDecimal(0);

	/**
	 * 
	 * canNotBeEmpty:参数不能为空
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	public static void canNotBeEmpty(String... obj) {
		for (String string : obj) {
			if (StringUtils.isEmpty(string)) {
				throw new BusinessException(BusinessCode.C9000, null);
			}
		}
	}

	/**
	 * 
	 * canNotBeNull:参数不能为空
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	public static void canNotBeNull(Object... obj) {
		for (Object object : obj) {
			if (null == object) {
				throw new BusinessException(BusinessCode.C9000, null);
			}
		}
	}

	/**
	 * 
	 * canNotBeMinus:参数不能为负数
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	public static void canNotBeMinus(Integer... obj) {
		canNotBeNull((Object) obj);
		for (Integer integer : obj) {
			if (integer < 0) {
				throw new BusinessException(BusinessCode.C9001, null);
			}
		}
	}

	/**
	 * 
	 * canNotBeMinus:参数不能为负数
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	public static void canNotBeMinus(BigDecimal... obj) {
		canNotBeNull((Object) obj);
		for (BigDecimal bigDecimal : obj) {
			if (bigDecimal.compareTo(ZERO) == -1) {
				throw new BusinessException(BusinessCode.C9001, null);
			}
		}
	}

	/**
	 * 
	 * isTrue:是true
	 * 
	 * @author junkai.zhang
	 * @param b
	 * @return
	 */
	public static boolean isTrue(Boolean b) {
		if (null != b && true == b) {
			return true;
		}
		return false;
	}


	/**
	 * 参数大于0
	 * @param obj
	 * @return
	 */
	public static boolean isBiggerThanZero(BigDecimal obj) {
		canNotBeNull((Object) obj);
		if (obj.compareTo(ZERO) == 1) {
			return true;
		}
		return false;
	}

}
