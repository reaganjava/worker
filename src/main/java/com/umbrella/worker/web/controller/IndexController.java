package com.umbrella.worker.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav, 
			HttpServletRequest request) {
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value = "/test.html", method = RequestMethod.GET)
	public ModelAndView test(ModelAndView mav, 
			HttpServletRequest request) {
		mav.setViewName("test");
		return mav;
	}
}
