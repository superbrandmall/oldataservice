package com.sbm.module.onlineleasing.base.bidparam.promotionkind.biz;

import java.util.List;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.onlineleasing.base.bidparam.promotionkind.domain.TOLBidPromotionKind;

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
public interface ITOLBidPromotionKindService extends IDaoSupportService<TOLBidPromotionKind> {

	public List<TOLBidPromotionKind> findAll();

	public TOLBidPromotionKind findByItemNo(Integer itemNo);
}
