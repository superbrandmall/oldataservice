package com.sbm.module.onlineleasing.api.download.biz;

import javax.servlet.http.HttpServletResponse;

import com.sbm.module.onlineleasing.api.download.domain.Download;

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
public interface IDownloadService {

	/**
	 * 
	 * preDownload:下载预处理
	 * 
	 * @author junkai.zhang
	 * @param download
	 */
	public void preDownload(Download download);

	/**
	 * 
	 * getFile:下载文件
	 *
	 * @author junkai.zhang
	 * @param key
	 * @param type
	 * @param response
	 */
	public void getFile(String key, String type, HttpServletResponse response);

}
