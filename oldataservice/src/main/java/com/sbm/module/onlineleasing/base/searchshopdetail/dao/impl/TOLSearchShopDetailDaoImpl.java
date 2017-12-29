package com.sbm.module.onlineleasing.base.searchshopdetail.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.common.business.domain.HqlData;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.api.searchshop.domain.SearchShopVo;
import com.sbm.module.onlineleasing.base.searchshopdetail.dao.ITOLSearchShopDetailDao;
import com.sbm.module.onlineleasing.base.searchshopdetail.domain.TOLSearchShopDetail;

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
public class TOLSearchShopDetailDaoImpl extends BaseHibernateDaoImpl<TOLSearchShopDetail> implements
		ITOLSearchShopDetailDao {

	public List<TOLSearchShopDetail> findAll() {
		String hql = "from TOLSearchShopDetail";
		List<TOLSearchShopDetail> list = find(hql);
		return list;
	}

	public TOLSearchShopDetail findByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLSearchShopDetail where 1=1 ");
		sb.append(" and code = ? ");
		List<TOLSearchShopDetail> list = find(sb.toString(), code);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public TOLSearchShopDetail findByCondition(TOLSearchShopDetail obj) {
		StringBuffer sb = new StringBuffer("from TOLSearchShopDetail where 1=1 ");
		// sb.append(" and unit ='").append(obj.getUnit()).append("'");
		// sb.append(" and buildingCode ='").append(obj.getBuildingCode()).append("'");
		// sb.append(" and mallCode ='").append(obj.getMallCode()).append("'");
		List<TOLSearchShopDetail> list = find(sb.toString());
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public List<TOLSearchShopDetail> findAllBySearchShop(SearchShopVo obj) {
		return find(findAllBySearchShopHql(obj));
	}

	public Pagination<TOLSearchShopDetail> findAllBySearchShopPage(SearchShopVo obj) {
		return pageQuery(findAllBySearchShopHql(obj));
	}

	private HqlData findAllBySearchShopHql(SearchShopVo obj) {
		HqlData data = getHqlData(obj);
		StringBuffer sb = new StringBuffer("from TOLSearchShopDetail where 1=1 ");
		sb.append(" and userCode = ? ");
		data.getObjs().add(obj.getUserCode());
		sb.append(" order by updated desc ");
		data.setHql(sb.toString());
		return data;
	}

}
