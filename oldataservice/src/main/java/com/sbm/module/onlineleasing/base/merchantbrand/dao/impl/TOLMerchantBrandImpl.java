package com.sbm.module.onlineleasing.base.merchantbrand.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.merchantbrand.dao.ITOLMerchantBrandDao;
import com.sbm.module.onlineleasing.base.merchantbrand.domain.TOLMerchantBrand;

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
public class TOLMerchantBrandImpl extends BaseHibernateDaoImpl<TOLMerchantBrand> implements ITOLMerchantBrandDao {

	public List<TOLMerchantBrand> findAll() {
		String hql = "from TOLMerchantBrand";
		List<TOLMerchantBrand> list = find(hql);
		return list;
	}

	public List<TOLMerchantBrand> findAllByMerchantCode(String merchantCode) {
		StringBuffer sb = new StringBuffer("from TOLMerchantBrand where 1=1 ");
		sb.append(" and merchantCode = ?");
		List<TOLMerchantBrand> list = find(sb.toString(), merchantCode);
		return list;
	}

	public List<TOLMerchantBrand> findAllByBrandCode(String brandCode) {
		StringBuffer sb = new StringBuffer("from TOLMerchantBrand where 1=1 ");
		sb.append(" and brandCode = ?");
		List<TOLMerchantBrand> list = find(sb.toString(), brandCode);
		return list;
	}

	public TOLMerchantBrand findByMerchantCodeAndBrandCode(String merchantCode, String brandCode) {
		StringBuffer sb = new StringBuffer("from TOLMerchantBrand where 1=1 ");
		sb.append(" and merchantCode = ? and brandCode = ?");
		List<TOLMerchantBrand> list = find(sb.toString(), merchantCode, brandCode);
		if (null != list && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
