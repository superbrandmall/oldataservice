package com.sbm.module.onlineleasing.base.tempparam.biz;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.onlineleasing.base.bidparam.rentmethod.domain.TOLBidRentMethod;
import com.sbm.module.onlineleasing.base.tempparam.domain.TOLTempParam;

import java.util.List;

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
public interface ITOLTempParamService extends IDaoSupportService<TOLTempParam> {

	public List<TOLTempParam> findAll();

	public TOLTempParam findByParamAndKey(String param, Integer key);

	public TOLTempParam findByParamAndValue(String param, String value);
}
