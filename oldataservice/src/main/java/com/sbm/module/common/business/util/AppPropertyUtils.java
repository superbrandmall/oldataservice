package com.sbm.module.common.business.util;




/**
 * property file execute class 
 * 
 * @author Administrator
 *
 */
public class AppPropertyUtils {
	/** file path **/
	private static final String FILE_NAME = "application/ApplicationResources.properties";
	
	/**
	 * get property file of key value<p>
	 * 
	 * @param key key name
	 * @return key value
	 */
	public static String getProperty(String key) {
		return PropertyUtility.getProperty(FILE_NAME, key);
	}
}
