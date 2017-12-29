package com.sbm.module.onlineleasing.api.download.domain;

import com.sbm.module.onlineleasing.base.fileuploaddetail.domain.TOLFileUploadDetail;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.onlineleasingapi.upload.domain<br/>
 * File Name:MultiFileBucket.java<br/>
 * 
 * 作成日 ：2017-8-16 下午4:24:11 <br/>
 * 
 * @author ：junkai.zhang
 */
public class Download {

	private String key;

	private String type;

	private TOLFileUploadDetail detail;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TOLFileUploadDetail getDetail() {
		return detail;
	}

	public void setDetail(TOLFileUploadDetail detail) {
		this.detail = detail;
	}

}
