package com.sbm.module.onlineleasing.base.shopimages.biz;

import java.util.List;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.onlineleasing.base.shopimages.domain.TOLShopImages;

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
public interface ITOLShopImagesService extends IDaoSupportService<TOLShopImages> {

	public List<TOLShopImages> findAll();

	public List<TOLShopImages> findAllByCode(String code);
}
