package com.sbm.module.onlineleasing.api.sysmessage.biz;

import com.sbm.module.onlineleasing.api.sysmessage.domain.SysMessage;

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
public interface ISysMessageService {

	/**
	 * 
	 * getDetails:获取详细信息
	 * 
	 * @author junkai.zhang
	 * @param sysMessage
	 */
	public void getDetails(SysMessage sysMessage);

	/**
	 * 
	 * read:未读变已读
	 * 
	 * @author junkai.zhang
	 * @param sysMessage
	 */
	public void read(SysMessage sysMessage);

}
