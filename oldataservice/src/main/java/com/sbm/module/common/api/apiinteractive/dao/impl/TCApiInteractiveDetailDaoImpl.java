package com.sbm.module.common.api.apiinteractive.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.api.apiinteractive.dao.ITCApiInteractiveDetailDao;
import com.sbm.module.common.api.apiinteractive.domain.TCApiInteractiveDetail;
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
public class TCApiInteractiveDetailDaoImpl extends BaseHibernateDaoImpl<TCApiInteractiveDetail> implements
		ITCApiInteractiveDetailDao {

	public List<TCApiInteractiveDetail> findAll() {
		String hql = "from TCApiInteractiveDetail";
		List<TCApiInteractiveDetail> list = find(hql);
		return list;
	}

	public TCApiInteractiveDetail findByCondition(TCApiInteractiveDetail obj) {
		StringBuffer sb = new StringBuffer("from TCApiInteractiveDetail where 1=1 ");
		// sb.append(" and unit = ? ");
		// sb.append(" and buildingCode = ? ");
		// sb.append(" and mallCode = ? ");
		List<TCApiInteractiveDetail> list = find(sb.toString(), new Object[] {});
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
