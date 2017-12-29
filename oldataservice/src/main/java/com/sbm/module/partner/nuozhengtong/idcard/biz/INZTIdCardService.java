package com.sbm.module.partner.nuozhengtong.idcard.biz;

import com.sbm.module.partner.hl95.rest.sendSMS.domain.SendSMS;
import com.sbm.module.partner.hl95.rest.sendSMS.domain.SendSMSResult;
import com.sbm.module.partner.nuozhengtong.idcard.domain.NZTIdCard;
import com.sbm.module.partner.nuozhengtong.idcard.domain.NZTIdCardResult;

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
public interface INZTIdCardService {

	public NZTIdCardResult idCardCheck(String name, String idCard);

	public NZTIdCardResult idCardCheck(NZTIdCard nztIdCard);

	public void check(NZTIdCardResult result);
}
