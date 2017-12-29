package com.sbm.module.onlineleasing.api.login.biz;

import com.sbm.module.onlineleasing.api.login.domain.Login;

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
public interface ILoginService {

	/**
	 * 
	 * login:登陆
	 * 
	 * @author junkai.zhang
	 * @param login
	 * @param type
	 */
	public void login(Login login, int type);

	/**
	 * 
	 * updateLanguage:更新默认语言
	 * 
	 * @author junkai.zhang
	 * @param login
	 */
	public void updateLanguage(Login login);

}
