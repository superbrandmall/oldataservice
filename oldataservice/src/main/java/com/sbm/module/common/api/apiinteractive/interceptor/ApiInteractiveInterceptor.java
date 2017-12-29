package com.sbm.module.common.api.apiinteractive.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sbm.module.common.api.apiinteractive.biz.ITCApiInteractiveDetailService;
import com.sbm.module.common.api.apiinteractive.constant.ApiInteractiveConstant;
import com.sbm.module.common.api.apiinteractive.domain.TCApiInteractiveDetail;
import com.sbm.module.common.api.jsonwebtoken.constant.JSONWebTokenConstant;
import com.sbm.module.common.base.util.IPAddressUtil;
import com.sbm.module.common.business.constant.LangConstant;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.common.interceptor<br/>
 * File Name:JSONWebTokenInterceptor.java<br/>
 * 
 * 作成日 ：2017-8-2 上午10:59:52 <br/>
 * 
 * @author ：junkai.zhang
 */
@Component("apiInteractiveInterceptor")
public class ApiInteractiveInterceptor implements HandlerInterceptor {

	@Autowired
	private ITCApiInteractiveDetailService service;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		TCApiInteractiveDetail detail = new TCApiInteractiveDetail();

		// userCode
		detail.setUserCode(request.getHeader(JSONWebTokenConstant.LOGIN));

		// 请求语言环境
		Integer lang = null;
		try {
			lang = Integer.valueOf(request.getHeader(ApiInteractiveConstant.LANG));
		} catch (Exception e) {
			// ignore
		}
		if (null == lang) {
			lang = LangConstant.ZH_CN.intValue();
		}
		detail.setLang(lang);

		// 请求来源
		detail.setSource(request.getHeader(ApiInteractiveConstant.Source));
		// 真实ip
		detail.setRealIp(IPAddressUtil.getIpAddress(request));
		// 请求开始时间
		detail.setBeginTime(System.currentTimeMillis());
		// 请求uri
		detail.setUri(request.getRequestURI());

		// 加入本地线程
		TCApiInteractiveDetail.set(detail);

		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 从本地线程取
		TCApiInteractiveDetail detail = TCApiInteractiveDetail.get();
		// 请求结束时间
		detail.setEndTime(System.currentTimeMillis());
		// 请求耗时
		detail.setIntervalTime(detail.getEndTime() - detail.getBeginTime());

		// TODO 放在微软云上存在0毫秒的异常记录，暂时不做处理
		if (!(0 == detail.getIntervalTime())) {
			service.save(detail);
		}

		TCApiInteractiveDetail.remove();
	}
}
