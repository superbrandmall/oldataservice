package com.sbm.module.onlineleasing.base.shopengineeringimages.domain;

import com.sbm.module.common.business.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
@Entity(name = "TOLShopEngineeringImages")
@Table(name = "T_OL_SHOP_ENGINEERING_IMAGES")
public class TOLShopEngineeringImages extends BaseEntity {

	private String code;

	private String attachmentType;

	@Column(columnDefinition = "text")
	private String image;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
