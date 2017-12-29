package com.sbm.module;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.serialcode.annotation.SerialCodeRemark;
import com.sbm.module.common.api.serialcode.constant.SerialCodeConstant;
import com.sbm.module.onlineleasing.base.bidparam.leasetype.domain.TOLBidLeasetype;
import com.sbm.module.partner.hd.rest.contract.base.domain.HdContract;
import com.sbm.module.partner.hl95.rest.sendSMS.constant.SendSMSCode;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.boot.jaxb.SourceType;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module<br/>
 * File Name:Test.java<br/>
 * 
 * 作成日 ：2017-10-9 上午11:24:06 <br/>
 * 
 * @author ：junkai.zhang
 */
@SuppressWarnings("unused")
public class Test {

	@org.junit.Test
	public void test() {
		// test1();
		// test2();
		// test3();
		// test4();
		// test5();
		// test6();
		// test7();
		// test8();
		test9();
	}


	private void test9() {
		List<HdContract> list = new ArrayList<>();
		list.add(new HdContract());
		Object[] arr = new Object[] { list };

		String str = JSON.toJSONString(arr);
		System.out.println(str);
		System.out.println(1);
		System.out.println(JSON.parseArray(str));
		//System.out.println(JSON.parseObject(str));
	}

	private void test8() {
		String s = " ";
		System.out.println(StringUtils.isNotEmpty(s));
		System.out.println(StringUtils.isNotBlank(s));

		BigDecimal b1 = new BigDecimal(1);
		BigDecimal b2 = new BigDecimal(2);
		System.out.println(b1.compareTo(b2) == -1);

		Integer[] arr = new Integer[]{1, 2};
		List<Integer> list = Arrays.asList(arr);
		System.out.println(JSON.toJSONString(list));
	}

	public volatile int inc = 0;

	public void increase() {
		inc++;
	}

	public void test7() {
		final Test test = new Test();
		for(int i=0;i<10;i++){
			new Thread(){
				public void run() {
					for(int j=0;j<1000;j++)
						test.increase();
				};
			}.start();
		}

		while(Thread.activeCount()>2) { //保证前面的线程都执行完
			//System.out.println(Thread.activeCount());
			Thread.yield();
		}
		System.out.println(test.inc);
	}


	private void test6() {
		List<TOLBidLeasetype> list = new ArrayList<>();
		TOLBidLeasetype obj = new TOLBidLeasetype();
		obj.setItemKey("正柜");
		obj.setItemValue("0");
		list.add(obj);
		obj = new TOLBidLeasetype();
		obj.setItemKey("Popup");
		obj.setItemValue("1");
		list.add(obj);

		Map<String, TOLBidLeasetype> map = list.stream().collect(
				Collectors.toMap(TOLBidLeasetype::getItemKey, (p) -> p));

		System.out.println(JSON.toJSONString(map));

		TOLBidLeasetype tmp = list.stream().filter(t->t.getItemValue().equals("0") && t.getItemKey().equals("正柜")).collect(Collectors.toList()).get(0);
		System.out.println(JSON.toJSONString(tmp));
	}


	private void test5(){
		   m1("");
	       m1("aaa");
	       m1("aaa", "bbb");
	}
    public void m1(String s, String... ss) {
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i]);
        }
    }
	
	private void test4() {	
		List<BigDecimal> list = new ArrayList<BigDecimal>();
		list.add(new BigDecimal(2));
		list.add(new BigDecimal(1));
		list.add(new BigDecimal(3));
		Collections.sort(list);
		for (BigDecimal obj : list) {
			System.out.println(JSON.toJSONString(obj));
		}
	}

	private void test3() {
		SendSMSCode code = SendSMSCode.valueOf("C00");
		System.out.println(code.getReturnCode() + " : " + code.getReturnMessage());
	}

	private void test2() {
		String username = "yourapp-name";
		String password = "yourapp-password";

		String tmp = username + ":" + password;
		System.out.println("tmp : " + tmp);

		String key = Base64.getEncoder().encodeToString(tmp.getBytes());
		System.out.println("key : " + key);

		String tmp1 = new String(Base64.getDecoder().decode(key));
		System.out.println("tmp1 : " + tmp1);

	}

	private void test1() {
		try {
			Class<SerialCodeConstant> clazz = SerialCodeConstant.class;
			Field[] fields = clazz.getFields();
			for (Field field : fields) {
				System.out.println(field + " = " + field.get(new String()));
				System.out.println(field.getAnnotation(SerialCodeRemark.class).remark());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
