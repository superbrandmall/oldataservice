package com.sbm.module.onlineleasing.job.clean.init;

import java.io.File;

import org.springframework.stereotype.Component;

import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.base.init.InitAfterLoad;
import com.sbm.module.common.business.init.WebInitializer;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.onlineleasingjob.cache.modality.init<br/>
 * File Name:ModalityInit.java<br/>
 * 
 * 作成日 ：2017-8-17 下午5:54:14 <br/>
 * 
 * @author ：junkai.zhang
 */
@Component
public class CleanInit implements InitAfterLoad {

	public void init() {
		File dir = new File(WebInitializer.LOCATION);
		if (!dir.exists() || !dir.isDirectory()) {
			dir.mkdirs();
		} else {
			File[] files = dir.listFiles();
			for (File file : files) {
				file.delete();
				CommonConstant.FRAMEWORK.info("delete file : " + file.getName());
			}
		}
	}

}
