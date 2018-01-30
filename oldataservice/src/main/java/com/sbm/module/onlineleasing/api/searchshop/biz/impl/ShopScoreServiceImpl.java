package com.sbm.module.onlineleasing.api.searchshop.biz.impl;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.sbm.module.onlineleasing.base.mall.biz.ITOLMallService;
import com.sbm.module.onlineleasing.base.shopimages.biz.ITOLShopImagesService;
import com.sbm.module.onlineleasing.base.shopimages.domain.TOLShopImages;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.base.util.dateutil.DateParseUtil;
import com.sbm.module.common.base.util.dateutil.DifferentDays;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.searchshop.biz.IShopScoreService;
import com.sbm.module.onlineleasing.api.searchshop.domain.SearchShop;
import com.sbm.module.onlineleasing.api.searchshop.domain.SearchShopVo;
import com.sbm.module.onlineleasing.api.searchshop.domain.ShopScore;
import com.sbm.module.onlineleasing.base.brand.biz.ITOLBrandService;
import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;
import com.sbm.module.onlineleasing.base.modality.biz.ITOLModalityService;
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
public class ShopScoreServiceImpl extends BusinessServiceImpl implements IShopScoreService {

	@Autowired
	private ITOLShopService shopService;
	@Autowired
	private ITOLBrandService brandService;
	@Autowired
	private ITOLShopImagesService shopImagesService;
	@Autowired
	private ITOLMallService mallService;


	@Value("#{propertiesReader['application.ShopScoreServiceImpl.max']}")
	private String max;

	public void calShopScore(SearchShop searchShop) {
		List<ShopScore> shopScores = new ArrayList<ShopScore>();
		ShopScore shopScore;
		// 查出对应品牌
		TOLBrand brand = brandService.findByCode(searchShop.getVo().getBrandCode());
		// 查询出所有店铺
		List<TOLShop> shops = shopService.findAllBySearchShop(searchShop.getVo());
		// 设置开始日期
		searchShop.getVo().setStartDate(DateParseUtil.parse_yyyy_MM_dd(searchShop.getVo().getStart()));

		// 计算商铺得分
		for (TOLShop shop : shops) {
			shopScore = new ShopScore();
			calScore(searchShop.getVo(), brand, shop, shopScore);
			shopScores.add(shopScore);
		}
		// 商铺得分排序
		sort(shopScores);
		// 计算排序得分
		calcSortScore(shopScores);
		// 取前N条数据
		if (shopScores.size() > Integer.valueOf(max)) {
			shopScores = subScoreList(shopScores, Integer.valueOf(max));
		}
		// 商铺第一张图片
		setShopFirstImage(shopScores);
		// 设置列表
		searchShop.setShopScores(shopScores);
	}

	/**
	 * 商铺第一张图片
	 * @param shopScores
	 */
	private void setShopFirstImage(List<ShopScore> shopScores) {
		for (ShopScore shopScore : shopScores) {
			// 商铺第一张图片
			List<TOLShopImages> shopImages = shopImagesService.findAllByCode(shopScore.getShop().getCode());
			if (null != shopImages && !shopImages.isEmpty()) {
				shopScore.getShop().setFirstImage(shopImages.get(0).getImage());
			} else {
				// 如果商铺图片不存在，返回mall图片
				shopScore.getShop().setFirstImage(mallService.findByCode(shopScore.getShop().getMallCode()).getImg());
			}
		}
	}

	/*********************************************************************/

	/**
	 * 
	 * subScoreList:选取前N条数据
	 * 
	 * @author junkai.zhang
	 * @param shopScores
	 * @param toIndex
	 * @return
	 */
	private List<ShopScore> subScoreList(List<ShopScore> shopScores, Integer toIndex) {
		return shopScores.subList(0, toIndex);
	}

	/**
	 * 
	 * calcSortScore:计算排序得分
	 * 
	 * @author junkai.zhang
	 * @param shopScores
	 */
	private void calcSortScore(List<ShopScore> shopScores) {
		for (int i = 0; i < shopScores.size(); i++) {
			CommonConstant.FRAMEWORK.debug("##################################################");
			// ShopScore
			ShopScore shopScore = shopScores.get(i);

			CommonConstant.FRAMEWORK.debug(MessageFormat.format("原始得分 : {0} ; 序号 : {1}, 总条数 : {2}",
					shopScore.getScore(), i, shopScores.size()));

			BigDecimal score = new BigDecimal(100);
			score = (score.multiply(new BigDecimal(shopScores.size()).subtract(new BigDecimal(i)))).divide(
					new BigDecimal(shopScores.size()), 2, BigDecimal.ROUND_HALF_DOWN);
			// 取整
			score = score.setScale(0, BigDecimal.ROUND_HALF_UP);
			shopScore.setScore(score);

			CommonConstant.FRAMEWORK.debug(MessageFormat.format("计算后得分 : {0} ", score));
			CommonConstant.FRAMEWORK.debug("##################################################");
		}
	}

