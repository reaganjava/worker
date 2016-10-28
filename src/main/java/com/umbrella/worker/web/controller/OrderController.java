package com.umbrella.worker.web.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.util.PageBeanUtil;
import com.umbrella.worker.dto.MemberCouponDO;
import com.umbrella.worker.dto.MembersDO;
import com.umbrella.worker.dto.TaskDO;
import com.umbrella.worker.dto.ContactDO;
import com.umbrella.worker.dto.OrderDO;
import com.umbrella.worker.dto.OrderDetailDO;
import com.umbrella.worker.query.ContactQuery;
import com.umbrella.worker.query.OrderQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IContactService;
import com.umbrella.worker.service.IMemberService;
import com.umbrella.worker.service.IOrderService;



@Controller
@RequestMapping(value = "/order")
public class OrderController extends BaseController{
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IContactService contactService;
	
	@Autowired
	private IMemberService memberService;

	
	@RequestMapping(value = "/getOrder.html", method = RequestMethod.POST)
	public ModelAndView getOrder(ModelAndView mav, 
			OrderDetailDO orderDetailDO,
			HttpServletRequest request) {
		
		TaskDO taskDO = (TaskDO) request.getSession().getAttribute("TASK_INFO");
		
		Cookie cookie = getCookieByName(request, "MEMBER_ID");
		
		
		if(cookie == null) {
			return new ModelAndView("redirect:/members/login.html");
		}
		Integer memberId = Integer.parseInt(cookie.getValue());
		cookie = getCookieByName(request, "MEMBER_MOBILE");
		String memberMobile = cookie.getValue();
		
		
		ResultDO result = contactService.get(orderDetailDO.getContactId());
		ContactDO contactDO = null; 
		if(result.isSuccess()) {
			contactDO = (ContactDO) result.getModel(ResultSupport.FIRST_MODEL_KEY);
		} else {
			mav.setViewName("error");
		}
		
		OrderDO orderDO = new OrderDO();
		orderDetailDO.setwOCity("重庆");
		orderDetailDO.setwOAddress(contactDO.getwCAddress());
		orderDetailDO.setwOContact(contactDO.getwCContact());
		orderDetailDO.setwOTelephone(contactDO.getwCTelephone());
		orderDetailDO.setwODistrict(contactDO.getwCDistrict());
		switch(taskDO.getServiceType()) {
		case 0: {
			orderDO.setwOServiceName(taskDO.getServiceName());
			orderDO.setwOServiceType(taskDO.getServiceType());
			orderDetailDO.setwOServerTime(taskDO.getHours());
			orderDetailDO.setwOStaffCount(taskDO.getStaffCount());
			orderDetailDO.setwOPrice(taskDO.getPrice());
			break;
		}
		case 1: {
			orderDO.setwOServiceName(taskDO.getServiceName());
			orderDO.setwOServiceType(taskDO.getServiceType());
			orderDetailDO.setwOServerTime(taskDO.getHours());
			orderDetailDO.setwOLockType(taskDO.getLockType());
			orderDetailDO.setwOPrice(taskDO.getPrice());
			break;
		}
		case 2: {
			orderDO.setwOServiceName(taskDO.getServiceName());
			orderDO.setwOServiceType(taskDO.getServiceType());
			orderDetailDO.setwOServerTime(taskDO.getHours());
			orderDetailDO.setwOPipType(taskDO.getPipType());
			if(taskDO.getPipType() == 2) {
				orderDetailDO.setwOToiletType(taskDO.getToiletType());
			}
			orderDetailDO.setwOPrice(taskDO.getPrice());
			break;
		}
		case 3: {
			orderDO.setwOServiceName(taskDO.getServiceName());
			orderDO.setwOServiceType(taskDO.getServiceType());
			orderDetailDO.setwOServerTime(taskDO.getHours());
			orderDetailDO.setwODamageType(taskDO.getDamageType());
			orderDetailDO.setwOPrice(taskDO.getPrice());
			break;
		}
		}
		
	
		orderDetailDO.setCreateAuthor(memberMobile);

		System.out.println(taskDO.getSubscribe());
		orderDetailDO.setwOSubscribe(taskDO.getSubscribe());
		
		orderDO.setOrderDetailDO(orderDetailDO);
		orderDO.setwOMembersId(memberId);
		orderDO.setCreateAuthor(memberMobile);
		
		result = orderService.create(orderDO);
		
		if(!result.isSuccess()) {
			mav.setViewName("error");
			return mav;
		}
		int orderID = (int) result.getModel(ResultSupport.FIRST_MODEL_KEY);
		request.getSession().removeAttribute("TASK_INFO");
		return new ModelAndView("redirect:/order/payOrder/" + orderID + ".html");
	}
	
	@RequestMapping(value = "/payOrder/{id}.html", method = RequestMethod.GET)
	public ModelAndView payOrder(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
	
	
		Cookie cookie = getCookieByName(request, "MEMBER_ID");
		
		if(cookie == null) {
			return new ModelAndView("redirect:/members/login.html");
		} 
		
		ResultDO resultDO = orderService.get(id);
		OrderDO orderOD = null;
		
		Integer memberId = Integer.parseInt(cookie.getValue());
		if(resultDO.isSuccess()) {
			orderOD = (OrderDO) resultDO.getModel(ResultSupport.FIRST_MODEL_KEY);
			mav.addObject("ORDER_INFO", orderOD);
			resultDO = memberService.get(memberId);
			MembersDO membersDO = (MembersDO) resultDO.getModel(ResultSupport.FIRST_MODEL_KEY);
			List<MemberCouponDO> memberCouponDOList = membersDO.getMemberCoupons();
			
			mav.addObject("MEMBER_COUPON_LIST", memberCouponDOList);
		} else {
			mav.setViewName("error");
		}
		
		mav.setViewName("order/payOrder");
		return mav;
	}
	
