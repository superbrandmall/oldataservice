package com.sbm.module.partner.hd.job.base.domain;

import java.util.ArrayList;
import java.util.List;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.job.base.domain<br/>
 * File Name:SyncDetail.java<br/>
 * 
 * 作成日 ：2017-10-13 上午11:33:23 <br/>
 * 
 * @author ：junkai.zhang
 */
public class HdSyncDetail<T> {

	private List<T> insertList = new ArrayList<T>();

	private List<T> updateList = new ArrayList<T>();

	public List<T> getInsertList() {
		return insertList;
	}

	public void setInsertList(List<T> insertList) {
		this.insertList = insertList;
	}

	public List<T> getUpdateList() {
		return updateList;
	}

	public void setUpdateList(List<T> updateList) {
		this.updateList = updateList;
	}

}
