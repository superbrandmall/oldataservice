package com.sbm.module.onlineleasing.api.brandinfo.biz;

import com.sbm.module.onlineleasing.api.brandinfo.domain.BrandInfo;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.onlineleasing.shop.biz<br/>
 * File Name:ITOLShopService.java<br/>
 * 
 * 作成日 ：2017-5-18 下午4:34:06 <br/>
 * 
 * @author ：junkai.zhang
 */
public interface IBrandInfoService {

	/**
	 * 
	 * getBrandList:获取品牌列表
	 * 
	 * @author junkai.zhang
	 * @param brandInfo
	 */
	public void getBrandList(BrandInfo brandInfo);

	/**
	 * 
	 * getByCode:获取品牌信息
	 * 
	 * @author junkai.zhang
	 * @param brandInfo
	 */
	public void getByCode(BrandInfo brandInfo);

	/**
	 * 
	 * getByName:获取品牌信息
	 * 
	 * @author junkai.zhang
	 * @param brandInfo
	 */
	public void getByName(BrandInfo brandInfo);

	/**
	 * 
	 * addExistingBrandWithoutUpdate:添加已经存在的品牌，不修改
	 * 
	 * @author junkai.zhang
	 * @param brandInfo
	 */
	public void addExistingBrandWithoutUpdate(BrandInfo brandInfo);

	/**
	 * 
	 * addExistingBrandWithUpdate:添加已经存在的品牌，修改
	 * 
	 * @author junkai.zhang
	 * @param brandInfo
	 */
	public void addExistingBrandWithUpdate(BrandInfo brandInfo);

	/**
	 * 
	 * addNewBrand:添加一个新品牌
	 * 
	 * @author junkai.zhang
	 * @param brandInfo
	 */
	public void addNewBrand(BrandInfo brandInfo);

	/**
	 * 
	 * updateExistingBrand:修改现有品牌信息
	 * 
	 * @author junkai.zhang
	 * @param brandInfo
	 */
	public void updateExistingBrand(BrandInfo brandInfo);

	/**
	 * 
	 * delete:删除merchantBrand
	 * 
	 * @author junkai.zhang
	 * @param brandInfo
	 */
	public void delete(BrandInfo brandInfo);
}
