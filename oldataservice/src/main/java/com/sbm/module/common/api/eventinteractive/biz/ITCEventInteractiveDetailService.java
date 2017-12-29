package com.sbm.module.common.api.eventinteractive.biz;

import com.sbm.module.common.api.eventinteractive.domain.TCEventInteractiveDetail;
import com.sbm.module.common.api.jobinteractive.domain.TCJobInteractiveDetail;
import com.sbm.module.common.business.biz.IDaoSupportService;

import java.util.List;

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
public interface ITCEventInteractiveDetailService extends IDaoSupportService<TCEventInteractiveDetail> {

	public List<TCEventInteractiveDetail> findAll();

	public TCEventInteractiveDetail findByCondition(TCEventInteractiveDetail obj);

}
