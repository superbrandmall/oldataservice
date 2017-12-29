package com.sbm.module.onlineleasing.base.mall.biz;

import java.util.List;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;
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
public interface ITOLMallService extends IDaoSupportService<TOLMall> {

	List<TOLMall> findAll();

	TOLMall findByCode(String code);
	
	TOLMall findByHdUuid(String hdUuid);

	List<TOLMall> findAllByCondition(TOLMall obj);

	Pagination<TOLMall> findAllByConditionPage(TOLMall obj);

	/**
	 * 
	 * saveMall:保存mall
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	void saveMall(TOLMall obj);

	
	/**
	 * 
	 * refreshCache:更新缓存
	 * 
	 * @author junkai.zhang
	 */
	void refreshCache();

}
