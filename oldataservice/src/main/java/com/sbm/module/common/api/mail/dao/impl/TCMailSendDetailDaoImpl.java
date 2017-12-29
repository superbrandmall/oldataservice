package com.sbm.module.common.api.mail.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.api.mail.dao.ITCMailSendDetailDao;
import com.sbm.module.common.api.mail.domain.TCMailSendDetail;
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
public class TCMailSendDetailDaoImpl extends BaseHibernateDaoImpl<TCMailSendDetail> implements ITCMailSendDetailDao {

	public List<TCMailSendDetail> findAll() {
		String hql = "from TCMailSendDetail";
		List<TCMailSendDetail> list = find(hql);
		return list;
	}

	public TCMailSendDetail findByCode(String code) {
		StringBuffer sb = new StringBuffer("from TCMailSendDetail where 1=1 ");
		sb.append(" and code = ?");
		List<TCMailSendDetail> list = find(sb.toString(), code);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
