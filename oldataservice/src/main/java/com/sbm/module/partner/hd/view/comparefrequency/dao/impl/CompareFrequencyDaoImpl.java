package com.sbm.module.partner.hd.view.comparefrequency.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.partner.hd.view.base.dao.impl.HdBaseHibernateDaoImpl;
import com.sbm.module.partner.hd.view.comparefrequency.dao.ICompareFrequencyDao;
import com.sbm.module.partner.hd.view.comparefrequency.domain.CompareFrequency;

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
public class CompareFrequencyDaoImpl extends HdBaseHibernateDaoImpl<CompareFrequency> implements ICompareFrequencyDao {

	public List<CompareFrequency> findAll() {
		String hql = "from CompareFrequency";
		List<CompareFrequency> list = find(hql);
		return list;
	}

	public CompareFrequency findByItemno(Integer itemno) {
		StringBuffer sb = new StringBuffer("from CompareFrequency where 1=1 ");
		sb.append(" and itemno = ?");
		List<CompareFrequency> list = find(sb.toString(), itemno);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
