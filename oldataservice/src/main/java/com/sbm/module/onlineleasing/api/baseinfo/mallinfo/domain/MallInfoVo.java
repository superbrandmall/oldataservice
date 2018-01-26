package com.sbm.module.onlineleasing.api.baseinfo.mallinfo.domain;

/*****************************************************************************/

import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;

import java.util.List;

/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.onlineleasing.api.mallinfo.domain<br/>
 * File Name:MallInfoVo.java<br/>
 * 
 * 作成日 ：2017-11-16 下午3:55:39 <br/>
 * 
 * @author ：junkai.zhang
 */
public class MallInfoVo {

	private String code;

	private MallInfo mallInfo;

	public List<TOLMall> malls;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public MallInfo getMallInfo() {
		return mallInfo;
	}

	public void setMallInfo(MallInfo mallInfo) {
		this.mallInfo = mallInfo;
	}

	public List<TOLMall> getMalls() {
		return malls;
	}

	public void setMalls(List<TOLMall> malls) {
		this.malls = malls;
	}
}
