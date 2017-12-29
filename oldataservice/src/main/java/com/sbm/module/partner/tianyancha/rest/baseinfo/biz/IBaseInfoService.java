package com.sbm.module.partner.tianyancha.rest.baseinfo.biz;

import com.sbm.module.partner.tianyancha.rest.baseinfo.domain.BaseInfo;
import com.sbm.module.partner.tianyancha.rest.baseinfo.domain.BaseInfoVo;

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
public interface IBaseInfoService {

	public void getVo(BaseInfoVo vo);

	/**
	 * 
	 * findResultById:从天眼查获取基础信息
	 * 
	 * @author junkai.zhang
	 * @param id
	 * @return
	 */
	public BaseInfo findResultById(String id);

	public void check(BaseInfo result);

}
