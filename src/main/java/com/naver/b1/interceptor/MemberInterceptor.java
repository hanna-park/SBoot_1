package com.naver.b1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component
public class MemberInterceptor extends HandlerInterceptorAdapter{

	
	//controller 진입 전 사용
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		Object obj = request.getSession().getAttribute("member");
		
		if(obj != null) {
			return true;
		}else {

			response.sendRedirect("../member/memberLogin");
			return false;
		}

	}



}
