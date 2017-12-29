package com.sbm.module.onlineleasing.api.download.biz.impl;

import java.net.URLConnection;
import java.text.MessageFormat;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.redis.constant.RedisConstant;
import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.api.download.biz.IDownloadMethodService;
import com.sbm.module.onlineleasing.api.download.biz.IDownloadService;
import com.sbm.module.onlineleasing.api.download.domain.Download;
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
public class DownloadServiceImpl extends BusinessServiceImpl implements IDownloadService {

	@Autowired
	private ITOLFileUploadDetailService fileUploadDetailService;
	@Autowired
	@Qualifier("hdDownloadMethodServiceImpl")
	private IDownloadMethodService downloadMethodService;

	private static final String INLINE = "inline";

	private static final String STEAM = "application/octet-stream";

	private static final String CONTENT_DISPOSITION = "Content-Disposition";

	private static final String CONTENT_DISPOSITION_VALUE = "{0}; filename=\"{1}\"";

	/********************************************************************/
	// 下载预处理

	public void preDownload(Download download) {
		TOLFileUploadDetail detail = fileUploadDetailService.findByUri(download.getDetail().getUri());
		// 获取指定文件失败，指定文件不存在
		if (null == detail) {
			throw new BusinessException(BusinessCode.C1101, new Object[] { download.getDetail().getUri() }, null);
		}
		download.setDetail(detail);
		// 设置key
		setKey(download);
		// 加入缓存
		set2redis(download.getKey(), JSON.toJSONString(download.getDetail()));
	}

	/**
	 * 
	 * setKey:设置key
	 * 
	 * @author junkai.zhang
	 * @param download
	 */
	private void setKey(Download download) {
		download.setKey(download.getDetail().getSuffix() + RedisConstant.UNDER_LINE + getUUID());
	}

	/********************************************************************/
	// 下载文件

	public void getFile(String key, String type, HttpServletResponse response) {
		// 设置下载属性
		Download download = getDownload(key, type);
		// 获取文件详情
		TOLFileUploadDetail detail = getDetail(download);
		// 下载前设置
		beforeDownload(detail, download, response);
		// 下载文件
		downloadMethodService.downloadMethod(detail, response);

	}

	/**
	 * 
	 * getDownload:设置下载属性
	 * 
	 * @author junkai.zhang
	 * @param key
	 * @param type
	 * @return
	 */
	private Download getDownload(String key, String type) {
		if (StringUtils.isBlank(key)) {
			throw new BusinessException(BusinessCode.C1103, null);
		}
		Download download = new Download();
		download.setKey(key);
		download.setType(type);
		// 放入本地线程
		save2RequestBody(download);
		return download;
	}

	/**
	 * 
	 * getDetail:获取文件详情
	 * 
	 * @author junkai.zhang
	 * @param download
	 * @return
	 */
	private TOLFileUploadDetail getDetail(Download download) {
		String valuer = (String) redisService.get(download.getKey());
		if (StringUtils.isBlank(valuer)) {
			throw new BusinessException(BusinessCode.C1102, new Object[] { download.getKey() }, null);
		}
		TOLFileUploadDetail detail = JSON.parseObject(valuer, TOLFileUploadDetail.class);
		return detail;
	}

	/**
	 * 
	 * beforeDownload:下载前设置
	 * 
	 * @author junkai.zhang
	 * @param detail
	 * @param response
	 * @return
	 */
	private TOLFileUploadDetail beforeDownload(TOLFileUploadDetail detail, Download download,
			HttpServletResponse response) {
		String mimeType = URLConnection.guessContentTypeFromName(detail.getOriginalFilename());
		if (mimeType == null) {
			mimeType = STEAM;
		}
		response.setContentType(mimeType);
		if (StringUtils.isBlank(download.getType())) {
			download.setType(INLINE);
		}
		response.setHeader(CONTENT_DISPOSITION,
				MessageFormat.format(CONTENT_DISPOSITION_VALUE, download.getType(), detail.getOriginalFilename()));
		response.setContentLength(detail.getSize().intValue());
		return detail;
	}

}
