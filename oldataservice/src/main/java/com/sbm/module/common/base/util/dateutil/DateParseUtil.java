package com.sbm.module.common.base.util.dateutil;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.base.exception.BusinessException;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.common.util.dateutil<br/>
 * File Name:DateParseUtil.java<br/>
 * 
 * 作成日 ：2017-8-9 上午10:00:38 <br/>
 * 
 * @author ：junkai.zhang
 */
public class DateParseUtil {

	public static Date parse_yyyy_MM_dd(String yyyy_MM_dd) {
		try {
			if (StringUtils.isNotEmpty(yyyy_MM_dd)) {
				return CommonConstant.yyyy_MM_dd.parse(yyyy_MM_dd);
			} else {
				return null;
			}
		} catch (ParseException e) {
			throw new BusinessException(BusinessCode.C1000, new Object[] { yyyy_MM_dd }, e);
		}
	}

	public static String format_yyyy_MM_dd(Date date) {
		if (null != date) {
			return CommonConstant.yyyy_MM_dd.format(date);
		} else {
			return null;
		}
	}

}
