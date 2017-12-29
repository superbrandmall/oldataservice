package com.sbm.module.partner.hd.rest.contract.base.biz;

import com.sbm.module.onlineleasing.api.bid.domain.BidInfo;

import java.util.List;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.rest.contract.base.biz<br/>
 * File Name:IHdContractService.java<br/>
 * 
 * 作成日 ：2017-11-24 下午2:27:03 <br/>
 * 
 * @author ：junkai.zhang
 */
public interface IHdContractService {

	void preview(BidInfo bidInfo);

	void standardSubmit(BidInfo bidInfo);

	void nonStandardSubmit(List<BidInfo> bidInfos);
}
