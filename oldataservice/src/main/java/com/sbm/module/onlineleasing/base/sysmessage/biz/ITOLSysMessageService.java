package com.sbm.module.onlineleasing.base.sysmessage.biz;

import java.util.List;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.sysmessage.domain.TOLSysMessage;

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
public interface ITOLSysMessageService extends IDaoSupportService<TOLSysMessage> {

	public List<TOLSysMessage> findAll();

	public TOLSysMessage findByCondition(TOLSysMessage obj);

	/**
	 * 
	 * sendSysMessage:发送系统消息
	 * 
	 * @author junkai.zhang
	 * @param userCode
	 * @param message
	 */
	public void sendSysMessage(TOLSysMessage obj);

	/**
	 * 
	 * findAllByUserCodeAndType:根据usercode和type查询，type可以为空
	 * 
	 * @author junkai.zhang
	 * @param obj
	 * @return
	 */
	public List<TOLSysMessage> findAllByUserCodeAndType(TOLSysMessage obj);

	/**
	 * 
	 * findAllByUserCodeAndTypePage:根据usercode和type查询，type可以为空，分页数据
	 * 
	 * @author junkai.zhang
	 * @param obj
	 * @return
	 */
	public Pagination<TOLSysMessage> findAllByUserCodeAndTypePage(TOLSysMessage obj);

}
