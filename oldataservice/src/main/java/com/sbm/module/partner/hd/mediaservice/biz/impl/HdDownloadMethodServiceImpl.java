package com.sbm.module.partner.hd.mediaservice.biz.impl;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.onlineleasing.api.download.biz.IDownloadMethodService;
import com.sbm.module.onlineleasing.base.fileuploaddetail.domain.TOLFileUploadDetail;
import com.sbm.module.partner.hd.mediaservice.caller.BurlapServiceCaller;
import com.sbm.module.partner.hd.mediaservice.service.IFileProcessService;

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
@Component("hdDownloadMethodServiceImpl")
public class HdDownloadMethodServiceImpl extends BusinessServiceImpl implements IDownloadMethodService {

	public void downloadMethod(TOLFileUploadDetail detail, HttpServletResponse response) {
		try {
			IFileProcessService service = BurlapServiceCaller.getFileProcessService();
			byte[] bytes = service.getFile(detail.getFileId());
			response.getOutputStream().write(bytes);
		} catch (Exception e) {
			throw new BusinessException(BusinessCode.C2100, e);
		}

	}
}
