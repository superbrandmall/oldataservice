package com.sbm.module.onlineleasing.base.brand.biz;

import java.util.List;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.common.business.domain.Pagination;
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
public interface ITOLBrandService extends IDaoSupportService<TOLBrand> {

	public List<TOLBrand> findAll();

	public TOLBrand findByCode(String code);

	public TOLBrand findByHdUuid(String hdUuid);

	public TOLBrand findByName(String name);

	public List<TOLBrand> findAllByCondition(TOLBrand obj);

	public Pagination<TOLBrand> findAllByConditionPage(TOLBrand obj);

	/**
	 * 
	 * saveBrand:注册品牌
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	public void saveBrand(TOLBrand obj);

}
