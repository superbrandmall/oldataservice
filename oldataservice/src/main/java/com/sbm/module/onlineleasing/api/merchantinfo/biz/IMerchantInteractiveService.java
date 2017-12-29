package com.sbm.module.onlineleasing.api.merchantinfo.biz;

import com.sbm.module.common.business.biz.IBusinessService;
import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;
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
public interface IMerchantInteractiveService extends IBusinessService {

	/**
	 * 
	 * merchantAccress:商户准入
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	void merchantAccress(TOLMerchant obj);

	/**
	 * 
	 * doMerchantAccress:执行商户准入
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	void doMerchantAccress(TOLMerchant obj);

	/**
	 *
	 * merchantUpdate:商户修改
	 *
	 * @author junkai.zhang
	 * @param obj
	 */
	void merchantUpdate(TOLMerchant obj);

	/**
	 *
	 * doMerchantUpdate:执行商户修改
	 *
	 * @author junkai.zhang
	 * @param obj
	 */
	void doMerchantUpdate(TOLMerchant obj);

}
