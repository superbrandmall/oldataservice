package com.sbm.module.onlineleasing.base.myfavourite.biz;

import java.util.List;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.myfavourite.domain.TOLMyFavourite;

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
public interface ITOLMyFavouriteService extends IDaoSupportService<TOLMyFavourite> {

	public List<TOLMyFavourite> findAll();

	public List<TOLMyFavourite> findAllByUserCode(TOLMyFavourite obj);

	/**
	 * 
	 * findAllByUserCodePage:关注店铺分页
	 * 
	 * @author junkai.zhang
	 * @param obj
	 * @return
	 */
	public Pagination<TOLMyFavourite> findAllByUserCodePage(TOLMyFavourite obj);

	/**
	 * 
	 * findByUserCodeAndShopCode:根据用户code和商铺code查询
	 * 
	 * @author junkai.zhang
	 * @param obj
	 * @return
	 */
	public TOLMyFavourite findByUserCodeAndShopCode(TOLMyFavourite obj);

}
