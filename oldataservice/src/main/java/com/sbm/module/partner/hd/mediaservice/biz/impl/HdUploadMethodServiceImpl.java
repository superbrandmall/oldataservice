package com.sbm.module.partner.hd.mediaservice.biz.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.onlineleasing.api.upload.biz.IUploadMethodService;
import com.sbm.module.onlineleasing.base.fileuploaddetail.domain.TOLFileUploadDetail;
import com.sbm.module.partner.hd.mediaservice.caller.BurlapServiceCaller;
import com.sbm.module.partner.hd.mediaservice.image.ImageSize;
import com.sbm.module.partner.hd.mediaservice.service.IFileProcessService;
import com.sbm.module.partner.hd.mediaservice.service.MediaSFileInfo;
import com.sbm.module.partner.hd.mediaservice.util.MediaSUtil;

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
@Component("hdUploadMethodServiceImpl")
public class HdUploadMethodServiceImpl extends BusinessServiceImpl implements IUploadMethodService {

	public void uploadMethod(TOLFileUploadDetail detail, MultipartFile file) {

		try {
			IFileProcessService service = BurlapServiceCaller.getFileProcessService();
			MediaSFileInfo info = service.uploadFile(file.getBytes(), file.getOriginalFilename());
			// 设置文件id
			detail.setFileId(info.getFileID());
			// 设置uri
			detail.setUri(MediaSUtil.getFileGetUrl(info.getFileID(), file.getOriginalFilename(), ImageSize.SIZE_DEFAULT));
		} catch (Exception e) {
			throw new BusinessException(BusinessCode.C2100, e);
		}
	}


	public void setFileInfo(TOLFileUploadDetail detail) {
		try {
			IFileProcessService service = BurlapServiceCaller.getFileProcessService();
			MediaSFileInfo info = service.getMediaSFileInfo(detail.getFileId());
			detail.setFileId(info.getFileID());
			detail.setOriginalFilename(info.getFileName());
			detail.setSize(info.getFileSize());
			detail.setUri(MediaSUtil.getFileGetUrl(info.getFileID(), detail.getOriginalFilename(), ImageSize.SIZE_DEFAULT));
		} catch (Exception e) {
			throw new BusinessException(BusinessCode.C2100, e);
		}		
	}
}
