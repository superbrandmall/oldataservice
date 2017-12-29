package com.sbm.module.onlineleasing.api.baseinfo.floorinfo.biz;

import java.util.List;

import com.sbm.module.onlineleasing.api.baseinfo.floorinfo.domain.FloorInfo;
import com.sbm.module.onlineleasing.api.baseinfo.floorinfo.domain.FloorInfoVo;

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
public interface IFloorInfoService {

	public List<FloorInfo> findAll();

	/**
	 * 
	 * refreshCache:更新缓存
	 * 
	 * @author junkai.zhang
	 */
	public void refreshCache();

	public FloorInfo get(String code);

	public void getFloorInfo(FloorInfoVo vo);

}
