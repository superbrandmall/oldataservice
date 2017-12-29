package com.sbm.module.onlineleasing.api.storage.blob.biz.impl;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.onlineleasing.api.storage.blob.util.BlobClientUtil;
import com.sbm.module.onlineleasing.api.upload.biz.IUploadMethodService;
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
@Component("MSUploadMethodServiceImpl")
public class MSUploadMethodServiceImpl extends BusinessServiceImpl implements IUploadMethodService {

	@Autowired
	private BlobClientUtil util;

	public void uploadMethod(TOLFileUploadDetail detail, MultipartFile file) {
		// 设置文件uuid
		detail.setFileId(getUUID());

		util.initContainer(detail.getContainerName());
		// 拼接blobName
		String blobName = util.getBlobName(detail.getPrefix(), detail.getFileId());
		InputStream sourceStream;
		try {
			sourceStream = file.getInputStream();
		} catch (IOException e) {
			throw new BusinessException(BusinessCode.C1100, new Object[] { detail.getOriginalFilename() }, e);
		}
		// 上传至storage
		util.upload(blobName, sourceStream, detail.getSize());
		// 设置uri
		detail.setUri(util.getURI(blobName));
	}

	public void setFileInfo(TOLFileUploadDetail detail) {
		// 暂无
	}

}
