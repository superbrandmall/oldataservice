package com.sbm.module.onlineleasing.api.merchantinfo.listener;

import com.sbm.module.common.api.eventinteractive.listener.BusinessEventListener;
import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.sbm.module.common.base.pulisher.constant.BusinessEventListenerConstant;
import com.sbm.module.common.base.pulisher.event.BusinessEvent;
import com.sbm.module.onlineleasing.api.merchantinfo.biz.IMerchantInteractiveService;
import com.sbm.module.onlineleasing.api.merchantinfo.event.IMerchantEvent;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;

import java.text.MessageFormat;

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
public class MerchantListener extends BusinessEventListener {

	private static final String MESSAGE = "unknow method: {0}";

	@Autowired
	private IMerchantInteractiveService service;

	@EventListener
	public void onApplicationEvent(BusinessEvent event) {
		if (event instanceof IMerchantEvent) {
			async(event);
		}
	}

	protected void execute(BusinessEvent event) {
		if (event.isNotNull(BusinessEventListenerConstant.BaseEntity)) {
			String method = (String) event.getTemplate().get(BusinessEventListenerConstant.METHOD);
			TOLMerchant obj = (TOLMerchant) event.getTemplate().get(BusinessEventListenerConstant.BaseEntity);
			// 执行品牌准入
			if (BusinessEventListenerConstant.SAVE.equals(method)) {
				service.doMerchantAccress(obj);
			}
			// 执行品牌修改
			else if (BusinessEventListenerConstant.UPDATE.equals(method)) {
				service.doMerchantUpdate(obj);
			}
			// 未知操作
			else {
				CommonConstant.FRAMEWORK.warn(MessageFormat.format(MESSAGE, method));
			}

		}
	}
}
