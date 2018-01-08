package com.sbm.module.onlineleasing.base.bid.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sbm.module.common.business.domain.BaseEntity;

/*****************************************************************************/
/**
 * Project Name:CRMDataProcess<br/>
 * Package Name:com.sbm.module.gag.domain<br/>
 * File Name:GAGReceipt.java<br/>
 * 
 * 作成日 ：2017-4-13 下午5:58:11 <br/>
 * 
 * @author ：junkai.zhang
 */
@Entity(name = "TOLBid")
@Table(name = "T_OL_BID")
public class TOLBid extends BaseEntity {

	private String code;

	private String userCode;

	@Transient
	private String email;

	private String merchantCode;

	@Transient
	private String merchantName;

	private String shopCode;

	@Transient
	private String unit;

	@Transient
	private String mallName;

	@Transient
	private String buildingName;

	@Transient
	private String floorName;

	private String brandCode;

	@Transient
	private String brandName;

	@Column(columnDefinition = "timestamp")
	private Date startDate;

	@Column(columnDefinition = "timestamp")
	private Date endDate;

	private Integer contractLength;

	private Integer leaseType;

	private Integer accType;

	private Integer rentMethod;

	private Integer compareFrequency;

	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal gurantee;

	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal maintenanceDuringDecoration;

	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal maintenanceAfterDecoration;

	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal target;

	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal publicDeposit;

	private Integer promotion;

	private Integer freeDays;

	private Integer promotionKind;

	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal promotionBudget;

	@Column(columnDefinition = "timestamp")
	private Date opening;

	private Integer cashierMode;

	private Integer businessHours;

	private String extraBusinessHour_1;

	private String extraBusinessHour_2;

	@Column(columnDefinition = "text")
	private String others;

	private Integer extendedDecoration;

	private Integer businessFreePeriod;

	private Integer freeAdsNo;

	@Column(columnDefinition = "decimal(15,2)")
	private BigDecimal practiceRateReached;

	@Column(columnDefinition = "text")
	private String transferCondition;

	@Column(columnDefinition = "text")
	private String maintenanceCompensate;

	@Column(columnDefinition = "text")
	private String exclusiveCondition;

	@Column(columnDefinition = "text")
	private String bindingCondition;

	/**
	 * 处理状态
	 */
	private Integer processState;

	@Column(columnDefinition = "text")
	private String legalSuggest;

	@Column(columnDefinition = "text")
	private String businessSuggest;

	/**
	 * 标准/非标
	 */
	private Integer isStandard;

	/**
	 * 审批结果
	 */
	private Integer isApprove;

	/**
	 * 审批结果列表
	 */
	@Transient
	private List<Integer> isApproves;

	/**
	 * 是否生效
	 */
	private Integer isEffect;

	/**
	 * 过期日期
	 */
	@Column(columnDefinition = "timestamp")
	private Date expireDate;

	private String billNumber;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getRentMethod() {
		return rentMethod;
	}

	public void setRentMethod(Integer rentMethod) {
		this.rentMethod = rentMethod;
	}

	public Integer getCompareFrequency() {
		return compareFrequency;
	}

	public void setCompareFrequency(Integer compareFrequency) {
		this.compareFrequency = compareFrequency;
	}

	public BigDecimal getGurantee() {
		return gurantee;
	}

	public void setGurantee(BigDecimal gurantee) {
		this.gurantee = gurantee;
	}

	public Integer getContractLength() {
		return contractLength;
	}

	public void setContractLength(Integer contractLength) {
		this.contractLength = contractLength;
	}

	public Integer getLeaseType() {
		return leaseType;
	}

	public void setLeaseType(Integer leaseType) {
		this.leaseType = leaseType;
	}

	public BigDecimal getMaintenanceDuringDecoration() {
		return maintenanceDuringDecoration;
	}

	public void setMaintenanceDuringDecoration(BigDecimal maintenanceDuringDecoration) {
		this.maintenanceDuringDecoration = maintenanceDuringDecoration;
	}

	public BigDecimal getMaintenanceAfterDecoration() {
		return maintenanceAfterDecoration;
	}

	public void setMaintenanceAfterDecoration(BigDecimal maintenanceAfterDecoration) {
		this.maintenanceAfterDecoration = maintenanceAfterDecoration;
	}

	public BigDecimal getTarget() {
		return target;
	}

	public void setTarget(BigDecimal target) {
		this.target = target;
	}

