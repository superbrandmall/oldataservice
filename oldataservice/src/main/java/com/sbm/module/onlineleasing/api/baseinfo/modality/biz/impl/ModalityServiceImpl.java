package com.sbm.module.onlineleasing.api.baseinfo.modality.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.baseinfo.modality.biz.IModalityService;
import com.sbm.module.onlineleasing.api.baseinfo.modality.domain.ModalityVo;
import com.sbm.module.onlineleasing.base.modality.biz.ITOLModalityService;
import com.sbm.module.onlineleasing.base.modality.domain.TOLModality;

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
public class ModalityServiceImpl extends BusinessServiceImpl implements IModalityService {

	@Autowired
	private ITOLModalityService service;

	public void getModalityList(ModalityVo vo) {
		List<TOLModality> list = service.getModalityList();
		vo.setList(list);
	}

}
