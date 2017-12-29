package com.sbm.module.onlineleasing.api.baseinfo.floorinfo.domain;

import com.sbm.module.onlineleasing.api.baseinfo.base.domain.ModalityProportion;
import com.sbm.module.onlineleasing.base.floor.domain.TOLFloor;

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
public class FloorInfo {

	private TOLFloor floor;

	private ModalityProportion proportion;

	public TOLFloor getFloor() {
		return floor;
	}

	public void setFloor(TOLFloor floor) {
		this.floor = floor;
	}

	public ModalityProportion getProportion() {
		return proportion;
	}

	public void setProportion(ModalityProportion proportion) {
		this.proportion = proportion;
	}

}
