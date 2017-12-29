package com.sbm.module.partner.tianyancha.rest.punishmentinfo.biz;

import com.sbm.module.partner.tianyancha.rest.punishmentinfo.domain.PunishmentInfo;
import com.sbm.module.partner.tianyancha.rest.punishmentinfo.domain.PunishmentInfoVo;

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
public interface IPunishmentInfoService {

	public void getVo(PunishmentInfoVo vo);

	/**
	 * 
	 * findResultByName:从天眼查PunishmentInfo
	 * 
	 * @author junkai.zhang
	 * @param name
	 * @param pageNum
	 * @return
	 */
	public PunishmentInfo findResultByName(String name, Integer pageNum);

}
