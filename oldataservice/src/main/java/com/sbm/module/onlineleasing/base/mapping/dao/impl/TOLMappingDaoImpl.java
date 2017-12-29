package com.sbm.module.onlineleasing.base.mapping.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.mapping.dao.ITOLMappingDao;
import com.sbm.module.onlineleasing.base.mapping.domain.TOLMapping;

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
public class TOLMappingDaoImpl extends BaseHibernateDaoImpl<TOLMapping> implements ITOLMappingDao {

	public List<TOLMapping> findAll() {
		String hql = "from TOLMapping";
		List<TOLMapping> list = find(hql);
		return list;
	}

	public TOLMapping findBySystemId(String systemId, String system, String type) {
		StringBuffer sb = new StringBuffer("from TOLMapping where 1=1 ");
		sb.append(" and systemId = ? ");
		sb.append(" and system = ? ");
		sb.append(" and type = ? ");
		List<TOLMapping> list = find(sb.toString(), systemId, system, type);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
}
