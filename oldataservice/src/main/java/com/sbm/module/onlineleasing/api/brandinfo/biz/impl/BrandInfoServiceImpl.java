package com.sbm.module.onlineleasing.api.brandinfo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.util.ParamsUtil;
import com.sbm.module.onlineleasing.api.brandinfo.biz.IBrandInfoService;
import com.sbm.module.onlineleasing.api.brandinfo.biz.IBrandInteractiveService;
import com.sbm.module.onlineleasing.api.brandinfo.domain.BrandInfo;
import com.sbm.module.onlineleasing.base.brand.biz.ITOLBrandService;
import com.sbm.module.onlineleasing.base.brand.constant.BrandConstant;
import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;
import com.sbm.module.onlineleasing.base.brandshopsample.biz.ITOLBrandShopSampleService;
import com.sbm.module.onlineleasing.base.brandshopsample.domain.TOLBrandShopSample;
import com.sbm.module.onlineleasing.base.merchantbrand.biz.ITOLMerchantBrandService;
import com.sbm.module.onlineleasing.base.merchantbrand.constant.MerchantBrandConstant;
import com.sbm.module.onlineleasing.base.merchantbrand.domain.TOLMerchantBrand;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/
/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.biz.impl<br/>
 * File Name:EdiInteractiveDetailServiceImpl.java<br/>
 * 
 * 作成日 ：2016-1-4 下午5:05:55 <br/>
 * 
 * @author ：junkai.zhang 
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
/**
 * @preserve public
 */
@Component
@Transactional(value = TransactionConstant.OL, propagation = Propagation.REQUIRED)
public class BrandInfoServiceImpl extends BusinessServiceImpl implements IBrandInfoService {

	@Autowired
	private ITOLMerchantBrandService merchantBrandService;
	@Autowired
	private ITOLBrandService brandService;
	@Autowired
	private ITOLBrandShopSampleService brandShopSampleService;
	@Autowired
	private IBrandInteractiveService brandInteractiveService;

	/******************************************************************************************/
	// 获取merchantBrand列表

	public void getBrandList(BrandInfo brandInfo) {
		List<TOLMerchantBrand> list = merchantBrandService.findAllByMerchantCode(brandInfo.getMerchantBrand()
				.getMerchantCode());
		// 添加名字
		for (TOLMerchantBrand tolMerchantBrand : list) {
			tolMerchantBrand.setName(brandService.findByCode(tolMerchantBrand.getBrandCode()).getName());
		}
		brandInfo.setList(list);
	}

	/******************************************************************************************/
	// 获取brand信息

	public void getByCode(BrandInfo brandInfo) {
		// 商户code
		String merchantCode = brandInfo.getMerchantBrand().getMerchantCode();
		// 品牌code
		String brandCode = brandInfo.getMerchantBrand().getBrandCode();
		brandInfo.setBrand(brandService.findByCode(brandCode));
		// 品牌图片
		brandInfo.setSampleList(brandShopSampleService.findByCode(brandCode));
		// 品牌授权书
		brandInfo.setMerchantBrand(merchantBrandService.findByMerchantCodeAndBrandCode(merchantCode, brandCode));
	}

	public void getByName(BrandInfo brandInfo) {
		// 查询品牌
		String name = brandInfo.getMerchantBrand().getName();
		TOLBrand brand = brandService.findByName(name);
		if (null != brand) {
			brandInfo.setBrand(brand);
			// 品牌图片
			brandInfo.setSampleList(brandShopSampleService.findByCode(brand.getCode()));
			// 品牌授权书
			brandInfo.setMerchantBrand(merchantBrandService.findByMerchantCodeAndBrandCode(brandInfo.getMerchantBrand()
					.getMerchantCode(), brand.getCode()));

		}
	}

	/******************************************************************************************/
	// 已有品牌

