package com.sbm.module.partner.hd.rest.contract.base.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.annotation.JSONField;
import com.sbm.module.partner.hd.rest.base.domain.HdBizType;
import com.sbm.module.partner.hd.rest.base.domain.HdUCN;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.rest.contract.base.domain<br/>
 * File Name:HdContract.java<br/>
 * 
 * 作成日 ：2017-11-20 下午4:09:54 <br/>
 * 
 * @author ：junkai.zhang
 */
public class HdContract {

	/**
	 * 模板名称
	 */
	private String template;

	/**
	 * OL合同id
	 */
	private String olContractId;

	/**
	 * 合同类型
	 */
	private String contractCategory;

	/**
	 * 合作方式
	 */
	private String coopMode;

	/**
	 * 结算方式
	 */
	private String accType;

	/**
	 * 法务异议
	 */
	private String legal_objection;

	/**
	 * 有效期天数
	 */
	private Integer effective_Days;

	/**
	 * 装修免租期
	 */
	private Integer free_days;

	/**
	 * 商户
	 */
	private HdUCN tenant;

	/**
	 * 品牌
	 */
	private HdUCN brand;

	/**
	 * 核算楼层 为空则默认取铺位的楼层
	 */
	private HdUCN floor;

	/**
	 * 业态
	 */
	private HdBizType bizType = new HdBizType();

	/**
	 * 计租面积 为空则默认取铺位的计租面积
	 */
	private BigDecimal rentArea;

	/**
	 * 店招 为空则默认取品牌名称
	 */
	private String signboard;

	/**
	 * 合同开始时间
	 */
	//@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date beginDate;

	/**
	 * 合同结束时间
	 */
	//@JSONField (format="yyyy-MM-dd HH:mm:ss")
	private Date endDate;

	/**
	 * 招商人员
	 */
	private HdUCN employee;

	/**
	 * 收银方式 unuse("不用POS自收银"), useRent("租用POS自收银"), usePublic("公用POS代收银");
	 */
	private String posMode;

	/**
	 * 铺位
	 */
	private HdUCN position;

	/**
	 * 月固定条款列表
	 */
	private List<HdMonthFixedTerm> monthFixeds = new ArrayList<>();

	/**
	 * 账款按科目取最大值条款列表
	 */
	private List<HdMaxSubjectTerm> maxSubjects = new ArrayList<>();

	/**
	 * 商品类别销售固定比例提成条款列表
	 */
	private List<HdNormalCategorySaleRateTerm> categorySaleRates = new ArrayList<>();

	/**
	 * 销售固定比例提成条款列表
	 */
	private List<HdNormalSaleRateTerm> normalSaleRates = new ArrayList<>();

	/**
	 * 免租条款列表
	 */
	private List<HdFreeAccountTerm> freeAccountTerms = new ArrayList<>();

	/**
	 * 预存款条款列表
	 */
	private List<HdDepositTerm> depositTerms = new ArrayList<>();

	/**
	 * 进场条款
	 */
	private HdEnteryTerm enteryTerm = new HdEnteryTerm();

	/**
	 * 自定义属性 供自定义字段使用，例如： Properties：｛ “olContractId”:”000sdf05848sdg48484” ｝
	 */
	private Map<String, String> properties;

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getOlContractId() {
		return olContractId;
	}

	public void setOlContractId(String olContractId) {
		this.olContractId = olContractId;
	}

	public String getContractCategory() {
		return contractCategory;
	}

	public void setContractCategory(String contractCategory) {
		this.contractCategory = contractCategory;
	}

	public String getCoopMode() {
		return coopMode;
	}

	public void setCoopMode(String coopMode) {
		this.coopMode = coopMode;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getLegal_objection() {
		return legal_objection;
	}

	public void setLegal_objection(String legal_objection) {
		this.legal_objection = legal_objection;
	}

	public Integer getEffective_Days() {
		return effective_Days;
	}

	public void setEffective_Days(Integer effective_Days) {
		this.effective_Days = effective_Days;
	}

	public Integer getFree_days() {
		return free_days;
	}

	public void setFree_days(Integer free_days) {
		this.free_days = free_days;
	}

	public HdUCN getTenant() {
		return tenant;
	}

	public void setTenant(HdUCN tenant) {
		this.tenant = tenant;
	}

	public HdUCN getBrand() {
		return brand;
	}

	public void setBrand(HdUCN brand) {
		this.brand = brand;
	}

	public HdUCN getFloor() {
		return floor;
	}

	public void setFloor(HdUCN floor) {
		this.floor = floor;
	}

	public HdBizType getBizType() {
		return bizType;
	}

	public void setBizType(HdBizType bizType) {
		this.bizType = bizType;
	}

	public BigDecimal getRentArea() {
		return rentArea;
	}

	public void setRentArea(BigDecimal rentArea) {
		this.rentArea = rentArea;
	}

	public String getSignboard() {
		return signboard;
	}

	public void setSignboard(String signboard) {
		this.signboard = signboard;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public HdUCN getEmployee() {
		return employee;
	}

	public void setEmployee(HdUCN employee) {
		this.employee = employee;
	}

	public String getPosMode() {
		return posMode;
	}

	public void setPosMode(String posMode) {
		this.posMode = posMode;
	}

	public HdUCN getPosition() {
		return position;
	}

	public void setPosition(HdUCN position) {
		this.position = position;
	}

	public List<HdMonthFixedTerm> getMonthFixeds() {
		return monthFixeds;
	}

	public void setMonthFixeds(List<HdMonthFixedTerm> monthFixeds) {
		this.monthFixeds = monthFixeds;
	}

	public List<HdMaxSubjectTerm> getMaxSubjects() {
		return maxSubjects;
	}

	public void setMaxSubjects(List<HdMaxSubjectTerm> maxSubjects) {
		this.maxSubjects = maxSubjects;
	}

	public List<HdNormalCategorySaleRateTerm> getCategorySaleRates() {
		return categorySaleRates;
	}

	public void setCategorySaleRates(List<HdNormalCategorySaleRateTerm> categorySaleRates) {
		this.categorySaleRates = categorySaleRates;
	}

	public List<HdNormalSaleRateTerm> getNormalSaleRates() {
		return normalSaleRates;
	}

	public void setNormalSaleRates(List<HdNormalSaleRateTerm> normalSaleRates) {
		this.normalSaleRates = normalSaleRates;
	}

	public List<HdFreeAccountTerm> getFreeAccountTerms() {
		return freeAccountTerms;
	}

	public void setFreeAccountTerms(List<HdFreeAccountTerm> freeAccountTerms) {
		this.freeAccountTerms = freeAccountTerms;
	}

	public List<HdDepositTerm> getDepositTerms() {
		return depositTerms;
	}

	public void setDepositTerms(List<HdDepositTerm> depositTerms) {
		this.depositTerms = depositTerms;
	}

	public HdEnteryTerm getEnteryTerm() {
		return enteryTerm;
	}

	public void setEnteryTerm(HdEnteryTerm enteryTerm) {
		this.enteryTerm = enteryTerm;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

}
