package com.sbm.module.onlineleasing.api.searchshop.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.base.util.dateutil.DateParseUtil;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.api.searchshop.biz.ISearchShopService;
import com.sbm.module.onlineleasing.api.searchshop.biz.IShopScoreService;
import com.sbm.module.onlineleasing.api.searchshop.domain.SearchShop;
import com.sbm.module.onlineleasing.api.searchshop.domain.SearchShopVo;
import com.sbm.module.onlineleasing.base.brand.biz.ITOLBrandService;
import com.sbm.module.onlineleasing.base.mall.biz.ITOLMallService;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;
import com.sbm.module.onlineleasing.base.searchshopdetail.biz.ITOLSearchShopDetailService;
import com.sbm.module.onlineleasing.base.searchshopdetail.domain.TOLSearchShopDetail;

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
public class SearchShopServiceImpl extends BusinessServiceImpl implements ISearchShopService {

	@Autowired
	private IShopScoreService shopScoreService;
	@Autowired
	private ITOLSearchShopDetailService searchShopDetailService;
	@Autowired
	private ITOLMallService mallService;
	@Autowired
	private ITOLBrandService brandService;

	/********************************************************************/
	// 查询推荐店铺

	public void getDetails(SearchShop searchShop) {
		// 计算商铺评分
		shopScoreService.calShopScore(searchShop);
		// 保存查询结果
		TOLSearchShopDetail searchShopDetail = new TOLSearchShopDetail();
		convert2searchShopDetail(searchShop.getVo(), searchShopDetail);
		searchShopDetailService.saveSearchShopDetail(searchShopDetail);
		// 将查询结果code返回给前端
		searchShop.getVo().setCode(searchShopDetail.getCode());
	}

	/**
	 * 
	 * convert2searchShopDetail:将searchShop转换为searchShopDetail
	 * 
	 * @author junkai.zhang
	 * @param vo
	 * @param searchShopDetail
	 */
	private void convert2searchShopDetail(SearchShopVo vo, TOLSearchShopDetail searchShopDetail) {
		// 用户code
		searchShopDetail.setUserCode(vo.getUserCode());
		// 品牌code
		searchShopDetail.setBrandCode(vo.getBrandCode());
		// 最小面积
		searchShopDetail.setMinArea(vo.getMinArea());
		// 最大面积
		searchShopDetail.setMaxArea(vo.getMaxArea());
		// 开始日期转换
		searchShopDetail.setStart(DateParseUtil.parse_yyyy_MM_dd(vo.getStart()));
		// 结束日期转换
		searchShopDetail.setEnd(DateParseUtil.parse_yyyy_MM_dd(vo.getEnd()));
		// 商场codes
		searchShopDetail.setMallCodes(JSON.toJSONString(vo.getMallCodes()));
	}

	/********************************************************************/
	// 查询历史记录

	public void getHistories(SearchShop searchShop) {
		Pagination<TOLSearchShopDetail> pagination = searchShopDetailService
				.findAllBySearchShopPage(searchShop.getVo());
		Pagination<SearchShopVo> histories = getPagination();
		// 转换
		convertPagination(pagination, histories);
		searchShop.setHistories(histories);
	}

	/**
	 * 
	 * convertPagination:将Pagination<TOLSearchShopDetail>转换为Pagination<
	 * SearchShopVo>
	 * 
	 * @author junkai.zhang
	 * @param pagination
	 * @param histories
	 */
	private void convertPagination(Pagination<TOLSearchShopDetail> pagination, Pagination<SearchShopVo> histories) {
		histories.setTotalCount(pagination.getTotalCount());
		List<SearchShopVo> details = new ArrayList<SearchShopVo>();
		SearchShopVo vo = null;
		for (TOLSearchShopDetail searchShopDetail : pagination.getDetails()) {
			vo = new SearchShopVo();
			convert2searchShopVo(searchShopDetail, vo);
			details.add(vo);
		}
		histories.setDetails(details);
	}

	/**
	 * 
	 * convert2searchShopVo:将searchShopDetail转换为vo
	 * 
	 * @author junkai.zhang
	 * @param vo
	 * @param searchShopDetail
	 */
	private void convert2searchShopVo(TOLSearchShopDetail searchShopDetail, SearchShopVo vo) {
		// 查询记录code
		vo.setCode(searchShopDetail.getCode());
		// 用户code
		vo.setUserCode(searchShopDetail.getUserCode());
		// 品牌code
		vo.setBrandCode(searchShopDetail.getBrandCode());
		// 品牌名称
		vo.setBrandName(brandService.findByCode(searchShopDetail.getBrandCode()).getName());
		// 最小面积
		vo.setMinArea(searchShopDetail.getMinArea());
		// 最大面积
		vo.setMaxArea(searchShopDetail.getMaxArea());
		// 开始日期转换
		vo.setStart(DateParseUtil.format_yyyy_MM_dd(searchShopDetail.getStart()));
		// 结束日期转换
		vo.setEnd(DateParseUtil.format_yyyy_MM_dd(searchShopDetail.getEnd()));
		// 商场codes
		List<String> list = JSON.parseArray(searchShopDetail.getMallCodes(), String.class);
		List<TOLMall> malls = new ArrayList<TOLMall>();
		for (String code : list) {
			TOLMall mall = mallService.findByCode(code);
			if (null != mall) {
				malls.add(mall);
			}
		}
		vo.setMalls(malls);
		// 创建时间
		vo.setCreated(searchShopDetail.getCreated());
	}

}
