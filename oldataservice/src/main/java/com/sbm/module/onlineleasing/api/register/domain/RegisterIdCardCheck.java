package com.sbm.module.onlineleasing.api.register.domain;

import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.onlineleasing.base.merchantaddress.domain.TOLMerchantAddress;
import com.sbm.module.onlineleasing.base.merchantbusinesslicense.domain.TOLMerchantBusinessLicense;

import java.util.ArrayList;
import java.util.List;

/*****************************************************************************/

/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.onlineleasing.api.register.domain<br/>
 * File Name:RegisterMerchantCheck.java<br/>
 * 
 * 作成日 ：2017-9-20 上午11:43:48 <br/>
 * 
 * @author ：junkai.zhang
 */
public class RegisterIdCardCheck {

	private String name;

	private String idCard;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
}
