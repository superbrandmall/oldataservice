/**
 * Project Name:posUploadData
 * File Name:JsonContainer.java
 * Package Name:com.sbm.module.postsales.domain
 * Date:2016-1-7下午2:23:21
 * Copyright (c) 2016, Super Brand Mail Inc All Rights Reserved.
 *
 */

package com.sbm.module.onlineleasing.api.brandinfo.domain;

import java.util.List;

import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;
import com.sbm.module.onlineleasing.base.brandshopsample.domain.TOLBrandShopSample;
import com.sbm.module.onlineleasing.base.merchantbrand.domain.TOLMerchantBrand;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/
/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.domain<br/>
 * File Name:JsonContainer.java<br/>
 * 
 * 作成日 ：2016-1-7 下午2:23:21 <br/>
 * 
 * @author ：junkai.zhang
 * @preserve all
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
public class BrandInfo {

	private TOLMerchantBrand merchantBrand;

	private List<TOLMerchantBrand> list;

	private TOLBrand brand;

	private List<TOLBrandShopSample> sampleList;

	public TOLMerchantBrand getMerchantBrand() {
		return merchantBrand;
	}

	public void setMerchantBrand(TOLMerchantBrand merchantBrand) {
		this.merchantBrand = merchantBrand;
	}

	public List<TOLMerchantBrand> getList() {
		return list;
	}

	public void setList(List<TOLMerchantBrand> list) {
		this.list = list;
	}

	public TOLBrand getBrand() {
		return brand;
	}

	public void setBrand(TOLBrand brand) {
		this.brand = brand;
	}

	public List<TOLBrandShopSample> getSampleList() {
		return sampleList;
	}

	public void setSampleList(List<TOLBrandShopSample> sampleList) {
		this.sampleList = sampleList;
	}

}
