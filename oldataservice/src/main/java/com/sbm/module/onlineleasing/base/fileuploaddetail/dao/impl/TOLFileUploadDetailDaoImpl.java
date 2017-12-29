package com.sbm.module.onlineleasing.base.fileuploaddetail.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.fileuploaddetail.dao.ITOLFileUploadDetailDao;
import com.sbm.module.onlineleasing.base.fileuploaddetail.domain.TOLFileUploadDetail;

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
public class TOLFileUploadDetailDaoImpl extends BaseHibernateDaoImpl<TOLFileUploadDetail> implements
		ITOLFileUploadDetailDao {

	public List<TOLFileUploadDetail> findAll() {
		String hql = "from TOLFileUploadDetail";
		List<TOLFileUploadDetail> list = find(hql);
		return list;
	}

	public TOLFileUploadDetail findByUri(String uri) {
		StringBuffer sb = new StringBuffer("from TOLFileUploadDetail where 1=1 ");
		sb.append(" and uri = ? ");
		List<TOLFileUploadDetail> list = find(sb.toString(), uri);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
