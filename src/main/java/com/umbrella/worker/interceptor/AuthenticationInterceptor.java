package com.umbrella.worker.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



import com.umbrella.worker.dto.MembersDO;

public class AuthenticationInterceptor implements HandlerInterceptor {
	
	private static String notLoginUrl;

	public static void setNotLoginUrl(String notLoginUrl) {
		AuthenticationInterceptor.notLoginUrl = notLoginUrl;
	}

	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler, 
			ModelAndView mav) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		String requestURL = request.getRequestURL().toString();
		for(String url : MEMBER_LOGIN_URLS) {
			if(requestURL.indexOf(url) != -1) {
				MembersDO memberDO = (MembersDO) session.getAttribute("MEMBER_LOGIN_INFO");
				if(memberDO == null) {
					response.sendRedirect(request.getContextPath() + "/login.html");
					return false;
				} else {
					break;
				}
			}
		}
		return true;
	}
}
