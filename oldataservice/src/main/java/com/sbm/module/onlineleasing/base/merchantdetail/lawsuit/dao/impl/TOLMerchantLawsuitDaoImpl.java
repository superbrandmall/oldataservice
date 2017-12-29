package com.sbm.module.onlineleasing.base.merchantdetail.lawsuit.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.common.business.domain.HqlData;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.merchantdetail.lawsuit.dao.ITOLMerchantLawsuitDao;
import com.sbm.module.onlineleasing.base.merchantdetail.lawsuit.domain.TOLMerchantLawsuit;

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
public class TOLMerchantLawsuitDaoImpl extends BaseHibernateDaoImpl<TOLMerchantLawsuit> implements
		ITOLMerchantLawsuitDao {

	public List<TOLMerchantLawsuit> findAll() {
		String hql = "from TOLMerchantLawsuit";
		List<TOLMerchantLawsuit> list = find(hql);
		return list;
	}

	public List<TOLMerchantLawsuit> findAllByCondition(TOLMerchantLawsuit obj) {
		return find(findAllByConditionHql(obj));
	}

	public Pagination<TOLMerchantLawsuit> findAllByConditionPage(TOLMerchantLawsuit obj) {
		return pageQuery(findAllByConditionHql(obj));
	}

	private HqlData findAllByConditionHql(TOLMerchantLawsuit obj) {
		HqlData data = getHqlData(obj);
		StringBuffer sb = new StringBuffer("from TOLMerchantLawsuit where 1=1 ");
		sb.append(" and code = ? ");
		data.getObjs().add(obj.getCode());
		sb.append(" order by id desc ");
		data.setHql(sb.toString());
		return data;
	}

	public void deleteByCode(String code) {
		HqlData data = getHqlData(null);
		StringBuffer sb = new StringBuffer("delete from TOLMerchantLawsuit where 1=1 ");
		sb.append("and code = ? ");
		data.getObjs().add(code);
		data.setHql(sb.toString());
		execute(data);
	}

}
