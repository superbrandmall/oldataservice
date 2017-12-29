package com.sbm.module.partner.tianyancha.rest.abnormal.biz;

import com.sbm.module.partner.tianyancha.rest.abnormal.domain.Abnormal;
import com.sbm.module.partner.tianyancha.rest.abnormal.domain.AbnormalVo;

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
public interface IAbnormalService {

	public void getVo(AbnormalVo vo);

	/**
	 * 
	 * findResultByName:从天眼查Abnormal
	 * 
	 * @author junkai.zhang
	 * @param name
	 * @param pageNum
	 * @return
	 */
	public Abnormal findResultByName(String name, Integer pageNum);

	/**
	 * 
	 * findResultById:从天眼查Abnormal
	 * 
	 * @author junkai.zhang
	 * @param id
	 * @param pageNum
	 * @return
	 */
	public Abnormal findResultById(Long id, Integer pageNum);

}
