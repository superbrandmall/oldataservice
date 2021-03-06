package com.sbm.module.common.api.serialcode.constant;

import com.sbm.module.common.api.serialcode.annotation.SerialCodeRemark;

/*****************************************************************************/
/**
 * Project Name:upload2luis<br/>
 * Package Name:com.sbm.module.luis.base.constant<br/>
 * File Name:LuisConstant.java<br/>
 * 
 * 作成日 ：2017-4-10 下午2:04:51 <br/>
 * 
 * @author ：junkai.zhang
 */
public class SerialCodeConstant {

	/**********************************************************************/
	/** bot */

	@SerialCodeRemark(remark = "临时")
	public final static String TMP = "TMP";

	@SerialCodeRemark(remark = "品牌")
	public final static String BR = "BR";

	@SerialCodeRemark(remark = "基础信息")
	public final static String BASIC = "BASIC";

	@SerialCodeRemark(remark = "费用")
	public final static String FEE = "FEE";

	@SerialCodeRemark(remark = "楼层")
	public final static String FLOOR = "FLOOR";

	@SerialCodeRemark(remark = "项目")
	public final static String MALL = "MALL";

	/**********************************************************************/
	/** common */

	@SerialCodeRemark(remark = "邮件模板")
	public final static String CMAILTEMP = "CMAILTEMP";

	@SerialCodeRemark(remark = "邮件发送明细")
	public final static String CMAILDETAIL = "CMAILDETAIL";

	@SerialCodeRemark(remark = "REST交互明细")
	public final static String CRESTDETAIL = "CRESTDETAIL";
	
	@SerialCodeRemark(remark = "短信模板")
	public final static String CSMSTEMP = "CSMSTEMP";

	@SerialCodeRemark(remark = "短信发送明细")
	public final static String CSMSDETAIL = "CSMSDETAIL";

	
	/**********************************************************************/
	/** ol */

	@SerialCodeRemark(remark = "OL品牌")
	public final static String OLBRAND = "OLBRAND";

	@SerialCodeRemark(remark = "OL商户")
	public final static String OLMERCHANT = "OLMERCHANT";

	@SerialCodeRemark(remark = "OL建筑物")
	public final static String OLBUILDING = "OLBUILDING";

	@SerialCodeRemark(remark = "OL商场")
	public final static String OLMALL = "OLMALL";

	@SerialCodeRemark(remark = "OL楼层")
	public final static String OLFLOOR = "OLFLOOR";

	@SerialCodeRemark(remark = "OL店铺")
	public final static String OLSHOP = "OLSHOP";

	@SerialCodeRemark(remark = "OL用户")
	public final static String OLUSER = "OLUSER";

	@SerialCodeRemark(remark = "OL系统消息")
	public final static String OLSYSMESSAGE = "OLSYSMESSAGE";

	@SerialCodeRemark(remark = "OL店铺查询")
	public final static String OLSEARCHSHOP = "OLSEARCHSHOP";

	@SerialCodeRemark(remark = "OL出价")
	public final static String OLBID = "OLBID";

}
