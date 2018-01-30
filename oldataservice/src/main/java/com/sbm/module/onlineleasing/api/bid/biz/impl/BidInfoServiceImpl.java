package com.sbm.module.onlineleasing.api.bid.biz.impl;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.onlineleasing.api.bid.event.SubmitBidEvent;
import com.sbm.module.onlineleasing.base.mall.biz.ITOLMallService;
import com.sbm.module.onlineleasing.base.shopimages.biz.ITOLShopImagesService;
import com.sbm.module.onlineleasing.base.shopimages.domain.TOLShopImages;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.redis.constant.RedisConstant;
import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.base.pulisher.constant.BusinessEventListenerConstant;
import com.sbm.module.common.base.pulisher.template.BusinessEventTemplate;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.common.business.util.ParamsUtil;
import com.sbm.module.onlineleasing.api.bid.biz.IBidInfoService;
import com.sbm.module.onlineleasing.api.bid.biz.ISubmitBidService;
import com.sbm.module.onlineleasing.api.bid.domain.BidInfo;
import com.sbm.module.onlineleasing.api.bid.domain.BidInfoVo;
import com.sbm.module.onlineleasing.api.bid.domain.SuggestVo;
import com.sbm.module.onlineleasing.api.bid.event.SaveBidEvent;
import com.sbm.module.onlineleasing.base.bid.biz.ITOLBidService;
import com.sbm.module.onlineleasing.base.bid.constant.BidConstant;
import com.sbm.module.onlineleasing.base.bid.domain.TOLBid;
import com.sbm.module.onlineleasing.base.bidcontract.biz.ITOLBidContractService;
import com.sbm.module.onlineleasing.base.bidcontract.domain.TOLBidContract;
import com.sbm.module.onlineleasing.base.biddetail.biz.ITOLBidDetailService;
import com.sbm.module.onlineleasing.base.biddetail.domain.TOLBidDetail;
import com.sbm.module.onlineleasing.base.brand.biz.ITOLBrandService;
import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;
import com.sbm.module.onlineleasing.base.mallbidstandard.biz.ITOLMallBidStandardService;
import com.sbm.module.onlineleasing.base.mallbidstandard.domain.TOLMallBidStandard;
import com.sbm.module.onlineleasing.base.merchant.biz.ITOLMerchantService;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.onlineleasing.base.merchantbrand.biz.ITOLMerchantBrandService;
import com.sbm.module.onlineleasing.base.merchantbrand.domain.TOLMerchantBrand;
import com.sbm.module.onlineleasing.base.modality.biz.ITOLModalityService;
import com.sbm.module.onlineleasing.base.searchshopdetail.biz.ITOLSearchShopDetailService;
import com.sbm.module.onlineleasing.base.shop.biz.ITOLShopService;
import com.sbm.module.onlineleasing.base.shop.domain.TOLShop;

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
public class BidInfoServiceImpl extends BusinessServiceImpl implements IBidInfoService {

	@Autowired
	private ITOLShopService shopService;
	@Autowired
	private ITOLSearchShopDetailService searchShopDetailService;
	@Autowired
	private ITOLMerchantService merchantService;
	@Autowired
	private ITOLMerchantBrandService merchantBrandService;
	@Autowired
	private ITOLBrandService brandService;
	@Autowired
	private ITOLShopImagesService shopImagesService;


	/**********************************************************/

	@Autowired
	private ITOLBidService bidService;
	@Autowired
	private ITOLBidContractService bidContractService;
	@Autowired
	private ITOLBidDetailService bidDetailService;
	@Autowired
	private ITOLModalityService modalityService;
	@Autowired
	private ITOLMallBidStandardService mallBidStandardService;
	@Autowired
	private ITOLMallService mallService;

	/**********************************************************/

	@Autowired
	private ISubmitBidService submitBidService;

	/**********************************************************/

	private static final String STANDARD_BID = "standard bid. bidCode: {0}";

	private static final String NONSTANDARD_BID = "nonstandard bid. bidCode: {0}";

	/**********************************************************/

