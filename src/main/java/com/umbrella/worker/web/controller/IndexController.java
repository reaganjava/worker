package com.umbrella.worker.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav, 
			HttpServletRequest request) {
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value = "/waiting.html", method = RequestMethod.GET)
	public ModelAndView waiting(ModelAndView mav, 
			HttpServletRequest request) {
		mav.setViewName("waiting");
		return mav;
	}

}