	/**
	 * 
	 * sort:排序
	 * 
	 * @author junkai.zhang
	 * @param shopScores
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void sort(List<ShopScore> shopScores) {
		Collections.sort(shopScores, new Comparator() {
			@Override
			public int compare(Object a, Object b) {
				BigDecimal score1 = ((ShopScore) a).getScore();
				BigDecimal score2 = ((ShopScore) b).getScore();
				return score2.compareTo(score1);
			}
		});
	}

	/*********************************************************************/

	/**
	 * 
	 * calScore:计算商铺得分
	 * 
	 * @author junkai.zhang
	 * @param vo
	 * @param brand
	 * @param shop
	 * @param shopScore
	 */
	private void calScore(SearchShopVo vo, TOLBrand brand, TOLShop shop, ShopScore shopScore) {
		CommonConstant.FRAMEWORK.debug("##################################################");
		// 修改业态（不修改，页面上处理）
		// shop.setModality(modalityService.getModalityName(modalityService.findByJdeId(shop.getModality())));
		// 设置商铺
		shopScore.setShop(shop);
		// 计算得分
		BigDecimal score = new BigDecimal(0);
		// 计算业态得分
		score = score.add(calModality(brand, shop));
		// 计算面积得分
		score = score.add(calArea(vo, shop));
		// 计算日期得分
		score = score.add(calDate(vo, shop));
		// 取整
		score = score.setScale(0, BigDecimal.ROUND_HALF_UP);
		shopScore.setScore(score);

		CommonConstant.FRAMEWORK.debug(MessageFormat.format("total score : {0}", score));
		CommonConstant.FRAMEWORK.debug("##################################################");
	}

	/*********************************************************************/

	/**
	 * 
	 * calModality:计算业态得分
	 * 
	 * @author junkai.zhang
	 * @param brand
	 * @param shop
	 * @return
	 */
	private BigDecimal calModality(TOLBrand brand, TOLShop shop) {
		CommonConstant.FRAMEWORK.debug("**************************************************");
		CommonConstant.FRAMEWORK.debug("method : calModality");
		CommonConstant.FRAMEWORK.debug(MessageFormat.format("brand modality_2 : {0} ; shop modality : {1}",
				brand.getModality_2(), shop.getModality()));

		BigDecimal score = new BigDecimal(0);
		// 取二级业态作比较
		String brandModality = brand.getModality_2();
		String shopModality = shop.getModality();
		// 商铺业态不为空
		if (StringUtils.isNotEmpty(shopModality)) {
			// 二级业态，相等100分
			if (brandModality.equals(shopModality)) {
				score = score.add(new BigDecimal(100));
			}
			// 一级业态，相等50分
			else if ((brandModality.substring(0, brandModality.length() - 1)).equals(shopModality.substring(0,
					shopModality.length() - 1))) {
				score = score.add(new BigDecimal(50));
			}
			// 零售非零售，相等10分
			else if ((brandModality.substring(0, brandModality.length() - 2)).equals(shopModality.substring(0,
					shopModality.length() - 2))) {
				score = score.add(new BigDecimal(10));
			}
			// 都不相等，0分
			else {
				score = score.add(new BigDecimal(0));
			}
		}
		// 商铺业态为空则，100分
		else {
			score = score.add(new BigDecimal(100));
		}
		// 占比40%
		score = score.multiply(new BigDecimal(0.4));
		CommonConstant.FRAMEWORK.debug("score : " + score);
		CommonConstant.FRAMEWORK.debug("**************************************************");
		return score;
	}

	/*********************************************************************/

