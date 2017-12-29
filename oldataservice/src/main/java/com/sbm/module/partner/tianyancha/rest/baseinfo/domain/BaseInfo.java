package com.sbm.module.partner.tianyancha.rest.baseinfo.domain;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.partner.tianyancha.rest.baseinfo.domain<br/>
 * File Name:BaseInfoVo.java<br/>
 * 
 * 作成日 ：2017-8-30 上午9:23:20 <br/>
 * 
 * @author ：junkai.zhang
 */
public class BaseInfo {

	private String uri;

	/**
	 * 错误代码
	 */
	private Integer error_code;

	/**
	 * 错误原因
	 */
	private String reason;

	/**
	 * 返回内容
	 */
	private BaseInfoResult result;

	public Integer getError_code() {
		return error_code;
	}

	public void setError_code(Integer error_code) {
		this.error_code = error_code;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public BaseInfoResult getResult() {
		return result;
	}

	public void setResult(BaseInfoResult result) {
		this.result = result;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
