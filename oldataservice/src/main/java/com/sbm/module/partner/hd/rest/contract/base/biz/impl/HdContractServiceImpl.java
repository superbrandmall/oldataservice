package com.sbm.module.partner.hd.rest.contract.base.biz.impl;

import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.business.util.ParamsUtil;
import com.sbm.module.onlineleasing.api.baseinfo.bidparam.biz.IBidParamService;
import com.sbm.module.onlineleasing.api.baseinfo.bidparam.domain.BidParam;
import com.sbm.module.onlineleasing.api.baseinfo.bidparam.domain.BidParamVo;
import com.sbm.module.onlineleasing.base.bidcontract.domain.TOLBidContract;
import com.sbm.module.onlineleasing.base.biddetail.domain.TOLBidDetail;
import com.sbm.module.onlineleasing.base.bidparam.acctype.domain.TOLBidAcctype;
import com.sbm.module.onlineleasing.base.bidparam.cashiermode.domain.TOLBidCashierMode;
import com.sbm.module.onlineleasing.base.bidparam.leasemodule.domain.TOLBidLeasemodule;
import com.sbm.module.onlineleasing.base.bidparam.leasetermname.domain.TOLBidLeasetermname;
import com.sbm.module.onlineleasing.base.bidparam.leasetype.domain.TOLBidLeasetype;
import com.sbm.module.onlineleasing.base.bidparam.promotionkind.constant.PromotionKindConstant;
import com.sbm.module.onlineleasing.base.bidparam.rentmethod.constant.RentMethodConstant;
import com.sbm.module.onlineleasing.base.bidparam.rentmethod.domain.TOLBidRentMethod;
import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;
import com.sbm.module.onlineleasing.base.merchant.domain.TOLMerchant;
import com.sbm.module.onlineleasing.base.modality.biz.ITOLModalityService;
import com.sbm.module.onlineleasing.base.modality.domain.TOLModality;
import com.sbm.module.onlineleasing.base.shop.domain.TOLShop;
import com.sbm.module.partner.hd.rest.base.biz.impl.HdInteractiveServiceImpl;
import com.sbm.module.partner.hd.rest.base.constant.HdConstant;
import com.sbm.module.partner.hd.rest.base.domain.HdBizType;
import com.sbm.module.partner.hd.rest.base.domain.HdUCN;
import com.sbm.module.partner.hd.rest.contract.base.domain.*;
import com.sbm.module.partner.hd.rest.contract.nonstandard.biz.IHdContractNonStandardSubmitService;
import com.sbm.module.partner.hd.rest.contract.nonstandard.domain.HdContractNonStandardResult;
import com.sbm.module.partner.hd.rest.contract.nonstandard.domain.HdContractNonStandardResultDetail;
import com.sbm.module.partner.hd.rest.contract.standard.biz.IHdContractStandardSubmitService;
import com.sbm.module.partner.hd.rest.contract.standard.domain.HdContractStandardResult;
import com.sbm.module.partner.hd.view.cashiermode.domain.CashierMode;
import com.sbm.module.partner.hd.view.promotionkind.domain.PromotionKind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.onlineleasing.api.bid.domain.BidInfo;
import com.sbm.module.onlineleasing.api.upload.biz.IUploadService;
import com.sbm.module.onlineleasing.api.upload.constant.UploadConstant;
import com.sbm.module.onlineleasing.base.bid.domain.TOLBid;
import com.sbm.module.partner.hd.rest.base.domain.HdResult;
import com.sbm.module.partner.hd.rest.contract.base.biz.IHdContractService;
import com.sbm.module.partner.hd.rest.contract.preview.biz.IHdContractPreviewService;
import org.springframework.util.CollectionUtils;
import sun.plugin2.message.Message;

/*****************************************************************************/

/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.rest.contract.base.biz.impl<br/>
 * File Name:HdContractServiceImpl.java<br/>
 * <p>
 * 作成日 ：2017-11-24 下午2:27:32 <br/>
 *
 * @author ：junkai.zhang
 */
@Component
public class HdContractServiceImpl extends HdInteractiveServiceImpl implements IHdContractService {

	@Autowired
	private ITOLModalityService modalityService;

	@Autowired
	private IHdContractPreviewService hdContractPreviewService;
	@Autowired
	private IUploadService uploadService;

	@Autowired
	private IBidParamService service;

	@Autowired
	private IHdContractNonStandardSubmitService hdContractNonStandardSubmitService;

	@Autowired
	private IHdContractStandardSubmitService hdContractStandardSubmitService;

	/***************************************************************************/

