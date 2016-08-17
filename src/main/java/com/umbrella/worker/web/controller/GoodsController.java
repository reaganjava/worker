package com.umbrella.worker.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.dto.ContactDO;
import com.umbrella.worker.dto.MembersDO;
import com.umbrella.worker.dto.OrderDO;
import com.umbrella.worker.dto.OrderDetailDO;
import com.umbrella.worker.dto.OrderTaskDO;
import com.umbrella.worker.dto.WorkerItemDO;
import com.umbrella.worker.dto.WorkerStaffDO;
import com.umbrella.worker.dto.WorkerTaskDO;
import com.umbrella.worker.query.ContactQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IContactService;
import com.umbrella.worker.service.IMemberService;
import com.umbrella.worker.service.IOrderService;
import com.umbrella.worker.service.IWorkerService;
import com.umbrella.worker.util.StringUtil;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

	
	@Autowired
	IWorkerService workerService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IContactService contactService;
	
	
	@RequestMapping(value = "/job/{id}.html", method = RequestMethod.GET)
	public ModelAndView job(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		
		ResultDO result = null;
		
		if(!StringUtil.isGreatOne(id)) {
			mav.setViewName("error");
		}
		
		result = workerService.get(id);
		
		if(result.isSuccess()) {
			WorkerTaskDO workerTaskDO = (WorkerTaskDO) result.getModel(ResultSupport.FIRST_MODEL_KEY);
			mav.addObject("TASK_GOODS", workerTaskDO);
			WorkerItemDO workerItemDO = workerTaskDO.getWorkerItems().get(0);
			mav.addObject("WORKER_ITEM_ID", workerItemDO.getId());
			mav.addObject("WORKER_STAFF_ID", workerItemDO.getWorkerStaffs().get(0).getId());
			mav.setViewName("goods/job");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/getStaff/{id}.json", method = RequestMethod.GET)
	public ModelAndView ajaxStaff(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		ResultDO result = workerService.getStaff(id);
		System.out.println(result);
		if(!result.isSuccess()) {
			mav.addObject("JSON_DATA", 0);
		}
		List<WorkerStaffDO> workerStaffs = (List<WorkerStaffDO>) result.getModel(ResultSupport.FIRST_MODEL_KEY);
		String line = "";
		int index = 0;
		for(WorkerStaffDO workerStaff : workerStaffs) {
			System.out.println(line);
			line += "<li id=\"staff" + index +"\"><a href=\"javascript:void\" onClick=\"setStaff(" + index + ", " + workerStaffs.size() + "," + workerStaff.getId() + ")\"><span id=\"staffFont" + index + "\">"+workerStaff.getwWsStaffCount()+"人"+workerStaff.getwWsHours()+"小时</span></a></li>";
			index++;
		}
		mav.addObject("JSON_DATA", line);
		return mav;
	}
	
	@RequestMapping(value = "/buyJob.html", method = RequestMethod.POST)
	public ModelAndView buyJob(ModelAndView mav, WorkerTaskDO workerTaskDO, HttpServletRequest request) {
		System.out.println(workerTaskDO);
		request.getSession().setAttribute("TASK_INFO", workerTaskDO);
		Integer memberId = (Integer) request.getSession().getAttribute("MEMBER_ID");
		ContactQuery query = new ContactQuery();
		query.setMemberId(memberId);
		query.setIsDefault(1);
		ResultDO result = contactService.list(query);
		if(result.isSuccess()) {
			List<ContactDO> list = (List<ContactDO>) result.getModel(ResultSupport.FIRST_MODEL_KEY);
			System.out.println(list.get(0));
			mav.addObject("CONTACT_DEFAULT", list.get(0));
			mav.setViewName("goods/reserver");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}

	
	@RequestMapping(value = "/getOrder.html", method = RequestMethod.POST)
	public ModelAndView getOrder(ModelAndView mav, 
			OrderDetailDO orderDetailDO,
			HttpServletRequest request) {
		
		WorkerTaskDO workerTaskDO = (WorkerTaskDO) request.getSession().getAttribute("TASK_INFO");
		
		String memberMobile = (String) request.getSession().getAttribute("MEMBER_MOBILE");
		
		Integer memberId = (Integer) request.getSession().getAttribute("MEMBER_ID");
		
		
	
		OrderTaskDO orderTaskDO = new OrderTaskDO();
		orderTaskDO.setCreateAuthor(memberMobile);
		orderTaskDO.setWorkerTaskId(workerTaskDO.getId());
		orderTaskDO.setWorkerItemId(workerTaskDO.getItemId());
		orderTaskDO.setWorkerStaffId(workerTaskDO.getStaffId());
		
		OrderDO orderDO = new OrderDO();
		
		orderDetailDO.setOrderTaskDO(orderTaskDO);
		orderDetailDO.setCreateAuthor(memberMobile);
		
		orderDO.setOrderDetailDO(orderDetailDO);
		orderDO.setMemberId(memberId);
		
		ResultDO resultDO = orderService.create(orderDO);
		
		if(!resultDO.isSuccess()) {
			mav.setViewName("error");
			return mav;
		}
		int orderID = (int) resultDO.getModel(ResultSupport.FIRST_MODEL_KEY);
		
		return new ModelAndView("redirect:/payOrder/+ " + orderID + ".html");
	}

}
