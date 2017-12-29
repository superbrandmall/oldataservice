package com.sbm.module.partner.tianyancha.rest.search.domain;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.partner.tianyancha.rest.search.domain<br/>
 * File Name:Search.java<br/>
 * 
 * 作成日 ：2017-8-30 下午1:55:17 <br/>
 * 
 * @author ：junkai.zhang
 */
public class SearchVo {

	/****************************************************/
	// input

	/**
	 * 搜索的关键词
	 */
	private String word;

	/****************************************************/
	// output

	private Search result;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Search getResult() {
		return result;
	}

	public void setResult(Search result) {
		this.result = result;
	}

}
