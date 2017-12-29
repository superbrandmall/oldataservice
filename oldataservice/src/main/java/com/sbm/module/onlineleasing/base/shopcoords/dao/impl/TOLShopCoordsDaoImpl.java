package com.sbm.module.onlineleasing.base.shopcoords.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.shopcoords.dao.ITOLShopCoordsDao;
import com.sbm.module.onlineleasing.base.shopcoords.domain.TOLShopCoords;

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
public class TOLShopCoordsDaoImpl extends BaseHibernateDaoImpl<TOLShopCoords> implements ITOLShopCoordsDao {

	public List<TOLShopCoords> findAll() {
		String hql = "from TOLShopCoords";
		List<TOLShopCoords> list = find(hql);
		return list;
	}

	public TOLShopCoords findByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLShopCoords where 1=1 ");
		sb.append(" and code = ? ");
		List<TOLShopCoords> list = find(sb.toString(), new Object[] { code });
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public TOLShopCoords findByCondition(TOLShopCoords obj) {
		StringBuffer sb = new StringBuffer("from TOLShopCoords where 1=1 ");
		sb.append(" and unit = ? ");
		sb.append(" and buildingCode = ? ");
		List<TOLShopCoords> list = find(sb.toString(), new Object[] { obj.getUnit(), obj.getBuildingCode() });
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
