package com.sbm.module.onlineleasing.base.biddetail.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.biddetail.dao.ITOLBidDetailDao;
import com.sbm.module.onlineleasing.base.biddetail.domain.TOLBidDetail;

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
public class TOLBidDetailDaoImpl extends BaseHibernateDaoImpl<TOLBidDetail> implements ITOLBidDetailDao {

	public List<TOLBidDetail> findAll() {
		String hql = "from TOLBidDetail";
		List<TOLBidDetail> list = find(hql);
		return list;
	}

	public List<TOLBidDetail> findAllByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLBidDetail where 1=1 ");
		sb.append(" and code = ?");
		sb.append(" order by orders asc");
		List<TOLBidDetail> list = find(sb.toString(), code);
		return list;
	}

}
