package com.umbrella.worker.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.dto.MembersDO;
import com.umbrella.worker.dto.OrderDO;
import com.umbrella.worker.service.IOrderService;

public class OrderController {

	private IOrderService orderService;
	
	
	public ModelAndView create_order(ModelAndView mav, 
			OrderDO orderDO,
			HttpServletRequest request) {
		
		MembersDO membersDO = (MembersDO) request.getSession(true).getAttribute("MEMBER_LOGIN_INFO");
		
		if(membersDO == null) {
			mav.setViewName("login");
		}
		
		
		return mav;
	}
}
