package com.umbrella.worker.web.controller.manager;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.dto.OrderDO;
import com.umbrella.worker.dto.OrderDetailDO;
import com.umbrella.worker.query.OrderQuery;
import com.umbrella.worker.query.StaffQuery;
import com.umbrella.worker.query.SupplierQuery;
import com.umbrella.worker.result.JsonResultDO;
import com.umbrella.worker.result.JsonResultSupport;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IOrderService;
import com.umbrella.worker.service.IStaffService;
import com.umbrella.worker.service.ISuppliersService;
import com.umbrella.worker.util.PageBeanUtil;

@Controller
@RequestMapping(value = "/morder")
public class ManagerOrderController {

	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private ISuppliersService suppliersService;
	
	@Autowired
	private IStaffService staffService;
	
	@RequestMapping(value = "/waitOrderList.html", method = RequestMethod.GET)
	public ModelAndView waitOrderList(ModelAndView mav,
			HttpServletRequest request) {
		mav.setViewName("manager/order/waitOrderList");
		return mav;
	}
	
	@RequestMapping(value = "/waitOrderList.json", method = RequestMethod.GET)
	public ModelAndView ajaxWaitOrderList(ModelAndView mav,
			HttpServletRequest request) {
		
		ResultDO resultDO = orderService.watiList();
		if(resultDO.isSuccess()) {
			List<OrderDO> list = (List<OrderDO>) resultDO.getModel(ResultSupport.FIRST_MODEL_KEY);
			String waitOrderContent = "";
			for(OrderDO orderDO : list) {
				waitOrderContent += "<tr class=\"text-c\"><td>" + orderDO.getwOOrderNo() + "</td><td>￥" + orderDO.getwOFee() + "元</td><td>" + orderDO.getOrderDetailDO().getwOAddress()+ "</td><td class=\"td-status\"><button onClick=\"rushOrder(" + orderDO.getId() + ")\">快速抢单</button></td></tr>";
			}
			//System.out.println(waitOrderContent);
			mav.addObject("JSON_DATA", waitOrderContent);
		} else {
			mav.addObject("JSON_DATA", 0);
		}
		return mav;
	}
	
