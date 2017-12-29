package com.sbm.module.onlineleasing.base.mallbidstandard.biz;

import java.util.List;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.onlineleasing.base.mallbidstandard.domain.TOLMallBidStandard;

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
public interface ITOLMallBidStandardService extends IDaoSupportService<TOLMallBidStandard> {

	public List<TOLMallBidStandard> findAll();

	public TOLMallBidStandard findByCode(String code);

	/**
	 * 
	 * refreshCache:更新缓存
	 * 
	 * @author junkai.zhang
	 */
	public void refreshCache();

}
