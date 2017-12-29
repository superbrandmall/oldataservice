package com.sbm.module.onlineleasing.api.register.biz;

import com.sbm.module.onlineleasing.api.register.domain.Register;

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
public interface IRegisterService {

	/**
	 * 
	 * step1:step1
	 * 
	 * @author junkai.zhang
	 * @param register
	 */
	public void step1(Register register);

	/**
	 * 
	 * step2:step2
	 * 
	 * @author junkai.zhang
	 * @param register
	 */
	public void step2(Register register);

	/**
	 * 
	 * step3AddExistingBrandWithoutUpdate:step3，已有品牌，不修改
	 * 
	 * @author junkai.zhang
	 * @param register
	 */
	public void step3AddExistingBrandWithoutUpdate(Register register);

	/**
	 * 
	 * step3AddNewBrand:step3，新增品牌
	 * 
	 * @author junkai.zhang
	 * @param register
	 */
	public void step3AddNewBrand(Register register);
}
