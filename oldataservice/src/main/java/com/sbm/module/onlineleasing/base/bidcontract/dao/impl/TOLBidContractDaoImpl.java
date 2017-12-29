package com.sbm.module.onlineleasing.base.bidcontract.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.bidcontract.dao.ITOLBidContractDao;
import com.sbm.module.onlineleasing.base.bidcontract.domain.TOLBidContract;

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
public class TOLBidContractDaoImpl extends BaseHibernateDaoImpl<TOLBidContract> implements ITOLBidContractDao {

	public List<TOLBidContract> findAll() {
		String hql = "from TOLBidContract";
		List<TOLBidContract> list = find(hql);
		return list;
	}

	public TOLBidContract findByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLBidContract where 1=1 ");
		sb.append(" and code = ?");
		List<TOLBidContract> list = find(sb.toString(), code);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public TOLBidContract findByDepositBillNumber(String depositBillNumber) {
		StringBuffer sb = new StringBuffer("from TOLBidContract where 1=1 ");
		sb.append(" and depositBillNumber = ?");
		List<TOLBidContract> list = find(sb.toString(), depositBillNumber);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
}
