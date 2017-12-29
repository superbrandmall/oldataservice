package com.sbm.module.onlineleasing.base.modality.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.common.business.domain.HqlData;
import com.sbm.module.onlineleasing.base.modality.dao.ITOLModalityDao;
import com.sbm.module.onlineleasing.base.modality.domain.TOLModality;

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
public class TOLModalityDaoImpl extends BaseHibernateDaoImpl<TOLModality> implements ITOLModalityDao {

	public List<TOLModality> findAll() {
		String hql = "from TOLModality";
		List<TOLModality> list = find(hql);
		return list;
	}

	public List<TOLModality> findAllByLvAndCode(String lv, String code) {
		HqlData data = getHqlData(null);
		StringBuffer sb = new StringBuffer("from TOLModality where 1=1 ");
		sb.append(" and lv = ? ");
		data.getObjs().add(lv);
		if (StringUtils.isNotBlank(code)) {
			sb.append(" and code like ? ");
			data.getObjs().add(likeStrRigth(code));
		}
		data.setHql(sb.toString());
		List<TOLModality> list = find(data);
		return list;
	}

	public TOLModality findByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLModality where 1=1 ");
		sb.append(" and code = ? ");
		List<TOLModality> list = find(sb.toString(), code);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
}
