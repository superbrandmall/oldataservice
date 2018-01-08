package com.sbm.module.onlineleasing.api.admin.bid.biz.impl;

import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.common.business.util.ParamsUtil;
import com.sbm.module.onlineleasing.api.admin.bid.biz.IBidVoService;
import com.sbm.module.onlineleasing.api.admin.bid.domain.BidVo;
import com.sbm.module.onlineleasing.api.admin.mall.biz.IMallVoService;
import com.sbm.module.onlineleasing.api.admin.mall.domain.MallVo;
import com.sbm.module.onlineleasing.base.bid.biz.ITOLBidService;
import com.sbm.module.onlineleasing.base.bid.domain.TOLBid;
import com.sbm.module.onlineleasing.base.bidcontract.biz.ITOLBidContractService;
import com.sbm.module.onlineleasing.base.biddetail.biz.ITOLBidDetailService;
import com.sbm.module.onlineleasing.base.brand.biz.ITOLBrandService;
import com.sbm.module.onlineleasing.base.mall.biz.ITOLMallService;
import com.sbm.module.onlineleasing.base.mallbidstandard.biz.ITOLMallBidStandardService;
import com.sbm.module.onlineleasing.base.malltraffic.biz.ITOLMallTrafficService;
import com.sbm.module.onlineleasing.base.merchant.biz.ITOLMerchantService;
import com.sbm.module.onlineleasing.base.shop.biz.ITOLShopService;
import com.sbm.module.onlineleasing.base.shop.domain.TOLShop;
import com.sbm.module.onlineleasing.base.user.biz.ITOLUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
public class BidVoServiceImpl extends BusinessServiceImpl implements IBidVoService {

	@Autowired
	private ITOLBidService bidService;
	@Autowired
	private ITOLBidDetailService bidDetailService;
	@Autowired
	private ITOLBidContractService bidContractService;

	@Autowired
	private ITOLUserService userService;
	@Autowired
	private ITOLMerchantService merchantService;
	@Autowired
	private ITOLShopService shopService;
	@Autowired
	private ITOLBrandService brandService;

	private void convert(TOLBid bid) {
		// email
		bid.setEmail(userService.findByCode(bid.getUserCode()).getEmail());
		// 商户名称
		bid.setMerchantName(merchantService.findByCode(bid.getMerchantCode()).getName());

		TOLShop shop = shopService.findByCode(bid.getShopCode());
		// unit
		bid.setUnit(shop.getUnit());
		// 项目名称
		bid.setMallName(shop.getMallName());
		// 建筑物名称
		bid.setBuildingName(shop.getBuildingName());
		// 楼层
		bid.setFloorName(shop.getFloorName());

		// 品牌名称
		bid.setBrandName(brandService.findByCode(bid.getBrandCode()).getName());
	}

	/******************************************************************************************/

	public void findAllByConditionPage(BidVo vo) {
		Pagination<TOLBid> pagination = bidService.findAllByConditionPage(vo.getBid());
		for (TOLBid bid : pagination.getDetails()) {
			convert(bid);
		}
		vo.setPagination(pagination);
	}

	/******************************************************************************************/

	@Override
	public void findByCode(BidVo vo) {
		TOLBid bid = bidService.findByCode(vo.getBid().getCode());
		if (null != bid) {
			convert(bid);
			vo.setBid(bid);
			vo.setDetails(bidDetailService.findAllByCode(bid.getCode()));
			vo.setContract(bidContractService.findByCode(bid.getCode()));
		}
	}

	/******************************************************************************************/

}
