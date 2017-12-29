package com.sbm.module.common.api.sms.biz;

import java.util.List;

import com.sbm.module.common.api.sms.domain.TCSMSTemplate;
import com.sbm.module.common.business.biz.IDaoSupportService;

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
public interface ITCSMSTemplateService extends IDaoSupportService<TCSMSTemplate> {

	public List<TCSMSTemplate> findAll();

	public TCSMSTemplate findByCode(String code);

	/**
	 * 
	 * saveSMSTemplate:保存短信发送模板
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	public void saveSMSTemplate(TCSMSTemplate obj);
}
