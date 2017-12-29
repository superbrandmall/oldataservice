package com.sbm.module.onlineleasing.api.sysmessage.biz.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.api.sysmessage.biz.ISysMessageService;
import com.sbm.module.onlineleasing.api.sysmessage.domain.SysMessage;
import com.sbm.module.onlineleasing.base.sysmessage.biz.ITOLSysMessageService;
import com.sbm.module.onlineleasing.base.sysmessage.constant.SysMessageConstant;
import com.sbm.module.onlineleasing.base.sysmessage.domain.TOLSysMessage;

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
public class SysMessageServiceImpl extends BusinessServiceImpl implements ISysMessageService {

	@Autowired
	private ITOLSysMessageService service;

	public void getDetails(SysMessage sysMessage) {
		Pagination<TOLSysMessage> pagination = service.findAllByUserCodeAndTypePage(sysMessage.getSysMessage());
		sysMessage.setPagination(pagination);
	}

	public void read(SysMessage sysMessage) {
		for (TOLSysMessage obj : sysMessage.getList()) {
			// 设置已读时间
			obj.setReadTime(new Date());
			// 设置已读状态
			obj.setType(SysMessageConstant.READ);
			service.update(obj);
		}
	}

}
