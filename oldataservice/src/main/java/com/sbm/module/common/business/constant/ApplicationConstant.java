package com.sbm.module.common.business.constant;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.sbm.module.common.business.util.AppPropertyUtils;

/*****************************************************************************/
/**
 * Project Name:posUploadDataService<br/>
 * Package Name:com.sbm.module.common.constant<br/>
 * File Name:CommonConstant.java<br/>
 * 
 * 作成日 ：2016-4-21 上午11:41:39 <br/>
 * 
 * @author ：junkai.zhang
 */
public class ApplicationConstant {

	/**
	 * 默认编码
	 */
	public static String defaultEncode = AppPropertyUtils.getProperty("defaultEncode");

	public static Charset defaultCharset = Charset.forName(defaultEncode);

	/**
	 * 文件基础路径
	 */
	public static String baseFilePath = AppPropertyUtils.getProperty("baseFilePath");

	/**
	 * LOG路径
	 */
	public static String LOG = null;

	/**
	 * ERR
	 */
	public static String ERR = null;

	/**
	 * ULD
	 */
	public static String ULD = null;

	/**
	 * TMP
	 */
	public static String TMP = null;

	/**
	 * FILE
	 */
	public static String FILE = null;

	/**
	 * 文件夹
	 */
	public static List<String> FOLDERS = null;

	static {
		FOLDERS = new ArrayList<String>();
		LOG = baseFilePath + "/LOG";
		FOLDERS.add(LOG);
		ERR = baseFilePath + "/ERR";
		FOLDERS.add(ERR);
		ULD = baseFilePath + "/ULD";
		FOLDERS.add(ULD);
		TMP = baseFilePath + "/TMP";
		FOLDERS.add(TMP);
		FILE = baseFilePath + "/FILE";
		FOLDERS.add(FILE);
	}

}
