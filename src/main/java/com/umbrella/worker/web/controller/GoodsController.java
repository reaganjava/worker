package com.umbrella.worker.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.dto.WorkerTaskDO;
import com.umbrella.worker.query.WorkerTaskQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IWorkerService;
import com.umbrella.worker.util.StringUtil;

@Controller
public class GoodsController {

	@Autowired
	IWorkerService workerService;
	
	@RequestMapping(value = "/getTask/{id}.html", method = RequestMethod.GET)
	public ModelAndView getTask(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		
		ResultDO result = null;
		
		if(!StringUtil.isGreatOne(id)) {
			mav.setViewName("error");
		}
		
		result = workerService.get(id);
		
		if(result.isSuccess()) {
			mav.addObject("TASK_GOODS", result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName("goods/task");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/subscribeTask/{taskId}/{taskItemId}/{taskStaffId}.html", method = RequestMethod.GET)
	public ModelAndView subscribeTask(ModelAndView mav, 
			@PathVariable(value="taskId") Integer taskId,
			@PathVariable(value="taskItemId") Integer taskItemId,
			@PathVariable(value="taskStaffId") Integer taskStaffId,
			HttpServletRequest request) {
		
		WorkerTaskQuery taskQuery = new WorkerTaskQuery();
		
		taskQuery.setTaskId(taskId);
		taskQuery.setTaskItemId(taskItemId);
		taskQuery.setTaskStaffId(taskStaffId);
		
		ResultDO resultDO = workerService.get(taskId, taskItemId, taskStaffId);
		
		if(!resultDO.isSuccess()) {
			mav.setViewName("error");
			return mav;
		}
		
		WorkerTaskDO workerTaskDO = (WorkerTaskDO) resultDO.getModel(ResultSupport.FIRST_MODEL_KEY);
		
		
		request.getSession().setAttribute("TASK_INFO", workerTaskDO);
		
		mav.setViewName("order/getOrder");
		return mav;
	}
	
	
}