	@RequestMapping(value = "/payOrderDetail/{id}.html", method = RequestMethod.GET)
	public ModelAndView payOrderDetail(ModelAndView mav, 
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
		
		mav.setViewName("order/detail");
		return mav;
	}
	
	@RequestMapping(value = "/confirmOrder/{id}.json", method = RequestMethod.GET)
	public ModelAndView confirmOrder(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
	
		ResultDO resultDO = orderService.confirm(id);
		if(resultDO.isSuccess()) {
			mav.addObject("JSON_DATA", 1);
		} else {
			mav.addObject("JSON_DATA", 0);
		}
		return mav;
	}
	
	@RequestMapping(value = "/cancel/{id}/{infoId}.json", method = RequestMethod.GET)
	public ModelAndView orderCancel(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			@PathVariable(value="infoId") Integer infoId,
			HttpServletRequest request) {
		
		String[] caneclInfo = {"时间定错了", "位置定错了", "不需要了", "其他原因"};
		OrderDO orderDO = new OrderDO();
		orderDO.setId(id);
		orderDO.setStatus(4);
		OrderDetailDO orderDetailDO = new OrderDetailDO();
		orderDetailDO.setwCaneclInfo(caneclInfo[infoId]);
		String memberMobile = (String) request.getSession().getAttribute("MEMBER_MOBILE");
		orderDO.setModifiAuthor(memberMobile);
		ResultDO resultDO = orderService.modifi(orderDO);
		if(!resultDO.isSuccess()) {
			mav.addObject("JSON_DATA", 0);
		}
		resultDO = orderService.modifiDetail(orderDetailDO);
		if(resultDO.isSuccess()) {
			mav.addObject("JSON_DATA", 1);
		} else {
			mav.addObject("JSON_DATA", 0);
		}
		return mav;
	}
	
	
	
	@RequestMapping(value = "/userOrders/{status}/{pageNo}.json", method = RequestMethod.GET)
	public ModelAndView getUserOrders(ModelAndView mav,
			@PathVariable(value="status") Integer status,
			@PathVariable(value="pageNo") Integer pageNo,
			HttpServletRequest request) {
		Cookie cookie = getCookieByName(request, "MEMBER_ID");	
		if(cookie == null) {
			return mav.addObject("JSON_DATA", 0);
		} 
		Integer memberId = Integer.parseInt(cookie.getValue());
		OrderQuery query = new OrderQuery();
		query.setStatus(status);
		query.setMemberId(memberId);
		query.setPage(true);
		query.setPageNO(pageNo);
		query.setPageRows(1000);
		ResultDO result = orderService.list(query);
		if(result.isSuccess()) {
			PageBeanUtil pageBean = new PageBeanUtil();
			long count = (Long) result.getModel(ResultSupport.SECOND_MODEL_KEY);
			pageBean.setCurrentPage(pageNo);
			pageBean.setPageSize(1000);
			pageBean.setRecordCount(count);
			pageBean.setPageCount(count);
			pageBean.setPages(pageNo);
			List<OrderDO> orderList = (List<OrderDO>) result.getModel(ResultSupport.FIRST_MODEL_KEY);
			String html = "";
		    for(OrderDO order : orderList) {
		    	html += "<section class=\"order\">"
		    	+ "<div class=\"order-title\"><span>下单时间：<fmt:formatDate value=\"" + order.getCreateTime() + "\"  type=\"BOTH\" dateStyle=\"full\"/></span><a href=\"/order/orderDetail/" + order.getId() + ".html\"><span class=\"o-more\"></span></a></div>"
		        + "<div class=\"order-detail\"><ul>"
		        + "<li>订单号：<span>" + order.getwOOrderNo() + "</span></li>"
		        + "<li>服务类型：<span>" + order.getwOServiceName() + "</span></li></ul>"
		        + "<div class=\"cancle-btn\">";
		    	switch(status) {
			    	case 1: {
			    		html += "<a href=\"javascript:;\" onclick=\"del(" + order.getId() + ")\">删除订单</a><br/>";
			    		html += "<a href=\"/order/payOrder/" + order.getId() + ".html\">立即支付</a>";
			    		break;
			    	}
			    	case 2: {
			    		html += "<a href=\"javascript:;\" onclick=\"cancelShow(" + order.getId() + ")\">取消订单</a>";
			    		break;
			    	}
			    	case 3: {
			    		html += "<button onclick=\"confirmOrder(" + order.getId() + ")\">确认订单</button>";
			    		break;                                            
			    	}
			    	
		    	}
		    	html += "</div></div></section>";

		    }
		    mav.addObject("JSON_DATA", html);
		} else {
			mav.addObject("JSON_DATA", 0);
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/userOrders/{status}.html", method = RequestMethod.GET)
	public ModelAndView getUserOrders(ModelAndView mav,
			@PathVariable(value="status") Integer status,
			HttpServletRequest request) {
		Cookie cookie = getCookieByName(request, "MEMBER_ID");	
		if(cookie == null) {
			return new ModelAndView("redirect:/members/login.html");
		} 
		
		mav.setViewName("order/userOrders");
		mav.addObject("STATUS", status);
		return mav;
	}
	
	/**
	 * 删除订单
	 * @param mav
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/del/{id}.json", method = RequestMethod.GET)
	public ModelAndView del(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		ResultDO result = orderService.remove(id);
		if(result.isSuccess()) {
			mav.addObject("JSON_DATA", 1);
		} else {
			mav.addObject("JSON_DATA", 0);
		}
		return mav;
	}
	
}
