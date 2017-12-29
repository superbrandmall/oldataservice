package com.sbm.module.onlineleasing.base.building.dao.impl;

import java.util.List;

import com.sbm.module.common.business.domain.HqlData;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;
import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.building.dao.ITOLBuildingDao;
import com.sbm.module.onlineleasing.base.building.domain.TOLBuilding;

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
public class TOLBuildingDaoImpl extends BaseHibernateDaoImpl<TOLBuilding> implements ITOLBuildingDao {

	public List<TOLBuilding> findAll() {
		String hql = "from TOLBuilding";
		List<TOLBuilding> list = find(hql);
		return list;
	}

	public List<TOLBuilding> findAllByMallCode(String mallCode) {
		StringBuffer sb = new StringBuffer("from TOLBuilding where 1=1 ");
		sb.append(" and mallCode = ?");
		List<TOLBuilding> list = find(sb.toString(), mallCode);
		return list;
	}

	public TOLBuilding findByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLBuilding where 1=1 ");
		sb.append(" and code = ?");
		List<TOLBuilding> list = find(sb.toString(), code);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public TOLBuilding findByHdUuid(String hdUuid) {
		StringBuffer sb = new StringBuffer("from TOLBuilding where 1=1 ");
		sb.append(" and hdUuid = ?");
		List<TOLBuilding> list = find(sb.toString(), hdUuid);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public List<TOLBuilding> findAllByCondition(TOLBuilding obj) {
		return find(findAllByConditionHql(obj));
	}

	public Pagination<TOLBuilding> findAllByConditionPage(TOLBuilding obj) {
		return pageQuery(findAllByConditionHql(obj));
	}

	private HqlData findAllByConditionHql(TOLBuilding obj) {
		HqlData data = getHqlData(obj);
		StringBuffer sb = new StringBuffer("from TOLBuilding where 1=1 ");
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
