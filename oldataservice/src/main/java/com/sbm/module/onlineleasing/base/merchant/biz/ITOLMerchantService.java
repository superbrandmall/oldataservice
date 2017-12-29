package com.sbm.module.onlineleasing.base.merchant.biz;

import java.util.List;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/
/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.biz<br/>
 * File Name:IEdiInteractiveDetailService.java<br/>
 * 
 * 作成日 ：2016-1-4 下午5:05:39 <br/>
 * 
 * @author ：junkai.zhang
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
public interface ITOLMerchantService extends IDaoSupportService<TOLMerchant> {

	List<TOLMerchant> findAll();

	TOLMerchant findByCode(String code);

	TOLMerchant findByHdUuid(String hdUuid);

	TOLMerchant findByUscc(String uscc);

	List<TOLMerchant> findAllByCondition(TOLMerchant obj);

	Pagination<TOLMerchant> findAllByConditionPage(TOLMerchant obj);

	/**
	 * 
	 * saveMerchant:注册商户
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	void saveMerchant(TOLMerchant obj);

}
