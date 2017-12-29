package com.sbm.module.onlineleasing.base.merchantbankaccount.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.onlineleasing.base.merchantbankaccount.dao.ITOLMerchantBankAccountDao;
import com.sbm.module.onlineleasing.base.merchantbankaccount.domain.TOLMerchantBankAccount;

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
public class TOLMerchantBankAccountDaoImpl extends BaseHibernateDaoImpl<TOLMerchantBankAccount> implements
		ITOLMerchantBankAccountDao {

	public List<TOLMerchantBankAccount> findAll() {
		String hql = "from TOLMerchantBankAccount";
		List<TOLMerchantBankAccount> list = find(hql);
		return list;
	}

	public List<TOLMerchantBankAccount> findAllByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLMerchantBankAccount where 1=1 ");
		sb.append(" and code = ?");
		List<TOLMerchantBankAccount> list = find(sb.toString(), code);
		return list;
	}

}
