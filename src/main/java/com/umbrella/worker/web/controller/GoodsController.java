package com.umbrella.worker.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IWorkerService;
import com.umbrella.worker.util.StringUtil;

@Controller
public class GoodsController {

	IWorkerService workerService;
	
	@RequestMapping(value = "/worker_task/{id}.html", method = RequestMethod.GET)
	public ModelAndView task_goods(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		
		ResultDO result = null;
		
		if(!StringUtil.isGreatOne(id)) {
			mav.setViewName("error");
		}
		
		result = workerService.get(id);
		
		if(result.isSuccess()) {
			mav.addObject("TASK_GOODS", result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName("goods/worker_task");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	
}
