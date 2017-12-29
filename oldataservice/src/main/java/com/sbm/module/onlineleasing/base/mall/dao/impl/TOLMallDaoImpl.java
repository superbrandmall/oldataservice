package com.sbm.module.onlineleasing.base.mall.dao.impl;

import java.util.List;

import com.sbm.module.common.business.domain.HqlData;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.mall.dao.ITOLMallDao;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;

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
public class TOLMallDaoImpl extends BaseHibernateDaoImpl<TOLMall> implements ITOLMallDao {

	public List<TOLMall> findAll() {
		String hql = "from TOLMall";
		List<TOLMall> list = find(hql);
		return list;
	}

	public TOLMall findByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLMall where 1=1 ");
		sb.append(" and code = ?");
		List<TOLMall> list = find(sb.toString(), code);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public TOLMall findByHdUuid(String hdUuid) {
		StringBuffer sb = new StringBuffer("from TOLMall where 1=1 ");
		sb.append(" and hdUuid = ?");
		List<TOLMall> list = find(sb.toString(), hdUuid);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public List<TOLMall> findAllByCondition(TOLMall obj) {
		return find(findAllByConditionHql(obj));
	}

	public Pagination<TOLMall> findAllByConditionPage(TOLMall obj) {
		return pageQuery(findAllByConditionHql(obj));
	}

	private HqlData findAllByConditionHql(TOLMall obj) {
		HqlData data = getHqlData(obj);
		StringBuffer sb = new StringBuffer("from TOLMall where 1=1 ");
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
