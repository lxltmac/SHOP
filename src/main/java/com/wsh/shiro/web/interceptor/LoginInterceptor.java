package com.wsh.shiro.web.interceptor;

import com.wsh.shiro.domain.dto.UserDto;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object obj) throws Exception {
//
//		Subject subject = SecurityUtils.getSubject();
//
//		UserDto user = (UserDto) subject.getPrincipal();
////
//		if (user != null) {
//			return true;
//		}
//
//		response.sendRedirect("/index.jsp");
//
//		return false;
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
		
	}

}