	// 没修改
	public void addExistingBrandWithoutUpdate(BrandInfo brandInfo) {
		// 已有品牌校验
		checkExistingBrand(brandInfo);
		// 品牌状态
		Integer status = brandInfo.getBrand().getStatus();
		// 审核中或修改中或已准入，不能修改，只存关联关系
		if (BrandConstant.IN_REVIEW == status || BrandConstant.IN_REVISION == status
				|| BrandConstant.ADMITTANCE == status) {
			// 其他关联关系
			brandInfo.getMerchantBrand().setCreator(MerchantBrandConstant.OTHER);
			// 保存关联关系
			merchantBrandService.save(brandInfo.getMerchantBrand());
		}
		// 未准入，修改为审核中，并走品牌准入流程
		else if (BrandConstant.NOT_ADMITTANCE == status) {
			// 其他关联关系
			brandInfo.getMerchantBrand().setCreator(MerchantBrandConstant.OTHER);
			// 保存关联关系
			merchantBrandService.save(brandInfo.getMerchantBrand());
			// 修改为审核中
			brandInfo.getBrand().setStatus(BrandConstant.IN_REVIEW);
			// 修改品牌
			brandService.update(brandInfo.getBrand());
			// 发起品牌准入流程
			brandInteractiveService.brandAccress(brandInfo.getBrand());
		}
		// 状态不正确
		else {
			throw new BusinessException(BusinessCode.C5000, new Object[] { brandInfo.getBrand().getCode(),
					brandInfo.getBrand().getStatus() }, null);
		}
	}

	// 修改
	public void addExistingBrandWithUpdate(BrandInfo brandInfo) {
		// 已有品牌校验
		checkExistingBrand(brandInfo);
		// 品牌状态
		Integer status = brandInfo.getBrand().getStatus();
		// 未准入，修改为审核中，并走品牌准入流程
		if (BrandConstant.NOT_ADMITTANCE == status) {
			// 其他关联关系
			brandInfo.getMerchantBrand().setCreator(MerchantBrandConstant.OTHER);
			// 保存关联关系
			merchantBrandService.save(brandInfo.getMerchantBrand());
			// 修改为审核中
			brandInfo.getBrand().setStatus(BrandConstant.IN_REVIEW);
			// 修改品牌
			brandService.update(brandInfo.getBrand());
			// 修改品牌图片
			processBrandShopSamples(brandInfo);
			// 发起品牌准入流程
			brandInteractiveService.brandAccress(brandInfo.getBrand());
		}
		// 已准入，修改为修改中，并走品牌修改流程
		else if (BrandConstant.ADMITTANCE == status) {
			// 其他关联关系
			brandInfo.getMerchantBrand().setCreator(MerchantBrandConstant.OTHER);
			// 保存关联关系
			merchantBrandService.save(brandInfo.getMerchantBrand());
			// 修改为修改中
			brandInfo.getBrand().setStatus(BrandConstant.IN_REVISION);
			// 修改品牌
			brandService.update(brandInfo.getBrand());
			// 修改品牌图片
			processBrandShopSamples(brandInfo);
			// 发起品牌修改流程
			brandInteractiveService.brandUpdate(brandInfo.getBrand());
		} else {
			throw new BusinessException(BusinessCode.C5001, new Object[] { brandInfo.getBrand().getCode(),
					brandInfo.getBrand().getStatus() }, null);
		}
	}

	/**
	 * 
	 * checkExistingBrand:已有品牌校验
	 * 
	 * @author junkai.zhang
	 * @param brandInfo
	 */
	private void checkExistingBrand(BrandInfo brandInfo) {
		// 非空校验
		ParamsUtil.canNotBeNull(brandInfo.getMerchantBrand());
		ParamsUtil.canNotBeEmpty(brandInfo.getMerchantBrand().getMerchantCode(), brandInfo.getMerchantBrand()
				.getBrandCode());

		if (null != merchantBrandService.findByMerchantCodeAndBrandCode(brandInfo.getMerchantBrand().getMerchantCode(),
				brandInfo.getMerchantBrand().getBrandCode())) {
			throw new BusinessException(BusinessCode.C5003, new Object[] {
					brandInfo.getMerchantBrand().getMerchantCode(), brandInfo.getMerchantBrand().getBrandCode() }, null);
		}
	}

