package com.sbm.module.common.api.restinteractive.aop;

import com.sbm.module.common.base.constant.CommonConstant;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.restinteractive.annotation.RestInteractive;
import com.sbm.module.common.api.restinteractive.biz.ITCRestInteractiveDetailService;
import com.sbm.module.common.api.restinteractive.domain.TCRestInteractiveDetail;
import com.sbm.module.common.api.serialcode.constant.SerialCodeConstant;
import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;
import com.sbm.module.common.business.biz.impl.BusinessServiceImpl;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.common.api.restinteractive.aop<br/>
 * File Name:RestTemplateAspect.java<br/>
 * 
 * 作成日 ：2017-9-30 上午9:13:24 <br/>
 * 
 * @author ：junkai.zhang
 */
@Aspect
@Component
public class RestTemplateAspect extends BusinessServiceImpl {

	@Autowired
	private ITCRestInteractiveDetailService service;

	/**
	 * 
	 * pointcut:切入点，含有RestInteractive的方法 声明切入点表达式，一般在该方法中不再添加其他代码。
	 * 使用@Pointcut来声明切入点表达式。 后面的通知直接使用方法名来引用当前的切入点表达式。
	 * 
	 * @author junkai.zhang
	 * @param a
	 */
	@Pointcut("@annotation(a)")
	public void declareJoinPointExpression(RestInteractive a) {

	}

	/**
	 * 
	 * before:前置通知，在目标方法开始之前执行。
	 * 
	 * @author junkai.zhang
	 * @param joinPoint
	 * @param a
	 */
	@Before("declareJoinPointExpression(a)")
	public void before(JoinPoint joinPoint, RestInteractive a) {
		CommonConstant.FRAMEWORK.info(joinPoint.getTarget().getClass().getName() + " - " + joinPoint.getSignature().getName() + ": rest started");

		TCRestInteractiveDetail detail = new TCRestInteractiveDetail();
		// 请求流水号
		detail.setCode(serialCodeService.nextBizId(SerialCodeConstant.CRESTDETAIL).getNextBizId());
		// 请求开始时间
		detail.setBeginTime(System.currentTimeMillis());
		// 请求类
		detail.setClazz(joinPoint.getTarget().getClass().getName());
		// 请求方法
		detail.setMethod(joinPoint.getSignature().getName());
		// 请求参数
		detail.setRequestObj(JSON.toJSONString(joinPoint.getArgs()));

		// 加入本地线程
		TCRestInteractiveDetail.set(detail);
	}

	/**
	 * 
	 * after:后置通知，在目标方法执行之后开始执行，无论目标方法是否抛出异常。 在后置通知中不能访问目标方法执行的结果。
	 * 
	 * @author junkai.zhang
	 * @param joinPoint
	 * @param a
	 */
	@After("declareJoinPointExpression(a)")
	public void after(JoinPoint joinPoint, RestInteractive a) {

	}

	/**
	 * 
	 * afterReturnning:返回通知，在方法正常结束之后执行。 可以访问到方法的返回值。
	 * 
	 * @author junkai.zhang
	 * @param joinPoint
	 * @param result
	 * @param a
	 */
	@AfterReturning(value = "declareJoinPointExpression(a)", returning = "result")
	public void afterReturnning(JoinPoint joinPoint, Object result, RestInteractive a) {
		// 从本地线程取
		TCRestInteractiveDetail detail = TCRestInteractiveDetail.get();
		// 请求结束时间
		detail.setEndTime(System.currentTimeMillis());
		// 请求耗时
		detail.setIntervalTime(detail.getEndTime() - detail.getBeginTime());
		// 返回参数
		if (null != result) {
			detail.setResponseObj(JSON.toJSONString(result));
		}
		// 保存
		service.save(detail);
		// 移除
		TCRestInteractiveDetail.remove();

		CommonConstant.FRAMEWORK.info(joinPoint.getTarget().getClass().getName() + " - " + joinPoint.getSignature().getName() + ": rest completed in " + detail.getIntervalTime() + " ms");
	}

	/**
	 * 
	 * afterThrowing:异常通知。目标方法出现异常的时候执行，可以访问到异常对象，可以指定在出现特定异常时才执行。
	 * 假如把参数写成NullPointerException则只在出现空指针异常的时候执行。
	 * 
	 * @author junkai.zhang
	 * @param joinPoint
	 * @param e
	 * @param a
	 */
	@AfterThrowing(value = "declareJoinPointExpression(a)", throwing = "e")
	public void afterThrowing(JoinPoint joinPoint, Exception e, RestInteractive a) {
		// 从本地线程取
		TCRestInteractiveDetail detail = TCRestInteractiveDetail.get();
		// 请求结束时间
		detail.setEndTime(System.currentTimeMillis());
		// 请求耗时
		detail.setIntervalTime(detail.getEndTime() - detail.getBeginTime());

		// 转换为businessException
		e = BusinessException.convert(BusinessCode.C9999, e);
		// 错误码
		detail.setErrorCode(((BusinessException) e).getCode());
		// 错误信息
		detail.setErrorMessage(getStackTrace(e));

		// 保存
		service.save(detail);
		// 移除
		TCRestInteractiveDetail.remove();

		CommonConstant.FRAMEWORK.info(joinPoint.getTarget().getClass().getName() + " - " + joinPoint.getSignature().getName() + ": rest error in " + detail.getIntervalTime() + " ms");
	}

	/***************************************************************************/
	// 不常用

	// /**
	// * aroundMethod:环绕通知类似于动态代理的全过程，ProceedingJoinPoint类型的参数可以决定是否执行目标方法。
	// *
	// * @author junkai.zhang
	// * @param point
	// * 环绕通知需要携带ProceedingJoinPoint类型的参数。
	// * @return 目标方法的返回值。必须有返回值。
	// */
	// // 不常用
	// @Around("declareJoinPointExpression(a)")
	// public Object aroundMethod(ProceedingJoinPoint point) {
	// Object result = null;
	// String methodName = point.getSignature().getName();
	// try {
	// // 前置通知
	// System.out.println("The method " + methodName + " begins with " +
	// Arrays.asList(point.getArgs()));
	// // 执行目标方法
	// result = point.proceed();
	// // 翻译通知
	// System.out.println("The method " + methodName + " ends with " + result);
	// } catch (Throwable e) {
	// // 异常通知
	// System.out.println("The method " + methodName + " occurs exception " +
	// e);
	// throw new RuntimeException(e);
	// }
	// // 后置通知
	// System.out.println("The method " + methodName + " ends");
	// return result;
	// }
}
