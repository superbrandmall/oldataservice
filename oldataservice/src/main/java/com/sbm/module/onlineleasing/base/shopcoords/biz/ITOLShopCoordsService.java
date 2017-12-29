package com.sbm.module.onlineleasing.base.shopcoords.biz;

import java.util.List;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.onlineleasing.base.shopcoords.domain.TOLShopCoords;

/*****************************************************************************/

/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.onlineleasing.shop.biz<br/>
 * File Name:ITOLShopService.java<br/>
 * <p>
 * 作成日 ：2017-5-18 下午4:34:06 <br/>
 *
 * @author ：junkai.zhang
 */
public interface ITOLShopCoordsService extends IDaoSupportService<TOLShopCoords> {

	List<TOLShopCoords> findAll();

	TOLShopCoords findByCode(String code);

	TOLShopCoords findByCondition(TOLShopCoords obj);

}