	/**
	 * 
	 * checkBid:校对出价信息
	 * 
	 * @author junkai.zhang
	 * @param code
	 * @param bid
	 */
	private void checkBid(String code, TOLBid bid) {
		// 出价不存在
		if (null == bid) {
			throw new BusinessException(BusinessCode.C6000, new Object[] { code }, null);
		}
		// 判断用户
		if (!getUserCode().equals(bid.getUserCode())) {
			throw new BusinessException(BusinessCode.C6005, new Object[] { getUserCode(), bid.getUserCode() }, null);
		}
	}

	/**
	 * 判断processState，为null, 1, 2, 3 可以修改，其他不可以修改
	 * @param bid
	 * @return
	 */
	private void canUpdate(TOLBid bid) {
		Integer processState = bid.getProcessState();
		if (null == processState || processState.equals(BidConstant.CREATED) || processState.equals(BidConstant.PREVIEW_CONTRACT_CREATED) || processState.equals(BidConstant.PREVIEW_CONTRACT_FAILURE)){

		} else {
			throw new BusinessException(BusinessCode.C6007, new Object[] {bid.getCode(), bid.getProcessState()}, null);
		}
	}

	/**
	 * 判断processState, 为2 可以提交，其他不可以提交
	 * @param bid
	 */
	private void canSubmit(TOLBid bid) {
		Integer processState = bid.getProcessState();
		if (processState.equals(BidConstant.PREVIEW_CONTRACT_CREATED)){

		} else {
			throw new BusinessException(BusinessCode.C6008, new Object[] {bid.getCode(), bid.getProcessState()}, null);
		}
	}

	/********************************************************************/
	// 出价页信息

	public void getBidInfo(BidInfo bidInfo) {
		// 判断非空
		ParamsUtil.canNotBeEmpty(bidInfo.getShop().getCode());
		// 查询商铺
		TOLShop shop = shopService.findByCode(bidInfo.getShop().getCode());
		if (null == shop) {
			throw new BusinessException(BusinessCode.C5300, null);
		}
		bidInfo.setShop(shop);
		// 查询搜索记录
		if (null != bidInfo.getSearchShopDetail() && StringUtils.isNotBlank(bidInfo.getSearchShopDetail().getCode())) {
			bidInfo.setSearchShopDetail(searchShopDetailService.findByCode(bidInfo.getSearchShopDetail().getCode()));
		}
		// 查询商户品牌
		setBidMerchantBrand(bidInfo);
		// 如果bidCode不为空，则查询出相关信息
		if (null != bidInfo.getBid() && StringUtils.isNotBlank(bidInfo.getBid().getCode())) {
			TOLBid bid = bidService.findByCode(bidInfo.getBid().getCode());
			// 校对出价信息
			checkBid(bidInfo.getCode(), bid);
			// 判断商户
			if (!shop.getCode().equals(bid.getShopCode())) {
				throw new BusinessException(BusinessCode.C6004, new Object[] { shop.getCode(), bid.getShopCode() },
						null);
			}
			// 出价主体
			bidInfo.setBid(bid);
			// 出价明细
			bidInfo.setBidDetails(bidDetailService.findAllByCode(bidInfo.getBid().getCode()));
		}
		// 查询商场出价标准
		TOLMallBidStandard mallBidStandard = mallBidStandardService.findByCode(shop.getMallCode());
		bidInfo.setMallBidStandard(mallBidStandard);
	}

	/**
	 * 
	 * setBidMerchantBrand:获取商铺品牌
	 * 
	 * @author junkai.zhang
	 * @param bidInfo
	 */
	private void setBidMerchantBrand(BidInfo bidInfo) {
		ParamsUtil.canNotBeEmpty(bidInfo.getBidMerchantBrandVo().getCode());
		// 查询商户信息
		TOLMerchant merchant = merchantService.findByCode(bidInfo.getBidMerchantBrandVo().getCode());
		if (null == merchant) {
			throw new BusinessException(BusinessCode.C5200, new Object[] { bidInfo.getBidMerchantBrandVo().getCode() },
					null);
		}
		bidInfo.getBidMerchantBrandVo().setName(merchant.getName());
		// 查询品牌信息
		List<TOLBrand> brands = new ArrayList<TOLBrand>();
		TOLBrand brand = null;
		List<TOLMerchantBrand> merchantBrands = merchantBrandService.findAllByMerchantCode(bidInfo
				.getBidMerchantBrandVo().getCode());
		for (TOLMerchantBrand merchantBrand : merchantBrands) {
			brand = brandService.findByCode(merchantBrand.getBrandCode());
			brands.add(brand);
		}
		bidInfo.getBidMerchantBrandVo().setBrands(brands);
	}

