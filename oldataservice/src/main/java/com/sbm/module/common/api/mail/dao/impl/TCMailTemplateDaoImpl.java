package com.sbm.module.common.api.mail.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.api.mail.dao.ITCMailTemplateDao;
import com.sbm.module.common.api.mail.domain.TCMailTemplate;
import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;

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
public class TCMailTemplateDaoImpl extends BaseHibernateDaoImpl<TCMailTemplate> implements ITCMailTemplateDao {

	public List<TCMailTemplate> findAll() {
		String hql = "from TCMailTemplate";
		List<TCMailTemplate> list = find(hql);
		return list;
	}

	public TCMailTemplate findByCode(String code) {
		StringBuffer sb = new StringBuffer("from TCMailTemplate where 1=1 ");
		sb.append(" and code = ?");
		List<TCMailTemplate> list = find(sb.toString(), code);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
