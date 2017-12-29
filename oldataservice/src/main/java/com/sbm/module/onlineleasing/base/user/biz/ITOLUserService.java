package com.sbm.module.onlineleasing.base.user.biz;

import java.util.List;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.onlineleasing.base.user.domain.TOLUser;

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
public interface ITOLUserService extends IDaoSupportService<TOLUser> {
	public List<TOLUser> findAll();

	public List<TOLUser> findAllByMerchantCode(String merchantCode);

	public List<TOLUser> findAllByMerchantCodes(List<String> merchantCodes);

	public TOLUser findByCondition(TOLUser obj);

	public TOLUser findByCode(String code);

	public TOLUser findByMobile(String mobile);

	public TOLUser findByEmail(String email);

	/**
	 * 
	 * saveUser:注册用户
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	public void saveUser(TOLUser obj);

	/**
	 * 
	 * findByUsername:通过用户名（手机或者邮箱）查询
	 * 
	 * @author junkai.zhang
	 * @param username
	 * @return
	 */
	public TOLUser findByUsername(String username);

	/**
	 * 
	 * changePassword:修改密码
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	public void changePassword(TOLUser obj);
}
