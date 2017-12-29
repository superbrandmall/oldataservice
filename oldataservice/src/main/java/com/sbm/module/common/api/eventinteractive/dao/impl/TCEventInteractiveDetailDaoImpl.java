package com.sbm.module.common.api.eventinteractive.dao.impl;

import com.sbm.module.common.api.eventinteractive.dao.ITCEventInteractiveDetailDao;
import com.sbm.module.common.api.eventinteractive.domain.TCEventInteractiveDetail;
import com.sbm.module.common.api.jobinteractive.dao.ITCJobInteractiveDetailDao;
import com.sbm.module.common.api.jobinteractive.domain.TCJobInteractiveDetail;
import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

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
public class TCEventInteractiveDetailDaoImpl extends BaseHibernateDaoImpl<TCEventInteractiveDetail> implements
		ITCEventInteractiveDetailDao {

	public List<TCEventInteractiveDetail> findAll() {
		String hql = "from TCEventInteractiveDetail";
		List<TCEventInteractiveDetail> list = find(hql);
		return list;
	}

	public TCEventInteractiveDetail findByCondition(TCEventInteractiveDetail obj) {
		StringBuffer sb = new StringBuffer("from TCEventInteractiveDetail where 1=1 ");
		// sb.append(" and unit = ? ");
		// sb.append(" and buildingCode = ? ");
		// sb.append(" and mallCode = ? ");
		List<TCEventInteractiveDetail> list = find(sb.toString(), new Object[] {});
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
