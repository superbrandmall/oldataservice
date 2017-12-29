package com.sbm.module.partner.tianyancha.rest.illegalinfo.biz;

import com.sbm.module.partner.tianyancha.rest.illegalinfo.domain.IllegalInfo;
import com.sbm.module.partner.tianyancha.rest.illegalinfo.domain.IllegalInfoVo;

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
public interface IIllegalInfoService {

	public void getVo(IllegalInfoVo vo);

	/**
	 * 
	 * findResultByName:从天眼查IllegalInfo
	 * 
	 * @author junkai.zhang
	 * @param name
	 * @param pageNum
	 * @return
	 */
	public IllegalInfo findResultByName(String name, Integer pageNum);

}
