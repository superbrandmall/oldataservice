package com.sbm.module.onlineleasing.api.admin.mall.domain;

import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.mall.domain.TOLMall;
import com.sbm.module.onlineleasing.base.mallbidstandard.domain.TOLMallBidStandard;
import com.sbm.module.onlineleasing.base.malltraffic.domain.TOLMallTraffic;

import java.util.List;

public class MallVo {

	private TOLMall mall;

	private Pagination<TOLMall> pagination;

	private TOLMallTraffic traffic;

	private List<TOLMallTraffic> traffics;

	private TOLMallBidStandard mallBidStandard;

	public TOLMall getMall() {
		return mall;
	}

	public void setMall(TOLMall mall) {
		this.mall = mall;
	}

	public Pagination<TOLMall> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<TOLMall> pagination) {
		this.pagination = pagination;
	}

	public TOLMallTraffic getTraffic() {
		return traffic;
	}

	public void setTraffic(TOLMallTraffic traffic) {
		this.traffic = traffic;
	}

	public List<TOLMallTraffic> getTraffics() {
		return traffics;
	}

	public void setTraffics(List<TOLMallTraffic> traffics) {
		this.traffics = traffics;
	}

	public TOLMallBidStandard getMallBidStandard() {
		return mallBidStandard;
	}

	public void setMallBidStandard(TOLMallBidStandard mallBidStandard) {
		this.mallBidStandard = mallBidStandard;
	}
}
