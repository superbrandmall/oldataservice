package com.sbm.module.onlineleasing.api.upload.biz;

import com.sbm.module.onlineleasing.api.upload.domain.Upload;
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
public interface IUploadService {

	/**
	 * 
	 * upload:上传数据
	 * 
	 * @author junkai.zhang
	 * @param upload
	 */
	public void upload(Upload upload);

	/**
	 * 
	 * saveFileUploadDetail:保存上传信息
	 *
	 * @author junkai.zhang
	 * @param fileId
	 * @param containerName
	 * @param prefix
	 * @return uri
	 */
	public String saveFileUploadDetail(String fileId, String containerName, String prefix);
	
	/**
	 * 
	 * saveFileUploadDetail:保存上传信息
	 *
	 * @author junkai.zhang
	 * @param detail
	 */
	public void saveFileUploadDetail(TOLFileUploadDetail detail);
	
	/**
	 * 
	 * getPrefix:获取前缀
	 *
	 * @author junkai.zhang
	 * @param userCode
	 * @param type
	 * @param use
	 * @return
	 */
	public String getPrefix(String userCode, String type, String use);
}