	/******************************************************************************************/
	// 新增品牌

	public void addNewBrand(BrandInfo brandInfo) {
		// 新增品牌校验
		checkNewBrand(brandInfo);
		// 修改为审核中
		brandInfo.getBrand().setStatus(BrandConstant.IN_REVIEW);
		// 品牌信息来源为ol
		brandInfo.getBrand().setSource(5);
		// 新增品牌
		brandService.saveBrand(brandInfo.getBrand());
		// 修改品牌图片
		processBrandShopSamples(brandInfo);
		// 插入品牌code
		brandInfo.getMerchantBrand().setBrandCode(brandInfo.getBrand().getCode());
		// 第一个创建品牌
		brandInfo.getMerchantBrand().setCreator(MerchantBrandConstant.FIRST);
		// 保存关联关系
		merchantBrandService.save(brandInfo.getMerchantBrand());
		// 发起品牌准入流程
		brandInteractiveService.brandAccress(brandInfo.getBrand());
	}

	/**
	 * 
	 * checkNewBrand:新增品牌校验
	 * 
	 * @author junkai.zhang
	 * @param brandInfo
	 */
	private void checkNewBrand(BrandInfo brandInfo) {
		if (null != brandService.findByName(brandInfo.getBrand().getName())) {
			throw new BusinessException(BusinessCode.C5002, new Object[] { brandInfo.getBrand().getName() }, null);
		}
	}

	/**
	 * 
	 * processBrandShopSamples:处理品牌图片
	 * 
	 * @author junkai.zhang
	 * @param brandInfo
	 */
	private void processBrandShopSamples(BrandInfo brandInfo) {
		if (null != brandInfo.getSampleList() && !brandInfo.getSampleList().isEmpty()) {
			for (TOLBrandShopSample brandShopSample : brandInfo.getSampleList()) {
				// 删除原有记录
				if (ParamsUtil.isTrue(brandShopSample.getDeleteFlag())) {
					if (null != brandShopSample.getId()) {
						brandShopSampleService.delete(brandShopSample);
					}
				}
				// 保存/修改记录
				else {
					// 设置品牌code
					brandShopSample.setCode(brandInfo.getBrand().getCode());
					// id不为空update
					if (null != brandShopSample.getId()) {
						brandShopSampleService.update(brandShopSample);
					}
					// id为空save
					else {
						brandShopSampleService.save(brandShopSample);
					}
				}
			}
		}
	}

	/******************************************************************************************/
	// 修改

	public void updateExistingBrand(BrandInfo brandInfo) {
		// 未准入
		if (BrandConstant.NOT_ADMITTANCE == brandInfo.getBrand().getStatus()) {
			// 修改为审核中
			brandInfo.getBrand().setStatus(BrandConstant.IN_REVIEW);
			// 修改品牌
			brandService.update(brandInfo.getBrand());
			// 修改品牌图片
			processBrandShopSamples(brandInfo);
			// 发起品牌准入流程
			brandInteractiveService.brandAccress(brandInfo.getBrand());
		}
		// 已准入
		else if (BrandConstant.ADMITTANCE == brandInfo.getBrand().getStatus()) {
			// 修改为修改中
			brandInfo.getBrand().setStatus(BrandConstant.IN_REVISION);
			// 修改品牌
			brandService.update(brandInfo.getBrand());
			// 修改品牌图片
			processBrandShopSamples(brandInfo);
			// 发起品牌修改流程
			brandInteractiveService.brandUpdate(brandInfo.getBrand());
		} else {
			throw new BusinessException(BusinessCode.C5001, new Object[] { brandInfo.getBrand().getCode(),
					brandInfo.getBrand().getStatus() }, null);
		}
	}

	/******************************************************************************************/
	// 删除

	public void delete(BrandInfo brandInfo) {
		merchantBrandService.delete(brandInfo.getMerchantBrand());
	}
}
