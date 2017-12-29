package com.sbm.module.onlineleasing.base.merchantaddress.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.merchantaddress.dao.ITOLMerchantAddressDao;
import com.sbm.module.onlineleasing.base.merchantaddress.domain.TOLMerchantAddress;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/
/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.dao.impl<br/>
 * File Name:EdiInteractiveDetailDaoImpl.java<br/>
 * 
 * 作成日 ：2016-1-4 下午4:41:35 <br/>
 * 
 * @author ：junkai.zhang
 * @preserve public
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Repository
public class TOLMerchantAddressDaoImpl extends BaseHibernateDaoImpl<TOLMerchantAddress> implements
		ITOLMerchantAddressDao {

	public List<TOLMerchantAddress> findAll() {
		String hql = "from TOLMerchantAddress";
		List<TOLMerchantAddress> list = find(hql);
		return list;
	}

	public TOLMerchantAddress findByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLMerchantAddress where 1=1 ");
		sb.append(" and code = ?");
		List<TOLMerchantAddress> list = find(sb.toString(), code);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
