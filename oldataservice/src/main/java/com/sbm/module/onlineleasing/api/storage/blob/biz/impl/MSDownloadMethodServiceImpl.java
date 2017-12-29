package com.sbm.module.onlineleasing.api.storage.blob.biz.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.onlineleasing.api.download.biz.IDownloadMethodService;
import com.sbm.module.onlineleasing.api.storage.blob.util.BlobClientUtil;
import com.sbm.module.onlineleasing.base.fileuploaddetail.domain.TOLFileUploadDetail;

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
@Component("MSDownloadMethodServiceImpl")
public class MSDownloadMethodServiceImpl extends BusinessServiceImpl implements IDownloadMethodService {

	@Autowired
	private BlobClientUtil util;

	public void downloadMethod(TOLFileUploadDetail detail, HttpServletResponse response) {
		String blobName = util.getBlobName(detail.getPrefix(), detail.getFileId());
		util.initContainer(detail.getContainerName());
		try {
			util.download(blobName, response.getOutputStream());
		} catch (IOException e) {
			throw new BusinessException(BusinessCode.C2003, new Object[] { detail.getContainerName(), blobName }, e);
		}
	}

}
