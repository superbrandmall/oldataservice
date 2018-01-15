package com.sbm.module.onlineleasing.base.user.biz;

import java.util.List;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.floor.domain.TOLFloor;
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
	List<TOLUser> findAll();

	List<TOLUser> findAllByMerchantCode(String merchantCode);

	List<TOLUser> findAllByMerchantCodes(List<String> merchantCodes);

	List<TOLUser> findAllByCondition(TOLUser obj);

	Pagination<TOLUser> findAllByConditionPage(TOLUser obj);

	TOLUser findByCondition(TOLUser obj);

	TOLUser findByCode(String code);

	TOLUser findByMobile(String mobile);

	TOLUser findByEmail(String email);

	/**
	 * 
	 * saveUser:注册用户
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	void saveUser(TOLUser obj);

	/**
	 * 
	 * findByUsername:通过用户名（手机或者邮箱）查询
	 * 
	 * @author junkai.zhang
	 * @param username
	 * @return
	 */
	TOLUser findByUsername(String username);

	/**
	 * 
	 * changePassword:修改密码
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	void changePassword(TOLUser obj);
}
