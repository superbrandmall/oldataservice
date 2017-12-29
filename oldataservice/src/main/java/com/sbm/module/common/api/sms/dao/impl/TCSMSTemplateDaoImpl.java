package com.sbm.module.common.api.sms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.api.sms.dao.ITCSMSTemplateDao;
import com.sbm.module.common.api.sms.domain.TCSMSTemplate;
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
public class TCSMSTemplateDaoImpl extends BaseHibernateDaoImpl<TCSMSTemplate> implements ITCSMSTemplateDao {

	public List<TCSMSTemplate> findAll() {
		String hql = "from TCSMSTemplate";
		List<TCSMSTemplate> list = find(hql);
		return list;
	}

	public TCSMSTemplate findByCode(String code) {
		StringBuffer sb = new StringBuffer("from TCSMSTemplate where 1=1 ");
		sb.append(" and code = ?");
		List<TCSMSTemplate> list = find(sb.toString(), code);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
