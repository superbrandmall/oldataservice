package com.sbm.module.onlineleasing.base.tempparam.dao.impl;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.bidparam.rentmethod.dao.ITOLBidRentMethodDao;
import com.sbm.module.onlineleasing.base.bidparam.rentmethod.domain.TOLBidRentMethod;
import com.sbm.module.onlineleasing.base.tempparam.dao.ITOLTempParamDao;
import com.sbm.module.onlineleasing.base.tempparam.domain.TOLTempParam;
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
public class TOLTempParamDaoImpl extends BaseHibernateDaoImpl<TOLTempParam> implements ITOLTempParamDao {

	public List<TOLTempParam> findAll() {
		String hql = "from TOLTempParam";
		List<TOLTempParam> list = find(hql);
		return list;
	}

	public TOLTempParam findByParamAndKey(String param, Integer key) {
		StringBuffer sb = new StringBuffer("from TOLTempParam where 1=1 ");
		sb.append(" and param = ?");
		sb.append(" and key = ?");
		List<TOLTempParam> list = find(sb.toString(), param, key);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public TOLTempParam findByParamAndValue(String param, String value) {
		StringBuffer sb = new StringBuffer("from TOLTempParam where 1=1 ");
		sb.append(" and param = ?");
		sb.append(" and value = ?");
		List<TOLTempParam> list = find(sb.toString(), param, value);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
}
