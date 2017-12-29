package com.sbm.module.onlineleasing.init.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.base.init.InitAfterLoad;
import com.sbm.module.onlineleasing.api.storage.blob.util.BlobClientUtil;

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
public class StorageInit implements InitAfterLoad {

	@Value("#{propertiesReader['storage.containerAndPolicy']}")
	private String containerAndPolicy;

	private static final String PUBLIC = "public";

	@Autowired
	private BlobClientUtil util;

	public void init() {
		// if (StringUtils.isNotEmpty(containerAndPolicy)) {
		// for (String str : containerAndPolicy.split(";")) {
		// String[] arr = str.split("#");
		// initContainer(arr[0], arr[1]);
		// }
		// }
		// 不使用微软云存储
		CommonConstant.FRAMEWORK.info("不使用微软云存储");
	}

	/**
	 * 
	 * initContainer:初始化容器
	 * 
	 * @author junkai.zhang
	 * @param containerName
	 * @param policy
	 */
	@SuppressWarnings("unused")
	private void initContainer(String containerName, String policy) {
		util.initContainer(containerName, true);
		if (PUBLIC.equals(policy)) {
			util.setPublicAccessPermissions();
		}
	}
}
