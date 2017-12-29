package com.sbm.module.partner.tianyancha.rest.owntax.biz;

import com.sbm.module.partner.tianyancha.rest.owntax.domain.OwnTax;
import com.sbm.module.partner.tianyancha.rest.owntax.domain.OwnTaxVo;

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
public interface IOwnTaxService {

	public void getVo(OwnTaxVo vo);

	/**
	 * 
	 * findResultByName:从天眼查OwnTax
	 * 
	 * @author junkai.zhang
	 * @param name
	 * @param pageNum
	 * @return
	 */
	public OwnTax findResultByName(String name, Integer pageNum);

	/**
	 * 
	 * findResultById:从天眼查OwnTax
	 * 
	 * @author junkai.zhang
	 * @param id
	 * @param pageNum
	 * @return
	 */
	public OwnTax findResultById(Long id, Integer pageNum);

}
