package com.sbm.module.onlineleasing.base.user.dao;

import java.util.List;

import com.sbm.module.common.business.dao.IBaseHibernateDao;
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

	public List<TOLUser> findAll();

	public List<TOLUser> findAllByMerchantCode(String merchantCode);

	public List<TOLUser> findAllByMerchantCodes(List<String> merchantCodes);

	public TOLUser findByCondition(TOLUser obj);

	public TOLUser findByCode(String code);

	public TOLUser findByMobile(String mobile);

	public TOLUser findByEmail(String email);

	public TOLUser findByUsername(String username);

}
