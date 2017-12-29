package com.sbm.module.onlineleasing.api.upload.biz;

import org.springframework.web.multipart.MultipartFile;

import com.sbm.module.onlineleasing.base.fileuploaddetail.domain.TOLFileUploadDetail;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.onlineleasing.shop.biz<br/>
 * File Name:ITOLShopService.java<br/>
 * 
 * 作成日 ：2017-5-18 下午4:34:06 <br/>
 * 
 * @author ：junkai.zhang
 */
public interface IUploadMethodService {

	/**
	 * 
	 * uploadMethod:上传数据具体实现方法
	 * 
	 * @author junkai.zhang
	 * @param detail
	 * @param file
	 */
	public void uploadMethod(TOLFileUploadDetail detail, MultipartFile file);

	
	public void setFileInfo(TOLFileUploadDetail detail);
	
}
