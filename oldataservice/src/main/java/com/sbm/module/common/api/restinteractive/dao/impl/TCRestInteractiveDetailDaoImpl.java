package com.sbm.module.common.api.restinteractive.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.api.restinteractive.dao.ITCRestInteractiveDetailDao;
import com.sbm.module.common.api.restinteractive.domain.TCRestInteractiveDetail;
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
public class TCRestInteractiveDetailDaoImpl extends BaseHibernateDaoImpl<TCRestInteractiveDetail> implements
		ITCRestInteractiveDetailDao {

	public List<TCRestInteractiveDetail> findAll() {
		String hql = "from TCRestInteractiveDetail";
		List<TCRestInteractiveDetail> list = find(hql);
		return list;
	}

	public TCRestInteractiveDetail findByCondition(TCRestInteractiveDetail obj) {
		StringBuffer sb = new StringBuffer("from TCRestInteractiveDetail where 1=1 ");
		// sb.append(" and unit = ? ");
		// sb.append(" and buildingCode = ? ");
		// sb.append(" and mallCode = ? ");
		List<TCRestInteractiveDetail> list = find(sb.toString(), new Object[] {});
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
