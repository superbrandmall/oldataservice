package com.sbm.module.onlineleasing.api.baseinfo.base.domain;

import java.math.BigDecimal;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.onlineleasing.api.mallinfo.domain<br/>
 * File Name:ModalityProportionDetail.java<br/>
 * 
 * 作成日 ：2017-11-16 下午3:34:37 <br/>
 * 
 * @author ：junkai.zhang
 */
public class ModalityProportionDetail {

	/**
	 * 业态
	 */
	private String code;

	/**
	 * 数量
	 */
	private Long count;

	/**
	 * 占比
	 */
	private BigDecimal percentage;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public BigDecimal getPercentage() {
		return percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

}
