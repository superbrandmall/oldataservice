package com.sbm.module.onlineleasing.api.bidcontract.biz.impl;

import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.onlineleasing.base.biddetail.biz.ITOLBidDetailService;
import com.sbm.module.onlineleasing.base.brand.biz.ITOLBrandService;
import com.sbm.module.onlineleasing.base.merchant.biz.ITOLMerchantService;
import com.sbm.module.onlineleasing.base.shop.biz.ITOLShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.IThreadSleepExecuteCallBack;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.bid.domain.BidInfo;
import com.sbm.module.onlineleasing.api.bidcontract.biz.IContractPreviewService;
import com.sbm.module.onlineleasing.base.bid.biz.ITOLBidService;
import com.sbm.module.onlineleasing.base.bid.constant.BidConstant;
import com.sbm.module.onlineleasing.base.bid.domain.TOLBid;
import com.sbm.module.onlineleasing.base.bidcontract.biz.ITOLBidContractService;
import com.sbm.module.onlineleasing.base.bidcontract.domain.TOLBidContract;
import com.sbm.module.partner.hd.rest.contract.base.biz.IHdContractService;

/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.biz.impl<br/>
 * File Name:EdiInteractiveDetailServiceImpl.java<br/>
 * <p>
 * 作成日 ：2016-1-4 下午5:05:55 <br/>
 *
 * @author ：junkai.zhang
 */
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
public class ContractPreviewServiceImpl extends BusinessServiceImpl implements IContractPreviewService {

	@Autowired
	private ITOLShopService shopService;
	@Autowired
	private ITOLMerchantService merchantService;
	@Autowired
	private ITOLBrandService brandService;

	@Autowired
	private ITOLBidService bidService;
	@Autowired
	private ITOLBidDetailService bidDetailService;
	@Autowired
	private ITOLBidContractService bidContractService;
	@Autowired
	private IHdContractService hdContractService;

	public void createContractPreview(BidInfo bidInfo) {
		// 设置bid状态 预览合同生成
		// 多线程防止事务未提交
		TOLBid bid = findByCode(bidInfo.getBid().getCode());
		// 出价主体
		bidInfo.setBid(bid);
		// 出价明细
		bidInfo.setBidDetails(bidDetailService.findAllByCode(bidInfo.getBid().getCode()));
		// 查询出原有的合同
		TOLBidContract bidContract = bidContractService.findByCode(bidInfo.getBid().getCode());
		// 商户
		bidInfo.setMerchant(merchantService.findByCode(bidInfo.getBid().getMerchantCode()));
		// 品牌
		bidInfo.setBrand(brandService.findByCode(bidInfo.getBid().getBrandCode()));
		// 商铺
		bidInfo.setShop(shopService.findByCode(bidInfo.getBid().getShopCode()));

		try {
			// 不存在出价合同，调用接口，保存记录
			if (null == bidContract) {
				bidContract = new TOLBidContract();
				bidInfo.setBidContract(bidContract);
				// 设置code
				bidContract.setCode(bidInfo.getBid().getCode());
				// 设置pdfTemp
				hdContractService.preview(bidInfo);
				// 保存
				bidContractService.save(bidContract);
			}
			// 存在出价合同，挑用接口，修改记录
			else {
				bidInfo.setBidContract(bidContract);
				// 设置pdfTemp
				hdContractService.preview(bidInfo);
				// 更新
				bidContractService.update(bidContract);
			}
			bid.setProcessState(BidConstant.PREVIEW_CONTRACT_CREATED);
		} catch (Exception e) {
			// 预览合同生成失败
			bidInfo.getBid().setProcessState(BidConstant.PREVIEW_CONTRACT_FAILURE);
			CommonConstant.ERRORDATA.error(bidInfo, e);
		}
		bidService.update(bid);
	}

	/***********************************************************/

	/**
	 *
	 * findByCode:多线程处理防止事务未提交
	 *
	 * @author junkai.zhang
	 * @param code
	 * @return
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
