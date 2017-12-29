package com.sbm.module.onlineleasing.base.brand.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.common.business.domain.HqlData;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.brand.dao.ITOLBrandDao;
import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;

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
public class TOLBrandDaoImpl extends BaseHibernateDaoImpl<TOLBrand> implements ITOLBrandDao {

	public List<TOLBrand> findAll() {
		String hql = "from TOLBrand";
		List<TOLBrand> list = find(hql);
		return list;
	}

	public TOLBrand findByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLBrand where 1=1 ");
		sb.append(" and code = ?");
		List<TOLBrand> list = find(sb.toString(), code);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public TOLBrand findByHdUuid(String hdUuid) {
		StringBuffer sb = new StringBuffer("from TOLBrand where 1=1 ");
		sb.append(" and hdUuid = ?");
		List<TOLBrand> list = find(sb.toString(), hdUuid);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public TOLBrand findByName(String name) {
		StringBuffer sb = new StringBuffer("from TOLBrand where 1=1 ");
		sb.append(" and name = ?");
		List<TOLBrand> list = find(sb.toString(), name);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public List<TOLBrand> findAllByCondition(TOLBrand obj) {
		return find(findAllByConditionHql(obj));
	}

	public Pagination<TOLBrand> findAllByConditionPage(TOLBrand obj) {
		return pageQuery(findAllByConditionHql(obj));
	}

	private HqlData findAllByConditionHql(TOLBrand obj) {
		HqlData data = getHqlData(obj);
		StringBuffer sb = new StringBuffer("from TOLBrand where 1=1 ");
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
