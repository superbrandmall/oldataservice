package com.sbm.module.onlineleasing.base.searchshopdetail.biz;

import java.util.List;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.api.searchshop.domain.SearchShopVo;
import com.sbm.module.onlineleasing.base.searchshopdetail.domain.TOLSearchShopDetail;

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
public interface ITOLSearchShopDetailService extends IDaoSupportService<TOLSearchShopDetail> {

	public List<TOLSearchShopDetail> findAll();

	public TOLSearchShopDetail findByCode(String code);

	public TOLSearchShopDetail findByCondition(TOLSearchShopDetail obj);

	public void saveSearchShopDetail(TOLSearchShopDetail obj);

	/**
	 * 
	 * findAllBySearchShop:查询搜索店铺历史记录
	 * 
	 * @author junkai.zhang
	 * @param obj
	 * @return
	 */
	public List<TOLSearchShopDetail> findAllBySearchShop(SearchShopVo obj);

	/**
	 * 
	 * findAllBySearchShop:查询搜索店铺历史记录，分页数据
	 * 
	 * @author junkai.zhang
	 * @param obj
	 * @return
	 */
	public Pagination<TOLSearchShopDetail> findAllBySearchShopPage(SearchShopVo obj);

}
