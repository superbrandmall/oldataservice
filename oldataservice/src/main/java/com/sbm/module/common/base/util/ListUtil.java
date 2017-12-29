package com.sbm.module.common.base.util;

import java.util.List;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.common.util<br/>
 * File Name:ListUtil.java<br/>
 * 
 * 作成日 ：2017-8-7 下午5:32:00 <br/>
 * 
 * @author ：junkai.zhang
 */
public class ListUtil {

	public static String strList2HQLStr(List<String> list) {
		StringBuffer hql = new StringBuffer(" (");
		StringBuffer sb = new StringBuffer("");
		for (String string : list) {
			sb.append("'").append(string).append("'");
			sb.append(",");
		}
		String str = sb.toString();
		if (str.length() > 0) {
			str = str.substring(0, str.length() - 1);
		}
		hql.append(str);
		hql.append(") ");
		return hql.toString();
	}

	public static String intList2HQLStr(List<Integer> list){
		StringBuffer hql = new StringBuffer(" (");
		StringBuffer sb = new StringBuffer("");
		for (Integer i : list) {
			sb.append("").append(i).append("");
			sb.append(",");
		}
		String str = sb.toString();
		if (str.length() > 0) {
			str = str.substring(0, str.length() - 1);
		}
		hql.append(str);
		hql.append(") ");
		return hql.toString();
	}

}