	public BigDecimal getPublicDeposit() {
		return publicDeposit;
	}

	public void setPublicDeposit(BigDecimal publicDeposit) {
		this.publicDeposit = publicDeposit;
	}

	public Integer getPromotion() {
		return promotion;
	}

	public void setPromotion(Integer promotion) {
		this.promotion = promotion;
	}

	public Integer getFreeDays() {
		return freeDays;
	}

	public void setFreeDays(Integer freeDays) {
		this.freeDays = freeDays;
	}

	public Integer getPromotionKind() {
		return promotionKind;
	}
	public Integer getAccType() {
		return accType;
	}

	public void setAccType(Integer accType) {
		this.accType = accType;
	}

	public void setPromotionKind(Integer promotionKind) {
		this.promotionKind = promotionKind;
	}

	public BigDecimal getPromotionBudget() {
		return promotionBudget;
	}

	public void setPromotionBudget(BigDecimal promotionBudget) {
		this.promotionBudget = promotionBudget;
	}

	public Date getOpening() {
		return opening;
	}

	public void setOpening(Date opening) {
		this.opening = opening;
	}

	public Integer getCashierMode() {
		return cashierMode;
	}

	public void setCashierMode(Integer cashierMode) {
		this.cashierMode = cashierMode;
	}

	public Integer getBusinessHours() {
		return businessHours;
	}

	public void setBusinessHours(Integer businessHours) {
		this.businessHours = businessHours;
	}

	public String getExtraBusinessHour_1() {
		return extraBusinessHour_1;
	}

	public void setExtraBusinessHour_1(String extraBusinessHour_1) {
		this.extraBusinessHour_1 = extraBusinessHour_1;
	}

	public String getExtraBusinessHour_2() {
		return extraBusinessHour_2;
	}

	public List<Integer> getIsApproves() {
		return isApproves;
	}

	public void setIsApproves(List<Integer> isApproves) {
		this.isApproves = isApproves;
	}

	public void setExtraBusinessHour_2(String extraBusinessHour_2) {
		this.extraBusinessHour_2 = extraBusinessHour_2;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public Integer getExtendedDecoration() {
		return extendedDecoration;
	}

	public void setExtendedDecoration(Integer extendedDecoration) {
		this.extendedDecoration = extendedDecoration;
	}

	public Integer getBusinessFreePeriod() {
		return businessFreePeriod;
	}

	public void setBusinessFreePeriod(Integer businessFreePeriod) {
		this.businessFreePeriod = businessFreePeriod;
	}

	public Integer getFreeAdsNo() {
		return freeAdsNo;
	}

	public void setFreeAdsNo(Integer freeAdsNo) {
		this.freeAdsNo = freeAdsNo;
	}

	public BigDecimal getPracticeRateReached() {
		return practiceRateReached;
	}

	public void setPracticeRateReached(BigDecimal practiceRateReached) {
		this.practiceRateReached = practiceRateReached;
	}

	public String getTransferCondition() {
		return transferCondition;
	}

	public void setTransferCondition(String transferCondition) {
		this.transferCondition = transferCondition;
	}

	public String getMaintenanceCompensate() {
		return maintenanceCompensate;
	}

	public void setMaintenanceCompensate(String maintenanceCompensate) {
		this.maintenanceCompensate = maintenanceCompensate;
	}

	public String getExclusiveCondition() {
		return exclusiveCondition;
	}

	public void setExclusiveCondition(String exclusiveCondition) {
		this.exclusiveCondition = exclusiveCondition;
	}

	public String getBindingCondition() {
		return bindingCondition;
	}

	public void setBindingCondition(String bindingCondition) {
		this.bindingCondition = bindingCondition;
	}

	public Integer getProcessState() {
		return processState;
	}

	public void setProcessState(Integer processState) {
		this.processState = processState;
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

	public Integer getIsStandard() {
		return isStandard;
	}

	public void setIsStandard(Integer isStandard) {
		this.isStandard = isStandard;
	}

	public Integer getIsApprove() {
		return isApprove;
	}

	public void setIsApprove(Integer isApprove) {
		this.isApprove = isApprove;
	}

	public Integer getIsEffect() {
		return isEffect;
	}

	public void setIsEffect(Integer isEffect) {
		this.isEffect = isEffect;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getMallName() {
		return mallName;
	}

	public void setMallName(String mallName) {
		this.mallName = mallName;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
