package com.sbm.module.partner.hd.mediaservice.caller;

import com.caucho.burlap.client.BurlapProxyFactory;
import com.sbm.module.partner.hd.mediaservice.constants.MediaSConstants;
import com.sbm.module.partner.hd.mediaservice.service.IFileProcessService;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.mediaservice.caller<br/>
 * File Name:BurlapServiceCaller.java<br/>
 * 
 * 作成日 ：2017-11-2 下午4:32:26 <br/>
 * 
 * @author ：junkai.zhang
 */
public class BurlapServiceCaller {

	public static IFileProcessService getFileProcessService() throws Exception {
		try {
			BurlapProxyFactory factory = new BurlapProxyFactory();
			String url = getUrl("FileProcessService");
			IFileProcessService service = (IFileProcessService) factory.create(IFileProcessService.class, url);
			return service;
		} catch (Exception e) {
			throw e;
		}
	}

	public static String getUrl(String urlPattern) {
		String url = MediaSConstants.URL;
		if (!url.endsWith("/"))
			url = url + "/";
		url = url + urlPattern;
		return url;
	}

}
