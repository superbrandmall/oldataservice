package com.sbm.module.onlineleasing.base.merchantbusinesslicense.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.merchantbusinesslicense.dao.ITOLMerchantBusinessLicenseDao;
import com.sbm.module.onlineleasing.base.merchantbusinesslicense.domain.TOLMerchantBusinessLicense;

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
public class TOLMerchantBusinessLicenseImpl extends BaseHibernateDaoImpl<TOLMerchantBusinessLicense> implements
		ITOLMerchantBusinessLicenseDao {

	public List<TOLMerchantBusinessLicense> findAll() {
		String hql = "from TOLMerchantBusinessLicense";
		List<TOLMerchantBusinessLicense> list = find(hql);
		return list;
	}

	public TOLMerchantBusinessLicense findByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLMerchantBusinessLicense where 1=1 ");
		sb.append(" and code = ?");
		List<TOLMerchantBusinessLicense> list = find(sb.toString(), code);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
