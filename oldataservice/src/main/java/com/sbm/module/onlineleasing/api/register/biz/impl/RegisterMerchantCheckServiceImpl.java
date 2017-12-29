package com.sbm.module.onlineleasing.api.register.biz.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.util.ParamsUtil;
import com.sbm.module.onlineleasing.api.register.biz.IRegisterMerchantCheckService;
import com.sbm.module.onlineleasing.api.register.domain.RegisterMerchantCheck;
import com.sbm.module.onlineleasing.base.merchant.biz.ITOLMerchantService;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.onlineleasing.base.merchantaddress.biz.ITOLMerchantAddressService;
import com.sbm.module.onlineleasing.base.merchantaddress.domain.TOLMerchantAddress;
import com.sbm.module.onlineleasing.base.merchantbankaccount.biz.ITOLMerchantBankAccountService;
import com.sbm.module.onlineleasing.base.merchantbusinesslicense.biz.ITOLMerchantBusinessLicenseService;
import com.sbm.module.onlineleasing.base.merchantbusinesslicense.domain.TOLMerchantBusinessLicense;
import com.sbm.module.partner.tianyancha.rest.baseinfo.biz.IBaseInfoService;
import com.sbm.module.partner.tianyancha.rest.baseinfo.domain.BaseInfo;
import com.sbm.module.partner.tianyancha.rest.baseinfo.domain.BaseInfoResult;
import com.sbm.module.partner.tianyancha.rest.search.biz.ISearchService;
import com.sbm.module.partner.tianyancha.rest.search.domain.Search;
import com.sbm.module.partner.tianyancha.rest.search.domain.SearchData;

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
public class RegisterMerchantCheckServiceImpl extends BusinessServiceImpl implements IRegisterMerchantCheckService {

	// 租户相关
	@Autowired
	private ITOLMerchantService merchantService;
	@Autowired
	private ITOLMerchantAddressService merchantAddressService;
	@Autowired
	private ITOLMerchantBankAccountService merchantBankAccountService;
	@Autowired
	private ITOLMerchantBusinessLicenseService merchantBusinessLicenseService;

	// 天眼查相关
	@Autowired
	private ISearchService searchService;
	@Autowired
	private IBaseInfoService baseInfoService;

	/*********************************************************************/
	// search

	public void getSearch(RegisterMerchantCheck registerMerchantCheck) {
		// 查询db
		TOLMerchant merchant = merchantService.findByUscc(registerMerchantCheck.getUscc());
		// 如果db中有，则直接回传
		if (null != merchant) {
			registerMerchantCheck.getList().add(merchant);
		}
		// 如果没有，则查询天眼查
		else {
			// 通过天眼查查询同一信用代码证
			Search search = searchService.findResultByWord(registerMerchantCheck.getUscc());
			searchService.check(search);
			// 处理
			processSearchVo(search, registerMerchantCheck);
		}

	}

	/**
	 * 
	 * processSearchVo:处理SearchVo
	 * 
	 * @author junkai.zhang
	 * @param vo
	 * @param registerMerchantCheck
	 */
	private void processSearchVo(Search vo, RegisterMerchantCheck registerMerchantCheck) {
		// TOLMerchant merchant = null;
		// for (SearchData data : vo.getData()) {
		// merchant = new TOLMerchant();
		// convertSearchData(data, merchant);
		// registerMerchantCheck.getList().add(merchant);
		// }
		// 天眼查做过处理，第一条记录有效，默认取第一条记录
		TOLMerchant merchant = new TOLMerchant();
		convertSearchData(vo.getData().get(0), merchant);
		registerMerchantCheck.getList().add(merchant);
	}

	/**
	 * 
	 * convertSearchData:转换SearchData
	 * 
	 * @author junkai.zhang
	 * @param data
	 * @param merchant
	 */
	private void convertSearchData(SearchData data, TOLMerchant merchant) {
		merchant.setTianyanchaId(data.getId());
		merchant.setName(data.getName());
	}

	/*********************************************************************/
	// baseinfo

	public void getBaseInfo(RegisterMerchantCheck registerMerchantCheck) {
		// merchantCode存在
		if (StringUtils.isNotBlank(registerMerchantCheck.getMerchantCode())) {
			String code = registerMerchantCheck.getMerchantCode();
			// 查询merchant
			TOLMerchant merchant = merchantService.findByCode(code);
			if (null == merchant) {
				throw new BusinessException(BusinessCode.C5200, new Object[] { code }, null);
			}
			registerMerchantCheck.setMerchant(merchant);
			// 查询merchantAddress
			TOLMerchantAddress merchantAddress = merchantAddressService.findByCode(code);
			registerMerchantCheck.setMerchantAddress(merchantAddress);
			// 查询merchantBusinessLicense
			TOLMerchantBusinessLicense merchantBusinessLicense = merchantBusinessLicenseService.findByCode(code);
			registerMerchantCheck.setMerchantBusinessLicense(merchantBusinessLicense);
		}
		// 天眼查id存在
		else if (StringUtils.isNotBlank(registerMerchantCheck.getTianyanchaId())) {
			// 通过天眼查查询基本信息
			BaseInfo baseInfo = baseInfoService.findResultById(registerMerchantCheck.getTianyanchaId());
			baseInfoService.check(baseInfo);
			// 检查 
			checkBaseInfoVo(baseInfo);
			// 处理
			processBaseInfoVo(baseInfo, registerMerchantCheck);
		}
		// 都不存在
		else {
			throw new BusinessException(BusinessCode.C9000, null);
		}
	}

	
	/**
	 * 
	 * checkBaseInfoVo:BaseInfoVo校对
	 * 
	 * @author junkai.zhang
	 * @param vo
	 */
	private void checkBaseInfoVo(BaseInfo vo) {
		// 检查 （因为目前不清楚状态，暂不使用）
//		// 不是开业状态
//		if (!vo.getResult().getRegStatus().contains(BaseinfoConstant.OPEN)) {
//			throw new BusinessException(BusinessCode.C0301, new Object[] { vo.getResult().getId(),
//					vo.getResult().getRegStatus() }, null);
//		}
	}

