package com.sbm.module.onlineleasing.api.bid.domain;

import com.sbm.module.common.business.domain.BaseEntity;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.onlineleasingapi.bid.domain<br/>
 * File Name:BidDetail.java<br/>
 * 
 * 作成日 ：2017-8-18 上午10:23:05 <br/>
 * 
 * @author ：junkai.zhang
 */
public class SuggestVo extends BaseEntity {

	private String code;

	private String legalSuggest;

	private String businessSuggest;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLegalSuggest() {
		return legalSuggest;
	}

	public void setLegalSuggest(String legalSuggest) {
		this.legalSuggest = legalSuggest;
	}

	public String getBusinessSuggest() {
		return businessSuggest;
	}

	public void setBusinessSuggest(String businessSuggest) {
		this.businessSuggest = businessSuggest;
	}

}
