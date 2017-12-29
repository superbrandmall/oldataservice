package com.sbm.module.onlineleasing.api.baseinfo.mallinfo.biz;

import java.util.List;

import com.sbm.module.onlineleasing.api.baseinfo.mallinfo.domain.MallInfo;
import com.sbm.module.onlineleasing.api.baseinfo.mallinfo.domain.MallInfoVo;

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
public interface IMallInfoService {

	public List<MallInfo> findAll();

	/**
	 * 
	 * refreshCache:更新缓存
	 * 
	 * @author junkai.zhang
	 */
	public void refreshCache();

	public MallInfo get(String code);

	public void getMallInfo(MallInfoVo vo);

}
