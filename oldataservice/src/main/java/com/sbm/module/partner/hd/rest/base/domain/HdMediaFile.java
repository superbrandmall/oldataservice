package com.sbm.module.partner.hd.rest.base.domain;

/*****************************************************************************/

import java.util.Date;

/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.rest.base.domain<br/>
 * File Name:HdMediaFile.java<br/>
 * 
 * 作成日 ：2017-11-24 下午4:22:38 <br/>
 * 
 * @author ：junkai.zhang
 */
public class HdMediaFile {

	private String id;

	private String attachmentType;

	private String name;

	private String caption;

	private String fileType;

	private Integer size;

	private String md5;

	private String uploader;

	private Date uploadTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getUploader() {
		return uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
}
