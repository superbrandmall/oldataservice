package com.sbm.module.onlineleasing.api.admin.user.biz;

import com.sbm.module.onlineleasing.api.admin.floor.domain.FloorVo;
import com.sbm.module.onlineleasing.api.admin.user.domain.UserVo;

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
public interface IUserVoService {

	void findAllByConditionPage(UserVo vo);

	void findByCode(UserVo vo);

}
