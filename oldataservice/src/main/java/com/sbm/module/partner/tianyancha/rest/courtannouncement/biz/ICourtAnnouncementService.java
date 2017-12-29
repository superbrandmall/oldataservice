package com.sbm.module.partner.tianyancha.rest.courtannouncement.biz;

import com.sbm.module.partner.tianyancha.rest.courtannouncement.domain.CourtAnnouncements;
import com.sbm.module.partner.tianyancha.rest.courtannouncement.domain.CourtAnnouncementsVo;

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
public interface ICourtAnnouncementService {

	public void getVo(CourtAnnouncementsVo vo);

	/**
	 * 
	 * findResultByName:从天眼查CourtAnnouncements
	 * 
	 * @author junkai.zhang
	 * @param name
	 * @param pageNum
	 * @return
	 */
	public CourtAnnouncements findResultByName(String name, Integer pageNum);

}
