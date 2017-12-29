package com.sbm.module.onlineleasing.base.modality.biz;

import java.util.List;

import com.sbm.module.common.business.biz.IDaoSupportService;
import com.sbm.module.onlineleasing.base.modality.domain.TOLModality;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/
/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.biz<br/>
 * File Name:IEdiInteractiveDetailService.java<br/>
 * 
 * 作成日 ：2016-1-4 下午5:05:39 <br/>
 * 
 * @author ：junkai.zhang
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
public interface ITOLModalityService extends IDaoSupportService<TOLModality> {

	public List<TOLModality> findAll();

	/**
	 * 
	 * findAllByLvAndCode:通过业态级别和code模糊查询
	 * 
	 * @author junkai.zhang
	 * @param lv
	 * @param code
	 * @return
	 */
	public List<TOLModality> findAllByLvAndCode(String lv, String code);

	/**
	 * 
	 * findModalityList:查询业态列表
	 * 
	 * @author junkai.zhang
	 * @return
	 */
	public List<TOLModality> findModalityList();

	public TOLModality findByCode(String code, boolean cacheFlag);

	/**
	 * 
	 * refreshCache:更新缓存
	 * 
	 * @author junkai.zhang
	 */
	public void refreshCache();

	/**
	 * 
	 * getModalityName:获取业态名称
	 * 
	 * @author junkai.zhang
	 * @param obj
	 * @return
	 */
	public String getModalityName(TOLModality obj);

	/**
	 * 
	 * getModalityList:业态列表
	 * 
	 * @author junkai.zhang
	 * @return
	 */
	public List<TOLModality> getModalityList();

}
