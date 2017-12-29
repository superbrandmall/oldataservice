package com.sbm.module.onlineleasing.base.malltraffic.dao.impl;

import java.util.List;

import com.sbm.module.common.business.domain.HqlData;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;
import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.malltraffic.dao.ITOLMallTrafficDao;
import com.sbm.module.onlineleasing.base.malltraffic.domain.TOLMallTraffic;

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
public class TOLMallTrafficDaoImpl extends BaseHibernateDaoImpl<TOLMallTraffic> implements ITOLMallTrafficDao {

	public List<TOLMallTraffic> findAll() {
		String hql = "from TOLMallTraffic";
		List<TOLMallTraffic> list = find(hql);
		return list;
	}

	public List<TOLMallTraffic> findAllByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLMallTraffic where 1=1 ");
		sb.append(" and code = ?");
		List<TOLMallTraffic> list = find(sb.toString(), code);
		return list;
	}

	public List<TOLMallTraffic> findAllByCondition(TOLMallTraffic obj) {
		return find(findAllByConditionHql(obj));
	}

	public Pagination<TOLMallTraffic> findAllByConditionPage(TOLMallTraffic obj) {
		return pageQuery(findAllByConditionHql(obj));
	}

	private HqlData findAllByConditionHql(TOLMallTraffic obj) {
		HqlData data = getHqlData(obj);
		StringBuffer sb = new StringBuffer("from TOLMallTraffic where 1=1 ");
		 sb.append(" and code = ? ");
		 data.getObjs().add(obj.getCode());
		// if (null != obj.getType()) {
		// sb.append(" and type = ? ");
		// data.getObjs().add(obj.getType());
		// }
		sb.append(" order by id desc ");
		data.setHql(sb.toString());
		return data;
	}
}
