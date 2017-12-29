package com.sbm.module.common.business.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * 读取配置文件
 * eg: sendPhones  =  PropertyUtility.getProperty("文件名", "属性名");
 * 文件名可以保护类路径比如：String FILE_NAME = "test/cn/com/cits/core/file/resources/ApplicationResources.properties";
 * @author he.qinghua
 * @date 2012/01/09
 *
 */
public class PropertyUtility {

	private static Map<String, Properties> propertiesMap  = Collections.synchronizedMap(new HashMap<String, Properties>());

	private PropertyUtility() {
	}

	private synchronized static void loadProperties(String fileName) throws Exception {
		InputStream is = null;
        try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	        is = classLoader.getResourceAsStream(fileName);
			//File propFile = new File(System.getProperty("user.dir"), fileName);
        } catch ( Exception e) {
        	e.printStackTrace();
        }
		Properties props = new Properties();
		if (is != null) {
			props.load(is);
		} else {
			File propFile = new File(System.getProperty("user.dir"), fileName);
			props.load(new FileInputStream(propFile));
		}

		propertiesMap.put(fileName, props);
	}

	public static String getProperty(String fileName,String key) {
		String value = null;
		try {
			Properties properties = propertiesMap.get(fileName);
			if (properties == null) {
				loadProperties(fileName);
				properties = propertiesMap.get(fileName);
			}
			value = properties.getProperty(key);

		} catch (Exception e) {
			e.printStackTrace();
			value = null;
		}
		return value;
	}
	
	/**
	 * 获取资源文件中的所有KEY名称<br/>
	 * 
	 * @param fileName 资源文件名
	 * @return KEY名称
	 */
	public static Enumeration<Object> getProperty(String fileName) {
		Enumeration<Object> value = null;
		try {
			Properties properties = propertiesMap.get(fileName);
			if (properties == null) {
				loadProperties(fileName);
				properties = propertiesMap.get(fileName);
			}
			value = properties.keys();

		} catch (Exception e) {
			value = null;
		}
		return value;
	}
}
