package com.sbm.module.onlineleasing.api.interactive.bidresult.biz.impl;

import java.util.List;

import com.sbm.module.onlineleasing.base.shop.biz.ITOLShopService;
import com.sbm.module.onlineleasing.base.shop.constant.ShopConstant;
import com.sbm.module.onlineleasing.base.shop.domain.TOLShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.util.ParamsUtil;
import com.sbm.module.onlineleasing.api.interactive.bidresult.biz.IBidResultReceiveService;
import com.sbm.module.onlineleasing.api.interactive.bidresult.domain.BidResultReceive;
import com.sbm.module.onlineleasing.api.interactive.bidresult.domain.BidResultReceiveVo;
import com.sbm.module.onlineleasing.api.upload.biz.IUploadService;
import com.sbm.module.onlineleasing.api.upload.constant.UploadConstant;
import com.sbm.module.onlineleasing.base.bid.biz.ITOLBidService;
import com.sbm.module.onlineleasing.base.bid.constant.BidConstant;
import com.sbm.module.onlineleasing.base.bid.domain.TOLBid;
import com.sbm.module.onlineleasing.base.bidcontract.biz.ITOLBidContractService;
import com.sbm.module.onlineleasing.base.bidcontract.domain.TOLBidContract;

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
public class BidResultReceiveServiceImpl extends BusinessServiceImpl implements IBidResultReceiveService {

	@Autowired
	private ITOLBidService service;
	@Autowired
	private ITOLBidContractService contractService;
	@Autowired
	private IUploadService uploadService;

	@Autowired
	private ITOLShopService shopService;

	/**
	 * 
	 * checkBid:检查出价
	 * 
	 * @author junkai.zhang
	 * @param billNumber
	 * @param po
	 */
	private void checkBid(String billNumber, TOLBid po) {
		// 查不到bid
		if (null == po) {
			throw new BusinessException(BusinessCode.C11203, new Object[] { billNumber }, null);
		}
	}

	/************************************************************************************************/

	public void approve(BidResultReceiveVo vo) {
		List<BidResultReceive> bidResultReceives = vo.getBidResultReceives();
		for (BidResultReceive obj : bidResultReceives) {
			// 判断非空
			ParamsUtil.canNotBeEmpty(obj.getBid().getBillNumber());
			ParamsUtil.canNotBeNull(obj.getBid().getIsApprove());
			// 查询bid
			TOLBid po = service.findByBillNumber(obj.getBid().getBillNumber());
			// 检查出价
			checkBid(obj.getBid().getBillNumber(), po);
			// 审批通过
			if (BidConstant.APPROVE.equals(obj.getBid().getIsApprove())) {
				po.setIsApprove(obj.getBid().getIsApprove());
				// 合同过期日期
				if (null != obj.getBid().getExpireDate()) {
					po.setExpireDate(obj.getBid().getExpireDate());
				} else {
					throw new BusinessException(BusinessCode.C11200, new Object[] { obj.getBid().getBillNumber() },
							null);
				}
				// 判断非空
				ParamsUtil.canNotBeEmpty(obj.getBidContract().getDepositBillNumber());
				ParamsUtil.canNotBeEmpty(obj.getBidContract().getFileId());
				// 预存款单编号
				TOLBidContract bidContract = contractService.findByCode(po.getCode());
				bidContract.setDepositBillNumber(obj.getBidContract().getDepositBillNumber());
				// 生成upload明细
				String uri = uploadService.saveFileUploadDetail(obj.getBidContract().getFileId(),
						UploadConstant.CONTAINER_NAME_DEFAULT,
						uploadService.getPrefix(po.getUserCode(), UploadConstant.PDF, UploadConstant.DEPOSIT_BILL));

				// pdf
				bidContract.setDepositBillPdf(uri);
				contractService.update(bidContract);
			}
			// 审批不通过
			else if (BidConstant.REJECT.equals(obj.getBid().getIsApprove())) {
				po.setIsApprove(obj.getBid().getIsApprove());
			}
			// 未知状态
			else {
				throw new BusinessException(BusinessCode.C11201, new Object[] { obj.getBid().getBillNumber(),
						obj.getBid().getIsApprove() }, null);
			}
			// 审批结束
			po.setProcessState(BidConstant.END_OF_APPROVAL);
			// 更新记录
			service.update(po);
			// TODO 各种事件
		}
	}

	/************************************************************************************************/

	public void effect(BidResultReceiveVo vo) {
		List<BidResultReceive> bidResultReceives = vo.getBidResultReceives();
		for (BidResultReceive obj : bidResultReceives) {
			// 判断非空
			ParamsUtil.canNotBeEmpty(obj.getBid().getBillNumber());
			ParamsUtil.canNotBeNull(obj.getBid().getIsEffect());
			// 查询bid
			TOLBid po = service.findByBillNumber(obj.getBid().getBillNumber());
			// 检查出价
			checkBid(obj.getBid().getBillNumber(), po);
			// 生效
			if (BidConstant.EFFECTIVE.equals(obj.getBid().getIsEffect())) {
				po.setIsEffect(obj.getBid().getIsEffect());

				// 合同生效时，更新铺位
				TOLShop shop = shopService.findByCode(po.getShopCode());
				// 更新铺位状态为在租
				shop.setShopState(ShopConstant.SHOP_STATE_0);
				// 更新最后一份合同到期日为本合同到期日
				shop.setContractExpireDate(po.getEndDate());
				// 商铺品牌
				shop.setBrandCode(po.getBrandCode());
				shopService.update(shop);
			}
			// 不生效
			else if (BidConstant.INVAILD.equals(obj.getBid().getIsEffect())) {
				po.setIsEffect(obj.getBid().getIsEffect());
			}
			// 未知状态
			else {
				throw new BusinessException(BusinessCode.C11202, new Object[] { obj.getBid().getBillNumber(),
						obj.getBid().getIsEffect() }, null);
			}
			// 更新记录
			service.update(po);

			// TODO 各种事件
		}

	}

}
