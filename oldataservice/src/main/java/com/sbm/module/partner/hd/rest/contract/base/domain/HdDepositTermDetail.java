package com.sbm.module.partner.hd.rest.contract.base.domain;

import java.math.BigDecimal;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.rest.contract.base.domain<br/>
 * File Name:HdDepositTermDetail.java<br/>
 * 
 * 作成日 ：2017-11-20 下午4:30:10 <br/>
 * 
 * @author ：junkai.zhang
 */
public class HdDepositTermDetail {

	/**
	 * 金额
	 */
	private BigDecimal value;

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public HdDepositTermDetail() {
	}

	public HdDepositTermDetail(BigDecimal value) {
		this.value = value;
	}
}
