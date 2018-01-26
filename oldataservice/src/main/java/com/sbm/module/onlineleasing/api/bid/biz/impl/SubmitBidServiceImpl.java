package com.sbm.module.onlineleasing.api.bid.biz.impl;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.business.biz.IThreadSleepExecuteCallBack;
import com.sbm.module.onlineleasing.base.bid.biz.ITOLBidService;
import com.sbm.module.onlineleasing.base.bid.constant.BidConstant;
import com.sbm.module.onlineleasing.base.bidcontract.biz.ITOLBidContractService;
import com.sbm.module.onlineleasing.base.bidcontract.domain.TOLBidContract;
import com.sbm.module.onlineleasing.base.biddetail.biz.ITOLBidDetailService;
import com.sbm.module.onlineleasing.base.bidparam.promotionkind.constant.PromotionKindConstant;
import com.sbm.module.onlineleasing.base.bidparam.rentmethod.constant.RentMethodConstant;
import com.sbm.module.onlineleasing.base.brand.biz.ITOLBrandService;
import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;
import com.sbm.module.onlineleasing.base.mallbidstandard.biz.ITOLMallBidStandardService;
import com.sbm.module.onlineleasing.base.mallbidstandard.domain.TOLMallBidStandard;
import com.sbm.module.onlineleasing.base.merchant.biz.ITOLMerchantService;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.onlineleasing.base.merchantbrand.biz.ITOLMerchantBrandService;
import com.sbm.module.onlineleasing.base.merchantbrand.domain.TOLMerchantBrand;
import com.sbm.module.onlineleasing.base.modality.constant.ModalityConstant;
import com.sbm.module.onlineleasing.base.shop.constant.ShopConstant;
import com.sbm.module.partner.hd.rest.base.constant.HdConstant;
import com.sbm.module.partner.hd.rest.contract.base.biz.IHdContractService;
import com.sbm.module.partner.hd.view.rentmethod.domain.RentMethod;
import com.sun.org.apache.regexp.internal.RE;
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
import com.sbm.module.onlineleasing.api.bid.biz.ISubmitBidService;
import com.sbm.module.onlineleasing.api.bid.domain.BidInfo;
import com.sbm.module.onlineleasing.base.bid.domain.TOLBid;
import com.sbm.module.onlineleasing.base.biddetail.domain.TOLBidDetail;
import com.sbm.module.onlineleasing.base.shop.biz.ITOLShopService;
import com.sbm.module.onlineleasing.base.shop.domain.TOLShop;

@Component
@Transactional(value = TransactionConstant.OL, propagation = Propagation.REQUIRED)
public class SubmitBidServiceImpl extends BusinessServiceImpl implements ISubmitBidService {

	@Autowired
	private ITOLShopService shopService;
	@Autowired
	private ITOLMerchantService merchantService;
	@Autowired
	private ITOLBrandService brandService;
	@Autowired
	private ITOLMerchantBrandService merchantBrandService;

	@Autowired
	private ITOLBidService bidService;
	@Autowired
	private ITOLBidDetailService bidDetailService;
	@Autowired
	private ITOLBidContractService bidContractService;

	@Autowired
	private IHdContractService hdContractService;

	@Autowired
	private ITOLMallBidStandardService mallBidStandardService;

	/*********************************************************************************************/

