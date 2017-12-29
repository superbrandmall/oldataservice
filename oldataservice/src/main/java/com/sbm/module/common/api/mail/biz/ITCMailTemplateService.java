package com.sbm.module.common.api.mail.biz;

import java.util.List;

import com.sbm.module.common.api.mail.domain.TCMailTemplate;
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
public interface ITCMailTemplateService extends IDaoSupportService<TCMailTemplate> {

	public List<TCMailTemplate> findAll();

	public TCMailTemplate findByCode(String code);

	/**
	 * 
	 * saveMailTemplate:保存邮件发送模板
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	public void saveMailTemplate(TCMailTemplate obj);
}
