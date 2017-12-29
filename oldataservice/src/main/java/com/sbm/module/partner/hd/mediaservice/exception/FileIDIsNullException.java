package com.sbm.module.partner.hd.mediaservice.exception;

import java.text.MessageFormat;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.hd.mediaservice.exception<br/>
 * File Name:FileIDIsNullException.java<br/>
 * 
 * 作成日 ：2017-11-2 下午4:33:52 <br/>
 * 
 * @author ：junkai.zhang
 */
public class FileIDIsNullException extends Exception {

	private static final long serialVersionUID = 300100L;

	public FileIDIsNullException() {
		super("文件标识fileID不能为空。");
	}

	public FileIDIsNullException(String s) {
		super(s);
	}

	public FileIDIsNullException(Exception t) {
		super(t);
	}

	public FileIDIsNullException(String pattern, Object[] arguments) {
		super(MessageFormat.format(pattern, arguments));
	}

	public FileIDIsNullException(String s, Exception t) {
		super(s, t);
	}

}