	private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);
	private static final BigDecimal TWO_HUNDRED = new BigDecimal(200);
	private static final BigDecimal FIVE_HUNDRED = new BigDecimal(500);
	private static final BigDecimal TRIPLE = new BigDecimal(3);

	/*********************************************************************************************/

	private static final String PAUSE_MESSAGE = "bid is paused. bidCode: {0}";

	/*********************************************************************************************/

	private void checkNotNullAndStatus(BidInfo bidInfo) {
		// 商户，品牌，商铺 代码不能为空
		ParamsUtil.canNotBeEmpty(bidInfo.getBid().getBrandCode(), bidInfo.getBid().getShopCode());
		// 合作类型，结算方式不能为空
		ParamsUtil.canNotBeNull(bidInfo.getBid().getLeaseType(), bidInfo.getBid().getAccType());

		// 起租日期，终止日期不能为空
		ParamsUtil.canNotBeNull(bidInfo.getBid().getStartDate(), bidInfo.getBid().getEndDate());
		// 计租方式，比高频率不能为空
		ParamsUtil.canNotBeNull(bidInfo.getBid().getRentMethod(), bidInfo.getBid().getCompareFrequency());

		/*********************************************************************************************/

		TOLShop shop = shopService.findByCode(bidInfo.getBid().getShopCode());
		// 商铺是否为空
		if (null == shop) {
			throw new BusinessException(BusinessCode.C5300, null);
		}

		// 商铺是否可用
		if (!HdConstant.HD_STATE_USING.equals(shop.getHdState())) {
			throw new BusinessException(BusinessCode.C5301, new Object[]{shop.getCode(), shop.getHdState()}, null);
		}
		// 商铺是否在租
		if (ShopConstant.SHOP_STATE_0.equals(shop.getShopState())) {
			throw new BusinessException(BusinessCode.C5302, new Object[]{shop.getCode(), shop.getShopState()}, null);
		}
		// 商铺是否锁定
		if (0 == shop.getState()) {
			throw new BusinessException(BusinessCode.C5303, new Object[]{shop.getCode(), shop.getState()}, null);
		}

		bidInfo.setShop(shop);

		/*********************************************************************************************/

		TOLMerchant merchant = merchantService.findByCode(bidInfo.getBid().getMerchantCode());
		// 商户是否为空
		if (null == merchant) {
			throw new BusinessException(BusinessCode.C5200, new Object[]{bidInfo.getBid().getMerchantCode()}, null);
		}

		// 商户是否可用
		if (!HdConstant.HD_STATE_USING.equals(merchant.getHdState())) {
			throw new BusinessException(BusinessCode.C5201, new Object[]{bidInfo.getShop().getCode(), merchant.getHdState()}, null);
		}
		bidInfo.setMerchant(merchant);

		/*********************************************************************************************/

		TOLBrand brand = brandService.findByCode(bidInfo.getBid().getBrandCode());

		// 品牌是否唯恐
		if (null == brand) {
			throw new BusinessException(BusinessCode.C5004, new Object[]{bidInfo.getBid().getBrandCode()}, null);
		}

		// 品牌是否可用
		if (!HdConstant.HD_STATE_USING.equals(brand.getHdState())) {
			throw new BusinessException(BusinessCode.C5005, new Object[]{bidInfo.getShop().getCode(), brand.getHdState()}, null);
		}

		// 品牌商户是否绑定
		TOLMerchantBrand merchantBrand = merchantBrandService.findByMerchantCodeAndBrandCode(bidInfo.getBid().getMerchantCode(), bidInfo.getBid().getBrandCode());
		if (null == merchantBrand) {
			throw new BusinessException(BusinessCode.C5006, new Object[]{bidInfo.getBid().getMerchantCode(), bidInfo.getBid().getBrandCode()}, null);
		}
		bidInfo.setBrand(brand);

	}

	/**************************************************************************/

	public void preSave(BidInfo bidInfo) {
		TOLBid bid = bidInfo.getBid();

		// 校验非空和状态
		checkNotNullAndStatus(bidInfo);

		TOLShop shop = bidInfo.getShop();

		// 起租日期必须大于等于当日
		Date now = new Date();
		if (now.getTime() > bid.getStartDate().getTime()) {
			throw new BusinessException(BusinessCode.C6100, new Object[]{bid.getStartDate(), now}, null);
		}
		// 起租日期必须大于最早可入住日期
		if (null != shop.getContractExpireDate()
				&& shop.getContractExpireDate().getTime() > bid.getStartDate().getTime()) {
			throw new BusinessException(BusinessCode.C6101, new Object[]{bid.getStartDate(),
					shop.getContractExpireDate()}, null);
		}
		// 起租日期必须小于等于终止日期
		if (bid.getEndDate().getTime() < bid.getStartDate().getTime()) {
			throw new BusinessException(BusinessCode.C6102, new Object[]{bid.getStartDate(), bid.getEndDate()}, null);
		}
		// 宣传推广费不能为负数
		ParamsUtil.canNotBeMinus(bid.getPromotionBudget());
		// 装修期内物业管理费不能为负数
		ParamsUtil.canNotBeMinus(bid.getMaintenanceDuringDecoration());
		// 装修期外物业管理费不能为负数
		ParamsUtil.canNotBeMinus(bid.getMaintenanceAfterDecoration());
		// 保证金不能为负数
		ParamsUtil.canNotBeMinus(bid.getGurantee());
		// 目标营业额不能为负数
		ParamsUtil.canNotBeMinus(bid.getTarget());
		// 推广活动次数不能为负数
		ParamsUtil.canNotBeMinus(bid.getPromotion());
		// 免租期不能为负数
		ParamsUtil.canNotBeMinus(bid.getFreeDays());

		// 判断明细
		checkDetail(bidInfo);
	}

	private void checkDetail(BidInfo bidInfo) {
		List<TOLBidDetail> details = bidInfo.getBidDetails();
		for (TOLBidDetail bidDetail : details) {
			// 删除标记不为删除的才做判断
			if (!ParamsUtil.isTrue(bidDetail.getDeleteFlag())) {
				// 开始日期，结束日期不能为空
				ParamsUtil.canNotBeNull(bidDetail.getStartDate(), bidDetail.getEndDate());
				// 开始日期必须大于等于起租日期
				if (bidDetail.getStartDate().getTime() < bidInfo.getBid().getStartDate().getTime()) {
					throw new BusinessException(BusinessCode.C6103, new Object[]{bidDetail.getStartDate().getTime(),
							bidInfo.getBid().getStartDate().getTime()}, null);
				}
				// 结束日期必须小于等于终止日期
				if (bidDetail.getEndDate().getTime() > bidInfo.getBid().getEndDate().getTime()) {
					throw new BusinessException(BusinessCode.C6104, new Object[]{bidDetail.getEndDate().getTime(),
							bidInfo.getBid().getEndDate().getTime()}, null);
				}
				// 开始日期必须小于等于结束日期
				if (bidDetail.getStartDate().getTime() > bidDetail.getEndDate().getTime()) {
					throw new BusinessException(BusinessCode.C6105, new Object[]{bidDetail.getStartDate().getTime(),
							bidDetail.getEndDate().getTime()}, null);
				}
				// 固定租金不能为负数
				ParamsUtil.canNotBeMinus(bidDetail.getDeadRent());
				// 浮动租金不能为负数
				ParamsUtil.canNotBeMinus(bidDetail.getFloatingRentalRate());
			}
		}
	}

	/**************************************************************************/

	public void preSubmit(BidInfo bidInfo) {
		// 检查非空和状态
		checkNotNullAndStatus(bidInfo);
	}

	/**************************************************************************/

	public boolean isStandard(BidInfo bidInfo) {
		// 目前暂定都是非标合同
		if (1 == 1) {
			return false;
		}

		TOLShop shop = bidInfo.getShop();
		// 出价标准
		TOLMallBidStandard mallBidStandard = mallBidStandardService.findByCode(shop.getMallCode());
		TOLBid bid = bidInfo.getBid();
		List<TOLBidDetail> bidDetails = bidInfo.getBidDetails();
		TOLBrand brand = bidInfo.getBrand();

		// 有法务异议，为非标出价；
		if (StringUtils.isNotBlank(bid.getLegalSuggest())) {
			return false;
		}
		// 有其他商务异议，为非标出价；
		if (StringUtils.isNotBlank(bid.getBusinessSuggest())) {
			return false;
		}
		// 若计租方式选择非“提成租金”，首期固定租金小于参考租金，则为非标；
		if (null != shop.getDeadRent() && !RentMethodConstant.RENT_METHOD_1.equals(bid.getRentMethod())) {
			if (bidDetails.get(0).getDeadRent().compareTo(shop.getDeadRent()) == -1) {
				return false;
			}
		}
		// 若计租方式选择非“固定租金”，首期浮动租金扣率小于参考扣率，则为非标；
		if (null != shop.getFloatingRentalRate() && !RentMethodConstant.RENT_METHOD_0.equals(bid.getRentMethod())) {
			if (bidDetails.get(0).getFloatingRentalRate().compareTo(shop.getFloatingRentalRate()) == -1) {
				return false;
			}
		}
		// 租期小于等于3年，若有固定租金，则后一期间的租金与前一期间的租金差异小于前一期金额的getRentIncrease_1，则为非标出价；
		if (bid.getContractLength() <= 3) {
			if (!RentMethodConstant.RENT_METHOD_1.equals(bid.getRentMethod()) && bidDetails.size() >= 2) {
				for (int i = 1; i < bidDetails.size(); i++) {
					if (bidDetails.get(i - 1).getDeadRent().multiply(mallBidStandard.getRentIncrease_1()).compareTo(bidDetails.get(i).getDeadRent().multiply(ONE_HUNDRED)) == 1) {
						return false;
					}
				}
			}
		}
		// 租期大于3年，若有固定租金，则后一期间的租金与前一期间的租金差异小于前一期金额的getRentIncrease_2，则为非标出价；
		if (bid.getContractLength() > 3) {
			if (!RentMethodConstant.RENT_METHOD_1.equals(bid.getRentMethod()) && bidDetails.size() >= 2) {
				for (int i = 1; i < bidDetails.size(); i++) {
					if (bidDetails.get(i - 1).getDeadRent().multiply(mallBidStandard.getRentIncrease_2()).compareTo(bidDetails.get(i).getDeadRent().multiply(ONE_HUNDRED)) == 1) {
						return false;
					}
				}
			}
		}
		// 浮动租金，后一期间扣率值小于前一期间扣率值，则为非标出价；
		if (!RentMethodConstant.RENT_METHOD_0.equals(bid.getRentMethod()) && bidDetails.size() >= 2) {
			for (int i = 1; i < bidDetails.size(); i++) {
				if (bidDetails.get(i - 1).getFloatingRentalRate().compareTo(bidDetails.get(i).getFloatingRentalRate()) == 1) {
					return false;
				}
			}
		}
		// 推广宣传费小于getPromotionBudget，则为非标出价；
		if (PromotionKindConstant.PROMOTION_KIND_0.equals(bid.getPromotionKind())) {
			if (bid.getPromotionBudget().compareTo(mallBidStandard.getPromotionBudget()) == -1) {
				return false;
			}
		}
		// 装修期内/外物业管理费，小于getMaintenanceFee元/月/平米，则为非标出价；
		if (bid.getMaintenanceDuringDecoration().compareTo(mallBidStandard.getMaintenanceFee()) == -1) {
			return false;
		}
		if (bid.getMaintenanceAfterDecoration().compareTo(mallBidStandard.getMaintenanceFee()) == -1) {
			return false;
		}
		// 保证金金额小于（最高含税月租金+最高含税装修期外物业管理费）*3倍，则为非标出价；
		BigDecimal max = bidDetails.stream().max(Comparator.comparing(TOLBidDetail::getDeadRent)).get().getDeadRent();
		if ((bid.getMaintenanceAfterDecoration().add(max).multiply(TRIPLE)).compareTo(bid.getGurantee()) == -1) {
			return false;
		}

		// 业态
		String modality = brand.getModality_1().substring(0, 2);
		// 装修免租期
		BigDecimal freeDays = new BigDecimal(bid.getFreeDays());
		// 合约年限
		BigDecimal contractLength = new BigDecimal(bid.getContractLength());

		// 零售
		if (ModalityConstant.RETAIL.equals(modality)) {
			// 装修免租期
			// area < 200
			if (shop.getArea().compareTo(TWO_HUNDRED) == -1) {
				// > getRentFreeRetail_1
				if (freeDays.compareTo(mallBidStandard.getRentFreeRetail_1()) == 1) {
					return false;
				}
				// > getLimitRetail_1
				if (contractLength.compareTo(mallBidStandard.getLimitRetail_1()) == 1) {
					return false;
				}
			}
			// 200 <= area < 500
			else if (shop.getArea().compareTo(TWO_HUNDRED) != -1 && shop.getArea().compareTo(FIVE_HUNDRED) == -1) {
				// > getRentFreeRetail_2
				if (freeDays.compareTo(mallBidStandard.getRentFreeRetail_2()) == 1) {
					return false;
				}
				// > getLimitRetail_2
				if (contractLength.compareTo(mallBidStandard.getLimitRetail_2()) == 1) {
					return false;
				}
			}
			// area >= 500
			else if (shop.getArea().compareTo(FIVE_HUNDRED) != -1) {
				// > getRentFreeRetail_3
				if (freeDays.compareTo(mallBidStandard.getRentFreeRetail_3()) == 1) {
					return false;
				}
				// > getLimitRetail_3
				if (contractLength.compareTo(mallBidStandard.getLimitRetail_3()) == 1) {
					return false;
				}
			}
		}
		// 非零售
		else if (ModalityConstant.NONRETAIL.equals(modality)) {
			// area < 200
			if (shop.getArea().compareTo(ONE_HUNDRED) == -1) {
				// > getRentFreeNonretail_1
				if (freeDays.compareTo(mallBidStandard.getRentFreeNonretail_1()) == 1) {
					return false;
				}
				// > getLimitNonretail_1
				if (contractLength.compareTo(mallBidStandard.getLimitNonretail_1()) == 1) {
					return false;
				}
			}
			// 200 <= area < 500
			else if (shop.getArea().compareTo(ONE_HUNDRED) != -1 && shop.getArea().compareTo(FIVE_HUNDRED) == -1) {
				// > getRentFreeNonretail_2
				if (freeDays.compareTo(mallBidStandard.getRentFreeNonretail_2()) == 1) {
					return false;
				}
				// > getLimitNonretail_2
				if (contractLength.compareTo(mallBidStandard.getLimitNonretail_2()) == 1) {
					return false;
				}
			}
			// area >= 500
			else if (shop.getArea().compareTo(FIVE_HUNDRED) != -1) {
				// > getRentFreeNonretail_3
				if (freeDays.compareTo(mallBidStandard.getRentFreeNonretail_3()) == 1) {
					return false;
				}
				// > getLimitNonretail_3
				if (contractLength.compareTo(mallBidStandard.getLimitNonretail_3()) == 1) {
					return false;
				}
			}
		}
		return true;
	}

	/**************************************************************************/

	public void submit(BidInfo bidInfo) {
		// 设置bid状态 预览合同生成
		// 多线程防止事务未提交
		TOLBid bid = findByCode(bidInfo.getCode());
		// 出价主体
		bidInfo.setBid(bid);
		// 出价明细
		bidInfo.setBidDetails(bidDetailService.findAllByCode(bidInfo.getBid().getCode()));
		// 查询出原有的合同
		bidInfo.setBidContract(bidContractService.findByCode(bidInfo.getBid().getCode()));
		// 商户
		bidInfo.setMerchant(merchantService.findByCode(bidInfo.getBid().getMerchantCode()));
		// 品牌
		bidInfo.setBrand(brandService.findByCode(bidInfo.getBid().getBrandCode()));
		// 商铺
		bidInfo.setShop(shopService.findByCode(bidInfo.getBid().getShopCode()));

		// 标准
		if (BidConstant.STANDARD.equals(bidInfo.getBid().getIsStandard())) {
			// 标准出价
			standardSubmit(bidInfo);
		}
		// 非标准
		else {
			nonStandardSubmit(bidInfo);
		}
	}

	/**************************************************************************/

	/**
	 * 标准出价
	 *
	 * @param bidInfo
	 */
	private void standardSubmit(BidInfo bidInfo) {
		doStandardSubmit(bidInfo);
	}

	/**
	 * 执行标准出价
	 *
	 * @param bidInfo
	 */
	private void doStandardSubmit(BidInfo bidInfo) {
		try {
			// 出价成功 对于标准出价，出价成功=审批结束
			// bidInfo.getBid().setProcessState(BidConstant.SUCCESS);
			hdContractService.standardSubmit(bidInfo);
			// 审批结束
			bidInfo.getBid().setProcessState(BidConstant.END_OF_APPROVAL);
			// 审批通过
			bidInfo.getBid().setIsApprove(BidConstant.APPROVE);
			// 更新合同
			bidContractService.update(bidInfo.getBidContract());
		} catch (Exception e) {
			// 出价失败
			bidInfo.getBid().setProcessState(BidConstant.FAILURE);
			CommonConstant.ERRORDATA.error(bidInfo, e);
		}
		// 修改bid
		bidService.update(bidInfo.getBid());
	}

	/**************************************************************************/

	/**
	 * 非标准出价
	 *
	 * @param bidInfo
	 */
	private void nonStandardSubmit(BidInfo bidInfo) {
		// 判断该铺位是否有审批结束，非标准，审批通过，未生效的出价
		List<TOLBid> bids = bidService.findAllBeforeNonStandardSubmit(bidInfo.getBid().getShopCode());
		// 有对应出价
		if (null != bids && !bids.isEmpty()) {
			// 暂不提交至海鼎
			bidInfo.getBid().setProcessState(BidConstant.PAUSE);
			// 修改bid
			bidService.update(bidInfo.getBid());
			CommonConstant.ERRORDATA.info(MessageFormat.format(PAUSE_MESSAGE, bidInfo.getBid().getCode()));
			// TODO 等待job处理
		}
		// 没有对应出价
		else {
			// 提交出价
			List<BidInfo> bidInfos = new ArrayList<>();
			bidInfos.add(bidInfo);
			doNonStandardSubmit(bidInfos);
		}
	}

	/**
	 * 执行非标准出价
	 *
	 * @param bidInfos
	 */
	private void doNonStandardSubmit(List<BidInfo> bidInfos) {
		try {
			// 出价成功
			for (BidInfo tmp : bidInfos) {
				tmp.getBid().setProcessState(BidConstant.SUCCESS);
			}
			hdContractService.nonStandardSubmit(bidInfos);
			// 更新合同
			for (BidInfo tmp : bidInfos) {
				bidContractService.update(tmp.getBidContract());
			}
		} catch (Exception e) {
			// 出价失败
			for (BidInfo tmp : bidInfos) {
				tmp.getBid().setProcessState(BidConstant.FAILURE);
			}
			CommonConstant.ERRORDATA.error(bidInfos, e);
		}
		// 修改bid
		for (BidInfo tmp : bidInfos) {
			bidService.update(tmp.getBid());
		}
	}

	/***********************************************************/

	/**
	 * findByCode:多线程处理防止事务未提交
	 *
	 * @param code
	 * @return
	 * @author junkai.zhang
	 */
	private TOLBid findByCode(final String code) {
		return threadSleepExecute(new BusinessException(BusinessCode.C6000, new Object[]{code}, null),
				new IThreadSleepExecuteCallBack<TOLBid>() {
					public TOLBid execute() {
						TOLBid po = bidService.findByCode(code);
						return po;
					}
				});
	}
}
