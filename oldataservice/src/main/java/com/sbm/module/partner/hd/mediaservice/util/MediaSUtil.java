package com.sbm.module.partner.hd.mediaservice.util;

import com.sbm.module.partner.hd.mediaservice.constants.MediaSConstants;
import com.sbm.module.partner.hd.mediaservice.image.ImageSize;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.mediaservice.util<br/>
 * File Name:MediaSUtil.java<br/>
 * 
 * 作成日 ：2017-11-2 下午4:38:55 <br/>
 * 
 * @author ：junkai.zhang
 */
public class MediaSUtil {

	public static final String PARAM_FILEID = "fileID";
	public static final String PARAM_SIZE = "size";
	public static final String PARAM_FILENAME = "fileName";
	public static final String URL_PATH_IMAGELOAD = "/imageload";
	public static final String URL_PATH_FILEGET = "/fileget";
	public static final String[] IMAGE_SUFFIX = { "jpg", "jpeg", "gif", "bmp", "png" };

	public static boolean supportResize(String suffix) {
		if ((suffix == null) || ("".equals(suffix.trim()))) {
			return false;
		}
		if (suffix.startsWith(".")) {
			suffix = suffix.substring(1);
		}
		for (String s : IMAGE_SUFFIX)
			if (s.equalsIgnoreCase(suffix))
				return true;
		return false;
	}

	public static String getImageLoadUrl(String fileID, String fileName, ImageSize imageSize) {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append(MediaSConstants.URL);
			sb.append("/imageload?");
			sb.append("fileID=");
			sb.append(fileID);

			if ((fileName != null) && (!"".equals(fileName.trim()))) {
				sb.append("&");
				sb.append("fileName=");
				sb.append(new DesUtils().encrypt(fileName));
			}

			if (imageSize != null) {
				sb.append("&");
				sb.append("size=");
				sb.append(imageSize.getParamString());
			}

			return sb.toString();
		} catch (Exception e) {
		}
		return "";
	}

	public static String getFileGetUrl(String fileID, String fileName, ImageSize imageSize) {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append(MediaSConstants.URL);
			sb.append("/fileget?");
			sb.append("fileID=");
			sb.append(fileID);

			if ((fileName != null) && (!"".equals(fileName.trim()))) {
				sb.append("&");
				sb.append("fileName=");
				sb.append(new DesUtils().encrypt(fileName));
			}

			if (imageSize != null) {
				sb.append("&");
				sb.append("size=");
				sb.append(imageSize.getParamString());
			}

			return sb.toString();
		} catch (Exception e) {
		}
		return "";
	}
}
