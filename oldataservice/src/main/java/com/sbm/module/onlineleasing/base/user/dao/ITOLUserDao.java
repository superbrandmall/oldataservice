package com.sbm.module.onlineleasing.base.user.dao;

import java.util.List;

import com.sbm.module.common.business.dao.IBaseHibernateDao;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.floor.domain.TOLFloor;
import com.sbm.module.onlineleasing.base.user.domain.TOLUser;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.onlineleasing.shop.dao<br/>
 * File Name:ITOLShopDao.java<br/>
 * 
 * 作成日 ：2017-5-18 下午4:22:16 <br/>
 * 
 * @author ：junkai.zhang
 */
public interface ITOLUserDao extends IBaseHibernateDao<TOLUser> {

	List<TOLUser> findAll();

	List<TOLUser> findAllByMerchantCode(String merchantCode);

	List<TOLUser> findAllByMerchantCodes(List<String> merchantCodes);

	List<TOLUser> findAllByCondition(TOLUser obj);

	Pagination<TOLUser> findAllByConditionPage(TOLUser obj);

	TOLUser findByCondition(TOLUser obj);

	TOLUser findByCode(String code);

	TOLUser findByMobile(String mobile);

	TOLUser findByEmail(String email);

	TOLUser findByUsername(String username);

}
