package com.sbm.module.onlineleasing.api.brandinfo.biz;

import com.sbm.module.common.business.biz.IBusinessService;
import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;

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
public interface IBrandInteractiveService extends IBusinessService {

	/**
	 * 
	 * brandAccress:品牌准入
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	public void brandAccress(TOLBrand obj);

	/**
	 * 
	 * doBrandAccress:执行品牌准入
	 *
	 * @author junkai.zhang
	 * @param obj
	 */
	public void doBrandAccress(TOLBrand obj);
	
	/**
	 * 
	 * brandUpdate:品牌修改
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	public void brandUpdate(TOLBrand obj);
	
	/**
	 * 
	 * doBrandUpdate:执行品牌修改
	 *
	 * @author junkai.zhang
	 * @param obj
	 */
	public void doBrandUpdate(TOLBrand obj);
}
