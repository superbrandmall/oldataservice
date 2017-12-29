package com.sbm.module.onlineleasing.base.shopimages.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.shopimages.dao.ITOLShopImagesDao;
import com.sbm.module.onlineleasing.base.shopimages.domain.TOLShopImages;

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
public class TOLShopImagesDaoImpl extends BaseHibernateDaoImpl<TOLShopImages> implements ITOLShopImagesDao {

	public List<TOLShopImages> findAll() {
		String hql = "from TOLShopImages";
		List<TOLShopImages> list = find(hql);
		return list;
	}

	public List<TOLShopImages> findAllByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLShopImages where 1=1 ");
		sb.append(" and code = ? ");
		sb.append(" order by position asc");
		List<TOLShopImages> list = find(sb.toString(), code);
		return list;
	}

}
