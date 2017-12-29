package com.sbm.module.onlineleasing.api.register.biz;

import com.sbm.module.onlineleasing.api.register.domain.RegisterIdCardCheck;
import com.sbm.module.onlineleasing.api.register.domain.RegisterMerchantCheck;

/*****************************************************************************/

/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.onlineleasing.shop.biz<br/>
 * File Name:ITOLShopService.java<br/>
 * 
 * 作成日 ：2017-5-18 下午4:34:06 <br/>
 * 
 * @author ：junkai.zhang
 */
public interface IRegisterIdCardCheckService {

	/**
	 * 校验身份证信息
	 * @param registerIdCardCheck
	 */
	public void check(RegisterIdCardCheck registerIdCardCheck);



}
