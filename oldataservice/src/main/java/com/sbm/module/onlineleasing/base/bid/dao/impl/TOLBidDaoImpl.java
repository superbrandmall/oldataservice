package com.sbm.module.onlineleasing.base.bid.dao.impl;

import java.util.List;

import com.sbm.module.common.base.util.ListUtil;
import com.sbm.module.onlineleasing.base.bid.constant.BidConstant;
import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.common.business.domain.HqlData;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.bid.dao.ITOLBidDao;
import com.sbm.module.onlineleasing.base.bid.domain.TOLBid;

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
public class TOLBidDaoImpl extends BaseHibernateDaoImpl<TOLBid> implements ITOLBidDao {

	public List<TOLBid> findAll() {
		String hql = "from TOLBid";
		List<TOLBid> list = find(hql);
		return list;
	}

	public TOLBid findByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLBid where 1=1 ");
		sb.append(" and code = ? ");
		List<TOLBid> list = find(sb.toString(), code);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public TOLBid findByBillNumber(String billNumber) {
		StringBuffer sb = new StringBuffer("from TOLBid where 1=1 ");
		sb.append(" and billNumber = ? ");
		List<TOLBid> list = find(sb.toString(), billNumber);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public List<TOLBid> findAllByUserCodeAndApprove(TOLBid obj) {
		return find(findAllByUserCodeAndApproveHql(obj));
	}

	public Pagination<TOLBid> findAllByUserCodeAndApprovePage(TOLBid obj) {
		return pageQuery(findAllByUserCodeAndApproveHql(obj));
	}

	private HqlData findAllByUserCodeAndApproveHql(TOLBid obj) {
		HqlData data = getHqlData(obj);
		StringBuffer sb = new StringBuffer("from TOLBid where 1=1 ");
		sb.append(" and userCode = ? ");
		data.getObjs().add(obj.getUserCode());
		sb.append(" and isApprove in ").append(ListUtil.intList2HQLStr(obj.getIsApproves()));
		sb.append(" order by id desc ");
		data.setHql(sb.toString());
		return data;
	}

	public List<TOLBid> findAllBeforeNonStandardSubmit(String shopCode){
		StringBuffer sb = new StringBuffer("from TOLBid where 1=1 ");
		sb.append(" and shopCode = ? ");
		sb.append(" and processState = ? ");
		sb.append(" and isStandard = ? ");
		sb.append(" and isApprove = ? ");
		sb.append(" and isEffect = ? ");

		List<TOLBid> list = find(sb.toString(), shopCode, BidConstant.END_OF_APPROVAL, BidConstant.NONSTANDARD, BidConstant.APPROVE, BidConstant.INEFFECTIVE);
		return list;

	}


}
