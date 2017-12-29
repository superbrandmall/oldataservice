package com.sbm.module.onlineleasing.base.bidparam.leasetype.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.bidparam.leasetype.dao.ITOLBidLeasetypeDao;
import com.sbm.module.onlineleasing.base.bidparam.leasetype.domain.TOLBidLeasetype;

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
public class TOLBidLeasetypeDaoImpl extends BaseHibernateDaoImpl<TOLBidLeasetype> implements ITOLBidLeasetypeDao {

	public List<TOLBidLeasetype> findAll() {
		String hql = "from TOLBidLeasetype";
		List<TOLBidLeasetype> list = find(hql);
		return list;
	}

	public TOLBidLeasetype findByItemNo(Integer itemNo) {
		StringBuffer sb = new StringBuffer("from TOLBidLeasetype where 1=1 ");
		sb.append(" and itemNo = ?");
		List<TOLBidLeasetype> list = find(sb.toString(), itemNo);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
