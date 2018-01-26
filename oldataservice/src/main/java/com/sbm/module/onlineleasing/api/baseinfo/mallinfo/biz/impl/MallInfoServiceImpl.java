package com.sbm.module.onlineleasing.api.baseinfo.mallinfo.biz.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.redis.constant.RedisConstant;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.util.ParamsUtil;
import com.sbm.module.onlineleasing.api.baseinfo.base.domain.ModalityProportion;
import com.sbm.module.onlineleasing.api.baseinfo.base.domain.ModalityProportionDetail;
import com.sbm.module.onlineleasing.api.baseinfo.mallinfo.biz.IMallInfoService;
import com.sbm.module.onlineleasing.api.baseinfo.mallinfo.domain.MallInfo;
import com.sbm.module.onlineleasing.api.baseinfo.mallinfo.domain.MallInfoVo;
import com.sbm.module.onlineleasing.base.mall.biz.ITOLMallService;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;
import com.sbm.module.onlineleasing.base.malltraffic.biz.ITOLMallTrafficService;
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
public class MallInfoServiceImpl extends BusinessServiceImpl implements IMallInfoService {

	@Autowired
	private ITOLMallService mallService;
	@Autowired
	private ITOLMallTrafficService mallTrafficService;
	@Autowired
	private ITOLShopService shopService;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<MallInfo> findAll() {
		List<MallInfo> mallInfos = new ArrayList<MallInfo>();
		// 查询所有mall
		List<TOLMall> malls = mallService.findAll();
		for (TOLMall mall : malls) {
			MallInfo mallInfo = find(mall.getCode());
			mallInfos.add(mallInfo);
		}
		return mallInfos;
	}

	/**
	 * 
	 * find:查询一个mall的数据
	 * 
	 * @author junkai.zhang
	 * @param mallCode
	 * @return
	 */
	private MallInfo find(String mallCode) {
		// 判断非空
		ParamsUtil.canNotBeEmpty(mallCode);
		
		MallInfo mallInfo = new MallInfo();
		// 查询mall
		mallInfo.setMall(mallService.findByCode(mallCode));
		// 查询mallTraffic
		mallInfo.setTraffics(mallTrafficService.findAllByCode(mallCode));
		// mall业态分布
		mallInfo.setProportion(getMallProportion(mallCode));
		return mallInfo;
	}

	/**
	 * 
	 * getMallProportion:获取mall业态占比
	 * 
	 * @author junkai.zhang
	 * @param mallCode
	 * @return
	 */
	private ModalityProportion getMallProportion(String mallCode) {
		ModalityProportion proportion = new ModalityProportion();
		proportion.setMallCode(mallCode);
		List<TOLShop> shops = shopService.findCountGroupByMall(mallCode);
		convert(proportion.getDetails(), shops);
		return proportion;
	}

	/**************************************************************************************************/
	// 转换

	private void convert(List<ModalityProportionDetail> vos, List<TOLShop> pos) {
		Long total = 0L;
		for (TOLShop po : pos) {
			total += po.getCount();
		}
		for (TOLShop po : pos) {
			ModalityProportionDetail vo = new ModalityProportionDetail();
			convert(vo, po, total);
			vos.add(vo);
		}
	}

	private void convert(ModalityProportionDetail vo, TOLShop po, Long total) {
		vo.setCode(po.getModality());
		vo.setCount(po.getCount());
		// 保留两位小数
		vo.setPercentage(new BigDecimal(po.getCount()).divide(new BigDecimal(total), 2, BigDecimal.ROUND_HALF_EVEN));
	}

	/**************************************************************************************************/

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public MallInfo get(String code) {
		String valuer = (String) redisService.get(RedisConstant.PREFIX_MALL_INFO + code);
		if (StringUtils.isNotBlank(valuer)) {
			MallInfo obj = JSON.parseObject(valuer, MallInfo.class);
			return obj;
		}
		return find(code);
	}

	public void refreshCache() {
		List<MallInfo> list = findAll();
		for (MallInfo obj : list) {
			set2redis(RedisConstant.PREFIX_MALL_INFO + obj.getMall().getCode(), JSON.toJSONString(obj), 2L,
					TimeUnit.DAYS);
		}
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public void getMallInfo(MallInfoVo vo) {
		vo.setMallInfo(get(vo.getCode()));
	}

	/**************************************************************************************************/

	@Override
	public void findAllOrderByPosition(MallInfoVo vo) {
		// 查询所有mall
		List<TOLMall> malls = mallService.findAllOrderByPosition();
		vo.setMalls(malls);
	}
}
