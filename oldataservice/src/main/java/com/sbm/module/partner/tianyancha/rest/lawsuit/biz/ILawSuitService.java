package com.sbm.module.partner.tianyancha.rest.lawsuit.biz;

import com.sbm.module.partner.tianyancha.rest.lawsuit.domain.LawSuit;
import com.sbm.module.partner.tianyancha.rest.lawsuit.domain.LawSuitVo;

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
public interface ILawSuitService {

	public void getVo(LawSuitVo vo);

	/**
	 * 
	 * findResultByName:从天眼查LawSuit
	 * 
	 * @author junkai.zhang
	 * @param name
	 * @param pageNum
	 * @return
	 */
	public LawSuit findResultByName(String name, Integer pageNum);

}
