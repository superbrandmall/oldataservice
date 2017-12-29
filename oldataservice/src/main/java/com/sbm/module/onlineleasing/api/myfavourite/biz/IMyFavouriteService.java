package com.sbm.module.onlineleasing.api.myfavourite.biz;

import com.sbm.module.onlineleasing.api.myfavourite.domain.MyFavourite;

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
public interface IMyFavouriteService {

	/**
	 * 
	 * getDetails:获取详细信息
	 * 
	 * @author junkai.zhang
	 * @param myFavourite
	 */
	public void getDetails(MyFavourite myFavourite);

	/**
	 * 
	 * save:添加关注
	 * 
	 * @author junkai.zhang
	 * @param myFavourite
	 */
	public void save(MyFavourite myFavourite);

	/**
	 * 
	 * delete:取消关注
	 * 
	 * @author junkai.zhang
	 * @param myFavourite
	 */
	public void delete(MyFavourite myFavourite);

}