	/********************************************************************/
	// 保存出价信息

	public void saveBidInfo(BidInfo bidInfo) {
		// 校对出价信息
		checkBid(bidInfo.getCode(), bidInfo.getBid());
		// 出价可以被修改
		canUpdate(bidInfo.getBid());
		// 出价明细不能为空
		if (null == bidInfo.getBidDetails() || bidInfo.getBidDetails().isEmpty()) {
			throw new BusinessException(BusinessCode.C6006, null);
		}
		// 保存前校验
		submitBidService.preSave(bidInfo);

		// 设置bid状态 已保存
		bidInfo.getBid().setProcessState(BidConstant.CREATED);
		// 设置未审批
		bidInfo.getBid().setIsApprove(BidConstant.NOT_APPROVED);
		// 设置未生效
		bidInfo.getBid().setIsEffect(BidConstant.INEFFECTIVE);

		// 修改/保存bid
		if (null != bidInfo.getBid().getId()) {
			bidService.update(bidInfo.getBid());
		} else {
			bidService.saveBid(bidInfo.getBid());
		}
		// 遍历出价明细
		for (TOLBidDetail bidDetail : bidInfo.getBidDetails()) {
			// 删除原有出价记录
			if (ParamsUtil.isTrue(bidDetail.getDeleteFlag())) {
				if (null != bidDetail.getId()) {
					bidDetailService.delete(bidDetail);
				}
			}
			// 修改/保存bidDetail
			else {
				bidDetail.setCode(bidInfo.getBid().getCode());
				if (null != bidDetail.getId()) {
					bidDetailService.update(bidDetail);
				} else {
					bidDetailService.save(bidDetail);
				}
			}
		}

		// 生成预览合同
		BusinessEventTemplate template = getTemplate().put(BusinessEventListenerConstant.BaseEntity, bidInfo);
		publishEvent(new SaveBidEvent(template));
	}

	/********************************************************************/
	// 出价列表

	public void getDetails(BidInfo bidInfo) {
		bidInfo.getBid().setIsApproves(Arrays.asList(new Integer[]{BidConstant.NOT_APPROVED, BidConstant.REJECT}));
		Pagination<TOLBid> bidPage = bidService.findAllByUserCodeAndApprovePage(bidInfo.getBid());
		setPagination(bidInfo, bidPage);
	}

	public void getContractDetails(BidInfo bidInfo) {
		bidInfo.getBid().setIsApproves(Arrays.asList(new Integer[]{BidConstant.APPROVE}));
		Pagination<TOLBid> bidPage = bidService.findAllByUserCodeAndApprovePage(bidInfo.getBid());
		setPagination(bidInfo, bidPage);
	}

	/**
	 * 设置分页对象
	 * @param bidInfo
	 * @param bidPage
	 */
	private void setPagination(BidInfo bidInfo, Pagination<TOLBid> bidPage){
		Pagination<BidInfoVo> pagination = getPagination();
		// 转换
		convertPagination(bidPage, pagination);
		bidInfo.setPagination(pagination);
	}

	/**
	 * 
	 * convertPagination:将Pagination<TOLBid>转换为Pagination<BidInfoVo>
	 * 
	 * @author junkai.zhang
	 * @param bidPage
	 * @param pagination
	 */
	private void convertPagination(Pagination<TOLBid> bidPage, Pagination<BidInfoVo> pagination) {
		pagination.setTotalCount(bidPage.getTotalCount());
		List<BidInfoVo> details = new ArrayList<>();
		BidInfoVo vo;
		for (TOLBid bid : bidPage.getDetails()) {
			vo = new BidInfoVo();
			convert2BidInfoVo(bid, vo);
			details.add(vo);
		}
		pagination.setDetails(details);
	}

