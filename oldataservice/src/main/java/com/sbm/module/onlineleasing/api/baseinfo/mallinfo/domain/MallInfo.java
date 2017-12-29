package com.sbm.module.onlineleasing.api.baseinfo.mallinfo.domain;

import java.util.List;

import com.sbm.module.onlineleasing.api.baseinfo.base.domain.ModalityProportion;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;
import com.sbm.module.onlineleasing.base.malltraffic.domain.TOLMallTraffic;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.onlineleasing.api.mallinfo.domain<br/>
 * File Name:MallInfo.java<br/>
 * 
 * 作成日 ：2017-11-16 下午3:12:03 <br/>
 * 
 * @author ：junkai.zhang
 */
public class MallInfo {

	private TOLMall mall;

	private List<TOLMallTraffic> traffics;

	private ModalityProportion proportion;

	public TOLMall getMall() {
		return mall;
	}

	public void setMall(TOLMall mall) {
		this.mall = mall;
	}

	public ModalityProportion getProportion() {
		return proportion;
	}

	public void setProportion(ModalityProportion proportion) {
		this.proportion = proportion;
	}

	public List<TOLMallTraffic> getTraffics() {
		return traffics;
	}

	public void setTraffics(List<TOLMallTraffic> traffics) {
		this.traffics = traffics;
	}

}