	private static final String PDF_TEMP_MESSAGE = "bidCode: {0}, pdfTemp: {1}";

	private static final String PDF_MESSAGE = "bidCode: {0}, pdf: {1}";

	private static final String NO_LEASEMODULE = "not found leasemodule. bidCode: {0}, leasetype: {1}, acctype: {2}";

	private static final String NO_LEASETYPE = "not found leasetype. bidCode: {0}, leasetype: {1}";

	private static final String NO_RENT_METHOD = "not found rentMethod. bidCode: {0}, rentMethods: {1}";

	private static final String NO_ACCTYPE = "not found acctype. bidCode: {0}, acctype: {1}";

	private static final String NO_CASHIER_MODE = "not found cashierMode. bidCode: {0}, cashierMode: {1}";

	private static final String NO_TERM_NAME = "not found term name. bidCode:{0}, template: {1}, feename: {2}";

	/***************************************************************************/

	private static final String DEAD_RENT = "固定租金";

	private static final String PROPERTY_FEE = "物业费";

	private static final String PROMOTION_FEE_DEAD = "推广费（固定）";

	private static final String PROMOTION_FEE_FLOAT = "推广费（比例）";

	private static final String GAG = "GAG维护费";

	private static final String GURANTEE = "租赁保证金";

	private static final String PUBLIC_DEPOSIT = "公共事业费押金";

	private static final String FLOATING_RENTAL_RATE = "提成租金";

	private static final String FEE_DAYS = "装修免租期";

	private static final String BUSINESS_FEE_DAYS = "经营免租期";

	private static final String HIGH = "比高";

	/***************************************************************************/

