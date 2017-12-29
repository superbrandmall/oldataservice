package com.sbm.module.partner.hd.view.leasemodule.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.partner.hd.view.base.dao.impl.HdBaseHibernateDaoImpl;
import com.sbm.module.partner.hd.view.leasemodule.dao.ILeasemoduleDao;
import com.sbm.module.partner.hd.view.leasemodule.domain.Leasemodule;

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
public class LeasemoduleDaoImpl extends HdBaseHibernateDaoImpl<Leasemodule> implements ILeasemoduleDao {

	public List<Leasemodule> findAll() {
		String hql = "from Leasemodule";
		List<Leasemodule> list = find(hql);
		return list;
	}

	public Leasemodule findByItemno(Integer itemno) {
		StringBuffer sb = new StringBuffer("from Leasemodule where 1=1 ");
		sb.append(" and itemno = ?");
		List<Leasemodule> list = find(sb.toString(), itemno);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
