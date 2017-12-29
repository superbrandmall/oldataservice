package com.sbm.module.onlineleasing.api.userinfo.change.biz;

import com.sbm.module.onlineleasing.api.userinfo.change.domain.UserInfoChange;

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
public interface IUserInfoChangeService {

	/**
	 * 
	 * forgetPassword:忘记密码
	 * 
	 * @author junkai.zhang
	 * @param userInfoChange
	 */
	public void forgetPassword(UserInfoChange userInfoChange);

	/**
	 * 
	 * changePassword:修改密码
	 * 
	 * @author junkai.zhang
	 * @param userInfoChange
	 */
	public void changePassword(UserInfoChange userInfoChange);

	/**
	 * 
	 * changeMobile:修改手机
	 * 
	 * @author junkai.zhang
	 * @param userInfoChange
	 */
	public void changeMobile(UserInfoChange userInfoChange);

	/**
	 * 
	 * changeEmail:修改邮箱
	 * 
	 * @author junkai.zhang
	 * @param userInfoChange
	 */
	public void changeEmail(UserInfoChange userInfoChange);

}
