package com.sbm.module.partner.hd.mediaservice.service;

import java.io.Serializable;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.mediaservice.service<br/>
 * File Name:MediaSFileInfo.java<br/>
 * 
 * 作成日 ：2017-11-2 下午4:36:42 <br/>
 * 
 * @author ：junkai.zhang
 */
public class MediaSFileInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String fileID;
	private Long fileSize;
	private String fileName;

	public String getFileID() {
		return this.fileID;
	}

	public void setFileID(String fileID) {
		this.fileID = fileID;
	}

	public Long getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("fileID: " + this.fileID + ", ");
		sb.append("fileName: " + this.fileName + ", ");
		sb.append("fileSize: " + this.fileSize);
		return sb.toString();
	}

}
