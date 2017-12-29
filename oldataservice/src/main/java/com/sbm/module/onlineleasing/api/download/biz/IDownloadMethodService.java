package com.sbm.module.onlineleasing.api.download.biz;

import javax.servlet.http.HttpServletResponse;

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
public interface IDownloadMethodService {

	/**
	 * 
	 * downloadMethod:下载具体实现
	 * 
	 * @author junkai.zhang
	 * @param detail
	 * @param response
	 */
	public void downloadMethod(TOLFileUploadDetail detail, HttpServletResponse response);
}
