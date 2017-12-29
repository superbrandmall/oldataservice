package com.sbm.module.onlineleasing.base.bidparam.rentmethod.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.bidparam.rentmethod.dao.ITOLBidRentMethodDao;
import com.sbm.module.onlineleasing.base.bidparam.rentmethod.domain.TOLBidRentMethod;

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
public class TOLBidRentMethodDaoImpl extends BaseHibernateDaoImpl<TOLBidRentMethod> implements ITOLBidRentMethodDao {

	public List<TOLBidRentMethod> findAll() {
		String hql = "from TOLBidRentMethod";
		List<TOLBidRentMethod> list = find(hql);
		return list;
	}

	public TOLBidRentMethod findByItemNo(Integer itemNo) {
		StringBuffer sb = new StringBuffer("from TOLBidRentMethod where 1=1 ");
		sb.append(" and itemNo = ?");
		List<TOLBidRentMethod> list = find(sb.toString(), itemNo);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
