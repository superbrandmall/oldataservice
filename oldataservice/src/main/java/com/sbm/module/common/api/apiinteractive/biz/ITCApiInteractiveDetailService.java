package com.sbm.module.common.api.apiinteractive.biz;

import java.util.List;

import com.sbm.module.common.api.apiinteractive.domain.TCApiInteractiveDetail;
import com.sbm.module.common.business.biz.IDaoSupportService;

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
public interface ITCApiInteractiveDetailService extends IDaoSupportService<TCApiInteractiveDetail> {

	public List<TCApiInteractiveDetail> findAll();

	public TCApiInteractiveDetail findByCondition(TCApiInteractiveDetail obj);

}