	/**
	 * 
	 * calArea:计算面积得分
	 * 
	 * @author junkai.zhang
	 * @param vo
	 * @param shop
	 * @return
	 */
	private BigDecimal calArea(SearchShopVo vo, TOLShop shop) {
		CommonConstant.FRAMEWORK.debug("**************************************************");
		CommonConstant.FRAMEWORK.debug("method : calArea");
		CommonConstant.FRAMEWORK.debug(MessageFormat.format("min area : {0} ; max area : {1} ; shop area : {2}",
				vo.getMinArea(), vo.getMaxArea(), shop.getArea()));

		BigDecimal score = new BigDecimal(0);
		// -1 最小面积小于商店店铺
		Integer min = new BigDecimal(vo.getMinArea()).compareTo(shop.getArea());
		// 1 最大面积大于商店店铺
		Integer max = new BigDecimal(vo.getMaxArea()).compareTo(shop.getArea());
		// 范围内，100分
		if (-1 == min && 1 == max) {
			score = score.add(new BigDecimal(100));
		}
		// 范围外，0分
		else {
			score = score.add(new BigDecimal(0));
		}

		// 占比10%
		score = score.multiply(new BigDecimal(0.1));
		CommonConstant.FRAMEWORK.debug("score : " + score);
		CommonConstant.FRAMEWORK.debug("**************************************************");
		return score;
	}

	/*********************************************************************/

	/**
	 * 
	 * calDate:计算日期得分
	 * 
	 * @author junkai.zhang
	 * @param vo
	 * @param shop
	 * @return
	 */
	private BigDecimal calDate(SearchShopVo vo, TOLShop shop) {
		CommonConstant.FRAMEWORK.debug("**************************************************");
		CommonConstant.FRAMEWORK.debug("method : calDate");

		BigDecimal score = new BigDecimal(0);
		// 最早可入住日期
		Date earliestDate = getEarliestDate(shop);
		// 店铺状态是空铺
		if (1 == shop.getShopState()) {
			CommonConstant.FRAMEWORK.debug(MessageFormat.format("start : {0} ; earliestDate : {1} ; 店铺状态是空铺",
					vo.getStartDate(), earliestDate));
			// 满分
			score = score.add(new BigDecimal(100));
		}
		// 店铺状态是待租
		else {
			// 最早可入住时间或者开始时间为空（异常数据）
			if (null == earliestDate || null == vo.getStartDate()) {
				CommonConstant.FRAMEWORK.debug(MessageFormat.format(
						"start : {0} ; earliestDate : {1} ; 最早可入住时间或者开始时间为空（异常数据）", vo.getStartDate(), earliestDate));
				// 0分
				score = score.add(new BigDecimal(0));
			} else {
				// 相差天数
				Integer diffDays = getDiffDays(earliestDate, vo.getStartDate());
				CommonConstant.FRAMEWORK
						.debug(MessageFormat.format("start : {0} ; earliestDate : {1} ; diffDays ： {2}",
								vo.getStartDate(), earliestDate, diffDays));
				// 相差0天，100分
				if (0 == diffDays) {
					score = score.add(new BigDecimal(100));
				}
				// 相差N天，1/N * 100 分 = 100/N 分
				else {
					BigDecimal tmp = new BigDecimal(100)
							.divide(new BigDecimal(diffDays), 2, BigDecimal.ROUND_HALF_DOWN);
					score = score.add(tmp);
				}
			}

		}

		// 占比50%
		score = score.multiply(new BigDecimal(0.5));
		CommonConstant.FRAMEWORK.debug("score : " + score);
		CommonConstant.FRAMEWORK.debug("**************************************************");
		return score;
	}

	/**
	 * 
	 * getEarliestDate:最早可入住日期
	 * 
	 * @author junkai.zhang
	 * @param shop
	 * @return
	 */
	private Date getEarliestDate(TOLShop shop) {
		Date earliestDate = shop.getContractExpireDate();
		if (null != earliestDate) {
			// 合同结束日期+1天
			earliestDate = DifferentDays.addNdays(earliestDate, 1);
		}
		// 不取当前日期
		// else {
		// // 当天
		// earliestDate = new Date();
		// }
		return earliestDate;
	}

	/**
	 * 
	 * getDiffDays:相差天数
	 * 
	 * @author junkai.zhang
	 * @param d1
	 * @param d2
	 * @return
	 */
	private Integer getDiffDays(Date d1, Date d2) {
		Integer diffDays = null;
		if (d1.before(d2)) {
			diffDays = DifferentDays.differentDays(d1, d2);
		} else {
			diffDays = DifferentDays.differentDays(d2, d1);
		}
		return diffDays;
	}
}
