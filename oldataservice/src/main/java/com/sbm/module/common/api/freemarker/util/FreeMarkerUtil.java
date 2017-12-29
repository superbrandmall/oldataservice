package com.sbm.module.common.api.freemarker.util;

import java.io.File;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;

import freemarker.template.Configuration;
import freemarker.template.Template;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.commonapi.freemarker.util<br/>
 * File Name:FreeMarkerUtil.java<br/>
 * 
 * 作成日 ：2017-8-1 下午1:19:15 <br/>
 * 
 * @author ：junkai.zhang
 */
@Component
public class FreeMarkerUtil {

	@Autowired
	private Configuration cfg;

	/**
	 * 
	 * getFreeMarkerTemplate:获取freemarker模板
	 * 
	 * @author junkai.zhang
	 * @param prefix
	 * @param templateName
	 * @param params
	 * @return
	 */
	public String getFreeMarkerTemplate(String prefix, String templateName, Map<String, Object> params) {
		Template template;
		String str = null;
		try {
			template = cfg.getTemplate(prefix + File.separator + templateName);
			str = FreeMarkerTemplateUtils.processTemplateIntoString(template, params);
		} catch (Exception e) {
			throw new BusinessException(BusinessCode.C1200, null, e);
		}
		return str;
	}
}
