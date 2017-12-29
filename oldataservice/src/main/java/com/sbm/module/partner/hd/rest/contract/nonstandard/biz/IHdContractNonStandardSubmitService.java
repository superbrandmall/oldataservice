package com.sbm.module.partner.hd.rest.contract.nonstandard.biz;

import com.sbm.module.partner.hd.rest.base.domain.HdResult;
import com.sbm.module.partner.hd.rest.contract.base.domain.HdContract;
import com.sbm.module.partner.hd.rest.contract.nonstandard.domain.HdContractNonStandardResult;

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
public interface IHdContractNonStandardSubmitService {

	HdResult<HdContractNonStandardResult> nonstandardSubmit(List<HdContract> hdContracts);

}
