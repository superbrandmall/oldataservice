package com.sbm.module.onlineleasing.api.upload.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
public class Upload {

	private TOLFileUploadDetail vo;

	private MultipartFile[] files;

	private List<TOLFileUploadDetail> details = new ArrayList<TOLFileUploadDetail>();

	public TOLFileUploadDetail getVo() {
		return vo;
	}

	public void setVo(TOLFileUploadDetail vo) {
		this.vo = vo;
	}

	public MultipartFile[] getFiles() {
		return files;
	}

	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}

	public List<TOLFileUploadDetail> getDetails() {
		return details;
	}

	public void setDetails(List<TOLFileUploadDetail> details) {
		this.details = details;
	}

}
