package com.sbm.module.partner.hd.view.leasetermname.dao.impl;

import com.sbm.module.partner.hd.view.base.dao.impl.HdBaseHibernateDaoImpl;
import com.sbm.module.partner.hd.view.leasemodule.dao.ILeasemoduleDao;
import com.sbm.module.partner.hd.view.leasemodule.domain.Leasemodule;
import com.sbm.module.partner.hd.view.leasetermname.dao.ILeasetermnameDao;
import com.sbm.module.partner.hd.view.leasetermname.domain.Leasetermname;
import org.springframework.stereotype.Repository;

import java.util.List;

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
public class LeasetermnameDaoImpl extends HdBaseHibernateDaoImpl<Leasetermname> implements ILeasetermnameDao {

	public List<Leasetermname> findAll() {
		String hql = "from Leasetermname";
		List<Leasetermname> list = find(hql);
		return list;
	}

	public Leasetermname findByItemno(Integer itemno) {
		StringBuffer sb = new StringBuffer("from Leasetermname where 1=1 ");
		sb.append(" and itemno = ?");
		List<Leasetermname> list = find(sb.toString(), itemno);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
