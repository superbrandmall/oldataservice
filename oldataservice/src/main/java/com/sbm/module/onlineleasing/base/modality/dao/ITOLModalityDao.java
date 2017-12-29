package com.sbm.module.onlineleasing.base.modality.dao;

import java.util.List;

import com.sbm.module.common.business.dao.IBaseHibernateDao;
import com.sbm.module.onlineleasing.base.modality.domain.TOLModality;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/
/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.dao<br/>
 * File Name:IEdiInteractiveDetailDao.java<br/>
 * 
 * 作成日 ：2016-1-4 下午4:41:20 <br/>
 * 
 * @author ：junkai.zhang
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
public interface ITOLModalityDao extends IBaseHibernateDao<TOLModality> {

	public List<TOLModality> findAll();

	public List<TOLModality> findAllByLvAndCode(String lv, String code);
	
	public TOLModality findByCode(String code);

}
