package com.umbrella.worker.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.dto.MembersDO;

public class AuthenticationInterceptor implements HandlerInterceptor {
	
	private static Logger logger = Logger.getLogger(AuthenticationInterceptor.class);
	
	private static String notLoginUrl;

	public static void setNotLoginUrl(String notLoginUrl) {
		AuthenticationInterceptor.notLoginUrl = notLoginUrl;
	}

	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler, 
			ModelAndView mav) throws Exception {
		logger.info("posthandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception exception)
			throws Exception {
		logger.info("afterCompletion");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		HttpSession session = request.getSession();
		String requestURL = request.getRequestURL().toString();
		requestURL = requestURL.replace("http://", "");
		int startIndex = requestURL.indexOf("/");
		requestURL = requestURL.substring(startIndex);
		logger.info("Members REQUEST URL:" + requestURL);
		if(notLoginUrl != null) {
			logger.info("notLoginUrl:" + notLoginUrl);
			if(notLoginUrl.indexOf(requestURL) != -1) {
				MembersDO memberDO = (MembersDO) session.getAttribute("MEMBER_ID");
				if(memberDO == null) {
					response.sendRedirect(request.getContextPath() + "/login.html");
					return false;
				} 
			}
		}
		return true;
	}
}
