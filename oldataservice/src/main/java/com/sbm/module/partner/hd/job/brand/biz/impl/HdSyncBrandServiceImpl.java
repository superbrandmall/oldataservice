package com.sbm.module.partner.hd.job.brand.biz.impl;

import java.text.MessageFormat;

import com.sbm.module.onlineleasing.base.brand.constant.BrandConstant;
import com.sbm.module.onlineleasing.base.tempparam.biz.ITOLTempParamService;
import com.sbm.module.onlineleasing.base.tempparam.constant.TempParamConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.onlineleasing.base.brand.biz.ISyncBrandService;
import com.sbm.module.onlineleasing.base.brand.biz.ITOLBrandService;
import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;
import com.sbm.module.partner.hd.job.base.biz.impl.HdSyncServiceImpl;
import com.sbm.module.partner.hd.job.base.domain.HdSyncDetail;
import com.sbm.module.partner.hd.rest.base.domain.HdResult;
import com.sbm.module.partner.hd.rest.base.domain.HdResultBody;
import com.sbm.module.partner.hd.rest.base.domain.QueryFilter;
import com.sbm.module.partner.hd.rest.brand.biz.IHdBrandService;
import com.sbm.module.partner.hd.rest.brand.domain.HdBrand;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.job.sync.mall.biz.impl<br/>
 * File Name:HdSyncMallServiceImpl.java<br/>
 * 
 * 作成日 ：2017-10-11 下午1:29:23 <br/>
 * 
 * @author ：junkai.zhang
 */
@Component("hdSyncBrandServiceImpl")
public class HdSyncBrandServiceImpl extends HdSyncServiceImpl implements ISyncBrandService {

	private static final String BIZTYPE_MESSAGE = "biztype is missing, brandUuid:{0}";
	private static final String BIZTYPE_LENGTH_MESSAGE = "biztype.length != {0}, brandUuid:{1}, biztype:{2}";

	private static final Integer LENGTH = 8;

	@Autowired
	private ITOLBrandService service;
	@Autowired
	private ITOLTempParamService tempParamService;

	@Autowired
	private IHdBrandService hdBrandService;

	public void sync() {
		// 查询条件
		QueryFilter queryFilter = new QueryFilter();
		queryFilter.getFilter().put("type", "merchant");
		// 第一次查询
		HdResult<HdResultBody<HdBrand>> result = query(queryFilter);
		// 遍历查询
		for (int i = 1; i < result.getBody().getPageCount(); i++) {
			queryFilter.setPage(i);
			query(queryFilter);
		}
	}

	private HdResult<HdResultBody<HdBrand>> query(QueryFilter queryFilter) {
		HdSyncDetail<TOLBrand> detail = getSyncDetail();
		HdResult<HdResultBody<HdBrand>> result = hdBrandService.query(queryFilter);
		// 校对返回结果
		checkResult(result);
		// 遍历结果
		for (HdBrand obj : result.getBody().getRecords()) {
			TOLBrand po = service.findByHdUuid(obj.getUuid());
			// 不存在新增
			if (null == po) {
				po = new TOLBrand();
				convert(po, obj);
				service.saveBrand(po);
				detail.getInsertList().add(po);
			}
			// 存在更新
			else {
				convert(po, obj);
				service.update(po);
				detail.getUpdateList().add(po);
			}
		}
		log(detail, result, HdBrand.class);
		return result;
	}

	/**
	 * 
	 * convert:转换
	 * 
	 * @author junkai.zhang
	 * @param po
	 * @param obj
	 */
	private void convert(TOLBrand po, HdBrand obj) {
		// 海鼎uuid
		po.setHdUuid(obj.getUuid());
		// 海鼎编码
		po.setHdCode(obj.getCode());
		// 名称
		po.setName(obj.getName());
		// 英文名称
		po.setNameEng(obj.getForeignName());
		// 海鼎状态
		po.setHdState(obj.getState());

		// 业态3
		if (null != obj.getBizType()) {
			if (StringUtils.isNotBlank(obj.getBizType().getCode()) && obj.getBizType().getCode().length() == LENGTH) {
				po.setModality_1(obj.getBizType().getCode().substring(0, 4));
				po.setModality_2(obj.getBizType().getCode().substring(0, 6));
				po.setModality_3(obj.getBizType().getCode());
			} else {
				CommonConstant.FRAMEWORK.warn(MessageFormat.format(BIZTYPE_LENGTH_MESSAGE, LENGTH, obj.getUuid(), obj.getBizType().getCode()));
			}
		} else {
			CommonConstant.FRAMEWORK.warn(MessageFormat.format(BIZTYPE_MESSAGE, obj.getUuid()));
		}
		// 城市
		po.setCity(obj.getLocal());

		if (null != obj.getProperties()) {
			// 品牌属性
			po.setAttribute(tempParamService.findByParamAndValue(TempParamConstant.attribute, obj.getProperties().getIntroductions()).getKey());
			// 品牌价位
			po.setBrandClass(tempParamService.findByParamAndValue(TempParamConstant.brandClass, obj.getProperties().getBrandGrade()).getKey());
			// 标准店面积
			po.setStandardArea(tempParamService.findByParamAndValue(TempParamConstant.standardArea, obj.getProperties().getAreaLow()).getKey());
			// 主要客户群
			po.setTarget(tempParamService.findByParamAndValue(TempParamConstant.target, obj.getProperties().getTarget()).getKey());
			// 开店区域
			po.setLocation(tempParamService.findByParamAndValue(TempParamConstant.location, obj.getProperties().getLocation()).getKey());
			// 当前已开店数
			po.setShopAmount(tempParamService.findByParamAndValue(TempParamConstant.shopAmount, obj.getProperties().getShopCount()).getKey());
			// 品牌发展历史
			po.setHistory(tempParamService.findByParamAndValue(TempParamConstant.history, obj.getProperties().getHistory()).getKey());
			// 口碑
			po.setReputation(tempParamService.findByParamAndValue(TempParamConstant.reputation, obj.getProperties().getReputation()).getKey());
			// 是否有旗下品牌已入驻
			po.setJoined(tempParamService.findByParamAndValue(TempParamConstant.joined, obj.getProperties().getJoined()).getKey());
			// 是否有意进驻正大其它门店
			po.setJoinOtherMall(tempParamService.findByParamAndValue(TempParamConstant.joinOtherMall, obj.getProperties().getJoin_other_mall()).getKey());
			// 月均销售额坪效
			po.setCompare(tempParamService.findByParamAndValue(TempParamConstant.compare, obj.getProperties().getCompare()).getKey());
			// 品牌信息来源
			po.setSource(tempParamService.findByParamAndValue(TempParamConstant.source, obj.getProperties().getSource()).getKey());
			// 客单价
			po.setAverageUnitPrice(obj.getProperties().getPriceLow());
		}

		// 品牌状态 同步过来的品牌默认已准入
		po.setStatus(BrandConstant.ADMITTANCE);


	}

}
