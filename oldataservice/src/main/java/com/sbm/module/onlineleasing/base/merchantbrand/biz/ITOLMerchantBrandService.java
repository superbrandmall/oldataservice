package com.sbm.module.onlineleasing.base.merchantbrand.biz;

import java.util.List;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.onlineleasing.base.merchantbrand.domain.TOLMerchantBrand;

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
public interface ITOLMerchantBrandService extends IDaoSupportService<TOLMerchantBrand> {

	public List<TOLMerchantBrand> findAll();

	public List<TOLMerchantBrand> findAllByMerchantCode(String merchantCode);

	public List<TOLMerchantBrand> findAllByBrandCode(String brandCode);
	
	public TOLMerchantBrand findByMerchantCodeAndBrandCode(String merchantCode, String brandCode);

}
