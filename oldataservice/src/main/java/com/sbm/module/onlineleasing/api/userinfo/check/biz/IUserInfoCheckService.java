package com.sbm.module.onlineleasing.api.userinfo.check.biz;

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
public interface IUserInfoCheckService {

	/**
	 * 
	 * isNotExistMobile:手机号不存在
	 * 
	 * @author junkai.zhang
	 * @param mobile
	 */
	public void isNotExistMobile(String mobile);

	/**
	 * 
	 * isNotExistEmail:邮箱不存在
	 * 
	 * @author junkai.zhang
	 * @param email
	 */
	public void isNotExistEmail(String email);

	/**
	 * 
	 * isNotExistIdCard:证件不存在
	 * 
	 * @author junkai.zhang
	 * @param idCard
	 */
	public void isNotExistIdCard(String idCard);

	/*****************************************************************/

	/**
	 * 
	 * existMobile:手机号存在
	 * 
	 * @author junkai.zhang
	 * @param mobile
	 */
	public void existMobile(String mobile);

	/**
	 * 
	 * existEmail:邮箱存在
	 * 
	 * @author junkai.zhang
	 * @param email
	 */
	public void existEmail(String email);

	/**
	 * 
	 * existIdCard:证件存在
	 * 
	 * @author junkai.zhang
	 * @param idCard
	 */
	public void existIdCard(String idCard);
}
