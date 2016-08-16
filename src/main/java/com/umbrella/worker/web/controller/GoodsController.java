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
import com.umbrella.worker.dto.WorkerStaffDO;
import com.umbrella.worker.dto.WorkerTaskDO;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IContactService;
import com.umbrella.worker.service.IMemberService;
import com.umbrella.worker.service.IOrderService;
import com.umbrella.worker.service.IWorkerService;
import com.umbrella.worker.util.StringUtil;

@Controller
public class GoodsController {

	@Autowired
	private IMemberService memberService;
	@Autowired
	IWorkerService workerService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IContactService contactService;
	
	@RequestMapping(value = "/getTask/{id}.html", method = RequestMethod.GET)
	public ModelAndView getTask(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		
		ResultDO result = null;
		
		if(!StringUtil.isGreatOne(id)) {
			mav.setViewName("error");
		}
		
		result = workerService.get(id);
		System.out.println(result);
		if(result.isSuccess()) {
			mav.addObject("TASK_GOODS", result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName("goods/task");
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
		for(WorkerStaffDO workerStaff : workerStaffs) {
			System.out.println(line);
			line += "<li><a><span>"+workerStaff.getwWsStaffCount()+"人"+workerStaff.getwWsHours()+"小时</span></a></li>";
		}
		mav.addObject("JSON_DATA", line);
		return mav;
	}
	
	@RequestMapping(value = "/buyTask.html", method = RequestMethod.POST)
	public ModelAndView buyTask(ModelAndView mav, WorkerTaskDO workerTaskDO, HttpServletRequest request) {
		request.getSession().setAttribute("TASK_INFO", workerTaskDO);
		return new ModelAndView("redirect:/order/contacts.html");
	}
	
	
	
	@RequestMapping(value = "/contacts.html", method = RequestMethod.GET)
	public ModelAndView serviceContacts(ModelAndView mav, HttpServletRequest request) {
		
		Integer memberId = (Integer) request.getSession().getAttribute("MEMBER_ID");
		ResultDO resultDO = memberService.get(memberId);

		if(resultDO.isSuccess()) {
			MembersDO membersDO = (MembersDO) resultDO.getModel(ResultSupport.FIRST_MODEL_KEY);
			List<ContactDO> contactList = membersDO.getContacts();
			if(contactList.size() > 0) {
				for(ContactDO contact : contactList) {
					if(contact.getwCDefault() == 1) {
						mav.addObject("CONTACT_INFO", contact);
						break;
					}
				}
 			}
			mav.setViewName("contact");
		} else {
			mav.setViewName("error");
			return mav;
		}
		return mav;
	}
	
	@RequestMapping(value = "/contacts.html", method = RequestMethod.POST)
	public ModelAndView serviceContacts(ModelAndView mav, ContactDO contactDO, HttpServletRequest request) {
		
		if(!StringUtil.isGreatOne(contactDO.getId())) {
			Integer memberId = (Integer) request.getSession().getAttribute("MEMBER_ID");
			String memberMobile = (String) request.getSession().getAttribute("MEMBER_MOBILE");
			contactDO.setMemberId(memberId);
			contactDO.setwCDefault(1);
			contactDO.setCreateAuthor(memberMobile);
			ResultDO result = contactService.create(contactDO);
			if(!result.isSuccess()) {
				mav.setViewName("error");
			}
		}
		request.getSession().setAttribute("CONTACT_INFO", contactDO);
		mav.setViewName("getOrder");
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
