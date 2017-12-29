package com.sbm.module.partner.hd.job.base.biz.impl;

import java.text.MessageFormat;

import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.partner.hd.job.base.domain.HdSyncDetail;
import com.sbm.module.partner.hd.rest.base.biz.impl.HdInteractiveServiceImpl;
import com.sbm.module.partner.hd.rest.base.domain.HdResult;
import com.sbm.module.partner.hd.rest.base.domain.HdResultBody;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.job.base.biz.impl<br/>
 * File Name:SyncServiceImpl.java<br/>
 * 
 * 作成日 ：2017-10-13 上午11:32:52 <br/>
 * 
 * @author ：junkai.zhang
 */
public class HdSyncServiceImpl extends HdInteractiveServiceImpl {

	private static final String DETAIL_MESSAGE = "{0} - insert: {1}, update: {2}; ";
	private static final String RESULT_MESSAGE = "pageSize: {0}, page: {1}, pageCount: {2}, recordCount: {3}";

	protected <T> HdSyncDetail<T> getSyncDetail() {
		return new HdSyncDetail<T>();
	}

	@SuppressWarnings("rawtypes")
	protected void log(HdSyncDetail detail, Class clazz) {
		log(detail, null, clazz);
	}

	@SuppressWarnings("rawtypes")
	protected void log(HdSyncDetail detail, HdResult result, Class clazz) {
		StringBuffer message = new StringBuffer(MessageFormat.format(DETAIL_MESSAGE, clazz.getSimpleName(), detail
				.getInsertList().size(), detail.getUpdateList().size()));
		if (null != result && result.getBody() instanceof HdResultBody) {
			HdResultBody body = (HdResultBody) result.getBody();
			message.append(MessageFormat.format(RESULT_MESSAGE, body.getPageSize(), body.getPage(),
					body.getPageCount(), body.getRecordCount()));
		}
		CommonConstant.FRAMEWORK.info(message.toString());
	}
}
