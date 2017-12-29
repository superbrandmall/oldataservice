package com.sbm.module.common.api.sms.biz;

import com.sbm.module.common.api.sms.domain.SMSData;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/
/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.biz<br/>
 * File Name:IEdiInteractiveDetailService.java<br/>
 * 
 * 作成日 ：2016-1-4 下午5:05:39 <br/>
 * 
 * @author ：junkai.zhang
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
public interface ISMSService {

	/**
	 * 
	 * sendSMS:发送邮件
	 * 
	 * @author junkai.zhang
	 * @param smsData
	 */
	public void sendSMS(SMSData smsData);
}
