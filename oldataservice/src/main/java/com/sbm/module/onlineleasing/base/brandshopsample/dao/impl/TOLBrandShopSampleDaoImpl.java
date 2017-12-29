package com.sbm.module.onlineleasing.base.brandshopsample.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.brandshopsample.dao.ITOLBrandShopSampleDao;
import com.sbm.module.onlineleasing.base.brandshopsample.domain.TOLBrandShopSample;

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
public class TOLBrandShopSampleDaoImpl extends BaseHibernateDaoImpl<TOLBrandShopSample> implements
		ITOLBrandShopSampleDao {

	public List<TOLBrandShopSample> findAll() {
		String hql = "from TOLBrandShopSample";
		List<TOLBrandShopSample> list = find(hql);
		return list;
	}

	public List<TOLBrandShopSample> findByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLBrandShopSample where 1=1 ");
		sb.append(" and code = ?");
		List<TOLBrandShopSample> list = find(sb.toString(), code);
		return list;
	}

}
