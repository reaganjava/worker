package com.umbrella.worker.web.controller.manager;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.service.ISuppliersService;

@Controller
@RequestMapping(value = "/supplier")
public class SuppliersContrlloer {

	@Autowired
	private ISuppliersService suppliersService;
	
	@RequestMapping(value = "/join.html", method = RequestMethod.GET)
	public ModelAndView join(ModelAndView mav, HttpServletRequest request) {
		mav.setViewName("/supplier/join");
		return mav;
	}
}