	@RequestMapping(value = "/rushOrder/{id}.json", method = RequestMethod.GET)
	public ModelAndView rushOrder(ModelAndView mav,
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		JsonResultDO jsonResultDO = new JsonResultSupport();
		String adminName = (String) request.getSession().getAttribute("MANAGER_NAME");
		Integer supplierId = (Integer)  request.getSession().getAttribute("MANAGER_SUPPLIER_ID");
		String supplierName = (String) request.getSession().getAttribute("MANAGER_SUPPLIER_NAME");
		OrderDO orderDO = new OrderDO();
		orderDO.setId(id);
		System.out.println(supplierId);
		orderDO.setwOSupplierId(supplierId);
		orderDO.setModifiAuthor(adminName);
		OrderDetailDO orderDetailDO = new OrderDetailDO();
		orderDetailDO.setId(id);
		orderDetailDO.setwOSupplierName(supplierName);
		orderDetailDO.setModifiAuthor(adminName);
		orderDO.setOrderDetailDO(orderDetailDO);
		orderDO.setStatus(3);
		ResultDO result = orderService.rush(orderDO);
		if(result.isSuccess()) {
			jsonResultDO.setInfo("抢单成功");
			jsonResultDO.setStatus(JsonResultDO.JSON_SUCCESS);
			mav.addObject("JSON_DATA", jsonResultDO);
		} else {
			jsonResultDO.setInfo("抢单失败");
			jsonResultDO.setStatus(JsonResultDO.JSON_FAILED);
			mav.addObject("JSON_DATA", "error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/assigned/{id}.html", method = RequestMethod.GET)
	public ModelAndView assigned(ModelAndView mav,
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		int supplierId = (int) request.getSession().getAttribute("MANAGER_SUPPLIER_ID");
		ResultDO result = orderService.get(id);
		ResultDO result2 = null;
		ResultDO result3 = null;
		if(supplierId == 1) {
			SupplierQuery query = new SupplierQuery();
			result2 = suppliersService.list(query);
		} else {
			StaffQuery squery = new StaffQuery();
			squery.setSupplierId(supplierId);
			squery.setServiceType(1);
			squery.setStatus(1);
			result3 = staffService.list(squery);
		}
		if(result.isSuccess()) {
			
			mav.addObject("ORDER_INFO", result.getModel(ResultSupport.FIRST_MODEL_KEY));
			if(result2 != null) {
				mav.addObject("SUPPLIER_LIST", result2.getModel(ResultSupport.FIRST_MODEL_KEY));
			} else {
				mav.addObject("STAFF_LIST", result3.getModel(ResultSupport.FIRST_MODEL_KEY));
			}
			mav.setViewName("manager/order/assigned");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/assigned.json", method = RequestMethod.POST)
	public ModelAndView assigned(ModelAndView mav,
			OrderDO orderDO,
			HttpServletRequest request) {
		JsonResultDO jsonResultDO = new JsonResultSupport();
		String adminName = (String) request.getSession().getAttribute("MANAGER_NAME");
		orderDO.setStatus(8);
		orderDO.setModifiAuthor(adminName);
		orderDO.setOrderDetailDO(new OrderDetailDO());
		orderDO.getOrderDetailDO().setId(orderDO.getId());
		orderDO.getOrderDetailDO().setModifiAuthor(adminName);
		
		if(orderDO.getwOSupplierId() == null) {
			int supplierId = (int) request.getSession().getAttribute("MANAGER_SUPPLIER_ID");
			orderDO.setwOSupplierId(supplierId);
		}
		ResultDO resultDO = orderService.assigned(orderDO);
		if(resultDO.isSuccess()) {
			jsonResultDO.setInfo("提交成功");
			jsonResultDO.setStatus(JsonResultDO.JSON_SUCCESS);
			mav.addObject("JSON_DATA", jsonResultDO);
		} else {
			jsonResultDO.setInfo("提交失败");
			jsonResultDO.setStatus(JsonResultDO.JSON_FAILED);
			mav.addObject("JSON_DATA", jsonResultDO);
		}
		return mav;
	}
	
	@RequestMapping(value = "/assignedList/{pageNo}.html", method = RequestMethod.GET)
	public ModelAndView assignedList(ModelAndView mav,
			@PathVariable(value="pageNo") Integer pageNo,
			HttpServletRequest request) {
		
		int supplierId = (int) request.getSession().getAttribute("MANAGER_SUPPLIER_ID");
		OrderQuery query = new OrderQuery();
		query.setPage(true);
		query.setSupplierId(supplierId);
		query.setPageNO(pageNo);
		query.setPageRows(10);
	
		ResultDO result =  null;
		if(supplierId != 1) {
			result = orderService.cleanAssignedList(query);
		} else {
			result = orderService.adminAssignedList(query);
		}
		if(result.isSuccess()) {
			PageBeanUtil pageBean = new PageBeanUtil();
			long count = (Long) result.getModel(ResultSupport.SECOND_MODEL_KEY);
			pageBean.setCurrentPage(pageNo);
			pageBean.setPageSize(query.getPageRows());
			pageBean.setRecordCount(count);
			pageBean.setPageCount(count);
			pageBean.setPages(pageNo);
			pageBean.setDataList((List<Object>) result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.addObject("PAGE_BEAN", pageBean);
			mav.setViewName("manager/order/assignedList");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/detail/{id}.html", method = RequestMethod.GET)
	public ModelAndView orderDetail(ModelAndView mav,
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		
		ResultDO result = orderService.get(id);
		if(result.isSuccess()) {
			mav.addObject("ORDER_INFO", result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName("manager/order/detail");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/confirmCanecl/{id}.json", method = RequestMethod.GET)
	public ModelAndView confirmCanecl(ModelAndView mav,
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		JsonResultDO jsonResultDO = new JsonResultSupport();
		OrderDO orderDO = new OrderDO();
		orderDO.setId(id);
		orderDO.setStatus(5);
		ResultDO result = orderService.modifi(orderDO);
		if(result.isSuccess()) {
			jsonResultDO.setInfo("提交成功");
			jsonResultDO.setStatus(JsonResultDO.JSON_SUCCESS);
			mav.addObject("JSON_DATA", jsonResultDO);
		} else {
			jsonResultDO.setInfo("提交失败");
			jsonResultDO.setStatus(JsonResultDO.JSON_FAILED);
			mav.addObject("JSON_DATA", jsonResultDO);
		}
		return mav;
	}
	
	@RequestMapping(value = "/cancelList/{pageNo}.html", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mav,
			@PathVariable(value="pageNo") Integer pageNo,
			HttpServletRequest request) {

		OrderQuery query = new OrderQuery();
		query.setPage(true);
		query.setStatus(4);
		query.setPageNO(pageNo);
		query.setPageRows(10);
		
		ResultDO result = orderService.list(query);
		if(result.isSuccess()) {
			PageBeanUtil pageBean = new PageBeanUtil();
			long count = (Long) result.getModel(ResultSupport.SECOND_MODEL_KEY);
			pageBean.setCurrentPage(pageNo);
			pageBean.setPageSize(query.getPageRows());
			pageBean.setRecordCount(count);
			pageBean.setPageCount(count);
			pageBean.setPages(pageNo);
			pageBean.setDataList((List<Object>) result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.addObject("PAGE_BEAN", pageBean);
			mav.setViewName("manager/order/cancelList");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/list/{orderNo}/{status}/{pageNo}.html", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mav,
			@PathVariable(value="orderNo") String orderNo,
			@PathVariable(value="status") Integer status,
			@PathVariable(value="pageNo") Integer pageNo,
			HttpServletRequest request) {
		
		int supplierId = (int) request.getSession().getAttribute("MANAGER_SUPPLIER_ID");
		OrderQuery query = new OrderQuery();
		query.setPage(true);
		if(supplierId != 1) {
			query.setSupplierId(supplierId);
			
		}
		if(!orderNo.equals("all")) {
			query.setOrderNo(orderNo);
		}
		query.setStatus(status);
		query.setPageNO(pageNo);
		query.setPageRows(10);
		
		ResultDO result = orderService.list(query);
		if(result.isSuccess()) {
			PageBeanUtil pageBean = new PageBeanUtil();
			long count = (Long) result.getModel(ResultSupport.SECOND_MODEL_KEY);
			pageBean.setCurrentPage(pageNo);
			pageBean.setPageSize(query.getPageRows());
			pageBean.setRecordCount(count);
			pageBean.setPageCount(count);
			pageBean.setPages(pageNo);
			pageBean.setDataList((List<Object>) result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.addObject("PAGE_BEAN", pageBean);
			mav.addObject("INCOME", result.getModel(ResultSupport.THIRD_MODEL_KEY));
			if(supplierId != 1) {
			switch(status) {
			case 8: {
				mav.setViewName("manager/order/list8");
				break;
			}
			case 6:{
				mav.setViewName("manager/order/list6");
				break;
			}
			case 5:{
				mav.setViewName("manager/order/list5");
				break;
			}
			case 7:{
				mav.setViewName("manager/order/list7");
				break;
			}
			}
			} else {
				mav.setViewName("manager/order/list");
			}
			
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
}