	/**
	 * 出价转换
	 *
	 * @param vo
	 * @param bidInfo
	 */
	private void convert2HdContract(HdContract vo, BidInfo bidInfo) {
		// 获取出价参数
		BidParam param = service.get();

		TOLBid bid = bidInfo.getBid();
		List<TOLBidDetail> bidDetails = bidInfo.getBidDetails();

		// 合同模板
		List<TOLBidLeasemodule> leasemodules = param.getLeasemodules().stream()
				.filter(t -> (t.getLeasetype().equals(bid.getLeaseType()) && (t.getAcctype().equals(bid.getAccType())))).collect(Collectors.toList());
		if (!CollectionUtils.isEmpty(leasemodules)) {
			vo.setTemplate(leasemodules.get(0).getLeasemodulename());
		} else {
			CommonConstant.FRAMEWORK.warn(MessageFormat.format(NO_LEASEMODULE, bid.getCode(), String.valueOf(bid.getLeaseType()), String.valueOf(bid.getAccType())));
		}
		// ol合同id
		vo.setOlContractId(bid.getCode());
		// 合同类型
		List<TOLBidLeasetype> leasetypes = param.getLeasetypes().stream().filter(t -> t.getItemValue().equals(String.valueOf(bid.getLeaseType()))).collect(Collectors.toList());
		if (!CollectionUtils.isEmpty(leasetypes)) {
			vo.setContractCategory(leasetypes.get(0).getItemKey());
		} else {
			CommonConstant.FRAMEWORK.warn(MessageFormat.format(NO_LEASETYPE, bid.getCode(), String.valueOf(bid.getLeaseType())));
		}
		// 合作方式 计租方式
		List<TOLBidRentMethod> rentMethods = param.getRentMethods().stream().filter(t -> t.getItemValue().equals(String.valueOf(bid.getRentMethod()))).collect(Collectors.toList());
		if (!CollectionUtils.isEmpty(rentMethods)) {
			vo.setCoopMode(rentMethods.get(0).getItemKey());
		} else {
			CommonConstant.FRAMEWORK.warn(MessageFormat.format(NO_RENT_METHOD, bid.getCode(), String.valueOf(bid.getRentMethod())));
		}
		// 结算方式
		List<TOLBidAcctype> acctypes = param.getAcctypes().stream().filter(t -> t.getItemValue().equals(String.valueOf(bid.getAccType()))).collect(Collectors.toList());
		if (!CollectionUtils.isEmpty(acctypes)) {
			vo.setAccType(acctypes.get(0).getItemKey());
		} else {
			CommonConstant.FRAMEWORK.warn(MessageFormat.format(NO_ACCTYPE, bid.getCode(), String.valueOf(bid.getAccType())));
		}
		// 法务异议
		vo.setLegal_objection(bid.getLegalSuggest());
		// 有效期天数
		vo.setEffective_Days(15);
		// 装修免租期
		vo.setFree_days(bid.getFreeDays());
		// 商户
		TOLMerchant merchant = bidInfo.getMerchant();
		vo.setTenant(new HdUCN(merchant.getHdUuid(), merchant.getHdCode(), merchant.getName()));
		// 品牌
		TOLBrand brand = bidInfo.getBrand();
		vo.setBrand(new HdUCN(brand.getHdUuid(), brand.getHdCode(), merchant.getName()));
		// 核算楼层 为空则默认取铺位的楼层
		// vo.setFloor();
		// 业态
		TOLModality modality = modalityService.findByCode(brand.getModality_3(), true);
		vo.getBizType().setCode(modality.getCode());
		vo.getBizType().setUuid(modality.getHdUuid());
		vo.getBizType().setLevelId(modality.getHdLevelid());
		vo.getBizType().setName(modality.getName());
		// 计租面积 为空则默认取铺位的计租面积
		// vo.setRentArea();
		// 店招 为空则默认取品牌名称
		// vo.setSignboard();
		// 合同开始时间
		vo.setBeginDate(bid.getStartDate());
		// 合同结束时间
		vo.setEndDate(bid.getEndDate());
		// 收银方式 TODO
		vo.setPosMode("unuse");
//		List<TOLBidCashierMode> cashierModes = param.getCashierModes().stream().filter(t->t.getItemValue().equals(String.valueOf(bid.getCashierMode()))).collect(Collectors.toList());
//		if (!CollectionUtils.isEmpty(cashierModes)) {
//			vo.setPosMode(cashierModes.get(0).getItemKey());
//		} else {
//			CommonConstant.FRAMEWORK.warn(MessageFormat.format(NO_CASHIER_MODE, bid.getCode(), String.valueOf(bid.getCashierMode())));
//		}
		// 铺位
		TOLShop shop = bidInfo.getShop();
		vo.setPosition(new HdUCN(shop.getHdUuid(), shop.getHdCode(), shop.getShopName()));

		// 月固定条款
		HdMonthFixedTerm monthFixedTerm;
		// 商品类别销售固定比例提成条款
		HdNormalCategorySaleRateTerm normalCategorySaleRateTerm;
		// 销售固定比例提成条款
		HdNormalSaleRateTerm normalSaleRateTerm;
		// 预存款条款
		HdDepositTerm depositTerm;
		// 免租条款 TODO 暂无
		HdFreeAccountTerm freeAccountTerm;
		// 账款按科目取最大值条款
		HdMaxSubjectTerm maxSubjectTerm;

		// 条款名称
		TOLBidLeasetermname leasetermname;
		// 遍历出价明细
		for (TOLBidDetail detail : bidDetails) {
			if (!RentMethodConstant.RENT_METHOD_1.equals(bid.getRentMethod())) {
				// 固定租金
				leasetermname = getLeasetermname(param.getLeasetermnames(), bid.getCode(), vo.getTemplate(), DEAD_RENT);
				if (null != leasetermname) {
					monthFixedTerm = new HdMonthFixedTerm();
					monthFixedTerm.setCaption(leasetermname.getTermname());
					monthFixedTerm.setRemark(leasetermname.getRemark());
					monthFixedTerm.getDetails().add(new HdDateRangeDetail(detail.getStartDate(), detail.getEndDate(), detail.getDeadRent()));
					vo.getMonthFixeds().add(monthFixedTerm);
				}
			}
			if (!RentMethodConstant.RENT_METHOD_0.equals(bid.getRentMethod())) {
				// 提成扣率
				leasetermname = getLeasetermname(param.getLeasetermnames(), bid.getCode(), vo.getTemplate(), FLOATING_RENTAL_RATE);
				if (null != leasetermname) {
					normalCategorySaleRateTerm = new HdNormalCategorySaleRateTerm();
					normalCategorySaleRateTerm.setCaption(leasetermname.getTermname());
					normalCategorySaleRateTerm.setRemark(leasetermname.getRemark());
					normalCategorySaleRateTerm.getDetails().add(new HdDateRangeDetail(detail.getStartDate(), detail.getEndDate(), detail.getFloatingRentalRate()));
					vo.getCategorySaleRates().add(normalCategorySaleRateTerm);
				}
			}
		}

		// 物业费
		leasetermname = getLeasetermname(param.getLeasetermnames(), bid.getCode(), vo.getTemplate(), PROPERTY_FEE);
		if (null != leasetermname) {
			monthFixedTerm = new HdMonthFixedTerm();
			monthFixedTerm.setCaption(leasetermname.getTermname());
			monthFixedTerm.setRemark(leasetermname.getRemark());
			monthFixedTerm.getDetails().add(new HdDateRangeDetail(bid.getStartDate(), bid.getEndDate(), bid.getMaintenanceDuringDecoration()));
			vo.getMonthFixeds().add(monthFixedTerm);
		}

		// 推广费（比例）
		if (PromotionKindConstant.PROMOTION_KIND_0.equals(bid.getPromotionKind())) {
			leasetermname = getLeasetermname(param.getLeasetermnames(), bid.getCode(), vo.getTemplate(), PROMOTION_FEE_FLOAT);
			if (null != leasetermname) {
				normalSaleRateTerm = new HdNormalSaleRateTerm();
				normalSaleRateTerm.setCaption(leasetermname.getTermname());
				normalSaleRateTerm.setRemark(leasetermname.getRemark());
				normalSaleRateTerm.getDetails().add(new HdDateRangeDetail(bid.getStartDate(), bid.getEndDate(), bid.getPromotionBudget()));
				vo.getNormalSaleRates().add(normalSaleRateTerm);
			}
		}
		// 推广费（固定）
		else if (PromotionKindConstant.PROMOTION_KIND_1.equals(bid.getPromotionKind())) {
			leasetermname = getLeasetermname(param.getLeasetermnames(), bid.getCode(), vo.getTemplate(), PROMOTION_FEE_DEAD);
			if (null != leasetermname) {
				monthFixedTerm = new HdMonthFixedTerm();
				monthFixedTerm.setCaption(leasetermname.getTermname());
				monthFixedTerm.setRemark(leasetermname.getRemark());
				monthFixedTerm.getDetails().add(new HdDateRangeDetail(bid.getStartDate(), bid.getEndDate(), bid.getPromotionBudget()));
				vo.getMonthFixeds().add(monthFixedTerm);
			}
		}

		// 租赁保证金
		leasetermname = getLeasetermname(param.getLeasetermnames(), bid.getCode(), vo.getTemplate(), GURANTEE);
		if (null != leasetermname) {
			depositTerm = new HdDepositTerm();
			depositTerm.setCaption(leasetermname.getTermname());
			depositTerm.setRemark(leasetermname.getRemark());
			depositTerm.getDetails().add(new HdDepositTermDetail(bid.getGurantee()));
			vo.getDepositTerms().add(depositTerm);
		}

		// 公共事业费押金
		leasetermname = getLeasetermname(param.getLeasetermnames(), bid.getCode(), vo.getTemplate(), PUBLIC_DEPOSIT);
		if (null != leasetermname) {
			depositTerm = new HdDepositTerm();
			depositTerm.setCaption(leasetermname.getTermname());
			depositTerm.setRemark(leasetermname.getRemark());
			depositTerm.getDetails().add(new HdDepositTermDetail(bid.getPublicDeposit()));
			vo.getDepositTerms().add(depositTerm);
		}

		// 约定营业日
		vo.getEnteryTerm().setOpenDate(bid.getOpening());

		// 比高
		leasetermname = getLeasetermname(param.getLeasetermnames(), bid.getCode(), vo.getTemplate(), HIGH);
		if (null != leasetermname) {
			maxSubjectTerm = new HdMaxSubjectTerm();
			maxSubjectTerm.setCaption(leasetermname.getTermname());
			maxSubjectTerm.setRemark(leasetermname.getRemark());
			maxSubjectTerm.getDetails().add(new HdDateRangeDetail(bid.getStartDate(), bid.getEndDate(), null));
			vo.getMaxSubjects().add(maxSubjectTerm);
		}
	}

