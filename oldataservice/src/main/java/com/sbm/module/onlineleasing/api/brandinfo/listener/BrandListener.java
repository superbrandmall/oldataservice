package com.sbm.module.onlineleasing.api.brandinfo.listener;

import java.text.MessageFormat;

import com.sbm.module.common.api.eventinteractive.listener.BusinessEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.base.pulisher.constant.BusinessEventListenerConstant;
import com.sbm.module.common.base.pulisher.event.BusinessEvent;
import com.sbm.module.onlineleasing.api.brandinfo.biz.IBrandInteractiveService;
import com.sbm.module.onlineleasing.api.brandinfo.event.IBrandEvent;
import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.common.listener<br/>
 * File Name:InitListener.java<br/>
 * 
 * 作成日 ：2017-8-17 下午5:33:02 <br/>
 * 
 * @author ：junkai.zhang
 */
@Component
public class BrandListener extends BusinessEventListener {

	private static final String MESSAGE = "unknow method: {0}";

	@Autowired
	private IBrandInteractiveService service;

	@EventListener
	public void onApplicationEvent(BusinessEvent event) {
		if (event instanceof IBrandEvent) {
			async(event);
		}
	}

	protected void execute(BusinessEvent event) {
		if (event.isNotNull(BusinessEventListenerConstant.BaseEntity, BusinessEventListenerConstant.METHOD)) {
			String method = (String) event.getTemplate().get(BusinessEventListenerConstant.METHOD);
			TOLBrand obj = (TOLBrand) event.getTemplate().get(BusinessEventListenerConstant.BaseEntity);
			// 执行品牌准入
			if (BusinessEventListenerConstant.SAVE.equals(method)) {
				service.doBrandAccress(obj);
			}
			// 执行品牌修改
			else if (BusinessEventListenerConstant.UPDATE.equals(method)) {
				service.doBrandUpdate(obj);
			}
			// 未知操作
			else {
				CommonConstant.FRAMEWORK.warn(MessageFormat.format(MESSAGE, method));
			}
		}
	}
}
