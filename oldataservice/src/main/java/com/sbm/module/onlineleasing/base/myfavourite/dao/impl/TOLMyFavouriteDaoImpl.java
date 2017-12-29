package com.sbm.module.onlineleasing.base.myfavourite.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.common.business.domain.HqlData;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.myfavourite.dao.ITOLMyFavouriteDao;
import com.sbm.module.onlineleasing.base.myfavourite.domain.TOLMyFavourite;

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
public class TOLMyFavouriteDaoImpl extends BaseHibernateDaoImpl<TOLMyFavourite> implements ITOLMyFavouriteDao {

	public List<TOLMyFavourite> findAll() {
		String hql = "from TOLMyFavourite";
		List<TOLMyFavourite> list = find(hql);
		return list;
	}

	public List<TOLMyFavourite> findAllByUserCode(TOLMyFavourite obj) {
		return find(findAllByUserCodeHql(obj));
	}

	public Pagination<TOLMyFavourite> findAllByUserCodePage(TOLMyFavourite obj) {
		return pageQuery(findAllByUserCodeHql(obj));
	}

	private HqlData findAllByUserCodeHql(TOLMyFavourite obj) {
		HqlData data = getHqlData(obj);
		StringBuffer sb = new StringBuffer("from TOLMyFavourite where 1=1 ");
		sb.append(" and userCode = ? ");
		data.getObjs().add(obj.getUserCode());
		sb.append(" order by updated desc ");
		data.setHql(sb.toString());
		return data;
	}

	public TOLMyFavourite findByUserCodeAndShopCode(TOLMyFavourite obj) {
		StringBuffer sb = new StringBuffer("from TOLMyFavourite where 1=1 ");
		sb.append(" and userCode = ? ");
		sb.append(" and shopCode = ? ");
		List<TOLMyFavourite> list = find(sb.toString(), obj.getUserCode(), obj.getShopCode());
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
