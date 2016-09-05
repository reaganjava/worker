package com.umbrella.worker.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.util.PageBeanUtil;
import com.umbrella.worker.dto.CleanDO;
import com.umbrella.worker.dto.ContactDO;
import com.umbrella.worker.dto.OrderDO;
import com.umbrella.worker.dto.OrderDetailDO;

import com.umbrella.worker.query.OrderQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IOrderService;



@Controller
@RequestMapping(value = "/order")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;

	
	@RequestMapping(value = "/getOrder.html", method = RequestMethod.POST)
	public ModelAndView getOrder(ModelAndView mav, 
			OrderDetailDO orderDetailDO,
			HttpServletRequest request) {
		
		CleanDO cleanDO = (CleanDO) request.getSession().getAttribute("CLEAN_INFO");
		
		String memberMobile = (String) request.getSession().getAttribute("MEMBER_MOBILE");
		
		Integer memberId = (Integer) request.getSession().getAttribute("MEMBER_ID");
		
		ContactDO contactDO = (ContactDO) request.getSession().getAttribute("CONTACT_DEFAULT");
		
		if(memberId == null && memberMobile == null) {
			return new ModelAndView("redirect:/members/login.html");
		}
		
		if(contactDO == null) {
			return new ModelAndView("redirect:/goods/buyJob.html");
		}
		
		
		OrderDO orderDO = new OrderDO();
		orderDetailDO.setwOCity("重庆");
		orderDetailDO.setwOAddress(contactDO.getwCAddress());
		orderDetailDO.setwOContact(contactDO.getwCContact());
		orderDetailDO.setwOTelephone(contactDO.getwCTelephone());
		orderDetailDO.setwODistrict(contactDO.getwCDistrict());
		orderDetailDO.setwOServerName(cleanDO.getServiceName());
		orderDetailDO.setwOServerTime(cleanDO.getHours());
		orderDetailDO.setwOStaffCount(cleanDO.getStaffCount());
		orderDetailDO.setwOPrice(cleanDO.getPrice());
		
	
		orderDetailDO.setCreateAuthor(memberMobile);
		
		String strDate = orderDetailDO.getSubDate() + " " + orderDetailDO.getSubTime();
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		
		try {
			orderDetailDO.setwOSubscribe(format.parse(strDate));
		} catch (ParseException e) {
			e.printStackTrace();
			mav.setViewName("error");
			return mav;
		}
		
		orderDO.setOrderDetailDO(orderDetailDO);
		orderDO.setwOMembersId(memberId);
		orderDO.setCreateAuthor(memberMobile);
		
		ResultDO resultDO = orderService.create(orderDO);
		
		if(!resultDO.isSuccess()) {
			mav.setViewName("error");
			return mav;
		}
		int orderID = (int) resultDO.getModel(ResultSupport.FIRST_MODEL_KEY);
		
		return new ModelAndView("redirect:/order/payOrder/" + orderID + ".html");
	}
	
	@RequestMapping(value = "/payOrder/{id}.html", method = RequestMethod.GET)
	public ModelAndView payOrder(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
	
		ResultDO resultDO = orderService.get(id);
		OrderDO orderOD = null;
		if(resultDO.isSuccess()) {
			orderOD = (OrderDO) resultDO.getModel(ResultSupport.FIRST_MODEL_KEY);
			mav.addObject("ORDER_INFO", orderOD);
		} else {
			mav.setViewName("error");
		}
		
		System.out.println(resultDO);
		if(resultDO.isSuccess()) {
		
		} else {
			mav.setViewName("error");
		}
		
		mav.setViewName("order/payOrder");
		return mav;
	}
	
	@RequestMapping(value = "/orderDetail/{id}.html", method = RequestMethod.GET)
	public ModelAndView orderDetail(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
	
		ResultDO resultDO = orderService.get(id);
		OrderDO orderOD = null;
		if(resultDO.isSuccess()) {
			orderOD = (OrderDO) resultDO.getModel(ResultSupport.FIRST_MODEL_KEY);
			mav.addObject("ORDER_INFO", orderOD);
		} else {
			mav.setViewName("error");
		}
	
		if(resultDO.isSuccess()) {
		
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
		if(resultDO.isSuccess()) {
			mav.setViewName("order/grade");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/userOrders/{pageNo}.html", method = RequestMethod.GET)
	public ModelAndView getUserOrders(ModelAndView mav,
			@PathVariable(value="pageNo") Integer pageNo,
			HttpServletRequest request) {
		Integer memberId = (Integer) request.getSession().getAttribute("MEMBER_ID");
	
		if(memberId == null) {
			return new ModelAndView("redirect:/members/login.html");
		}
		OrderQuery query = new OrderQuery();
		query.setMemberId(memberId);
		query.setPage(true);
		query.setPageNO(pageNo);
		query.setPageRows(3);
		ResultDO result = orderService.list(query);
		if(result.isSuccess()) {
			PageBeanUtil pageBean = new PageBeanUtil();
			long count = (Long) result.getModel(ResultSupport.SECOND_MODEL_KEY);
			pageBean.setCurrentPage(pageNo);
			pageBean.setPageSize(3);
			pageBean.setRecordCount(count);
			pageBean.setPageCount(count);
			pageBean.setPages(pageNo);
			pageBean.setDataList((List<Object>) result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.addObject("PAGE_BEAN", pageBean);
			mav.setViewName("order/userOrders");
		} else {
			mav.setViewName("error");
		}
		
		return mav;
	}
}
