package com.sbm.module.onlineleasing.api.sysmessage.domain;

import java.util.List;

import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.sysmessage.domain.TOLSysMessage;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.onlineleasingapi.login.domain<br/>
 * File Name:Login.java<br/>
 * 
 * 作成日 ：2017-8-3 上午10:13:05 <br/>
 * 
 * @author ：junkai.zhang
 */
public class SysMessage {

	private TOLSysMessage sysMessage;

	private Pagination<TOLSysMessage> pagination;

	private List<TOLSysMessage> list;

	public TOLSysMessage getSysMessage() {
		return sysMessage;
	}

	public void setSysMessage(TOLSysMessage sysMessage) {
		this.sysMessage = sysMessage;
	}

	public Pagination<TOLSysMessage> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<TOLSysMessage> pagination) {
		this.pagination = pagination;
	}

	public List<TOLSysMessage> getList() {
		return list;
	}

	public void setList(List<TOLSysMessage> list) {
		this.list = list;
	}

}
