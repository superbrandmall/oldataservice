package com.sbm.module.onlineleasing.api.mall.biz.impl;

import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.common.business.util.ParamsUtil;
import com.sbm.module.onlineleasing.api.mall.biz.IMallVoService;
import com.sbm.module.onlineleasing.api.mall.domain.MallVo;
import com.sbm.module.onlineleasing.base.mall.biz.ITOLMallService;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;
import com.sbm.module.onlineleasing.base.mallbidstandard.biz.ITOLMallBidStandardService;
import com.sbm.module.onlineleasing.base.malltraffic.biz.ITOLMallTrafficService;
import org.apache.commons.lang3.StringUtils;
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
public class MallVoServiceImpl extends BusinessServiceImpl implements IMallVoService {

	@Autowired
	private ITOLMallService mallService;
	@Autowired
	private ITOLMallTrafficService mallTrafficService;
	@Autowired
	private ITOLMallBidStandardService mallBidStandardService;

	/******************************************************************************************/

	public void findAllByConditionPage(MallVo vo) {
		vo.setPagination(mallService.findAllByConditionPage(vo.getMall()));
	}

	/******************************************************************************************/

	@Override
	public void findByCode(MallVo vo) {
		vo.setMall(mallService.findByCode(vo.getMall().getCode()));
		vo.setTraffics(mallTrafficService.findAllByCode(vo.getMall().getCode()));
		vo.setMallBidStandard(mallBidStandardService.findByCode(vo.getMall().getCode()));
	}
}
