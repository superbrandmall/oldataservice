package com.sbm.module.partner.hd.view.promotionkind.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.partner.hd.view.base.dao.impl.HdBaseHibernateDaoImpl;
import com.sbm.module.partner.hd.view.promotionkind.dao.IPromotionKindDao;
import com.sbm.module.partner.hd.view.promotionkind.domain.PromotionKind;

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
public class PromotionKindDaoImpl extends HdBaseHibernateDaoImpl<PromotionKind> implements IPromotionKindDao {

	public List<PromotionKind> findAll() {
		String hql = "from PromotionKind";
		List<PromotionKind> list = find(hql);
		return list;
	}

	public PromotionKind findByItemno(Integer itemno) {
		StringBuffer sb = new StringBuffer("from PromotionKind where 1=1 ");
		sb.append(" and itemno = ?");
		List<PromotionKind> list = find(sb.toString(), itemno);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
