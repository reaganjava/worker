package com.umbrella.worker.web.controller;

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
import com.umbrella.worker.dto.WorkerTaskDO;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IContactService;
import com.umbrella.worker.service.IMemberService;
import com.umbrella.worker.service.IOrderService;
import com.umbrella.worker.util.StringUtil;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
	
	@Autowired
	private IMemberService memberService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IContactService contactService;
	
	@RequestMapping(value = "/getOrder.html", method = RequestMethod.POST)
	public ModelAndView getOrder(ModelAndView mav, 
			OrderDetailDO orderDetailDO,
			HttpServletRequest request) {
		
		WorkerTaskDO workerTaskDO = (WorkerTaskDO) request.getSession().getAttribute("TASK_INFO");
		
		if(workerTaskDO == null) {
			mav.setViewName("error");
			return mav;
		}
		Integer uid = (Integer) request.getSession().getAttribute("MEMBER_ID");
		ResultDO resultDO = memberService.get(uid);
		
		if(!resultDO.isSuccess()) {
			mav.setViewName("error");
			return mav;
		}
		
		MembersDO membersDO = (MembersDO) resultDO.getModel(ResultSupport.FIRST_MODEL_KEY);
		
		if(membersDO.getContacts().size() == 0) {
			ContactDO contactDO = new ContactDO();
			contactDO.setwCCity(orderDetailDO.getwOCity());
			contactDO.setwCDistrict(orderDetailDO.getwODistrict());
			if(StringUtil.isNotEmpty(orderDetailDO.getwOTelephone())) {
				contactDO.setwCTelephone(orderDetailDO.getwOTelephone());
			} else {
				contactDO.setwCTelephone(membersDO.getwMMobile());
			}
			contactDO.setwCContact(orderDetailDO.getwOContact());
			contactDO.setwCDefault(1);
			contactDO.setCreateAuthor(membersDO.getwMMobile());
			resultDO = contactService.create(contactDO);
			if(!resultDO.isSuccess()) {
				mav.setViewName("error");
				return mav;
			}
		}
		
		OrderDO orderDO = new OrderDO();
		
		orderDetailDO.setWorkerTaskDO(workerTaskDO);
		orderDetailDO.setCreateAuthor(membersDO.getwMMobile());
		
		orderDO.setOrderDetailDO(orderDetailDO);
		orderDO.setMembersDO(membersDO);
		
		resultDO = orderService.create(orderDO);
		
		if(!resultDO.isSuccess()) {
			mav.setViewName("error");
			return mav;
		}
		int orderID = (int) resultDO.getModel(ResultSupport.FIRST_MODEL_KEY);
		
		return new ModelAndView("redirect:/payOrder/+ " + orderID + ".html");
	}
	
	@RequestMapping(value = "/payOrder/{id}.html", method = RequestMethod.GET)
	public ModelAndView payOrder(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
	
		ResultDO resultDO = orderService.get(id);
		if(resultDO.isSuccess()) {
			mav.addObject("ORDER_INFO", resultDO.getModel(ResultSupport.FIRST_MODEL_KEY));
		} else {
			mav.setViewName("error");
		}
		mav.setViewName("order/payOrder");
		return mav;
	}
	
	@RequestMapping(value = "/confirmOrder/{id}.html", method = RequestMethod.GET)
	public ModelAndView confirmOrder(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
	
		ResultDO resultDO = orderService.confirm(id);
		if(!resultDO.isSuccess()) {
			mav.setViewName("error");
		}
		mav.setViewName("order/grade");
		return mav;
	}
}