	/**
	 * 出价列表转换
	 *
	 * @param vos
	 * @param bidInfos
	 */
	private void convert2HdContracts(List<HdContract> vos, List<BidInfo> bidInfos) {
		HdContract vo;
		for (BidInfo bidInfo : bidInfos) {
			vo = new HdContract();
			convert2HdContract(vo, bidInfo);
			vos.add(vo);
		}
	}

	/**
	 * 获取条款名称
	 * @param list
	 * @param code
	 * @param template
	 * @param feename
	 * @return
	 */
	private TOLBidLeasetermname getLeasetermname (List<TOLBidLeasetermname> list, String code, String template, String feename) {
		List<TOLBidLeasetermname> leasetermnames = list.stream().filter(t -> t.getLeasemodulename().equals(template) && t.getFeename().equals(feename)).collect(Collectors.toList());
		if (!CollectionUtils.isEmpty(leasetermnames)) {
			return leasetermnames.get(0);
		} else {
			CommonConstant.FRAMEWORK.warn(MessageFormat.format(NO_TERM_NAME, code, template, feename));
			return null;
		}
	}

	/***************************************************************************/

	public void preview(BidInfo bidInfo) {
		HdContract vo = new HdContract();
		// 转换为hdContract
		convert2HdContract(vo, bidInfo);
		// 生成预览合同
		HdResult<String> result = hdContractPreviewService.preview(vo);
		// 校对返回结果
		checkResult(result);
		// 生成upload明细
		String uri = uploadService.saveFileUploadDetail(result.getBody(), UploadConstant.CONTAINER_NAME_DEFAULT,
				uploadService.getPrefix(bidInfo.getBid().getUserCode(), UploadConstant.PDF,
						UploadConstant.CONTRACT_TEMP));
		CommonConstant.FRAMEWORK.info(MessageFormat.format(PDF_TEMP_MESSAGE, bidInfo.getBid().getCode(), uri));
		// 设置pdfTemp
		bidInfo.getBidContract().setPdfTemp(uri);
	}

