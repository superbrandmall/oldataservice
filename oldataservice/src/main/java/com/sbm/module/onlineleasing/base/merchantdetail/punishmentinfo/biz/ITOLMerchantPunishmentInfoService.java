package com.sbm.module.onlineleasing.base.merchantdetail.punishmentinfo.biz;

import java.util.List;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.merchantdetail.punishmentinfo.domain.TOLMerchantPunishmentInfo;

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
public interface ITOLMerchantPunishmentInfoService extends IDaoSupportService<TOLMerchantPunishmentInfo> {

	public List<TOLMerchantPunishmentInfo> findAll();

	public List<TOLMerchantPunishmentInfo> findAllByCondition(TOLMerchantPunishmentInfo obj);

	public Pagination<TOLMerchantPunishmentInfo> findAllByConditionPage(TOLMerchantPunishmentInfo obj);

	public void deleteByCode(String code);
}
