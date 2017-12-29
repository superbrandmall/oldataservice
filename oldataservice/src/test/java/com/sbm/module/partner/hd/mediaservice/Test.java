package com.sbm.module.partner.hd.mediaservice;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.sbm.module.partner.hd.mediaservice.caller.BurlapServiceCaller;
import com.sbm.module.partner.hd.mediaservice.constants.MediaSConstants;
import com.sbm.module.partner.hd.mediaservice.image.ImageSize;
import com.sbm.module.partner.hd.mediaservice.service.IFileProcessService;
import com.sbm.module.partner.hd.mediaservice.service.MediaSFileInfo;
import com.sbm.module.partner.hd.mediaservice.util.MediaSUtil;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.mediaservice<br/>
 * File Name:Test.java<br/>
 * 
 * 作成日 ：2017-11-2 下午4:42:46 <br/>
 * 
 * @author ：junkai.zhang
 */
public class Test {

	//@org.junit.Test
	@SuppressWarnings("resource")
	public void uploadImage() throws Exception {
		try {
			// 1. 根据部署情况，指定URL常量
			MediaSConstants.URL = "http://cre.trunk.hd123.cn/HDMediaService-web";

			// 2. 构造文件上传请求
			IFileProcessService service = BurlapServiceCaller.getFileProcessService();
			// File file = new
			// File("C:/Users/Public/Pictures/Sample Pictures/Desert.jpg");
			File file = new File("D:/海鼎会员系统对外接口说明.pdf");

			long len = file.length();
			byte[] bytes = new byte[(int) len];

			BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
			int r = bufferedInputStream.read(bytes);
			if (r != len)
				throw new IOException("读取文件不正确");
			bufferedInputStream.close();

			// MediaSFileInfo info = service.uploadImage(bytes,
			// "bpm_设置_任务缺少执行人通知.png", null);
			MediaSFileInfo info = service.uploadFile(bytes, file.getName());

			// 文件在媒体服务器的
			System.out.println(info.getFileID());

			// 访问图片URL
			System.out.println(MediaSUtil.getImageLoadUrl(info.getFileID(), file.getName(), ImageSize.SIZE_64_64));
			// 文件URL
			System.out.println(MediaSUtil.getFileGetUrl(info.getFileID(), file.getName(), ImageSize.SIZE_DEFAULT));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@org.junit.Test
	public void download() throws Exception {
		try {
			IFileProcessService service = BurlapServiceCaller.getFileProcessService();
			String paramString = "2bca6189f70aa63dfa8e9fe91f461a268993f858b5607b6c94608e8f298f8e7d66994f119b191b45";
			MediaSFileInfo info = service.getMediaSFileInfo(paramString);
			System.out.println(JSON.toJSONString(info));
			
			//byte[] bytes = service.getFile(paramString);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
