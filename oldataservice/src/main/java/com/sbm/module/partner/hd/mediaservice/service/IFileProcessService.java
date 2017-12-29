package com.sbm.module.partner.hd.mediaservice.service;

import java.util.List;

import javax.servlet.ServletException;

import com.sbm.module.partner.hd.mediaservice.image.ImageSize;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.mediaservice.service<br/>
 * File Name:IFileProcessService.java<br/>
 * 
 * 作成日 ：2017-11-2 下午4:35:46 <br/>
 * 
 * @author ：junkai.zhang
 */
public abstract interface IFileProcessService {

	public abstract MediaSFileInfo uploadFile(byte[] paramArrayOfByte, String paramString) throws ServletException;

	public abstract MediaSFileInfo uploadImage(byte[] paramArrayOfByte, String paramString, List<ImageSize> paramList)
			throws ServletException;

	public abstract MediaSFileInfo getMediaSFileInfo(String paramString) throws ServletException;

	public abstract void remove(String paramString) throws ServletException;

	public abstract byte[] getFile(String paramString) throws ServletException;

	public abstract byte[] getImage(String paramString, ImageSize paramImageSize) throws ServletException;

}
