package com.sbm.module.partner.hd.mediaservice;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sbm.module.partner.hd.mediaservice.caller.BurlapServiceCaller;
import com.sbm.module.partner.hd.mediaservice.image.ImageSize;
import com.sbm.module.partner.hd.mediaservice.service.IFileProcessService;
import com.sbm.module.partner.hd.mediaservice.service.MediaSFileInfo;
import com.sbm.module.partner.hd.mediaservice.util.MediaSUtil;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.mediaservice<br/>
 * File Name:BurlapTest.java<br/>
 * 
 * 作成日 ：2017-11-2 下午4:40:22 <br/>
 * 
 * @author ：junkai.zhang
 */
public class BurlapTest {

	@SuppressWarnings("resource")
	public static void upload() throws Exception {
		IFileProcessService service = BurlapServiceCaller.getFileProcessService();
		File file = new File("C:/Users/Public/Pictures/Sample Pictures/菊花.jpg");

		long len = file.length();
		byte[] bytes = new byte[(int) len];

		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
		int r = bufferedInputStream.read(bytes);
		if (r != len)
			throw new IOException("读取文件不正确");
		bufferedInputStream.close();

		MediaSFileInfo info = service.uploadFile(bytes, "JBOSS里EJB集群例子.zip");
		System.out.println(info.getFileID());
		System.out.println(MediaSUtil.getImageLoadUrl(info.getFileID(), "123", ImageSize.SIZE_16_16));
	}

	@SuppressWarnings({ "resource", "unchecked", "rawtypes" })
	public static void uploadImage() throws Exception {
		IFileProcessService service = BurlapServiceCaller.getFileProcessService();
		File file = new File("C:/Users/Public/Pictures/Sample Pictures/菊花.jpg");

		long len = file.length();
		byte[] bytes = new byte[(int) len];

		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
		int r = bufferedInputStream.read(bytes);
		if (r != len)
			throw new IOException("读取文件不正确");
		bufferedInputStream.close();

		List imgSizes = new ArrayList();
		imgSizes.add(ImageSize.SIZE_64_64);
		imgSizes.add(ImageSize.SIZE_48_48);
		imgSizes.add(ImageSize.SIZE_16_16);
		imgSizes.add(new ImageSize(500, 500));
		MediaSFileInfo info = service.uploadImage(bytes, "1.jpg", imgSizes);
		System.out.println(info.getFileID());
		System.out.println(MediaSUtil.getImageLoadUrl(info.getFileID(), "123", ImageSize.SIZE_16_16));
	}

	public static void main(String[] args) throws Exception {
		uploadImage();
	}

}
