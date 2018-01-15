package com.sbm.module.onlineleasing.base.shop.biz;

import java.util.List;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.api.searchshop.domain.SearchShopVo;
import com.sbm.module.onlineleasing.base.shop.domain.TOLShop;

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
public interface ITOLShopService extends IDaoSupportService<TOLShop> {

	List<TOLShop> findAll();

	TOLShop findByCode(String code);

	TOLShop findByHdUuid(String hdUuid);

	List<TOLShop> findAllByCondition(TOLShop obj);

	Pagination<TOLShop> findAllByConditionPage(TOLShop obj);

	/**
	 * 
	 * saveShop:保存shop
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	void saveShop(TOLShop obj);

	/**
	 * 
	 * refreshCache:更新缓存
	 * 
	 * @author junkai.zhang
	 */
	void refreshCache();

	TOLShop findByCondition(TOLShop obj);

	List<TOLShop> findAllBySearchShop(SearchShopVo vo);

	/**
	 * 
	 * checkShopState:检查商户状态
	 * 
	 * @author junkai.zhang
	 * @param obj
	 */
	void checkShopState(TOLShop obj);
	
	List<TOLShop> findCountGroupByMall(String mallCode);
	
	List<TOLShop> findCountGroupByFloor(String floorCode);
	
	List<TOLShop> findCountGroupByMallBuildingFloor(String mallCode, String buildingCode, String floorCode);
}
