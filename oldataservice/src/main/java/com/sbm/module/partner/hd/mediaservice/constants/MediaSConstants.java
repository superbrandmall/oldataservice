package com.sbm.module.partner.hd.mediaservice.constants;

import com.sbm.module.common.business.util.AppPropertyUtils;
import com.sbm.module.partner.hd.mediaservice.caller.BurlapServiceCaller;
import com.sbm.module.partner.hd.mediaservice.service.IFileProcessService;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.mediaservice.constants<br/>
 * File Name:MediaSConstants.java<br/>
 * 
 * 作成日 ：2017-11-2 下午4:33:02 <br/>
 * 
 * @author ：junkai.zhang
 */
public class MediaSConstants {

//	public static String URL = "http://cre.trunk.hd123.cn/HDMediaService-web";
	public static String URL = AppPropertyUtils.getProperty("hdMediaUrl");;

	public static String CALLER_CLASS = "default";

	private static IFileProcessService caller = null;

	public static IFileProcessService getCaller() throws Exception {
		if ((URL == null) || ("".equals(URL)))
			throw new Exception("未设置参数URL.");
		if ((CALLER_CLASS == null) || ("".equals(CALLER_CLASS))) {
			throw new Exception("请配置参数CALLER_CLASS，值为default或实类名.");
		}
		if ("default".equalsIgnoreCase(CALLER_CLASS)) {
			caller = BurlapServiceCaller.getFileProcessService();
		}
		if (caller == null) {
			try {
				caller = (IFileProcessService) Class.forName(CALLER_CLASS).newInstance();
			} catch (Exception e) {
				throw new Exception("无法实例化" + CALLER_CLASS + ".");
			}
		}
		return caller;
	}

}
