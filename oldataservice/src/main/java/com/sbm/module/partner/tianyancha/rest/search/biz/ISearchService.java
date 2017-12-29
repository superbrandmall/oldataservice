package com.sbm.module.partner.tianyancha.rest.search.biz;

import com.sbm.module.partner.tianyancha.rest.search.domain.Search;
import com.sbm.module.partner.tianyancha.rest.search.domain.SearchVo;

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
public interface ISearchService {

	public void getVo(SearchVo vo);

	/**
	 * 
	 * findResultByWord:从天眼查search
	 * 
	 * @author junkai.zhang
	 * @param word
	 * @return
	 */
	public Search findResultByWord(String word);

	public void check(Search result);
}