	/**
	 * 
	 * processBaseInfoVo:处理BaseInfoVo
	 * 
	 * @author junkai.zhang
	 * @param vo
	 * @param registerMerchantCheck
	 */
	private void processBaseInfoVo(BaseInfo vo, RegisterMerchantCheck registerMerchantCheck) {
		TOLMerchant obj = new TOLMerchant();
		TOLMerchantAddress merchantAddress = new TOLMerchantAddress();
		TOLMerchantBusinessLicense merchantBusinessLicense = new TOLMerchantBusinessLicense();
		convertBaseInfoResult(vo.getResult(), obj, merchantAddress);
		registerMerchantCheck.setMerchant(obj);
		registerMerchantCheck.setMerchantAddress(merchantAddress);
		// 插入一个空对象
		registerMerchantCheck.setMerchantBusinessLicense(merchantBusinessLicense);
	}

	/**
	 * 转换BaseInfoResult
	 * @param data
	 * @param merchant
	 * @param merchantAddress
	 */
	private void convertBaseInfoResult(BaseInfoResult data, TOLMerchant merchant, TOLMerchantAddress merchantAddress) {
		// 公司名称
		merchant.setName(data.getName());
		// 社会统一信用代码证
		merchant.setUscc(data.getCreditCode());
		// 注册资金
		merchant.setCapital(data.getRegCapital());
		// 注册地址
		merchantAddress.setStreetAddress(data.getRegLocation());
		// 天眼查id
		merchant.setTianyanchaId(data.getId());
	}

	/*********************************************************************/
	// baseinfoV2

	public void getBaseInfoV2(RegisterMerchantCheck registerMerchantCheck) {
		// 统一信用代码和商户名称不能为空
		ParamsUtil.canNotBeEmpty(registerMerchantCheck.getUscc(), registerMerchantCheck.getName());
		// 查询db
		TOLMerchant merchant = merchantService.findByUscc(registerMerchantCheck.getUscc());
		// 如果db中有，则比较名称
		if (null != merchant) {
			// 判断名称是否匹配
			checkNameByDb(registerMerchantCheck, merchant);
			// 设值
			registerMerchantCheck.setMerchant(merchant);
			// 查询merchantAddress
			TOLMerchantAddress merchantAddress = merchantAddressService.findByCode(merchant.getCode());
			registerMerchantCheck.setMerchantAddress(merchantAddress);
			// 查询merchantBusinessLicense
			TOLMerchantBusinessLicense merchantBusinessLicense = merchantBusinessLicenseService.findByCode(merchant
					.getCode());
			registerMerchantCheck.setMerchantBusinessLicense(merchantBusinessLicense);
		}
		// 如果没有，则查询天眼查
		else {
			// 通过天眼查查询同一信用代码证
			Search search = searchService.findResultByWord(registerMerchantCheck.getUscc());
			searchService.check(search);
			// 天眼查做过处理，第一条记录有效，默认取第一条记录
			merchant = new TOLMerchant();
			convertSearchData(search.getData().get(0), merchant);
			// 判断名称是否匹配
			checkNameByDb(registerMerchantCheck, merchant);
			// 通过天眼查查询基本信息
			BaseInfo baseInfo = baseInfoService.findResultById(String.valueOf(merchant.getTianyanchaId()));
			baseInfoService.check(baseInfo);
			// 检查 
			checkBaseInfoVo(baseInfo);
			// 处理
			processBaseInfoVo(baseInfo, registerMerchantCheck);
		}
	}

	/**
	 * 
	 * checkNameByDb:通过数据库校验名称
	 * 
	 * @author junkai.zhang
	 * @param registerMerchantCheck
	 * @param merchant
	 */
	private void checkNameByDb(RegisterMerchantCheck registerMerchantCheck, TOLMerchant merchant) {
		if (!registerMerchantCheck.getName().equals(merchant.getName())) {
			throw new BusinessException(BusinessCode.C0302, new Object[] { registerMerchantCheck.getUscc(),
					registerMerchantCheck.getName() }, null);
		}
	}
}
