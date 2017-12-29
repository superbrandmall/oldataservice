package com.sbm.module.common.base.handler;

import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.controller.BaseController;
import com.sbm.module.common.base.domain.JsonContainer;
import com.sbm.module.common.base.exception.BusinessException;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.exception.controller<br/>
 * File Name:GlobalExceptionHandler.java<br/>
 * 
 * 作成日 ：2017-7-28 下午1:51:42 <br/>
 * 
 * @author ：junkai.zhang
 */
@ControllerAdvice
public class GlobalExceptionHandler extends BaseController {

	/**
	 * 
	 * handleBusinessException:处理业务错误
	 * 
	 * @author junkai.zhang
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BusinessException.class)
	@ResponseBody
	public JsonContainer handleBusinessException(BusinessException e) {
		JsonContainer jsonContainer = getJsonContainer();
		setErrorMessage(jsonContainer, null, e);
		return jsonContainer;
	}

	/**
	 * 
	 * handleNullPointerException:处理空指针异常
	 * 
	 * @author junkai.zhang
	 * @param e
	 * @return
	 */
	@ExceptionHandler(NullPointerException.class)
	@ResponseBody
	public JsonContainer handleNullPointerException(NullPointerException e) {
		JsonContainer jsonContainer = getJsonContainer();
		setErrorMessage(jsonContainer, null, new BusinessException(BusinessCode.C9998, e));
		return jsonContainer;
	}

	/**
	 * 
	 * handleHibernateOptimisticLockingFailureException:数据库操作异常
	 * 
	 * @author junkai.zhang
	 * @param e
	 * @return
	 */
	@ExceptionHandler(HibernateOptimisticLockingFailureException.class)
	@ResponseBody
	public JsonContainer handleHibernateOptimisticLockingFailureException(HibernateOptimisticLockingFailureException e) {
		JsonContainer jsonContainer = getJsonContainer();
		setErrorMessage(jsonContainer, null, new BusinessException(BusinessCode.C9995, e));
		return jsonContainer;
	}

	/**
	 * 
	 * handleException:处理未捕获异常
	 * 
	 * @author junkai.zhang
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonContainer handleException(Exception e) {
		JsonContainer jsonContainer = getJsonContainer();
		setErrorMessage(jsonContainer, null, new BusinessException(BusinessCode.C9999, e));
		return jsonContainer;
	}

}
