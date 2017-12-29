package com.sbm.module.onlineleasing.base.sysmessage.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.common.business.domain.HqlData;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.sysmessage.dao.ITOLSysMessageDao;
import com.sbm.module.onlineleasing.base.sysmessage.domain.TOLSysMessage;

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
public class TOLSysMessageDaoImpl extends BaseHibernateDaoImpl<TOLSysMessage> implements ITOLSysMessageDao {

	public List<TOLSysMessage> findAll() {
		String hql = "from TOLSysMessage";
		List<TOLSysMessage> list = find(hql);
		return list;
	}

	public TOLSysMessage findByCondition(TOLSysMessage obj) {
		StringBuffer sb = new StringBuffer("from TOLSysMessage where 1=1 ");
		// sb.append(" and unit ='").append(obj.getUnit()).append("'");
		// sb.append(" and buildingCode ='").append(obj.getBuildingCode()).append("'");
		// sb.append(" and mallCode ='").append(obj.getMallCode()).append("'");
		List<TOLSysMessage> list = find(sb.toString());
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public List<TOLSysMessage> findAllByUserCodeAndType(TOLSysMessage obj) {
		return find(findAllByUserCodeAndTypeHql(obj));
	}

	public Pagination<TOLSysMessage> findAllByUserCodeAndTypePage(TOLSysMessage obj) {
		return pageQuery(findAllByUserCodeAndTypeHql(obj));
	}

	private HqlData findAllByUserCodeAndTypeHql(TOLSysMessage obj) {
		HqlData data = getHqlData(obj);
		StringBuffer sb = new StringBuffer("from TOLSysMessage where 1=1 ");
		sb.append(" and userCode = ? ");
		data.getObjs().add(obj.getUserCode());
		if (null != obj.getType()) {
			sb.append(" and type = ? ");
			data.getObjs().add(obj.getType());
		}
		sb.append(" order by id desc ");
		data.setHql(sb.toString());
		return data;
	}
}
