package com.sbm.module.onlineleasing.base.fileuploaddetail.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;
import com.sbm.module.onlineleasing.base.fileuploaddetail.biz.ITOLFileUploadDetailService;
import com.sbm.module.onlineleasing.base.fileuploaddetail.dao.ITOLFileUploadDetailDao;
import com.sbm.module.onlineleasing.base.fileuploaddetail.domain.TOLFileUploadDetail;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/
/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.biz.impl<br/>
 * File Name:EdiInteractiveDetailServiceImpl.java<br/>
 * 
 * 作成日 ：2016-1-4 下午5:05:55 <br/>
 * 
 * @author ：junkai.zhang 
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
/**
 * @preserve public
 */
@Component
@Transactional(value = TransactionConstant.OL, propagation = Propagation.REQUIRED)
public class TOLFileUploadDetailServiceImpl extends DaoSupportServiceImpl<TOLFileUploadDetail> implements
		ITOLFileUploadDetailService {

	@Autowired
	private ITOLFileUploadDetailDao dao;

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<TOLFileUploadDetail> findAll() {
		List<TOLFileUploadDetail> list = dao.findAll();
		return list;
	}

	@Transactional(value = TransactionConstant.OL, propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public TOLFileUploadDetail findByUri(String uri) {
		return dao.findByUri(uri);
	}

	public void saveOrUpdateDetail(TOLFileUploadDetail obj) {
		TOLFileUploadDetail po = findByUri(obj.getUri());
		// 不存在新增
		if (null == po) {
			po = new TOLFileUploadDetail();
			convert(po, obj);
			save(po);
		}
		// 存在更新
		else {
			convert(po, obj);
			update(po);
		}

	}

	/**
	 * 
	 * convert:转换
	 * 
	 * @author junkai.zhang
	 * @param po
	 * @param obj
	 */
	private void convert(TOLFileUploadDetail po, TOLFileUploadDetail obj) {
		po.setUserCode(obj.getUserCode());
		po.setUri(obj.getUri());
		po.setContainerName(obj.getContainerName());
		po.setPrefix(obj.getPrefix());
		po.setFileId(obj.getFileId());
		po.setSize(obj.getSize());
		po.setOriginalFilename(obj.getOriginalFilename());
		po.setSuffix(obj.getSuffix());
	}

}
