package com.sbm.module.common.api.jobinteractive.biz;

import java.util.List;

import com.sbm.module.common.api.jobinteractive.domain.TCJobInteractiveDetail;
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
public interface ITCJobInteractiveDetailService extends IDaoSupportService<TCJobInteractiveDetail> {

	public List<TCJobInteractiveDetail> findAll();

	public TCJobInteractiveDetail findByCondition(TCJobInteractiveDetail obj);

}
