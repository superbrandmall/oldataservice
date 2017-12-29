package com.sbm.module.partner.tianyancha.rest.executioninfo.biz;

import com.sbm.module.partner.tianyancha.rest.executioninfo.domain.ExecutionInfo;
import com.sbm.module.partner.tianyancha.rest.executioninfo.domain.ExecutionInfoVo;

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
public interface IExecutionInfoService {

	public void getVo(ExecutionInfoVo vo);

	/**
	 * 
	 * findResultByName:从天眼查ExecutionInfo
	 * 
	 * @author junkai.zhang
	 * @param name
	 * @param pageNum
	 * @return
	 */
	public ExecutionInfo findResultByName(String name, Integer pageNum);

	/**
	 * 
	 * findResultById:从天眼查ExecutionInfo
	 * 
	 * @author junkai.zhang
	 * @param id
	 * @param pageNum
	 * @return
	 */
	public ExecutionInfo findResultById(Long id, Integer pageNum);

}
