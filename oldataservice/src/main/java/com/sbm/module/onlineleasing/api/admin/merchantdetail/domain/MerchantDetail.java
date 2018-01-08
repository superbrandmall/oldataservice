package com.sbm.module.onlineleasing.api.admin.merchantdetail.domain;

import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.merchantdetail.courtannouncement.domain.TOLMerchantCourtAnnouncement;
import com.sbm.module.onlineleasing.base.merchantdetail.illegalinfo.domain.TOLMerchantIllegalInfo;
import com.sbm.module.onlineleasing.base.merchantdetail.lawsuit.domain.TOLMerchantLawsuit;
import com.sbm.module.onlineleasing.base.merchantdetail.owntax.domain.TOLMerchantOwnTax;
import com.sbm.module.onlineleasing.base.merchantdetail.punishmentinfo.domain.TOLMerchantPunishmentInfo;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.onlineleasing.api.merchantdetail.domain<br/>
 * File Name:MerchantDetail.java<br/>
 * 
 * 作成日 ：2017-10-23 下午3:10:05 <br/>
 * 
 * @author ：junkai.zhang
 */
public class MerchantDetail {

	private TOLMerchantCourtAnnouncement merchantCourtAnnouncement;

	private TOLMerchantIllegalInfo merchantIllegalInfo;

	private TOLMerchantLawsuit merchantLawsuit;

	private TOLMerchantOwnTax merchantOwnTax;

	private TOLMerchantPunishmentInfo merchantPunishmentInfo;

	/**********************************************************************/

	private Pagination<TOLMerchantCourtAnnouncement> merchantCourtAnnouncements;

	private Pagination<TOLMerchantIllegalInfo> merchantIllegalInfos;

	private Pagination<TOLMerchantLawsuit> merchantLawsuits;

	private Pagination<TOLMerchantOwnTax> merchantOwnTaxs;

	private Pagination<TOLMerchantPunishmentInfo> merchantPunishmentInfos;

	public TOLMerchantCourtAnnouncement getMerchantCourtAnnouncement() {
		return merchantCourtAnnouncement;
	}

	public void setMerchantCourtAnnouncement(TOLMerchantCourtAnnouncement merchantCourtAnnouncement) {
		this.merchantCourtAnnouncement = merchantCourtAnnouncement;
	}

	public TOLMerchantIllegalInfo getMerchantIllegalInfo() {
		return merchantIllegalInfo;
	}

	public void setMerchantIllegalInfo(TOLMerchantIllegalInfo merchantIllegalInfo) {
		this.merchantIllegalInfo = merchantIllegalInfo;
	}

	public TOLMerchantLawsuit getMerchantLawsuit() {
		return merchantLawsuit;
	}

	public void setMerchantLawsuit(TOLMerchantLawsuit merchantLawsuit) {
		this.merchantLawsuit = merchantLawsuit;
	}

	public TOLMerchantOwnTax getMerchantOwnTax() {
		return merchantOwnTax;
	}

	public void setMerchantOwnTax(TOLMerchantOwnTax merchantOwnTax) {
		this.merchantOwnTax = merchantOwnTax;
	}

	public TOLMerchantPunishmentInfo getMerchantPunishmentInfo() {
		return merchantPunishmentInfo;
	}

	public void setMerchantPunishmentInfo(TOLMerchantPunishmentInfo merchantPunishmentInfo) {
		this.merchantPunishmentInfo = merchantPunishmentInfo;
	}

	public Pagination<TOLMerchantCourtAnnouncement> getMerchantCourtAnnouncements() {
		return merchantCourtAnnouncements;
	}

	public void setMerchantCourtAnnouncements(Pagination<TOLMerchantCourtAnnouncement> merchantCourtAnnouncements) {
		this.merchantCourtAnnouncements = merchantCourtAnnouncements;
	}

	public Pagination<TOLMerchantIllegalInfo> getMerchantIllegalInfos() {
		return merchantIllegalInfos;
	}

	public void setMerchantIllegalInfos(Pagination<TOLMerchantIllegalInfo> merchantIllegalInfos) {
		this.merchantIllegalInfos = merchantIllegalInfos;
	}

	public Pagination<TOLMerchantLawsuit> getMerchantLawsuits() {
		return merchantLawsuits;
	}

	public void setMerchantLawsuits(Pagination<TOLMerchantLawsuit> merchantLawsuits) {
		this.merchantLawsuits = merchantLawsuits;
	}

	public Pagination<TOLMerchantOwnTax> getMerchantOwnTaxs() {
		return merchantOwnTaxs;
	}

	public void setMerchantOwnTaxs(Pagination<TOLMerchantOwnTax> merchantOwnTaxs) {
		this.merchantOwnTaxs = merchantOwnTaxs;
	}

	public Pagination<TOLMerchantPunishmentInfo> getMerchantPunishmentInfos() {
		return merchantPunishmentInfos;
	}

	public void setMerchantPunishmentInfos(Pagination<TOLMerchantPunishmentInfo> merchantPunishmentInfos) {
		this.merchantPunishmentInfos = merchantPunishmentInfos;
	}

}
