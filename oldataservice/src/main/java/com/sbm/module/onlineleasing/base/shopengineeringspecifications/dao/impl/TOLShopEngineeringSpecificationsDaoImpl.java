package com.sbm.module.onlineleasing.base.shopengineeringspecifications.dao.impl;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.shopengineeringimages.dao.ITOLShopEngineeringImagesDao;
import com.sbm.module.onlineleasing.base.shopengineeringimages.domain.TOLShopEngineeringImages;
import com.sbm.module.onlineleasing.base.shopengineeringspecifications.dao.ITOLShopEngineeringSpecificationsDao;
import com.sbm.module.onlineleasing.base.shopengineeringspecifications.domain.TOLShopEngineeringSpecifications;
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
public class TOLShopEngineeringSpecificationsDaoImpl extends BaseHibernateDaoImpl<TOLShopEngineeringSpecifications> implements ITOLShopEngineeringSpecificationsDao {

	public List<TOLShopEngineeringSpecifications> findAll() {
		String hql = "from TOLShopEngineeringSpecifications";
		List<TOLShopEngineeringSpecifications> list = find(hql);
		return list;
	}

	public List<TOLShopEngineeringSpecifications> findAllByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLShopEngineeringSpecifications where 1=1 ");
		sb.append(" and code = ? ");
		List<TOLShopEngineeringSpecifications> list = find(sb.toString(), code);
		return list;
	}

}
