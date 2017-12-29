package com.sbm.module.partner.hd.view.floor.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.partner.hd.view.base.dao.impl.HdBaseHibernateDaoImpl;
import com.sbm.module.partner.hd.view.floor.dao.IFloorDao;
import com.sbm.module.partner.hd.view.floor.domain.Floor;

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
public class FloorDaoImpl extends HdBaseHibernateDaoImpl<Floor> implements IFloorDao {

	public List<Floor> findAll() {
		String hql = "from Floor";
		List<Floor> list = find(hql);
		return list;
	}

	public Floor findByUuid(String hdUuid) {
		StringBuffer sb = new StringBuffer("from Floor where 1=1 ");
		sb.append(" and hdUuid = ?");
		List<Floor> list = find(sb.toString(), hdUuid);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
