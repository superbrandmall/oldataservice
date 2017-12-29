package com.sbm.module.onlineleasing.init.serialcode;

import java.lang.reflect.Field;
import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.module.common.api.serialcode.annotation.SerialCodeRemark;
import com.sbm.module.common.api.serialcode.biz.ITCSerialCodeService;
import com.sbm.module.common.api.serialcode.constant.SerialCodeConstant;
import com.sbm.module.common.api.serialcode.domain.TCSerialCode;
import com.sbm.module.common.base.constant.CommonConstant;
import com.sbm.module.common.base.init.InitAfterLoad;

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
public class SerialCodeInit implements InitAfterLoad {

	private static final String INSERT_MESSAGE = "insert serialGroup: {0}";
	private static final String WARN_MESSAGE = "field: {0} is not String";

	@Autowired
	private ITCSerialCodeService service;

	public void init() {
		Class<SerialCodeConstant> clazz = SerialCodeConstant.class;
		Field[] fields = clazz.getFields();
		for (Field field : fields) {
			try {
				String serialGroup = (String) field.get(new String());
				String remark = field.getAnnotation(SerialCodeRemark.class).remark();
				TCSerialCode serialCode = service.findBySerialGroup(serialGroup);
				if (null == serialCode) {
					serialCode = new TCSerialCode();
					process(serialCode, serialGroup, remark);
					service.save(serialCode);
					CommonConstant.FRAMEWORK.info(MessageFormat.format(INSERT_MESSAGE, field.getName()));
				}
			} catch (Exception e) {
				CommonConstant.FRAMEWORK.warn(MessageFormat.format(WARN_MESSAGE, field.getName()));
			}
		}
	}

	/**
	 * 
	 * process:处理
	 * 
	 * @author junkai.zhang
	 * @param serialCode
	 * @param serialGroup
	 * @param remark
	 */
	private void process(TCSerialCode serialCode, String serialGroup, String remark) {
		// 序列
		serialCode.setSerialGroup(serialGroup);
		// 备注
		serialCode.setRemark(remark);
	}
}