	/**
	 * 
	 * convert2BidInfoVo:将bid转换为vo
	 * 
	 * @author junkai.zhang
	 * @param bid
	 * @param vo
	 */
	private void convert2BidInfoVo(TOLBid bid, BidInfoVo vo) {
		// 出价Code
		vo.setCode(bid.getCode());
		// 出价时间
		vo.setCreated(bid.getCreated());
		// 商铺信息
		TOLShop shop = shopService.findByCode(bid.getShopCode());
		vo.setShopCode(shop.getCode());
		vo.setUnit(shop.getUnit());
		vo.setMallName(shop.getMallName());
		vo.setFloorName(shop.getFloorName());
		vo.setArea(shop.getArea());
		// 出价时间
		vo.setStartDate(bid.getStartDate());
		vo.setEndDate(bid.getEndDate());
		// 设置固定租金和浮动租金
		setRentAndRate(bid, vo);
		// 出价状态
		vo.setProcessState(bid.getProcessState());
		// 审批结果
		vo.setIsApprove(bid.getIsApprove());
		// 是否生效
		vo.setIsEffect(bid.getIsEffect());
		// 商铺第一张图片
		List<TOLShopImages> shopImages = shopImagesService.findAllByCode(shop.getCode());
		if (null != shopImages && !shopImages.isEmpty()) {
			vo.setFirstImage(shopImages.get(0).getImage());
		} else {
			// 如果商铺图片不存在，返回mall图片
			vo.setFirstImage(mallService.findByCode(shop.getMallCode()).getImg());
		}
		// 品牌名称
		vo.setBrandName(brandService.findByCode(bid.getBrandCode()).getName());
	}

	/**
	 * 
	 * setRentAndRate:设置固定租金和浮动租金
	 * 
	 * @author junkai.zhang
	 * @param bid
	 * @param vo
	 */
	private void setRentAndRate(TOLBid bid, BidInfoVo vo) {
		List<TOLBidDetail> list = bidDetailService.findAllByCode(bid.getCode());
		if (null != list && !list.isEmpty()) {
			List<BigDecimal> deadRentList = new ArrayList<>();
			List<BigDecimal> floatingRentalRateList = new ArrayList<>();
			for (TOLBidDetail detail : list) {
				deadRentList.add(detail.getDeadRent());
				floatingRentalRateList.add(detail.getFloatingRentalRate());
			}
			// 固定租金
			Collections.sort(deadRentList);
			vo.setDeadRentMin(deadRentList.get(0));
			vo.setDeadRentMax(deadRentList.get(deadRentList.size() - 1));
			// 浮动租金
			Collections.sort(floatingRentalRateList);
			vo.setFloatingRentalRateMin(floatingRentalRateList.get(0));
			vo.setFloatingRentalRateMax(floatingRentalRateList.get(floatingRentalRateList.size() - 1));
		}
	}

	/********************************************************************/
	// 预览合同

	public void preview(BidInfo bidInfo) {
		// 判断非空
		ParamsUtil.canNotBeEmpty(bidInfo.getCode());
		// 设置key
		setKey(bidInfo);
		// 加入缓存
		set2redis(bidInfo.getKey(), JSON.toJSONString(bidInfo));
	}

	/**
	 * 
	 * setKey:设置key
	 * 
	 * @author junkai.zhang
	 * @param bidInfo
	 */
	private void setKey(BidInfo bidInfo) {
		bidInfo.setKey(bidInfo.getCode() + RedisConstant.UNDER_LINE + getUUID());
	}

