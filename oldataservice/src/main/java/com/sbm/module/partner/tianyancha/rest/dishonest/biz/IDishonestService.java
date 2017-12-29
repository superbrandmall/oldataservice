package com.sbm.module.partner.tianyancha.rest.dishonest.biz;

import com.sbm.module.partner.tianyancha.rest.dishonest.domain.Dishonest;
import com.sbm.module.partner.tianyancha.rest.dishonest.domain.DishonestVo;

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
public interface IDishonestService {

	public void getVo(DishonestVo vo);

	/**
	 * 
	 * findResultByName:从天眼查Dishonest
	 * 
	 * @author junkai.zhang
	 * @param name
	 * @param pageNum
	 * @return
	 */
	public Dishonest findResultByName(String name, Integer pageNum);

}
