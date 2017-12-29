package com.sbm.module.onlineleasing.base.merchant.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.common.business.domain.HqlData;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.merchant.dao.ITOLMerchantDao;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;

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
public class TOLMerchantDaoImpl extends BaseHibernateDaoImpl<TOLMerchant> implements ITOLMerchantDao {

	public List<TOLMerchant> findAll() {
		String hql = "from TOLMerchant";
		List<TOLMerchant> list = find(hql);
		return list;
	}

	public TOLMerchant findByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLMerchant where 1=1 ");
		sb.append(" and code = ? ");
		List<TOLMerchant> list = find(sb.toString(), code);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public TOLMerchant findByHdUuid(String hdUuid) {
		StringBuffer sb = new StringBuffer("from TOLMerchant where 1=1 ");
		sb.append(" and hdUuid = ?");
		List<TOLMerchant> list = find(sb.toString(), hdUuid);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public TOLMerchant findByUscc(String uscc) {
		StringBuffer sb = new StringBuffer("from TOLMerchant where 1=1 ");
		sb.append(" and uscc = ? ");
		List<TOLMerchant> list = find(sb.toString(), uscc);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public List<TOLMerchant> findAllByCondition(TOLMerchant obj) {
		return find(findAllByConditionHql(obj));
	}

	public Pagination<TOLMerchant> findAllByConditionPage(TOLMerchant obj) {
		return pageQuery(findAllByConditionHql(obj));
	}

	private HqlData findAllByConditionHql(TOLMerchant obj) {
		HqlData data = getHqlData(obj);
		StringBuffer sb = new StringBuffer("from TOLMerchant where 1=1 ");
		// sb.append(" and userCode = ? ");
		// data.getObjs().add(obj.getUserCode());
		// if (null != obj.getType()) {
		// sb.append(" and type = ? ");
		// data.getObjs().add(obj.getType());
		// }
		sb.append(" order by id desc ");
		data.setHql(sb.toString());
		return data;
	}

}