	public void view(BidInfo bidInfo) {
		if (StringUtils.isBlank(bidInfo.getKey())) {
			throw new BusinessException(BusinessCode.C6002, null);
		}
		String valuer = (String) redisService.get(bidInfo.getKey());
		if (StringUtils.isBlank(valuer)) {
			throw new BusinessException(BusinessCode.C6003, new Object[] { bidInfo.getKey() }, null);
		}
		BidInfo tmp = JSON.parseObject(valuer, BidInfo.class);

		// 出价code
		bidInfo.setCode(tmp.getCode());
		// 出价状态
		bidInfo.setProcessState(tmp.getProcessState());
		// 审批结果
		bidInfo.setIsApprove(tmp.getIsApprove());
		// 是否有效
		bidInfo.setIsEffect(tmp.getIsEffect());

		// 查询出价
		TOLBid bid = bidService.findByCode(bidInfo.getCode());
		// 校对出价信息
		checkBid(bidInfo.getCode(), bid);
		// 查询合同
		TOLBidContract bidContract = bidContractService.findByCode(bidInfo.getCode());
		// 合同不存在
		if (null == bidContract) {
			throw new BusinessException(BusinessCode.C6001, new Object[] { bidInfo.getCode() }, null);
		}
		// 设置合同信息
		bidInfo.setBidContract(bidContract);
		// 设置异议
		SuggestVo suggestVo = new SuggestVo();
		suggestVo.setCode(bid.getCode());
		suggestVo.setLegalSuggest(bid.getLegalSuggest());
		suggestVo.setBusinessSuggest(bid.getBusinessSuggest());
		bidInfo.setSuggestVo(suggestVo);
	}

	/********************************************************************/
	// 保存异议

	public void saveBusinessSuggest(BidInfo bidInfo) {
		// 判断非空
		ParamsUtil.canNotBeNull(bidInfo.getSuggestVo());
		ParamsUtil.canNotBeEmpty(bidInfo.getSuggestVo().getCode());
		// 查询对象
		TOLBid bid = bidService.findByCode(bidInfo.getSuggestVo().getCode());
		// 校对出价信息
		checkBid(bidInfo.getCode(), bid);
		// 出价可以被修改
		canUpdate(bid);
		// 更新对象
		bid.setBusinessSuggest(bidInfo.getSuggestVo().getBusinessSuggest());
		bidService.update(bid);
	}

	public void saveLegalSuggest(BidInfo bidInfo) {
		// 判断非空
		ParamsUtil.canNotBeNull(bidInfo.getSuggestVo());
		ParamsUtil.canNotBeEmpty(bidInfo.getSuggestVo().getCode());
		// 查询对象
		TOLBid bid = bidService.findByCode(bidInfo.getSuggestVo().getCode());
		// 校对出价信息
		checkBid(bidInfo.getCode(), bid);
		// 出价可以被修改
		canUpdate(bid);
		// 更新对象
		bid.setLegalSuggest(bidInfo.getSuggestVo().getLegalSuggest());
		bidService.update(bid);
	}

	/********************************************************************/
	// 提交出价

	public void submit(BidInfo bidInfo) {
		// 判断非空
		ParamsUtil.canNotBeEmpty(bidInfo.getCode());
		// 查询对象
		TOLBid bid = bidService.findByCode(bidInfo.getCode());
		// 校对出价信息
		checkBid(bidInfo.getCode(), bid);
		// 可以出价
		canSubmit(bid);
		// 添加出价
		bidInfo.setBid(bid);
		// 添加出价明细
		bidInfo.setBidDetails(bidDetailService.findAllByCode(bidInfo.getCode()));
		// 出价明细不能为空
		if (null == bidInfo.getBidDetails() || bidInfo.getBidDetails().isEmpty()) {
			throw new BusinessException(BusinessCode.C6006, null);
		}
		// 提交前校验
		submitBidService.preSubmit(bidInfo);
		// 标准
		if (submitBidService.isStandard(bidInfo)) {
			bidInfo.getBid().setIsStandard(BidConstant.STANDARD);
			CommonConstant.FRAMEWORK.info(MessageFormat.format(STANDARD_BID, bidInfo.getCode()));
		}
		// 非标准
		else {
			bidInfo.getBid().setIsStandard(BidConstant.NONSTANDARD);
			CommonConstant.FRAMEWORK.info(MessageFormat.format(NONSTANDARD_BID, bidInfo.getCode()));
		}

		// 设置bid状态 等待提交至海鼎
		bidInfo.getBid().setProcessState(BidConstant.WAITING);

		// 修改bid
		bidService.update(bidInfo.getBid());

		// 提交出价
		BusinessEventTemplate template = getTemplate().put(BusinessEventListenerConstant.BaseEntity, bidInfo);
		publishEvent(new SubmitBidEvent(template));

	}

}
