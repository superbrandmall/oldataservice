package com.sbm.module.onlineleasing.api.baseinfo.base.domain;

import java.util.ArrayList;
import java.util.List;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.onlineleasing.api.mallinfo.domain<br/>
 * File Name:ModalityProportion.java<br/>
 * 
 * 作成日 ：2017-11-16 下午3:12:37 <br/>
 * 
 * @author ：junkai.zhang 
 */
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.onlineleasing.api.mallinfo.domain<br/>
 * File Name:ModalityProportion.java<br/>
 * 
 * 作成日 ：2017-11-16 下午3:12:37 <br/>
 * 
 * @author ：junkai.zhang
 */
public class ModalityProportion {

	private String mallCode;

	private String buildingCode;

	private String floorCode;

	private List<ModalityProportionDetail> details = new ArrayList<ModalityProportionDetail>();

	public String getMallCode() {
		return mallCode;
	}

	public void setMallCode(String mallCode) {
		this.mallCode = mallCode;
	}

	public String getBuildingCode() {
		return buildingCode;
	}

	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}

	public String getFloorCode() {
		return floorCode;
	}

	public void setFloorCode(String floorCode) {
		this.floorCode = floorCode;
	}

	public List<ModalityProportionDetail> getDetails() {
		return details;
	}

	public void setDetails(List<ModalityProportionDetail> details) {
		this.details = details;
	}

}
