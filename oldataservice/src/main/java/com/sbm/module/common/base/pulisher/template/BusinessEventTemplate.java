package com.sbm.module.common.base.pulisher.template;

import java.util.HashMap;
import java.util.Map;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.common.base.pulisher.template<br/>
 * File Name:BusinessEventTemplate.java<br/>
 * 
 * 作成日 ：2017-9-25 下午6:00:12 <br/>
 * 
 * @author ：junkai.zhang
 */
public class BusinessEventTemplate {

	private Map<String, Object> map = new HashMap<String, Object>();

	public Object get(String key) {
		return map.get(key);
	}

	public BusinessEventTemplate put(String key, Object value) {
		map.put(key, value);
		return this;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
}
