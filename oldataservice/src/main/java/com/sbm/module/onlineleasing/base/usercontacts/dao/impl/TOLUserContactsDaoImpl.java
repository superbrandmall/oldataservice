package com.sbm.module.onlineleasing.base.usercontacts.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.usercontacts.dao.ITOLUserContactsDao;
import com.sbm.module.onlineleasing.base.usercontacts.domain.TOLUserContacts;

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
public class TOLUserContactsDaoImpl extends BaseHibernateDaoImpl<TOLUserContacts> implements ITOLUserContactsDao {

	public List<TOLUserContacts> findAll() {
		String hql = "from TOLUserContacts";
		List<TOLUserContacts> list = find(hql);
		return list;
	}

	public TOLUserContacts findByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLUserContacts where 1=1 ");
		sb.append(" and code = ?");
		List<TOLUserContacts> list = find(sb.toString(), code);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public TOLUserContacts findByIdCard(String idCard) {
		StringBuffer sb = new StringBuffer("from TOLUserContacts where 1=1 ");
		sb.append(" and idCard = ?");
		List<TOLUserContacts> list = find(sb.toString(), idCard);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
