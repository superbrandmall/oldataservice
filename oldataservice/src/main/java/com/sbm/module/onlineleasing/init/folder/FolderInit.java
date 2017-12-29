package com.sbm.module.onlineleasing.init.folder;

import java.io.File;

import org.springframework.stereotype.Component;

import com.sbm.module.common.base.init.InitAfterLoad;
import com.sbm.module.common.business.constant.ApplicationConstant;

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
public class FolderInit implements InitAfterLoad {

	public void init() {
		File dir = null;
		for (String folder : ApplicationConstant.FOLDERS) {
			dir = new File(folder);
			if (!dir.exists() || !dir.isDirectory()) {
				dir.mkdirs();
			}
		}
	}

}
