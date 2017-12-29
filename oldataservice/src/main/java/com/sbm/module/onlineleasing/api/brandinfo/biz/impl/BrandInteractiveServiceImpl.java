package com.sbm.module.onlineleasing.api.brandinfo.biz.impl;

import com.sbm.module.onlineleasing.base.modality.biz.ITOLModalityService;
import com.sbm.module.onlineleasing.base.modality.domain.TOLModality;
import com.sbm.module.onlineleasing.base.tempparam.biz.ITOLTempParamService;
import com.sbm.module.onlineleasing.base.tempparam.constant.TempParamConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.base.pulisher.constant.BusinessEventListenerConstant;
import com.sbm.module.common.base.pulisher.template.BusinessEventTemplate;
import com.sbm.module.common.business.biz.IThreadSleepExecuteCallBack;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.brandinfo.biz.IBrandInteractiveService;
import com.sbm.module.onlineleasing.api.brandinfo.event.BrandEvent;
import com.sbm.module.onlineleasing.base.brand.biz.ITOLBrandService;
import com.sbm.module.onlineleasing.base.brand.domain.TOLBrand;
import com.sbm.module.onlineleasing.base.sysmessage.domain.TOLSysMessage;
import com.sbm.module.partner.hd.rest.base.biz.impl.HdInteractiveServiceImpl;
import com.sbm.module.partner.hd.rest.base.constant.HdConstant;
import com.sbm.module.partner.hd.rest.base.domain.HdResult;
import com.sbm.module.partner.hd.rest.brand.biz.IHdBrandService;
import com.sbm.module.partner.hd.rest.brand.domain.HdBrand;

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
public class BrandInteractiveServiceImpl extends HdInteractiveServiceImpl implements IBrandInteractiveService {

	@Autowired
	private ITOLBrandService service;
	@Autowired
	private ITOLTempParamService tempParamService;
	@Autowired
	private ITOLModalityService modalityService;

	@Autowired
	private IHdBrandService hdBrandService;

	/********************************************************************/
	// 品牌准入

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public void brandAccress(TOLBrand obj) {
		// 发布事件
		BusinessEventTemplate template = getTemplate()
				.put(BusinessEventListenerConstant.SysMessage,
						new TOLSysMessage(getUserCode(), "品牌准入流程已发起，品牌编码：" + obj.getCode()))
				.put(BusinessEventListenerConstant.BaseEntity, obj)
				.put(BusinessEventListenerConstant.METHOD, BusinessEventListenerConstant.SAVE);
		publishEvent(new BrandEvent(template));
	}

	/********************************************************************/
	// 执行品牌准入

	public void doBrandAccress(TOLBrand obj) {
		// 多线程防止事务未提交
		TOLBrand po = findByCode(obj.getCode());
		// 转换
		HdBrand vo = new HdBrand();
		convert2vo(vo, po);
		// 调用
		HdResult<HdBrand> result = hdBrandService.save(vo);
		// 校对返回结果
		checkResult(result);
		// 处理结果
		processResult(po, result);
		// 更新
		service.update(po);
	}

	/**
	 * 
	 * processResult:处理结果
	 * 
	 * @author junkai.zhang
	 * @param po
	 * @param result
	 */
	private void processResult(TOLBrand po, HdResult<HdBrand> result) {
		// 海鼎uuid
		po.setHdUuid(result.getBody().getUuid());
		// 海鼎编码
		po.setHdCode(result.getBody().getCode());
		// 设置海鼎状态
		po.setHdState(result.getBody().getState());
	}

	/**
	 * 
	 * convert2HdMerchant:转换
	 * 
	 * @author junkai.zhang
	 * @param vo
	 * @param po
	 */
	private void convert2vo(HdBrand vo, TOLBrand po) {
		// 海鼎自动生成
		// 品牌代码
		//vo.setCode(po.getCode());
		// 品牌名称
		vo.setName(po.getName());
		// 状态
		vo.setState(HdConstant.HD_STATE_USING);
		// 城市
		vo.setLocal(po.getCity());
		// 品牌属性
		vo.getProperties().setIntroductions(tempParamService.findByParamAndKey(TempParamConstant.attribute, po.getAttribute()).getValue());
		// 品牌价位
		vo.getProperties().setBrandGrade(tempParamService.findByParamAndKey(TempParamConstant.brandClass, po.getBrandClass()).getValue());
		// 标准店面积
		vo.getProperties().setAreaLow(tempParamService.findByParamAndKey(TempParamConstant.standardArea, po.getStandardArea()).getValue());

		// 业态
		TOLModality modality = modalityService.findByCode(po.getModality_3(), true);
		vo.getBizType().setCode(modality.getCode());
		vo.getBizType().setUuid(modality.getHdUuid());
		vo.getBizType().setLevelId(modality.getHdLevelid());
		vo.getBizType().setName(modality.getName());

		// 主要客户群
		vo.getProperties().setTarget(tempParamService.findByParamAndKey(TempParamConstant.target, po.getTarget()).getValue());
		// 客单价
		vo.getProperties().setPriceLow(po.getAverageUnitPrice());
		// 开店区域
		vo.getProperties().setLocation(tempParamService.findByParamAndKey(TempParamConstant.location, po.getLocation()).getValue());
		// 当前已开店数
		vo.getProperties().setShopCount(tempParamService.findByParamAndKey(TempParamConstant.shopAmount, po.getShopAmount()).getValue());
		// 品牌发展历史
		vo.getProperties().setHistory(tempParamService.findByParamAndKey(TempParamConstant.history, po.getHistory()).getValue());
		// 口碑
		vo.getProperties().setReputation(tempParamService.findByParamAndKey(TempParamConstant.reputation, po.getReputation()).getValue());
		// 是否有旗下品牌已入驻
		vo.getProperties().setJoined(tempParamService.findByParamAndKey(TempParamConstant.joined, po.getJoined()).getValue());
		// 是否有意进驻正大其它门店
		vo.getProperties().setJoin_other_mall(tempParamService.findByParamAndKey(TempParamConstant.joinOtherMall, po.getJoinOtherMall()).getValue());
		// 月均销售额坪效
		vo.getProperties().setCompare(tempParamService.findByParamAndKey(TempParamConstant.compare, po.getCompare()).getValue());
		// 品牌信息来源
		vo.getProperties().setSource(tempParamService.findByParamAndKey(TempParamConstant.source, po.getSource()).getValue());

	}
	
	/********************************************************************/
	// 品牌修改

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public void brandUpdate(TOLBrand obj) {
		// 发布事件
		BusinessEventTemplate template = getTemplate()
				.put(BusinessEventListenerConstant.SysMessage,
						new TOLSysMessage(getUserCode(), "品牌修改流程已发起，品牌编码：" + obj.getCode()))
				.put(BusinessEventListenerConstant.BaseEntity, obj)
				.put(BusinessEventListenerConstant.METHOD, BusinessEventListenerConstant.UPDATE);
		publishEvent(new BrandEvent(template));
	}

	/********************************************************************/
	// 执行品牌修改

	public void doBrandUpdate(TOLBrand obj) {
		// TODO

	}

	/********************************************************************/

	/**
	 * 
	 * findByCode:多线程处理防止事务未提交
	 * 
	 * @author junkai.zhang
	 * @param code
	 * @return
	 */
	private TOLBrand findByCode(final String code) {
		return threadSleepExecute(new BusinessException(BusinessCode.C5004, new Object[] { code }, null),
				new IThreadSleepExecuteCallBack<TOLBrand>() {
					public TOLBrand execute() {
						TOLBrand po = service.findByCode(code);
						return po;
					}
				});
	}

}
