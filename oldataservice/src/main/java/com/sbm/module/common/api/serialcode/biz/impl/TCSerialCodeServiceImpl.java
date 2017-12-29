package com.sbm.module.common.api.serialcode.biz.impl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.module.common.api.serialcode.biz.ITCSerialCodeService;
import com.sbm.module.common.api.serialcode.dao.ITCSerialCodeDao;
import com.sbm.module.common.api.serialcode.domain.TCSerialCode;
import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.impl.DaoSupportServiceImpl;
import com.sbm.module.common.business.constant.TransactionConstant;

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
public class TCSerialCodeServiceImpl extends DaoSupportServiceImpl<TCSerialCode> implements ITCSerialCodeService {

	@Autowired
	private ITCSerialCodeDao dao;

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
	private static DecimalFormat decimalFormat = new DecimalFormat("000000");

	public TCSerialCode findBySerialGroup(String serialGroup) {
		return dao.findBySerialGroup(serialGroup);
	}

	public TCSerialCode nextBizId(String serialGroup) {
		// 取当前流水号
		TCSerialCode obj = findBySerialGroup(serialGroup);
		// 查不到抛异常
		if (null == obj) {
			throw new BusinessException(BusinessCode.C9996, new Object[] { serialGroup }, null);
		}
		Integer currentNum = obj.getSerialNum();
		Date serialDate = obj.getSerialDate();

		// 如果流水日期为空，设为当前日期, 流水号重置为1
		if (null == obj.getSerialDate()) {
			serialDate = new Date();
			currentNum = 1;
		} else {
			// 比较流水日期与当前日期，如果是同一天，继续流水，否则重置
			if (simpleDateFormat.format(obj.getSerialDate()).equals(simpleDateFormat.format(new Date()))) {
				// 流水号+1
				currentNum++;
			} else {
				serialDate = new Date();
				currentNum = 1;
			}
		}

		// 重设流水号
		obj.setSerialNum(currentNum);
		obj.setSerialDate(serialDate);
		// 流水号更新到DB
		setBaseEntity(obj);
		dao.saveOrUpdate(obj);
		// 产生表单编号
		obj.setNextBizId(generalBizId(serialGroup, serialDate, currentNum));
		return obj;
	}

	private static String generalBizId(String prefix, Date date, int serialNum) {
		return prefix + simpleDateFormat.format(date) + decimalFormat.format(serialNum);
	}

}
