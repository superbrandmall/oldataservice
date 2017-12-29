package com.sbm.module.onlineleasing.api.baseinfo.bidparam.biz;

import com.sbm.module.onlineleasing.api.baseinfo.bidparam.domain.BidParam;
import com.sbm.module.onlineleasing.api.baseinfo.bidparam.domain.BidParamVo;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.onlineleasing.api.baseinfo.bidparam.biz<br/>
 * File Name:IBidParamService.java<br/>
 * 
 * 作成日 ：2017-10-31 下午2:36:28 <br/>
 * 
 * @author ：junkai.zhang
 */
public interface IBidParamService {

	public BidParam find();

	/**
	 * 
	 * refreshCache:更新缓存
	 * 
	 * @author junkai.zhang
	 */
	public void refreshCache();

	public BidParam get();

	public void getBidParam(BidParamVo vo);

}
