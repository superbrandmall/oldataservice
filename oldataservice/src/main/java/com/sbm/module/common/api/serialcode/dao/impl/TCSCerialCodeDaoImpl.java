package com.sbm.module.common.api.serialcode.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.api.serialcode.dao.ITCSerialCodeDao;
import com.sbm.module.common.api.serialcode.domain.TCSerialCode;
import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;

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
public class TCSCerialCodeDaoImpl extends BaseHibernateDaoImpl<TCSerialCode> implements ITCSerialCodeDao {

	public TCSerialCode findBySerialGroup(String serialGroup) {
		StringBuffer sb = new StringBuffer("from TCSerialCode where 1=1 ");
		sb.append(" and serialGroup = ?");
		List<TCSerialCode> list = find(sb.toString(), serialGroup.trim());
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
