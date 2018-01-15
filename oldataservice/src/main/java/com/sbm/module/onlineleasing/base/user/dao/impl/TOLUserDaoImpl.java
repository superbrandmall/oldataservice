package com.sbm.module.onlineleasing.base.user.dao.impl;

import java.util.List;

import com.sbm.module.common.business.domain.HqlData;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.floor.domain.TOLFloor;
import org.springframework.stereotype.Repository;

import com.sbm.module.common.base.util.ListUtil;
import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.user.dao.ITOLUserDao;
import com.sbm.module.onlineleasing.base.user.domain.TOLUser;

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
public class TOLUserDaoImpl extends BaseHibernateDaoImpl<TOLUser> implements ITOLUserDao {

	public List<TOLUser> findAll() {
		String hql = "from TOLUser";
		List<TOLUser> list = find(hql);
		return list;
	}

	public List<TOLUser> findAllByMerchantCode(String merchantCode) {
		StringBuffer sb = new StringBuffer("from TOLUser where 1=1 ");
		sb.append(" and merchantCode = ?");
		List<TOLUser> list = find(sb.toString(), merchantCode);
		return list;
	}

	public List<TOLUser> findAllByMerchantCodes(List<String> merchantCodes) {
		StringBuffer sb = new StringBuffer("from TOLUser where 1=1 ");
		sb.append(" and merchantCode in ").append(ListUtil.strList2HQLStr(merchantCodes));
		List<TOLUser> list = find(sb.toString());
		return list;
	}

	public List<TOLUser> findAllByCondition(TOLUser obj) {
		return find(findAllByConditionHql(obj));
	}

	public Pagination<TOLUser> findAllByConditionPage(TOLUser obj) {
		return pageQuery(findAllByConditionHql(obj));
	}

	private HqlData findAllByConditionHql(TOLUser obj) {
		HqlData data = getHqlData(obj);
		StringBuffer sb = new StringBuffer("from TOLUser where 1=1 ");
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

	public TOLUser findByCondition(TOLUser obj) {
		StringBuffer sb = new StringBuffer("from TOLUser where 1=1 ");
		// sb.append(" and unit ='").append(obj.getUnit()).append("'");
		// sb.append(" and buildingCode ='").append(obj.getBuildingCode()).append("'");
		// sb.append(" and mallCode ='").append(obj.getMallCode()).append("'");
		List<TOLUser> list = find(sb.toString());
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public TOLUser findByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLUser where 1=1 ");
		sb.append(" and code = ?");
		List<TOLUser> list = find(sb.toString(), code);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public TOLUser findByMobile(String mobile) {
		StringBuffer sb = new StringBuffer("from TOLUser where 1=1 ");
		sb.append(" and mobile = ?");
		List<TOLUser> list = find(sb.toString(), mobile);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public TOLUser findByEmail(String email) {
		StringBuffer sb = new StringBuffer("from TOLUser where 1=1 ");
		sb.append(" and email = ?");
		List<TOLUser> list = find(sb.toString(), email);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public TOLUser findByUsername(String username) {
		StringBuffer sb = new StringBuffer("from TOLUser where 1=1 ");
		sb.append(" and mobile = ? or email = ? ");
		List<TOLUser> list = find(sb.toString(), username, username);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
