package com.sbm.module.onlineleasing.base.floor.dao.impl;

import java.util.List;

import com.sbm.module.common.base.util.ListUtil;
import com.sbm.module.common.business.domain.HqlData;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.building.domain.TOLBuilding;
import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.floor.dao.ITOLFloorDao;
import com.sbm.module.onlineleasing.base.floor.domain.TOLFloor;

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
public class TOLFloorDaoImpl extends BaseHibernateDaoImpl<TOLFloor> implements ITOLFloorDao {

	public List<TOLFloor> findAll() {
		String hql = "from TOLFloor";
		List<TOLFloor> list = find(hql);
		return list;
	}

	public List<TOLFloor> findAllByBuildingCode(String buildingCode) {
		StringBuffer sb = new StringBuffer("from TOLFloor where 1=1 ");
		sb.append(" and buildingCode = ?");
		List<TOLFloor> list = find(sb.toString(), buildingCode);
		return list;
	}

	public List<TOLFloor> findAllByBuildingCodesAndDescription(List<String> buildingCodes, String description) {
		StringBuffer sb = new StringBuffer("from TOLFloor where 1=1 ");
		sb.append(" and buildingCode in ").append(ListUtil.strList2HQLStr(buildingCodes));
		sb.append(" and description = ? ");
		List<TOLFloor> list = find(sb.toString(), description);
		return list;
	}

	public TOLFloor findByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLFloor where 1=1 ");
		sb.append(" and code = ?");
		List<TOLFloor> list = find(sb.toString(), code);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public TOLFloor findByHdUuid(String hdUuid) {
		StringBuffer sb = new StringBuffer("from TOLFloor where 1=1 ");
		sb.append(" and hdUuid = ?");
		List<TOLFloor> list = find(sb.toString(), hdUuid);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public List<TOLFloor> findAllByCondition(TOLFloor obj) {
		return find(findAllByConditionHql(obj));
	}

	public Pagination<TOLFloor> findAllByConditionPage(TOLFloor obj) {
		return pageQuery(findAllByConditionHql(obj));
	}

	private HqlData findAllByConditionHql(TOLFloor obj) {
		HqlData data = getHqlData(obj);
		StringBuffer sb = new StringBuffer("from TOLFloor where 1=1 ");
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
