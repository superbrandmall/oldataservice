package com.sbm.module.onlineleasing.api.merchantdetail.listener;

import com.sbm.module.common.api.eventinteractive.listener.BusinessEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.sbm.module.common.base.pulisher.constant.BusinessEventListenerConstant;
import com.sbm.module.common.base.pulisher.event.BusinessEvent;
import com.sbm.module.onlineleasing.api.merchantdetail.biz.IDownloadMerchantDetailService;
import com.sbm.module.onlineleasing.api.merchantdetail.event.IDownloadMerchantDetailEvent;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;

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
public class DownloadMerchantDetailListener extends BusinessEventListener {

	@Autowired
	private IDownloadMerchantDetailService service;

	@EventListener
	public void onApplicationEvent(BusinessEvent event) {
		if (event instanceof IDownloadMerchantDetailEvent) {
			async(event);
		}
	}

	protected void execute(BusinessEvent event) {
		if (event.isNotNull(BusinessEventListenerConstant.BaseEntity)) {
			TOLMerchant obj = (TOLMerchant) event.getTemplate().get(BusinessEventListenerConstant.BaseEntity);
			service.download(obj);
		}
	}
}