	/***************************************************************************/

	@Override
	public void standardSubmit(BidInfo bidInfo) {
		HdContract vo = new HdContract();
		// 转换为hdContract
		convert2HdContract(vo, bidInfo);
		// 标准出价
		HdResult<HdContractStandardResult> result = hdContractStandardSubmitService.standardSubmit(vo);
		// 校对返回结果
		checkResult(result);

		// 合同过期日期
		bidInfo.getBid().setExpireDate(result.getBody().getDate());

		// 设置单据号
		bidInfo.getBid().setBillNumber(result.getBody().getBillNumber());
		// 生成upload明细
		String pdf_uri = uploadService.saveFileUploadDetail(result.getBody().getFileId(),
				UploadConstant.CONTAINER_NAME_DEFAULT,
				uploadService.getPrefix(bidInfo.getBid().getUserCode(), UploadConstant.PDF, UploadConstant.CONTRACT));
		CommonConstant.FRAMEWORK.info(MessageFormat.format(PDF_MESSAGE, bidInfo.getBid().getCode(), pdf_uri));
		// 设置pdf
		bidInfo.getBidContract().setPdf(pdf_uri);

//		// 预存款单编号
//		bidInfo.getBidContract().setDepositBillNumber(result.getBody().getDepositBillNumber());
//		// 生成upload明细
//		String depositBill_uri = uploadService.saveFileUploadDetail(result.getBody().getDepositFileId(),
//				UploadConstant.CONTAINER_NAME_DEFAULT,
//				uploadService.getPrefix(bidInfo.getBid().getUserCode(), UploadConstant.PDF, UploadConstant.DEPOSIT_BILL));
//
//		// 预存款单pdf
//		bidInfo.getBidContract().setDepositBillPdf(depositBill_uri);
		bidInfo.getBidContract().setDepositBillNumber("222222222");
		String tmp = "fileID=5b15c15d5b6f03ce90e96e5c3cab833fbe819e7ce3297208d1fbc91ce6ec00bd66994f119b191b45&fileName=15a4fa5db3a393cc2f80e59340eabfb9ecb00d1f5cf2043dfcbdd1c9260913db1ea76abb3ea220b2a119432727ca794b&size=0,0";
		bidInfo.getBidContract().setDepositBillPdf(tmp);
	}

	/***************************************************************************/

	@Override
	public void nonStandardSubmit(List<BidInfo> bidInfos) {
		List<HdContract> vos = new ArrayList<>();
		// 转换为hdContracts
		convert2HdContracts(vos, bidInfos);
		// 非标准出价
		HdResult<HdContractNonStandardResult> result = hdContractNonStandardSubmitService.nonstandardSubmit(vos);
		// 校对返回结果
		checkResult(result);
		// 转换成map
		Map<String, BidInfo> map = new HashMap<>();
		for (BidInfo bidInfo : bidInfos) {
			map.put(bidInfo.getBid().getCode(), bidInfo);
		}
		for (HdContractNonStandardResultDetail detail : result.getBody().getDetails()) {
			BidInfo tmp = map.get(detail.getContractId());
			// 设置单据号
			tmp.getBid().setBillNumber(detail.getBillNumber());

			// 生成upload明细
			String uri = uploadService.saveFileUploadDetail(detail.getFileId(), UploadConstant.CONTAINER_NAME_DEFAULT,
					uploadService.getPrefix(tmp.getBid().getUserCode(), UploadConstant.PDF,
							UploadConstant.CONTRACT));
			CommonConstant.FRAMEWORK.info(MessageFormat.format(PDF_MESSAGE, tmp.getBid().getCode(), uri));
			// 设置pdf
			tmp.getBidContract().setPdf(uri);
		}

	}
}
