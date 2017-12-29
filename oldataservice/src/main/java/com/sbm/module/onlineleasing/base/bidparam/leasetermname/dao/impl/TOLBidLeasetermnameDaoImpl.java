package com.sbm.module.onlineleasing.base.bidparam.leasetermname.dao.impl;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.bidparam.leasemodule.dao.ITOLBidLeasemoduleDao;
import com.sbm.module.onlineleasing.base.bidparam.leasemodule.domain.TOLBidLeasemodule;
import com.sbm.module.onlineleasing.base.bidparam.leasetermname.dao.ITOLBidLeasetermnameDao;
import com.sbm.module.onlineleasing.base.bidparam.leasetermname.domain.TOLBidLeasetermname;
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
public class TOLBidLeasetermnameDaoImpl extends BaseHibernateDaoImpl<TOLBidLeasetermname> implements ITOLBidLeasetermnameDao {

	public List<TOLBidLeasetermname> findAll() {
		String hql = "from TOLBidLeasetermname";
		List<TOLBidLeasetermname> list = find(hql);
		return list;
	}

	public TOLBidLeasetermname findByItemNo(Integer itemNo) {
		StringBuffer sb = new StringBuffer("from TOLBidLeasetermname where 1=1 ");
		sb.append(" and itemNo = ?");
		List<TOLBidLeasetermname> list = find(sb.toString(), itemNo);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
