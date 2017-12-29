//package com.sbm.module.onlineleasing.base.merchantcontacts.dao.impl;
//
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
//import com.sbm.module.onlineleasing.base.merchantcontacts.dao.ITOLMerchantContactsDao;
//import com.sbm.module.onlineleasing.base.merchantcontacts.domain.TOLMerchantContacts;
//
///*****************************************************************************/
///* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
///*****************************************************************************/
///**
// * Project Name:posUploadData<br/>
// * Package Name:com.sbm.module.postsales.dao.impl<br/>
// * File Name:EdiInteractiveDetailDaoImpl.java<br/>
// * 
// * 作成日 ：2016-1-4 下午4:41:35 <br/>
// * 
// * @author ：junkai.zhang
// * @preserve public
// */
//// ***************************************************************************/
//// * modified by 更新者 更新日 修改内容
//// ***************************************************************************/
//@Repository
//public class TOLMerchantContactsDaoImpl extends BaseHibernateDaoImpl<TOLMerchantContacts> implements
//		ITOLMerchantContactsDao {
//
//	public List<TOLMerchantContacts> findAll() {
//		String hql = "from TOLMerchantContacts";
//		List<TOLMerchantContacts> list = find(hql);
//		return list;
//	}
//
//	public List<TOLMerchantContacts> findByCode(String code) {
//		StringBuffer sb = new StringBuffer("from TOLMerchantContacts where 1=1 ");
//		sb.append(" and code = ?");
//		List<TOLMerchantContacts> list = find(sb.toString(), code);
//		return list;
//	}
//
//}
