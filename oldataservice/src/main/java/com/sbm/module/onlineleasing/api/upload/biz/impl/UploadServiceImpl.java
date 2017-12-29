package com.sbm.module.onlineleasing.api.upload.biz.impl;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.storage.blob.util.BlobClientUtil;
import com.sbm.module.onlineleasing.api.upload.biz.IUploadMethodService;
import com.sbm.module.onlineleasing.api.upload.biz.IUploadService;
import com.sbm.module.onlineleasing.api.upload.constant.UploadConstant;
import com.sbm.module.onlineleasing.api.upload.domain.Upload;
import com.sbm.module.onlineleasing.base.fileuploaddetail.biz.ITOLFileUploadDetailService;
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
@Component
@Transactional(value = TransactionConstant.OL, propagation = Propagation.REQUIRED)
public class UploadServiceImpl extends BusinessServiceImpl implements IUploadService {

	@Autowired
	private ITOLFileUploadDetailService fileUploadDetailService;
	@Autowired
	@Qualifier("hdUploadMethodServiceImpl")
	private IUploadMethodService uploadMethodService;

	private String getSuffix(String filename) {
		String suffix = filename.substring(filename.lastIndexOf(BlobClientUtil.DOT));
		if (StringUtils.isNotBlank(suffix)) {
			suffix = suffix.substring(1, suffix.length());
		}
		return suffix;
	}

	/*******************************************************************************************************/

	public void upload(Upload upload) {
		TOLFileUploadDetail detail = null;
		for (MultipartFile file : upload.getFiles()) {
			// 复制对象
			detail = (TOLFileUploadDetail) jsonClone(upload.getVo(), TOLFileUploadDetail.class);
			// 转换
			convert2FileUploadDetail(detail, file);
			// 上传
			uploadMethodService.uploadMethod(detail, file);
			fileUploadDetailService.saveOrUpdateDetail(detail);
			upload.getDetails().add(detail);
		}
		// 去除原来的对象
		upload.setVo(null);
		upload.setFiles(null);
		// 放入本地线程
		save2RequestBody(upload);
	}

	/*******************************************************************************************************/
	
	/**
	 * 
	 * convert2FileUploadDetail:转换成FileUploadDetail
	 * 
	 * @author junkai.zhang
	 * @param detail
	 * @param file
	 */
	private void convert2FileUploadDetail(TOLFileUploadDetail detail, MultipartFile file) {
		// 设置文件大小
		detail.setSize(file.getSize());
		// 设置文件原始名称
		try {
			detail.setOriginalFilename(new String(file.getOriginalFilename().getBytes(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new BusinessException(BusinessCode.C1104, new Object[] { file.getOriginalFilename() }, e);
		}
		// 设置文件后缀
		detail.setSuffix(getSuffix(file.getOriginalFilename()));
	}

	/*******************************************************************************************************/

	public String saveFileUploadDetail(String fileId, String containerName, String prefix) {
		// 生成upload明细
		TOLFileUploadDetail detail = new TOLFileUploadDetail();
		detail.setFileId(fileId);
		detail.setContainerName(containerName);
		detail.setPrefix(prefix);
		saveFileUploadDetail(detail);
		return detail.getUri();
	}
	
	public void saveFileUploadDetail(TOLFileUploadDetail detail) {
		uploadMethodService.setFileInfo(detail);
		if (StringUtils.isEmpty(detail.getUserCode())) {
			detail.setUserCode(getUserCode());
		}
		// 设置文件后缀
		detail.setSuffix(getSuffix(detail.getOriginalFilename()));
		fileUploadDetailService.saveOrUpdateDetail(detail);
	}

	/*******************************************************************************************************/

	public String getPrefix(String userCode, String type, String use) {
		return MessageFormat.format(UploadConstant.PREFIX_DEFAULT, userCode, type, use);
	}

}
